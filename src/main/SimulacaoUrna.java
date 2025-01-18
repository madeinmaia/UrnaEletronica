package main;

import java.util.Scanner;

 // Classe principal
 public class SimulacaoUrna {
    public static void main(String[] args) {
        UrnaEletronica urna = new UrnaEletronica();
        Scanner scanner = new Scanner(System.in);
        int votosTotais = 10;

        System.out.println("Bem-vindo à Urna Eletrônica!");
        System.out.println("Candidatos disponíveis:");
        System.out.println("01 - Ada Lovelace");
        System.out.println("02 - Alan Turing");
        System.out.println("03 - Marie Curie");
        System.out.println("04 - Albert Einstein");
        System.out.println("05 - Ludwig van Beethoven");
        System.out.println("Digite o número do candidato para votar.\n");

        for (int i = 1; i <= votosTotais; i++) {
            while (true) {
                System.out.printf("Digite o número do candidato para o voto %d: ", i);
                String entrada = scanner.nextLine();
                // Verifica se a entrada é válida
                if (!entrada.matches("\\d{2}")) {
                    System.out.println("Entrada inválida! O número deve ter exatamente dois dígitos.");
                    continue;
                }
                int voto = Integer.parseInt(entrada);
                // Confirmação do voto
                System.out.printf("Você votou no candidato número %02d. Confirma? (S/N): ", voto);
                String confirmacao = scanner.nextLine().trim().toUpperCase();
                if (confirmacao.equals("S")) {
                    urna.receberVoto(voto);
                    break;
                } else {
                    System.out.println("Voto cancelado. Digite novamente.");
                }
            }
        }
        urna.apurarResultados();
        scanner.close();
    }
}
