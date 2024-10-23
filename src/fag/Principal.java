package fag;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import objetos.Hospede;
import objetos.Hotel;
import objetos.Quarto;
import objetos.Reserva;

public class Principal {

	public static void main(String[] args) {
		Hotel hotel = new Hotel();
		Scanner scanner = new Scanner(System.in);
		int opcao;

		do {
			System.out.println("\nMenu:");
			System.out.println("1. Cadastrar Quarto");
			System.out.println("2. Check-in");
			System.out.println("3. Check-out");
			System.out.println("4. Listar Reservas");
			System.out.println("5. Listar Quartos");
			//System.out.println("6. Relatório de ocupação - Geral");
			//System.out.println("7. Relatório de ocupação - Hóspede");
			System.out.println("0. Sair");
			System.out.print("Escolha uma opção: ");
			opcao = scanner.nextInt();
			scanner.nextLine();

			switch (opcao) {
			case 1:
				cadastrarQuarto(hotel, scanner);
				break;
			case 2:
				realizarCheckIn(hotel, scanner);
				break;
			case 3:
				realizarCheckOut(hotel, scanner);
				break;
			case 4:
				listarReservas(hotel);
				break;
			case 5:
				listarQuartos(hotel);
				break;
			/*case 6:
				gerarRelatorioOcupacao(hotel);
				break;
			case 7:
				gerarRelatorioOcupacaoHospedes(hotel, scanner);
				break;*/
			case 0:
				System.out.println("Saindo...");
				break;
			default:
				System.out.println("Opção inválida! Tente novamente.");
			}
		} while (opcao != 0);

		scanner.close();
	}

	public static void cadastrarQuarto(Hotel hotel, Scanner scan) {
		System.out.print("Número do quarto: ");
		int numero = scan.nextInt();
		scan.nextLine();

		System.out.print("Tipo de quarto (solteiro, casal, suite): ");
		String tipo = scan.nextLine();

		System.out.print("Preço diário: ");
		float precoDiario = scan.nextFloat();

		Quarto quarto = new Quarto(numero, tipo, precoDiario);
		hotel.CadastrarQuarto(quarto);
		System.out.println("Quarto cadastrado com sucesso!");
	}

	public static void realizarCheckIn(Hotel hotel, Scanner scan) {
		System.out.print("Nome do hóspede: ");
		String nomeHospede = scan.nextLine();
		Hospede hospede = new Hospede(nomeHospede);

		System.out.print("Data de check-in (DD-MM-YYYY): ");
		String dataCheckIn = scan.nextLine();

		System.out.print("Data de check-out (DD-MM-YYYY): ");
		String dataCheckOut = scan.nextLine();

		System.out.print("Tipo de quarto reservado: ");
		String tipoQuarto = scan.nextLine();

		hotel.RealizaCheckIn(hospede, dataCheckIn, dataCheckOut, tipoQuarto);
	}

	public static void realizarCheckOut(Hotel hotel, Scanner scan) {
		System.out.println("Informe o nome completo do hóspede: ");
		String nome_hospede = scan.nextLine();
		List<Reserva> reservas = hotel.getReservas();

		boolean flagHospede = false;
		for (Reserva reserva : reservas) {
			if (reserva.getHospede().getNome().equalsIgnoreCase(nome_hospede)) {
				hotel.RealizaCheckOut(reserva);
				flagHospede = true;
				System.out.println("Check-out realizado!");
				break;
			}
		}
		if (!flagHospede) {
			System.out.println("Ops! Hóspede não encontrado.");
		}
	}

	public static void listarQuartos(Hotel hotel) {
		List<Quarto> listaQuartos = hotel.getQuartos();
		if (listaQuartos.isEmpty()) {
			System.out.println("Não há quartos para listar");
		} else {
			for (Quarto quarto : listaQuartos) {
				System.out.println("Número: " + quarto.getNumero() + ", tipo: " + quarto.getTipo() + ", preço: "
						+ quarto.getPreco());
				System.out.println("-----------");
			}
			System.out.println("- - - - - - - Lista finalizada - - - - - ");
		}
	}

	private static void listarReservas(Hotel hotel) {
		List<Reserva> reservas = hotel.getReservas();
		if (reservas.isEmpty()) {
			System.out.println("Não há reservas cadastradas.");
		} else {
			System.out.println("Reservas:");
			for (Reserva reserva : reservas) {
				System.out.println("Hóspede: " + reserva.getHospede().getNome() + ", Check-in: "
						+ reserva.getDataCheckIn() + ", Check-out: " + reserva.getDataCheckOut() + ", Número Quarto: "
						+ reserva.getNumeroQuarto());
			}
			System.out.println("- - - - - - - Lista finalizada - - - - - ");
		}
	}

	/*public static void gerarRelatorioOcupacao(Hotel hotel) {
		List<Reserva> reservas = hotel.getReservas();
		System.out.println("Quantidade de reservas já feitas: " + reservas.size());
		if (reservas.isEmpty()) {
			System.out.println("Não há dados para listar.");
		} else {

			Map<Integer, Integer> contagemQuartos = new HashMap<>();
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
			int totalDias = 0;
			for (Reserva reserva : reservas) {
				// implementar um dicionário de contagem para o tipo de quarto (tipo de quarto
				// ocupado)

				// criar a lista de quartos no hashmap;
				// criar soma de +1 na chave do tipo de quarto;
				// se não existir a chave, criar e add +1;
				contagemQuartos.put(reserva.getNumeroQuarto(),contagemQuartos.getOrDefault(reserva.getNumeroQuarto(), 0) + (int) 1);

				// calcular total de dias da reserva;
				 int diasOcupados = (int) ChronoUnit.DAYS.between(
		                    LocalDate.parse(reserva.getDataCheckIn(), formatter),
		                    LocalDate.parse(reserva.getDataCheckOut(), formatter));
				 totalDias += diasOcupados;
			}
			System.out.println("Contagem de reservas por tipo de quarto:");
			for (Map.Entry<Integer, Integer> entry : contagemQuartos.entrySet()) {
				System.out.println("Quarto " + entry.getKey() + ": " + entry.getValue() + " reservas");
			}

			double mediaDias = (double) totalDias / reservas.size();
			System.out.println("Média de dias de ocupação: " + mediaDias);
		}
	}

	public static void gerarRelatorioOcupacaoHospedes(Hotel hotel, Scanner scan) {
		System.out.println("Informe o nome completo do hóspede: ");
		String nome_hospede = scan.nextLine();
		List<Reserva> reservas = hotel.getReservas();
		boolean flagHospede = false;
		for (Reserva reserva : reservas) {
			if (reserva.getHospede().getNome().equalsIgnoreCase(nome_hospede)) {
				hotel.RealizaCheckOut(reserva);
				flagHospede = true;
				System.out.println("Check-out realizado!");
				break;
			}
		}
		if (!flagHospede) {
			System.out.println("Ops! Hóspede não encontrado.");
		}
	}*/
}
