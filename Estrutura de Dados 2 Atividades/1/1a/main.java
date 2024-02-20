import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] nomes = new String[5];
        double[] salarios = new double[5];

        // cadastros
        for (int i = 0; i < 5; i++) {
            System.out.println("Digite o nome do funcionário " + (i + 1) + ":");
            nomes[i] = scanner.nextLine();
            
            System.out.println("Digite o salário do funcionário " + (i + 1) + ":");
            salarios[i] = scanner.nextDouble();
            scanner.nextLine(); // Limpa o buffer do teclado
        }

        // Ordenação por salário usando Bubble Sort
        for (int i = 0; i < salarios.length; i++) {
            for (int j = i + 1; j < salarios.length; j++) {
                if (salarios[i] > salarios[j]) {
                    //  salários
                    double tempSalario = salarios[i];
                    salarios[i] = salarios[j];
                    salarios[j] = tempSalario;
                    
                    // 
                    String tempNome = nomes[i];
                    nomes[i] = nomes[j];
                    nomes[j] = tempNome;
                }
            }
        }

        // lista os funcionarios ordenados
        System.out.println("\nFuncionários ordenados por salário:");
        for (int i = 0; i < 5; i++) {
            System.out.println("Nome: " + nomes[i] + ", Salário: " + salarios[i]);
        }

        scanner.close();
    }
}
