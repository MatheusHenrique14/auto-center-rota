import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class EstoqueFuncoes {
    public static void cadastrarEstoque() {
        Scanner scanner = new Scanner(System.in);

        try {
            FileWriter arquivo = new FileWriter("app/data/estoque.csv", true);
            PrintWriter gravador = new PrintWriter(arquivo);

            System.out.println("==================================");
            System.out.println("Cadastro de Estoque");
            System.out.println("==================================");
            System.out.print("> Informe o Código da Peça: ");
            Estoque.codigo = scanner.nextInt();

            scanner.nextLine();

            System.out.print("> Informe a Descrição da Peça: ");
            Estoque.descricao_peca = scanner.nextLine();

            System.out.print("> Informe a Quantidade da Peça no Estoque: ");
            Estoque.quantidade_peca = scanner.nextInt();

            System.out.print("> Informe o Valor da Peça: R$ ");
            Estoque.valor_peca = scanner.nextDouble();

            String dado = Estoque.codigo + ";" + Estoque.descricao_peca + ";" + Estoque.quantidade_peca + ";"
                    + Estoque.valor_peca;

            gravador.println(dado);

            gravador.close();

            System.out.println("==================================");
            System.out.println("Estoque Cadastrado com Sucesso.");
            System.out.println("==================================");
        } catch (Exception e) {
            System.out.println("Erro ao Cadastrar Peça no Estoque: " + e.getMessage());
        }
    }
}
