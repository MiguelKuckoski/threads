package br.unisul.prog2.aula14.blockingQueue;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.concurrent.BlockingQueue;

public class EscritorArquivoTexto implements Runnable{

	private BlockingQueue<String> memoriaCompartilhada = null;
	
	public EscritorArquivoTexto(BlockingQueue<String> memoriaCompartilhada) {
		this.memoriaCompartilhada = memoriaCompartilhada;
	}

	@Override
	public void run() {
		this.escreverConteudoArquivo();
	}

	public void escreverConteudoArquivo() {
		OutputStream escritorByte = null;
		OutputStreamWriter escritorCaracter = null;
		BufferedWriter escritorPalavras = null;

		try {
			escritorByte = new FileOutputStream("conteudo/arquivos.txt");
			escritorCaracter = new OutputStreamWriter(escritorByte);
			escritorPalavras = new BufferedWriter(escritorCaracter);
			
			String linha = null;
			while (!(linha = memoriaCompartilhada.take()).equalsIgnoreCase("Done")) {
					escritorPalavras.write(linha);
					escritorPalavras.newLine();
			}
			escritorPalavras.flush();

		} catch (FileNotFoundException e) {
			System.err.println(e);
		} catch (IOException e) {
			System.err.println(e);
		} catch (InterruptedException e) {
			System.err.println(e.getMessage());
		} finally {
			try {
				if (escritorPalavras != null) {
					escritorPalavras.close();
				}
				if (escritorCaracter != null) {
					escritorCaracter.close();
				}
				if (escritorByte != null) {
					escritorByte.close();
				}
			} catch (Exception e) {
			}
		}
	}
}
