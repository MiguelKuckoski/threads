package br.unisul.prog2.aula14.blockingQueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class PrincipalMigracaoThread {

	public static void main(String[] args) throws InterruptedException {
		BlockingQueue<String> memoriaCompartilhada = new ArrayBlockingQueue<String>(1000);
		
		Thread leitor = new Thread(new LeitorSistemaArquivo("C:/", memoriaCompartilhada));
		Thread escritor = new Thread(new EscritorArquivoTexto(memoriaCompartilhada));
		long inicio = System.currentTimeMillis();

		leitor.start();	
		escritor.start();
		
		while(leitor.isAlive() || escritor.isAlive()) {
			Thread.sleep(500);
		}
		
		System.out.println("TEMPO TOTAL: "+(System.currentTimeMillis()-inicio));
	}
}
