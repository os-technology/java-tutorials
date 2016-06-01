package cn.aposoft.util.concurrent.demo.countan.gao;

public class Print2 implements Runnable {

	private Data d;

	public Print2(Data d) {
		this.d = d;
	}

	public void run() {
		while (d.getN() < d.getAlp().length) {
			d.print2();
		}
		System.out.println("cq2");
	}
}
