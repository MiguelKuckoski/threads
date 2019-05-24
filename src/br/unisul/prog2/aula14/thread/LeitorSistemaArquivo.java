package br.unisul.prog2.aula14.thread;

import java.io.File;

public class LeitorSistemaArquivo extends Thread {

	private String caminhoRaiz;
	
	private ServicoMemoriaCompartilhada memoria = ServicoMemoriaCompartilhada.getInstancia();
	
	@Override
	public void run() {
		this.recuperarListaArquivo();
	}
	
	public LeitorSistemaArquivo(String caminhoRaiz) {
		this.memoria.setProduzindo(true);
		this.caminhoRaiz = caminhoRaiz;
	}
	
	private void recuperarListaArquivo() {
		memoria.adiciona(caminhoRaiz);

		this.lerRaizPasta(caminhoRaiz);
	}

	private void lerRaizPasta(String caminhoRaiz) {
		File raiz = new File(caminhoRaiz);

		if(raiz != null && raiz.exists()) {
			File[] arquivos = raiz.listFiles();

			if(arquivos != null) {
				for(File arquivo : arquivos) {
					if(arquivo != null && arquivo.isHidden() == false) {
						String caminho = arquivo.getAbsolutePath();
						memoria.adiciona(caminho);

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
