import java.util.ArrayList;

/**
 * @author Iriedson Souto
 * Classe principal do programa responsavel por criar e manipulalas novas contas 
 * */
public abstract class Conta{
		
	/**
	 * Atributos e variaveis da classe
	 * */
	private static final int AGENCIA_PADRAO = 1;
	private static int SEQUENCIAL = 0;

	protected int agencia;
	protected int numeroTipoConta;
	protected String numeroConta;
	protected double saldo;
	protected Cliente titular;
	protected ArrayList<Operacao> historico = new ArrayList<Operacao>();

	
	/**
	 * @param metodo construtor que recebe objeto cliente e o tipo da conta
	 * */
	public Conta(Cliente titular, int numeroTipoConta) {
		this.agencia = Conta.AGENCIA_PADRAO;
		this.numeroTipoConta = numeroTipoConta;
		this.numeroConta = this.agencia+" "+this.numeroTipoConta+"-"+(++SEQUENCIAL);
		this.titular = titular;
	}
	
		
	/**
	 * @param recebe valor para debitar da conta
	 * @exception lança novo Exception caso o valor sejá maior que o saldo disponivel
	 * */
	public void sacar(double valor) throws Exception {
		debitarDoSaldo(valor);
		historico.add(new Operacao(TipoOperacoes.SAQUE, -valor));
	}

	/**
	 * @param recebe valor para adiciona na conta
	 * */
	public void depositar(double valor) {
		somarDoSaldo(valor);
		historico.add(new Operacao(TipoOperacoes.DEPOSITO, valor));
	}
	
	/**
	 * @param recebe valor para transferir a uma outra conta
	 * @exception lança novo Exception caso o valor sejá maior que o saldo disponivel
	 * */
	public void transferir(double valor, Conta contaDestino) throws Exception {
		debitarDoSaldo(valor);
		contaDestino.receberTransferencia(valor);
		historico.add(new Operacao(TipoOperacoes.TRANSFERENCIA, -valor));
	}
	
	/**
	 * metodo responsavel por mostrar o historico de operações da conta
	 * */
	public void extrato(){
		System.out.println("Conta: "+numeroConta );
		for(Operacao operacao: historico)
			System.out.println(operacao.toString());
	}
	/**
	 * @param recebe valor para adiciona na conta
	 * metodo interno complementar para as funcoes dos metodos depositar e receberTransferencia
	 * */
	private void somarDoSaldo(double valor){
		this.saldo += valor;
	}
	
	/**
	 * @param recebe valor para debitar da conta
	 * @exception lança novo Exception caso o valor sejá maior que o saldo disponivel
	 * metodo interno complementar para as funcoes dos metodos sacar e Transferir
	 * */
	private void debitarDoSaldo(double valor)throws Exception {
		if(this.saldo - valor < 0)
			throw new Exception("Saldo insuficiente!");
		this.saldo -= valor;
	}
	
	/**
	 * @param recebe valor de uma outra conta e adiciona a quantia no saldo
	 * */
	private void receberTransferencia(double valor) {
		somarDoSaldo(valor);
		historico.add(new Operacao(TipoOperacoes.TRANSFERENCIA, valor));
	}

	/**
	 * Metodos gets
	 * */
	public int getAgencia() {
		return agencia;
	}

	public String getNumeroConta() {
		return numeroConta;
	}

	public double getSaldo() {
		return saldo;
	}

	public Cliente getTitular() {
		return titular;
	}
	
	/**
	 * toString sobrescrito
	 * */
	public String toString() {
		return "Agencia: " + agencia 
				+"\nTipo da Conta: " + numeroTipoConta
				+"\nNumero da conta: "+ numeroConta  
				+"\nSaldo: "+ saldo
				+"\nTitular: " + titular.getNome();
	}

}
