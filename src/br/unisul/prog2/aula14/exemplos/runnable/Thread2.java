package br.unisul.prog2.aula14.exemplos.runnable;

public class Thread2 implements Runnable {

	@Override
	public void run() {
		this.inicio();
	}

	private void inicio() {
		try {
			for(int i = 0; i < 500; i++) {
				System.err.println("[Runnable2]: iteração = "+i);
				Thread.sleep(500);
			}
		} catch (InterruptedException e) {
			System.err.println(e);
		}
	}
}
