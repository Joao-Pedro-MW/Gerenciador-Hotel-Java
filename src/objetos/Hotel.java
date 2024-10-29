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

	

	public void RealizaCheckIn(Hospede hospede, String dataCheckIn, String dataCheckOut, String tipoQuarto) {
		if(quartos.size() != 0) {
			for (Quarto quarto : quartos) {
				System.out.println(quarto.getDisponibilidade());
				if (quarto.getTipo().equalsIgnoreCase(tipoQuarto) && quarto.getDisponibilidade()) {
					quarto.setDisponibilidade(false);
					System.out.println("Quarto disponível: " + quarto.getNumero());
					reservas.add((new Reserva(hospede, dataCheckIn, dataCheckOut, quarto.getNumero())));
					System.out.println("Check-in realizado ! :D");
					break;
				}
			}
		} else {
			System.out.println("Não há vagas...");
		}
	}
	public void RealizaCheckOut(Reserva reserva) {
		for (Quarto quarto : quartos) {
			if (quarto.getNumero() == reserva.getNumeroQuarto()) {
				quarto.setDisponibilidade(true);
			}
		}
	}

	public List<Quarto> getQuartos() {
		return quartos;
	}

	public List<Reserva> getReservas() {
		return reservas;
	}

}
