
public class Cliente {

	//atributos
	private String nome;
	private int idade;
	private String cpf;
	
	//construtor
	public Cliente(String nome, int idade, String cpf){
		this.nome = nome;
		this.idade = idade;
		this.cpf = cpf;
	}

	//metodos get e set
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}
	
	public String getCpf() {
		return cpf;
	}

	// metodo equals sobrescrito
	public boolean equals(Cliente cliente) {
		if (this.cpf.equals(cliente.getCpf()))
			return true;
		return false;
	}
}