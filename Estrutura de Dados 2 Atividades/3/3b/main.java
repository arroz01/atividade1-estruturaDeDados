import java.util.Scanner;

class Produto implements Comparable<Produto> {
    int codigo;
    String descricao;
    double preco;

    public Produto(int codigo, String descricao, double preco) {
        this.codigo = codigo;
        this.descricao = descricao;
        this.preco = preco;
    }

    @Override
    public int compareTo(Produto outro) {
        return this.codigo - outro.codigo;
    }
}

public class main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Produto[] produtos = new Produto[12];

        // Cadastro dos produtos
        for (int i = 0; i < produtos.length; i++) {
            System.out.println("Cadastro do produto " + (i + 1) + ":");
            System.out.print("Código: ");
            int codigo = scanner.nextInt();
            scanner.nextLine(); // Limpa o buffer do teclado
            System.out.print("Descrição: ");
            String descricao = scanner.nextLine();
            System.out.print("Preço: ");
            double preco = scanner.nextDouble();
            produtos[i] = new Produto(codigo, descricao, preco);
        }

        // Ordena os produtos por código
        ordenaProdutos(produtos);

        // Solicita o código do produto a ser encontrado
        System.out.print("Digite o código do produto a ser buscado: ");
        int codigoBusca = scanner.nextInt();

        // Realiza a busca binária
        int resultadoBusca = buscaBinaria(produtos, codigoBusca);

        // Exibe o resultado
        if (resultadoBusca != -1) {
            System.out.println("Produto encontrado após " + resultadoBusca + " comparações.");
        } else {
            System.out.println("Produto não encontrado.");
        }
        
        scanner.close();
    }

    // Método de ordenação por inserção
    public static void ordenaProdutos(Produto[] produtos) {
        for (int i = 1; i < produtos.length; i++) {
            Produto atual = produtos[i];
            int j = i - 1;

            while (j >= 0 && produtos[j].compareTo(atual) > 0) {
                produtos[j + 1] = produtos[j];
                j--;
            }
            produtos[j + 1] = atual;
        }
    }

    // Método de busca binária
    public static int buscaBinaria(Produto[] produtos, int codigoBusca) {
        int esquerda = 0;
        int direita = produtos.length - 1;
        int comparacoes = 0;

        while (esquerda <= direita) {
            int meio = esquerda + (direita - esquerda) / 2;
            comparacoes++;

            if (produtos[meio].codigo == codigoBusca) {
                return comparacoes; // Encontrado
            }

            if (produtos[meio].codigo < codigoBusca) {
                esquerda = meio + 1;
            } else {
                direita = meio - 1;
            }
        }

        return -1; // Não encontrado
    }
}
