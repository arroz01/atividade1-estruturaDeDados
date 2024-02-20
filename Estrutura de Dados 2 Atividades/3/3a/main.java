import java.util.Scanner;

class Produto {
    int codigo;
    String descricao;
    double preco;

    public Produto(int codigo, String descricao, double preco) {
        this.codigo = codigo;
        this.descricao = descricao;
        this.preco = preco;
    }
}

public class main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Produto[] produtos = new Produto[12];

        // cadastro
        for (int i = 0; i < 12; i++) {
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

        // pede o código do produto a ser encontrado
        System.out.print("Digite o código do produto a ser buscado: ");
        int codigoBusca = scanner.nextInt();

        // busca sequencial
        int resultadoBusca = buscaSequencial(produtos, codigoBusca);

        // lista o resultado
        if (resultadoBusca != -1) {
            System.out.println("Produto encontrado após " + resultadoBusca + " comparações.");
        } else {
            System.out.println("Produto não encontrado.");
        }
        
        scanner.close();
    }

    // busca sequencial
    public static int buscaSequencial(Produto[] produtos, int codigoBusca) {
        for (int i = 0; i < produtos.length; i++) {
            if (produtos[i].codigo == codigoBusca) {
                // Retorna a quantidade de comparações feitas (i + 1, pois o índice começa em 0)
                return i + 1;
            }
        }
        return -1; // Indica que o produto não foi encontrado
    }
}
