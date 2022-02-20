
public class Main {

	public static void main(String[] args) {
		
		Cliente cliente1 = new Cliente("Carlos", 18, "121.3131.-121"); //instancia de cliente1 para teste
		Cliente cliente2 = new Cliente("Maria", 18, "121.3131.-122"); //instancia de cliente2 para teste
		
		Conta cc = new ContaCorrente(cliente1); //instancia de conta corrente para teste
		Conta poupanca = new ContaPoupanca(cliente2); //instancia de conta poupanca para teste

		//operacoes para testar os metodos implementados na classe Conta
		cc.depositar(100);
		try {
			cc.transferir(100, poupanca);
			poupanca.sacar(50);
			cc.transferir(100, poupanca);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		cc.extrato();
		poupanca.extrato();
		
		System.out.println(cc.toString());
		System.out.println(poupanca.toString());
		
	}
}
