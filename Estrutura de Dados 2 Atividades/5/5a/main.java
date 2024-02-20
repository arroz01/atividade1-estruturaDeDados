import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numeros = new int[15];

        // úmeros
        for (int i = 0; i < numeros.length; i++) {
            System.out.print("Digite o número " + (i + 1) + ": ");
            numeros[i] = scanner.nextInt();
        }

        // ordenação dos números com Bubble Sort
        for (int i = 0; i < numeros.length - 1; i++) {
            for (int j = 0; j < numeros.length - i - 1; j++) {
                if (numeros[j] > numeros[j + 1]) {
                    // Troca os elementos
                    int temp = numeros[j];
                    numeros[j] = numeros[j + 1];
                    numeros[j + 1] = temp;
                }
            }
        }

        // Mostra os números
        System.out.println("Números ordenados:");
        for (int num : numeros) {
            System.out.print(num + " ");
        }
        System.out.println();

        // Busca sequencial 
        System.out.print("Digite um número para verificar se está na lista: ");
        int numeroBusca = scanner.nextInt();
        boolean encontrado = false;
        int posicao = -1;

        for (int i = 0; i < numeros.length; i++) {
            if (numeros[i] == numeroBusca) {
                encontrado = true;
                posicao = i;
                break;
            }
        }

        // posição do número, se encontrado
        if (encontrado) {
            System.out.println("Número encontrado na posição: " + (posicao + 1));
            if ((posicao + 1) % 2 == 0) {
                System.out.println("A posição é par.");
            } else {
                System.out.println("A posição é ímpar.");
            }
        } else {
            System.out.println("Número não encontrado.");
        }

        scanner.close();
    }
}
