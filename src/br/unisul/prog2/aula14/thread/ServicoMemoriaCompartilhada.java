package br.unisul.prog2.aula14.thread;

import java.util.ArrayList;
import java.util.List;

public class ServicoMemoriaCompartilhada {

	private List<String> memoriaCompartilhada = new ArrayList<String>();
	
	private boolean produzindo;
	
	private static ServicoMemoriaCompartilhada instancia = new ServicoMemoriaCompartilhada();
	
	private ServicoMemoriaCompartilhada(){
	};
	
	
	public static ServicoMemoriaCompartilhada getInstancia() {
		return instancia;
	}
	
	
	public void adiciona(String elemento) {
		this.memoriaCompartilhada.add(elemento);
	}
	
	public String recupera() {
		return this.memoriaCompartilhada.remove(0);
	}
	
	public boolean temElemento() {
		return !this.memoriaCompartilhada.isEmpty();
	}


	public boolean isProduzindo() {
		return produzindo;
	}


	public void setProduzindo(boolean produzindo) {
		this.produzindo = produzindo;
	}
}

