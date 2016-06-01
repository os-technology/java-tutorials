/**
 * 
 */
package com.eccl.product.liujian.tutorials.threads.soa;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author LiuJian
 *
 */
public class GoodsSoaClient {
	/**
	 * 需要从系统中读取的内容
	 */
	private ExecutorService executorService;

	public GoodsSoaClient(ExecutorService executorService) {
		this.executorService = executorService;
	}

	/**
	 * 根据商品id并行查询商品详细信息
	 * 
	 * @param goodsIds
	 * @return 读取的商品列表
	 */
	public List<String> getGoods(List<String> goodsIds) {
		// 商品数量
		int taskCount = goodsIds.size();
		// 创建异步线程任务集合
		List<Callable<String>> taskList = new ArrayList<Callable<String>>(
				taskCount);
		for (int i = 0; i < taskCount; i++) {
			// 商品id从商品id集合中读取
			String goodsId = goodsIds.get(i);
			Callable<String> task = new GoodsRequestService(goodsId);
			taskList.add(task);
		}
		// 结果集
		List<String> resultList = new ArrayList<String>(taskCount);
		try {
			// 异步执行task
			List<Future<String>> response = executorService.invokeAll(taskList);
			while (response.size() > 0) {
				for (int i = 0; i < response.size(); i++) {
					Future<String> future = response.get(i);
					if (future.isDone()) {
						try {
							resultList.add(future.get());
						} catch (InterruptedException | ExecutionException e) {
							e.printStackTrace();
						} finally {
							response.remove(i);
						}
					}
				}
				// 释放一次线程,避免CPU占用过高
				Thread.sleep(1);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		// 返回查询的最终结果集
		return resultList;
	}

	/**
	 * 任务执行子类
	 * 
	 * @author LiuJian
	 *
	 */
	private class GoodsRequestService implements Callable<String> {
		GoodsSoaService service = new GoodsSoaService();
		private String goodsId;

		public GoodsRequestService(String goodsId) {
			this.goodsId = goodsId;
		}

		@Override
		public String call() throws Exception {
			return service.getGoodsDetails(goodsId);
		}
	}

	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		BlockingQueue<Runnable> queue = new LinkedBlockingDeque<Runnable>();
		ExecutorService executorService = new ThreadPoolExecutor(512, 512, 5L,
				TimeUnit.SECONDS, queue);
		List<String> goodsIds = new ArrayList<String>();
		for (int i = 0; i < 100; i++) {
			goodsIds.add(String.valueOf(i));
		}
		GoodsSoaClient demo = new GoodsSoaClient(executorService);
		List<String> result = demo.getGoods(goodsIds);
		for (int i = 0; i < result.size(); i++) {
			System.out.println(result.get(i));
		}
		System.out.println("finished.");
		executorService.shutdownNow();
	}
}
