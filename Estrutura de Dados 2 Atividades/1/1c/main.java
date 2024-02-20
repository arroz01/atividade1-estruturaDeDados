import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] nomes = new String[5];
        double[] salarios = new double[5];

        // cadastro
        for (int i = 0; i < 5; i++) {
            System.out.println("Digite o nome do funcionário " + (i + 1) + ":");
            nomes[i] = scanner.nextLine();
            
            System.out.println("Digite o salário do funcionário " + (i + 1) + ":");
            salarios[i] = scanner.nextDouble();
            scanner.nextLine(); // Limpa o buffer do teclado
        }

        // Ordenação por nome usando Bubble Sort
        for (int i = 0; i < nomes.length; i++) {
            for (int j = i + 1; j < nomes.length; j++) {
                if (nomes[i].compareTo(nomes[j]) > 0) {
                    // Troca nomes
                    String tempNome = nomes[i];
                    nomes[i] = nomes[j];
                    nomes[j] = tempNome;
                    
                    // Troca salários para manter correspondência
                    double tempSalario = salarios[i];
                    salarios[i] = salarios[j];
                    salarios[j] = tempSalario;
                }
            }
        }

        // lista funcionarios por nome
        System.out.println("\nFuncionários ordenados por nome:");
        for (int i = 0; i < 5; i++) {
            System.out.println("Nome: " + nomes[i] + ", Salário: " + salarios[i]);
        }

        scanner.close();
    }
}
