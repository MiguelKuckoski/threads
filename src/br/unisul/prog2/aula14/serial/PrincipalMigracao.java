package br.unisul.prog2.aula14.serial;

import java.util.List;

public class PrincipalMigracao {

	public static void main(String[] args) {
		LeitorSistemaArquivo leitor = new LeitorSistemaArquivo();
		EscritorArquivoTexto escritor = new EscritorArquivoTexto();
		
		long inicioLeitura = System.currentTimeMillis();
		List<String> arquivos = leitor.recuperarListaArquivo("C:/");
		long tempoLeitura = System.currentTimeMillis() - inicioLeitura;
		
		if(arquivos != null) {
			System.out.println("Salvando os dados no arquivo");
			long inicioEscrita = System.currentTimeMillis();
			escritor.escreverConteudoArquivo(arquivos);
			long tempoEscrita = System.currentTimeMillis() - inicioEscrita;
			System.out.println("Processo finalizado");
			
			System.out.println("Tempo leitura: "+tempoLeitura+"\n" +
					"Tempo escrita: "+tempoEscrita+"\n" +
					"TEMPO TOTAL: "+(System.currentTimeMillis()-inicioLeitura));
		}
		
	}
}
