package br.unisul.prog2.aula14.serial;

import java.io.File;
import java.util.LinkedList;
import java.util.List;

public class LeitorSistemaArquivo {

	public List<String> recuperarListaArquivo(String caminhaRaiz) {
		final List<String> listaArquivos = new LinkedList<String>();
		
		listaArquivos.add(caminhaRaiz);

		this.lerRaizPasta(listaArquivos, caminhaRaiz);

		return listaArquivos;
	}

	private void lerRaizPasta(List<String> listaArquivos, String caminhaRaiz) {
		File raiz = new File(caminhaRaiz);

		if(raiz != null && raiz.exists()) {
			File[] arquivos = raiz.listFiles();

			if(arquivos != null) {
				for(File arquivo : arquivos) {
					if(arquivo != null && arquivo.isHidden() == false) {
						String caminho = arquivo.getAbsolutePath();
						listaArquivos.add(caminho);

						if(arquivo.isDirectory()) {
							System.out.println(caminho);
							lerRaizPasta(listaArquivos, caminho);
						} 
					}
				}
			}
		}

	}

	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		final List<String> listaArquivos = new LeitorSistemaArquivo().recuperarListaArquivo("/Users/flavioceci/Documents/");
		System.out.println("tempo de leitura "+(System.currentTimeMillis() - start));
		System.out.println("Quantidade de elementos: "+listaArquivos.size());
		
		for(String arquivo : listaArquivos) {
			System.out.println("=> "+arquivo);
		}
	}
}
