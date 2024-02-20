import java.util.Arrays;
import java.util.Comparator;

class Aluno {
    String nome;
    double nota1, nota2;

    public Aluno(String nome, double nota1, double nota2) {
        this.nome = nome;
        this.nota1 = nota1;
        this.nota2 = nota2;
    }

    public double mediaPonderada() {
        return (nota1 * 2 + nota2 * 3) / 5.0;
    }
}

public class main {

    public static void main(String[] args) {
        Aluno[] alunos = new Aluno[8];

        // cadastro de alunos
        alunos[0] = new Aluno("João", 8.0, 7.5);
        alunos[1] = new Aluno("Maria", 6.5, 9.0);
        alunos[2] = new Aluno("Ana", 5.0, 8.0);
        alunos[3] = new Aluno("Pedro", 7.0, 6.0);
        alunos[4] = new Aluno("Lucas", 9.0, 8.5);
        alunos[5] = new Aluno("Paula", 6.0, 7.0);
        alunos[6] = new Aluno("Carla", 8.5, 9.0);
        alunos[7] = new Aluno("Felipe", 5.5, 6.5);

        // média ponderada e listando
        System.out.println("Alunos ordenados pela média ponderada:");
        Arrays.sort(alunos, Comparator.comparingDouble(Aluno::mediaPonderada).reversed());
        for (Aluno aluno : alunos) {
            System.out.println(aluno.nome + " - Média Ponderada: " + aluno.mediaPonderada());
        }

        // nota 1 e listando
        System.out.println("\nAlunos ordenados pela Nota 1:");
        Arrays.sort(alunos, Comparator.comparingDouble(a -> a.nota1));
        for (Aluno aluno : alunos) {
            System.out.println(aluno.nome + " - Nota 1: " + aluno.nota1);
        }

        // listando alunos reprovados por média < 7, em ordem alfabética
        System.out.println("\nAlunos reprovados (média < 7):");
        Arrays.stream(alunos)
                .filter(a -> a.mediaPonderada() < 7)
                .sorted(Comparator.comparing(a -> a.nome))
                .forEach(aluno -> System.out.println(aluno.nome + " - Média Ponderada: " + aluno.mediaPonderada()));
    }
}
