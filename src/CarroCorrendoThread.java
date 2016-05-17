/* Classe usando Thread que simula a corrida de um carro */
class CarroCorrendoThread implements Runnable {

	String nome;					// nome do carro
	int distanciaCorrida = 0;		// dist�ncia j� corrida pelo carro
	int distanciaTotalCorrida;	// dist�ncia a ser corrida pelo carro
	int pulo = 0;					// pulo do carro em cm
	int pulos = 0;					// quantidades de pulos dados na corrida
	static int colocacao = 0;		// coloca��o do carro ao final da corrida
	final static int PULO_MAXIMO = 50; // pulo m�ximo em cm que um carro pode dar
	char id;
	boolean emJogo;
	
	/** Construtor da classe. Par�mtros : Nome do Carro e Dist�ncia da Corrida */
	public CarroCorrendoThread (String nome, int distanciaTotalCorrida, int i) {
		/* chamando o construtor de Thread passando o nome do carro como par�metro */
		this.nome=nome;
		this.distanciaTotalCorrida = distanciaTotalCorrida;
		this.nome = nome;
		if(i==1) id='q';
		if(i==2) id='f';
		if(i==3) id='u';
		if(i==4) id='l';
	}
	
	/** Faz o carro pular */
	public void carroPulando() {
		pulos++;
		pulo = (int) (Math.random() * PULO_MAXIMO);
		distanciaCorrida += pulo;
		if (distanciaCorrida > distanciaTotalCorrida) {
			distanciaCorrida = distanciaTotalCorrida;
		}
	}

	/** Imprime a coloca��o do carro ao final da corrida */
	public void colocacaoCarro () {
		colocacao++;
		System.out.println(nome + " foi o " + colocacao + 
							"� colocado com " + pulos + " pulos");
	}
	/** M�todo run da thread Corrida de Carros */
	public void run () {
		while (distanciaCorrida < distanciaTotalCorrida) {
			carroPulando();
		}
		colocacaoCarro();
	}
}