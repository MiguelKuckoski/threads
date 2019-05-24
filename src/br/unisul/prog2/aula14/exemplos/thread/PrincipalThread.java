package br.unisul.prog2.aula14.exemplos.thread;

public class PrincipalThread {

	public static void main(String[] args) {
		Thread1 thread1 = new Thread1();
		thread1.start();
		
		Thread2 thread2 = new Thread2();
		thread2.start();
	}
}
