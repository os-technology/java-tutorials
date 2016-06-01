package demo.study.networking.conn;

import java.io.IOException;
import java.net.CacheResponse;
import java.net.ResponseCache;
import java.net.URI;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class MemoryCache extends ResponseCache {

	private final Map<URI, SimpleCacheResponse> responses = new ConcurrentHashMap<URI, SimpleCacheResponse>();
	private final int maxEntries;

	public MemoryCache() {
		this(100);
	}

	public MemoryCache(int maxEntries) {
		this.maxEntries = maxEntries;
	}

	@Override
	public java.net.CacheRequest put(URI uri, URLConnection conn)
			throws IOException {
		if (responses.size() >= maxEntries)
			return null;
		CacheControl control = new CacheControl(
				conn.getHeaderField("Cache-Control"));
		if (control.noStore()) {
			return null;
		} else if (!conn.getHeaderField(0).startsWith("GET ")) {
			// only cache GET
			return null;
		}
		SimpleCacheRequest request = new SimpleCacheRequest();
		SimpleCacheResponse response = new SimpleCacheResponse(request, conn,
				control);
		responses.put(uri, response);

		return request;
	}

	@Override
	public CacheResponse get(URI uri, String requestMethod,
			Map<String, List<String>> requestHeaders) throws IOException {
		if ("GET".equals(requestMethod)) {
			SimpleCacheResponse response = responses.get(uri);
			// check expiration date
			if (response != null && response.isExpired()) {
				responses.remove(response);
				response = null;
			}
			return response;
		} else {
			return null;
		}
	}
}