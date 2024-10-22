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
	
	public void CadastrarQuarto(Quarto quarto) {
		quartos.add(quarto);
	}
	
	
	public void CadastrarReserva(Reserva reserva) {
		reservas.add(reserva);
		for (Quarto quarto : quartos) {
			if(quarto.getDisponibilidade()) {
				quarto.setDisponibilidade(false);
			}
		}
	}
	public void RealizaCheckIn(Hospede hospede, String dataCheckIn, String dataCheckOut,String tipoQuarto) {
		for (Quarto quarto : quartos) {
			if(quarto.getTipo().equalsIgnoreCase(tipoQuarto)) {
				quarto.setDisponibilidade(false);
				System.out.println("Quarto disponível: " + quarto.getNumero());
		        CadastrarReserva(new Reserva(hospede, dataCheckIn, dataCheckOut, quarto.getNumero()));
				break;
			}
		}
	}
	public void RealizaCheckOut(Reserva reserva) {
		for (Quarto quarto : quartos) {
			if(quarto.getNumero() == reserva.getNumeroQuarto()) {
				quarto.setDisponibilidade(false);
			}
		}
	}
	
	public List<Quarto> getQuartos(){return quartos;}
	public List<Reserva> getReservas(){return reservas;}
	
}
