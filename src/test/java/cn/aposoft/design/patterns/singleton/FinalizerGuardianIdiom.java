package cn.aposoft.design.patterns.singleton;

// Finalizer Guardian idiom
public class FinalizerGuardianIdiom {
	// Sole purpose of this object is to finalize outer Foo object
	@SuppressWarnings("unused")
	private final Object finalizerGuardian = new Object();

	public void dispose() {
		// do some finalize things
	}

	@Override
	protected void finalize() throws Throwable {
		// Finalize outer Foo object
		dispose();
	}
}
