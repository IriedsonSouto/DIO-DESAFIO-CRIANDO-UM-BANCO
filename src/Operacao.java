import java.text.SimpleDateFormat;
import java.util.Date;

public class Operacao {

	//atributos
	private TipoOperacoes tipoOperacao;
	private double valor;
	private String data;
	
	
	// construtor
	public Operacao(TipoOperacoes tipoOperacao, double valor) {
		this.tipoOperacao = tipoOperacao;
		this.valor = valor;
		SimpleDateFormat data = new SimpleDateFormat("dd/MM/yyyy");
		this.data = data.format(new Date( System.currentTimeMillis()));
	}
	
	//metodos get
	public TipoOperacoes getTipoOperacao() {
		return tipoOperacao;
	}
	public double getValor() {
		return valor;
	}

	public String getData() {
		return data;
	}
	
	// metodo toString sobrescrito
	public String toString() {
		return "Operacao: "+this.getTipoOperacao()
			+", Valor: "+this.getValor()+", Data: "+this.getData();
	}
}
