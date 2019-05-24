package br.unisul.prog2.aula14.exemplos.runnable;

public class Thread1 implements Runnable {

	@Override
	public void run() {
		this.inicio();
	}

	private void inicio() {
		try {
			for(int i = 0; i < 1000; i++) {
				System.out.println("[Runnable1]: iteração = "+i);
				Thread.sleep(250);
			}
		} catch (InterruptedException e) {
			System.err.println(e);
		}
	}
}
