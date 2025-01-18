package main;

import candidatos.Candidato;
import java.util.ArrayList;

class UrnaEletronica {
    private ArrayList<Candidato> candidatos;
    private int votosNulos;

    public UrnaEletronica() {
        candidatos = new ArrayList<>();
        candidatos.add(new Candidato("Ada Lovelace", 01));
        candidatos.add(new Candidato("Alan Turing", 02));
        candidatos.add(new Candidato("Marie Curie", 03));
        candidatos.add(new Candidato("Albert Einstein", 04));
        candidatos.add(new Candidato("Ludwig van Beethoven", 05));
        votosNulos = 0;
    }

    public void receberVoto(int numero) {
        boolean votoValido = false;
        for (Candidato candidato : candidatos) {
            if (candidato.getNumero() == numero) {
                candidato.incrementarVotos();
                votoValido = true;
                break;
            }
        }
        if (!votoValido) {
            votosNulos++;
        }
    }

    public void apurarResultados() {
        int totalVotosValidos = 0;
        for (Candidato candidato : candidatos) {
            totalVotosValidos += candidato.getVotos();
        }

        System.out.println("\nResultados da votação:");
        for (Candidato candidato : candidatos) {
            int votos = candidato.getVotos();
            double percentual = (totalVotosValidos > 0) ? (votos * 100.0 / totalVotosValidos) : 0.0;
            System.out.printf("%s (%d): %d votos (%.2f%%)%n", candidato.getNome(), candidato.getNumero(), votos, percentual);
        }
        System.out.println("Votos Nulos: " + votosNulos);

        // Determinar vencedor
        int maiorVotos = 0;
        ArrayList<Candidato> vencedores = new ArrayList<>();
        for (Candidato candidato : candidatos) {
            if (candidato.getVotos() > maiorVotos) {
                maiorVotos = candidato.getVotos();
                vencedores.clear();
                vencedores.add(candidato);
            } else if (candidato.getVotos() == maiorVotos) {
                vencedores.add(candidato);
            }
        }

        if (vencedores.size() > 1) {
            System.out.println("Houve empate entre os candidatos:");
            for (Candidato vencedor : vencedores) {
                System.out.println("- " + vencedor.getNome());
            }
        } else if (!vencedores.isEmpty()) {
            System.out.println("O vencedor é: " + vencedores.get(0).getNome());
        } else {
            System.out.println("Nenhum voto válido foi registrado.");
        }
    }
}
