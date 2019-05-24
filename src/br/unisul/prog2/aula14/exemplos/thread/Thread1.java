package br.unisul.prog2.aula14.exemplos.thread;

public class Thread1 extends Thread {

	@Override
	public void run() {
		this.inicio();
	}

	private void inicio() {
		try {
			for(int i = 0; i < 1000; i++) {
				System.out.println("[Thread1]: iteração = "+i);
				Thread.sleep(250);
			}
		} catch (InterruptedException e) {
			System.err.println(e);
		}
	}
}
