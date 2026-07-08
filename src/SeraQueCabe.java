import java.util.Scanner;

public class SeraQueCabe {
    public static void main(String[] args) {
        // A FCC (Fábrica de Cilindros de Carbono) fabrica vários tipos de cilindros de carbono. A FCC está
        //        instalada no décimo andar de um prédio, e utiliza os vários elevadores do prédio para transportar os
        //        cilindros. Por questão de segurança, os cilindros devem ser transportados na posição vertical; como são
        //        pesados, no máximo dois cilindros podem ser transportados em uma única viagem de elevador. Os
        //        elevadores têm formato de paralelepípedo e sempre têm altura maior que a altura dos cilindros. Para
        //        minimizar o número de viagens de elevador para transportar os cilindros, a FCC quer, sempre que
        //        possível, colocar dois cilindros no elevador. A figura abaixo ilustra, esquematicamente (vista superior),
        //        um caso em que isto é possível (a), e um caso em que isto não é possível (b):

        // A entrada contém vários casos de teste. A primeira e única linha de cada caso de teste contém quatro
        //números inteiros L, C, R1 e R2, separados por espaços em branco, indicando respectivamente a largura
        //do elevador (1 ≤ L ≤ 100), o comprimento do elevador (1 ≤ C ≤ 100), e os raios dos cilindros (1 ≤ R1, R2
        //≤ 100). O último caso de teste é seguido por uma linha que contém quatro zeros separados por espaços
        //em branco.

        // Para cada caso de teste, o seu programa deve imprimir uma única linha com um único caractere: ‘S’ se for
        // possível colocar os dois cilindros no elevador e ‘N’ caso contrário.

        Scanner in = new Scanner(System.in);
        int larguraElevador, comprimentoElevador, raioCilindro1, raioCilindro2;
        boolean cabem = false;

        System.out.println("Informe a largura do elevador, o comprimento do elevador, o raio do cilindro 1 e o raio do cilindro 2 - nesta ordem: ");
        String input = in.nextLine();
        String[] inputSplitted = input.split(" ");

        larguraElevador = Integer.parseInt(inputSplitted[0]);
        comprimentoElevador = Integer.parseInt(inputSplitted[1]);
        raioCilindro1 = Integer.parseInt(inputSplitted[2]);
        raioCilindro2 = Integer.parseInt(inputSplitted[3]);

        int r1 = raioCilindro1;
        int r2 = raioCilindro2;

        if ((r1 + r2) * 2 <= comprimentoElevador && Math.max(r1, r2) * 2 <= larguraElevador) cabem = true;
        if ((r1 + r2) * 2 <= larguraElevador && Math.max(r1, r2) * 2 <= comprimentoElevador) cabem = true;

        if (r1 * 2 <= comprimentoElevador && r1 * 2 <= larguraElevador && r2 * 2 <= comprimentoElevador && r2 * 2 <= larguraElevador) {
            // Calculo do centro
            double distCentrosQuadrado = Math.pow(comprimentoElevador - r1 - r2, 2) + Math.pow(larguraElevador - r1 - r2, 2);
            if (distCentrosQuadrado >= Math.pow(r1 + r2, 2)) cabem = true;
        }

        System.out.println("É possível que ambos cilindros caibam no elevador? ");
        if (cabem) System.out.println("S");
        else System.out.println("N");

        in.close();
    }
}
