import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class OsFuncoes {
    public static void cadastrarOrdemServico() {
        Scanner scanner = new Scanner(System.in);

        try {
            FileWriter arquivo = new FileWriter("app/data/os.csv", true);
            PrintWriter gravador = new PrintWriter(arquivo);

            System.out.println("==================================");
            System.out.println("Cadastro de Ordem de Serviço");
            System.out.println("==================================");
            System.out.print("> Informe o Código da OS: ");
            Os.codigo = scanner.nextInt();

            scanner.nextLine();

            System.out.print("> Informe a Placa do Veículo: ");
            Os.placa_veiculo = scanner.nextLine();

            System.out.print("> Informe o Código do Mecânico Responsável: ");
            Os.codigo_mecanico = scanner.nextInt();

            System.out.print("> Informe o Código da Peça que Será Usada: ");
            Os.codigo_peca = scanner.nextInt();

            System.out.print("> Informe a Quantidade de Peça que Será Usada: ");
            Os.quantidade_peca = scanner.nextInt();

            System.out.print("> Informe o Valor da Mão de Obra: R$ ");
            Os.valor_mao_obra = scanner.nextDouble();

            String dado = Os.codigo + ";" + Os.placa_veiculo + ";" + Os.codigo_mecanico + ";" + Os.codigo_peca + ";"
                    + Os.quantidade_peca + ";" + Os.valor_mao_obra;

            gravador.println(dado);

            gravador.close();

            System.out.println("==================================");
            System.out.println("OS Cadastrada com Sucesso.");
            System.out.println("==================================");
        } catch (Exception e) {
            System.out.println("Erro ao Cadastrar a OS: " + e.getMessage());
        }
    }
}
