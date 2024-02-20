import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numeros = new int[10]; // esse rray vai armazenar os números
        int menor, contador = 0; //  essas variáveis vão armazenar o menor número e sua contagem

        // Leitura dos números
        System.out.println("Digite 10 números:");
        for (int i = 0; i < 10; i++) {
            System.out.print("Número " + (i + 1) + ": ");
            numeros[i] = scanner.nextInt();
        }

        // começa pelo menor numero no array
        menor = numeros[0];

        // encontra o menor número
        for (int numero : numeros) {
            if (numero < menor) {
                menor = numero;
            }
        }

        // Conta quantas vezes o menor número aparece
        for (int numero : numeros) {
            if (numero == menor) {
                contador++;
            }
        }

        // lista o resultado
        System.out.println("O menor número é " + menor + " e ele aparece " + contador + " vezes.");

        scanner.close();
    }
}
