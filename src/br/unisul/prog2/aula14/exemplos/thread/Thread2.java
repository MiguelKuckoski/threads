package br.unisul.prog2.aula14.exemplos.thread;

public class Thread2 extends Thread {

	@Override
	public void run() {
		this.inicio();
	}

	private void inicio() {
		try {
			for(int i = 0; i < 500; i++) {
				System.err.println("[Thread2]: iteração = "+i);
				Thread.sleep(500);
			}
		} catch (InterruptedException e) {
			System.err.println(e);
		}
	}
}
