/**
 * 
 */
package cn.aposoft.basic.algorithm;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 
 * @author LiuJian
 * 
 */
public class PrimesGenerator {
	private static final long MIN_PRIME = 2L;

	/**
	 * 获取ceiling一下的全部素数的集合 本用例使用Long作为素数的表示范围,因此仅能计算 {@code Long#MAX_VALUE}
	 * 以内的素数,但要考虑虚拟机的使用和时间消耗情况
	 * 
	 * @param ceiling
	 *            素数集合的上限值包含ceiling
	 * @return 全部素数组成的集合 {@link List<Long>}
	 */
	public List<Long> getPrimes(long ceiling) {

		List<Long> primes = new LinkedList<Long>();
		if (ceiling >= MIN_PRIME) {
			primes.add(MIN_PRIME);
		}
		for (long i = 3; i <= ceiling; i += 2) {
			if (isPrime(i, primes)) {
				primes.add(i);
			}
		}
		return primes;
	}

	/*
	 * 素数判定条件
	 */
	private boolean isPrime(long target, Iterable<Long> primes) {
		if (target == MIN_PRIME) {
			return true;
		} else {
			return isNormalPrime(target, primes);
		}
	}

	/*
	 * Normal Prime is a prime that is greater than 2.
	 */
	private boolean isNormalPrime(long target, Iterable<Long> primes) {
		long sqrt = (long) Math.sqrt(target);
		boolean result = true;
		for (Long prime : primes) {
			// 终止条件:除数大于目标数字的平方根
			if (prime > sqrt) {
				break;
			}
			// 非素数判定条件:可以被某个素数整除.
			// 因任何非素数都是素数的乘积,因此仅判断素数就可以判定目标测试数据是否非素数.
			if (target % prime == 0) {
				result = false;
				break;
			}
		}
		return result;
	}

	/**
	 * 主测试方法: 测试0~~100以内的的全部数字所包含的素数集合.
	 * 
	 * @param args
	 *            在本实例中没有输入
	 */
	public static void main(String[] args) {
		// testMultiSmallRangeInput();
		testSingleLargeInput();
	}

	static void testMultiSmallRangeInput() {
		long begin = 1024L;
		long end = 1024L;
		for (long ceiling = begin; ceiling <= end; ceiling++) {
			List<Long> primes = new PrimesGenerator().getPrimes(ceiling);
			System.out.println(
					"target:" + ceiling + ",length:" + primes.size() + "," + Arrays.toString(primes.toArray()));
		}
	}

	static void testSingleLargeInput() {
		final long ceiling = 1000 * 1000 * 1000;// 1024L * 1024L * 16L;
		List<Long> primes = new PrimesGenerator().getPrimes(ceiling);
		System.out.println("target:" + ceiling + ",length:" + primes.size() + ",max:" + primes.get(primes.size() - 1));
	}
}
