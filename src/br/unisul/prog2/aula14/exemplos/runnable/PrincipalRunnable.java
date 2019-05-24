package br.unisul.prog2.aula14.exemplos.runnable;

public class PrincipalRunnable {

	public static void main(String[] args) {
		Thread thread = null;
		
		thread = new Thread(new Thread1());
		thread.start();
		
		thread = new Thread(new Thread2());
		thread.start();
	}
}
