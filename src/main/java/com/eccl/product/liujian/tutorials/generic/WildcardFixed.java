/**
 * 
 */
package com.eccl.product.liujian.tutorials.generic;

import java.util.List;

/**
 * @author LiuJian
 *
 */
public class WildcardFixed {

	    void foo(List<?> i) {
	        fooHelper(i);
	    }

	    // Helper method created so that the wildcard can be captured
	    // through type inference.
	    private <T> void fooHelper(List<T> l) {
	        l.set(0, l.get(0));
	    }

}
