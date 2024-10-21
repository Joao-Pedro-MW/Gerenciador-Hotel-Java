package objetos;
import java.util.List;
import java.util.ArrayList;

public class Hotel {
	private List<Quarto> quartos;
	private List<Reserva> reservas;
	
	public Hotel() {
		quartos = new ArrayList<>();
		reservas = new ArrayList<>();
	}
	
	// 	todo cadastrar quarto
	
	// todo cadastrar reserva
	
	// todo checkin
	
	// todo checkout
	
	public List<Quarto> getQuartos(){return quartos;}
	public List<Reserva> getReservas(){return reservas;}
	
}
