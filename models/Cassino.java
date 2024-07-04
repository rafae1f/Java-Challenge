package models;

import java.util.ArrayList;
import java.util.List;

public class Cassino {
    private List<Apostador> apostadores;
    private int N;
    private int k;
    private int m;

    public Cassino(int N, int k, int m) {
        this.N = N;
        this.k = k;
        this.m = m;

        this.apostadores = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            apostadores.add(new Apostador(i));
        }
    }

    public String processarApostadores() {
        StringBuilder resultado = new StringBuilder();
        int posicaoHorario = -1;
        int posicaoAntiHorario = N;

        while (!todosRetirados()) {
            posicaoHorario = proximaPosicaoHorario(posicaoHorario);
            posicaoAntiHorario = proximaPosicaoAntiHorario(posicaoAntiHorario);

            Apostador escolhidoHorario = apostadores.get(posicaoHorario);
            Apostador escolhidoAntiHorario = apostadores.get(posicaoAntiHorario);

            if (resultado.length() > 0) {
                resultado.append(", ");
            }

            if (posicaoHorario == posicaoAntiHorario) {
                resultado.append(String.format("%3d", escolhidoHorario.getNumero()));
                escolhidoHorario.setRetirado(true);
            } else {
                resultado.append(String.format("%3d", escolhidoHorario.getNumero()))
                        .append(String.format("%3d", escolhidoAntiHorario.getNumero()));
                escolhidoHorario.setRetirado(true);
                escolhidoAntiHorario.setRetirado(true);
            }
        }

        return resultado.toString();
    }

    private int proximaPosicaoHorario(int posicaoAtual) {
        int contador = 0;
        while (contador < k) {
            posicaoAtual = (posicaoAtual + 1) % N;
            if (!apostadores.get(posicaoAtual).isRetirado()) {
                contador++;
            }
        }
        return posicaoAtual;
    }

    private int proximaPosicaoAntiHorario(int posicaoAtual) {
        int contador = 0;
        while (contador < m) {
            posicaoAtual = (posicaoAtual - 1 + N) % N;
            if (!apostadores.get(posicaoAtual).isRetirado()) {
                contador++;
            }
        }
        return posicaoAtual;
    }

    private boolean todosRetirados() {
        for (Apostador a : apostadores) {
            if (!a.isRetirado()) {
                return false;
            }
        }
        return true;
    }
}
