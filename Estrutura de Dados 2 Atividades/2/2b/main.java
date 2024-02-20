import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numeros = new int[10]; // esse array vai armazenar os números
        int menor, maior, contadorMenor = 0, contadorMaior = 0; // Variáveis para armazenar o menor e maior número e suas contagens

        // Leitura dos números
        System.out.println("Digite 10 números:");
        for (int i = 0; i < 10; i++) {
            System.out.print("Número " + (i + 1) + ": ");
            numeros[i] = scanner.nextInt();
        }

        // começa o menor e o maior número com o primeiro valor do array
        menor = maior = numeros[0];

        // vai percorror o array uma única vez para encontrar o menor e o maior número
        for (int numero : numeros) {
            if (numero < menor) {
                menor = numero;
                contadorMenor = 1; // Reinicia a contagem para o novo menor número
            } else if (numero == menor) {
                contadorMenor++; // Incrementa se for igual ao menor atual
            }

            if (numero > maior) {
                maior = numero;
                contadorMaior = 1; // Reinicia a contagem para o novo maior número
            } else if (numero == maior) {
                contadorMaior++; // incrementa se for igual ao maior atual
            }
        }

        //vai listar o resultado
        System.out.println("O maior número é " + maior + " e ele aparece " + contadorMaior + " vezes.");

        scanner.close();
    }
}
