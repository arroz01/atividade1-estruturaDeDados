import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numeros = new int[15];
        int count = 0;

        while (count < 15) {
            System.out.print("Digite um número único (" + (count + 1) + "/15): ");
            int num = scanner.nextInt();

            // Checa se o número já foi inserido
            if (!numeroJaInserido(numeros, num, count)) {
                numeros[count] = num;
                count++;
            } else {
                System.out.println("Número repetido. Tente novamente.");
            }
        }

        // Bubble Sort
        for (int i = 0; i < numeros.length - 1; i++) {
            for (int j = 0; j < numeros.length - i - 1; j++) {
                if (numeros[j] > numeros[j + 1]) {
                    // Troca
                    int temp = numeros[j];
                    numeros[j] = numeros[j + 1];
                    numeros[j + 1] = temp;
                }
            }
        }

        // Busca binária simplificada 
        System.out.print("Digite um número para encontrar: ");
        int alvo = scanner.nextInt();
        int inicio = 0, fim = numeros.length - 1, meio, posicao = -1;

        while (inicio <= fim) {
            meio = (inicio + fim) / 2;

            if (numeros[meio] == alvo) {
                posicao = meio;
                break;
            } else if (numeros[meio] < alvo) {
                inicio = meio + 1;
            } else {
                fim = meio - 1;
            }
        }

        // Verifica se o número foi encontrado se a posição é par ou ímpar
        if (posicao != -1) {
            System.out.println("Número " + alvo + " encontrado na posição: " + (posicao + 1));
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

    // verifica se um número já foi inserido
    public static boolean numeroJaInserido(int[] arr, int num, int count) {
        for (int i = 0; i < count; i++) {
            if (arr[i] == num) {
                return true;
            }
        }
        return false;
    }
}
