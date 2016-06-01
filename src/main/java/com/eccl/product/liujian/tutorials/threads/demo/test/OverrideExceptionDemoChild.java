/**
 * 
 */
package com.eccl.product.liujian.tutorials.threads.demo.test;

import java.io.IOException;

/**
 * @author LiuJian
 * 
 */
public class OverrideExceptionDemoChild extends OverrideExceptionDemoBase {

	// Exception IOException is not compatible with throws clause in
	// OverrideExceptionDemoBase.run()
	// the overrided method can not change the return type
	@Override
	public void run() throws IOException {
	}
}
