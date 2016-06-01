/**
 * 
 */
package cn.aposoft.util.concurrent.locks;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

// Using a ReadWriteLock to implement a cache.  
public class CacheDemo {

	private Map<String, Object> cache = new ConcurrentHashMap<String, Object>();
	private ReadWriteLock rwl = new ReentrantReadWriteLock();

	public static void main(String[] args) {
		CacheDemo cache = new CacheDemo();
		Object obj = cache.getData("");
		System.out.println(obj.toString());

	}

	Object data;
	volatile boolean cacheValid;

	// jdk demo for ReentrantReadWriteLock
	void processCachedData() {
		rwl.readLock().lock();
		if (!cacheValid) {
			// Must release read lock before acquiring write lock
			rwl.readLock().unlock();
			rwl.writeLock().lock();
			// Recheck state because another thread might have acquired
			// write lock and changed state before we did.
			if (!cacheValid) {
				data = "Data";
				cacheValid = true;
			}
			// Downgrade by acquiring read lock before releasing write lock
			rwl.readLock().lock();
			rwl.writeLock().unlock(); // Unlock write, still hold read
		}

		use(data);
		rwl.readLock().unlock();
	}

	// use data demo
	private void use(Object data) {

	}

	// Get the value from DB if the value does not exist,and then return it.
	public Object getData(String key) {

		Object value = null;
		try {
			rwl.readLock().lock();
			value = cache.get(key);
			if (value == null) {
				try {
					// Must release read lock before acquiring write lock
					rwl.readLock().unlock();
					rwl.writeLock().lock();
					try {
						// Recheck state because another thread might have
						// acquired
						// write lock and changed state before we did.
						if (cache.get(key) == null) {
							// Here may access Database.
							// ...
							value = "Data";
							cache.put(key, value);
						}
					} finally {
						// Downgrade by acquiring read lock before releasing
						// write lock
						rwl.readLock().lock();
					}
				} finally {
					rwl.writeLock().unlock();
				}
			}
		} finally {
			rwl.readLock().unlock();
		}
		return value;

	}

}
