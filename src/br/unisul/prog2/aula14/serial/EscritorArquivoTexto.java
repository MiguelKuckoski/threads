package br.unisul.prog2.aula14.serial;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.List;

public class EscritorArquivoTexto {

	public void escreverConteudoArquivo(List<String> linhas) {
		OutputStream escritorByte = null;
		OutputStreamWriter escritorCaracter = null;
		BufferedWriter escritorPalavras = null;

		try {
			escritorByte = new FileOutputStream("C:/Users/Miguel Freitas/Documents/arquivos.txt", true);
			escritorCaracter = new OutputStreamWriter(escritorByte);
			escritorPalavras = new BufferedWriter(escritorCaracter);

			for(String linha : linhas) {
				escritorPalavras.write(linha);
				escritorPalavras.newLine();
			}
			escritorPalavras.flush();

		}catch (FileNotFoundException e) {
			System.err.println(e);
		} catch (IOException e) {
			System.err.println(e); 
		} finally {
			try {
				if(escritorPalavras != null) {
					escritorPalavras.close();
				}
				if(escritorCaracter != null) {
					escritorCaracter.close();
				}
				if(escritorByte != null) {
					escritorByte.close();
				}
			} catch(Exception e){}
		}
	}
}
