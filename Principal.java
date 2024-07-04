import models.Cassino;

import java.util.Scanner;

public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    while (true) {
        System.out.println("************************************************************\n" +
                "Bem vindo ao Cassino Romeno\n\n" +
                "Digite o número de apostadores, \n" +
                "posição escolhida no sentido horário e \n" +
                "posição escolhida no sentido anti-horário: ");
        int N = scanner.nextInt();
        int k = scanner.nextInt();
        int m = scanner.nextInt();

        if (N == 0 && k == 0 && m == 0) {
            break;
        }

        if (N < 1 || N >= 20 || k <= 0 || m <= 0) {
            System.out.println("Entrada inválida. Tente novamente.");
            continue;
        }

        Cassino cassino = new Cassino(N, k, m);
        System.out.println(cassino.processarApostadores());

        System.out.println("Jogar novamente? (0 para sair, qualquer outro número para continuar)");
        int jogarNovamente = scanner.nextInt();

        if (jogarNovamente == 0) {
            System.out.println("Até mais! =)");
            break;
        }
    }

    scanner.close();
}
