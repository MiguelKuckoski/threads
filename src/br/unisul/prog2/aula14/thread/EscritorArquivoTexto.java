package br.unisul.prog2.aula14.thread;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

public class EscritorArquivoTexto extends Thread {

	private ServicoMemoriaCompartilhada memoria = ServicoMemoriaCompartilhada.getInstancia();

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

			while (memoria.temElemento() || memoria.isProduzindo()) {
				if (memoria.temElemento()) {
					String linha = memoria.recupera();
					escritorPalavras.write(linha);
					escritorPalavras.newLine();
				} else {
					Thread.sleep(500);
				}
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
