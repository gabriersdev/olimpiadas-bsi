import java.util.Arrays;
import java.util.Scanner;

public class SmurfsDaSegundona {
    public static void main(String[] args) {
        // SmurfsDaSegundona
        //
        //// Os roupeiros do time do Azul da Segundona compraram um grande número de pares de chuteiras de
        //vários tamanhos para seus jogadores. Porém uma falha na logística da empresa impediu que todos os
        //pares fossem entregues corretamente, ou seja, com duas chuteiras do mesmo tamanho, uma para cada
        //pé. Após jogar sal grosso nas encomendas, o pai de santo ordenou que os atletas da divisão de base
        //retirassem todas as chuteiras de todas as caixas para embalar corretamente. Porém, você é um dos atletas
        //e sabe programar, portanto escreva um programa que, recebe a lista contendo as descrições das chuteiras
        //(número e lado, exemplo 42 D) e mostre quantos pares corretos podem ser formados com as chuteiras
        //entregues.
        //
        //Entrada: Seu programa deve receber um inteiro N indicando o número de chuteiras individuais
        //entregues. Após isso, solicite N entradas que descrevem uma chuteira, essa entrada deve conter um
        //número inteiro M e uma letra L, separados por um espaço em branco. M indica o número do tamanho da
        //chuteira e L indica o pé: L= ‘D’ indica que a chuteira é do pé direito, L= ‘E’ indica que a chuteira é do
        //pé esquerdo.
        //
        //Saída: Seu programa deve informar o número de pares corretos que podem ser formado, imprimindo
        //uma única linha contendo um único número inteiro.

        Scanner in = new Scanner(System.in);
        int shoesQuantity, pairsFormed = 0;
        String allShoesString;

        System.out.println("Informe a quantidade de chuteiras seram relacionadas: ");
        shoesQuantity = in.nextInt();
        String[] shoesList = new String[shoesQuantity];

        in.nextLine();

        for (int i = 0; i < shoesList.length; i++) {
            System.out.println("Informe a relação da chuteira para a posição " + (i + 1) + ": ");
            shoesList[i] = in.nextLine();
        }

        allShoesString = Arrays.toString(shoesList).toLowerCase();

        for (int i = 0; i < shoesList.length; i++) {
            String currentShoe = shoesList[i].toLowerCase();
            String[] shoeDetails = currentShoe.split(" ");

            String shoeSize = shoeDetails[0];
            String shoeSide = shoeDetails[1];
            String missingShoeSide = shoeSide.equals("e") ? "d" : "e";

            String searchString = shoeSize + " " + missingShoeSide;

            if (allShoesString.contains(currentShoe) && allShoesString.contains(searchString)) {
                pairsFormed++;
                allShoesString = allShoesString.replaceFirst(currentShoe, "usado");
                allShoesString = allShoesString.replaceFirst(searchString, "usado");
            }
        }

        System.out.println("De acordo com os dados informados podem ser formados " + pairsFormed + " pares de chuteiras.");
    }
}
