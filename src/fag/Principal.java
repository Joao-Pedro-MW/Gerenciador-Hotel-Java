package fag;
import objetos.*;
from java.util import Scanner;
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
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir a nova linha

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
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        } while (opcao != 0);

        scanner.close();
    }

	}

}
