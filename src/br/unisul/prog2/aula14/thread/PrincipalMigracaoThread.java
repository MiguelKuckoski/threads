package br.unisul.prog2.aula14.thread;


public class PrincipalMigracaoThread {

	public static void main(String[] args) throws InterruptedException {
		ServicoMemoriaCompartilhada memoria = ServicoMemoriaCompartilhada.getInstancia();
		LeitorSistemaArquivo leitor = new LeitorSistemaArquivo("C:/");
		EscritorArquivoTexto escritor = new EscritorArquivoTexto();
		long inicio = System.currentTimeMillis();

		leitor.start();
		
		while(memoria.temElemento() == false) {
			System.out.println("Esperando preencher adicionar elementos na memoria");
		}
		
		escritor.start();
		
		
		while(leitor.isAlive() || escritor.isAlive()) {
			Thread.sleep(500);
		}
		
		System.out.println("TEMPO TOTAL: "+(System.currentTimeMillis()-inicio));
	}
}
