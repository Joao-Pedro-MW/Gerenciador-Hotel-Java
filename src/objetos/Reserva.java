package objetos;

public class Reserva {
	
	private Hospede hospede;
	private String dataCKIN;
	private String dataCKOUT;
	private int numeroQuarto;
	
	public Reserva(Hospede hospede, String dataCKIN,int numeroQuarto) {
		this.hospede = hospede;
		this.dataCKIN = dataCKIN;
		this.numeroQuarto = numeroQuarto;
	}
	
	public Hospede getHospede(){ return hospede;}
	public String getDataCheckIn(){ return dataCKIN;}
	public int getNumeroQuarto(){ return numeroQuarto;}
	public void setDataCheckOut(String dataCKOUT){ this.dataCKOUT = dataCKOUT;}
	public String getDataCheckOut(){ return dataCKOUT;}
}
