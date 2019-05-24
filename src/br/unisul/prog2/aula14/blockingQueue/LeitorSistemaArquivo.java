package br.unisul.prog2.aula14.blockingQueue;

import java.io.File;
import java.util.concurrent.BlockingQueue;

public class LeitorSistemaArquivo implements Runnable{

	private String caminhoRaiz;
	BlockingQueue<String> memoriaCompartilhada = null;
	
	@Override
	public void run() {
		this.recuperarListaArquivo();
	}
	
	public LeitorSistemaArquivo(String caminhoRaiz, BlockingQueue<String> memoriaCompartilhada) {
		this.memoriaCompartilhada = memoriaCompartilhada;
		this.caminhoRaiz = caminhoRaiz;
	}
	
	private void recuperarListaArquivo() {
		try {
			memoriaCompartilhada.put(caminhoRaiz);
			this.lerRaizPasta(caminhoRaiz);
			memoriaCompartilhada.put("Done");
		} catch (InterruptedException e) {
			System.err.println(e.getMessage());
		}
		
	}

	private void lerRaizPasta(String caminhoRaiz) {
		File raiz = new File(caminhoRaiz);

		if(raiz != null && raiz.exists()) {
			File[] arquivos = raiz.listFiles();

			if(arquivos != null) {
				for(File arquivo : arquivos) {
					if(arquivo != null && arquivo.isHidden() == false) {
						String caminho = arquivo.getAbsolutePath();
						try {
							memoriaCompartilhada.put(caminho);
						} catch (InterruptedException e) {
							System.err.println(e.getMessage());
						}
						
						if(arquivo.isDirectory()) {
							System.out.println(caminho);
							lerRaizPasta(caminho);
						} 
					}
				}
			}
		}

	}
}
