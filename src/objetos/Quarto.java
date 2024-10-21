package objetos;

public class Quarto {
	private int numero;
	private String tipo;
	private float preco;
	private boolean disponibilidade;
	
	public Quarto(int numero, String tipo, float preco) {
		this.numero = numero;
		this.tipo = tipo;
		this.preco = preco;
		this.disponibilidade = true;
	}

	public int getNumero() {return numero;}
	public String getTipo() {return tipo;}
	public float getPreco() {return preco;}
	public boolean getDisponibilidade() {return disponibilidade;}
	public void setDisponibilidade(boolean disponibilidade) {this.disponibilidade = disponibilidade;}	
	
}
