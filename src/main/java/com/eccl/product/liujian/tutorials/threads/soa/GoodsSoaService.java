/**
 * 
 */
package com.eccl.product.liujian.tutorials.threads.soa;

import java.util.Random;

/**
 * @author LiuJian
 *
 */
public class GoodsSoaService {
	Random r = new Random();

	public String getGoodsDetails(String goodsId) {
		try {
			int delay = (r.nextInt(25) + 1) * 200;
			Thread.sleep(delay);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return goodsId + "," + String.valueOf(goodsId.hashCode());
	}
}
