import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class OsFuncoes {
    public static void cadastrarOrdemServico() {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.println("==================================");
            System.out.println("Cadastro de Ordem de Servico");
            System.out.println("==================================");
            
            System.out.print("> Informe o Codigo da OS: ");
            Os.codigo = scanner.nextInt();
            scanner.nextLine(); // Limpa buffer

            // VALIDAÇÃO DA PLACA
            while (true) {
                System.out.print("> Informe a Placa do Veiculo: ");
                Os.placa_veiculo = scanner.nextLine().trim();

                if (validacao.placaExiste(Os.placa_veiculo)) {
                    break; // Placa existe, continua o programa
                }
                System.out.println("[ERRO] Placa nao cadastrada no sistema!");
            }

            // VALIDAÇÃO DO MECÂNICO
            while (true) {
                System.out.print("> Informe o Codigo do Mecanico Responsavel: ");
                Os.codigo_mecanico = scanner.nextInt();

                if (validacao.mecanicoExiste(Os.codigo_mecanico)) {
                    break; // Mecânico existe, continua o programa
                }
                System.out.println("[ERRO] Mecanico nao encontrado!");
                scanner.nextLine();
            }

            // VALIDAÇÃO DE ESTOQUE (REGRA DE OURO)
            String textoNovoEstoque = null;
            while (textoNovoEstoque == null) {
                System.out.print("> Informe o Codigo da Peca que Sera Usada: ");
                Os.codigo_peca = scanner.nextInt();

                System.out.print("> Informe a Quantidade de Peca que Sera Usada: ");
                Os.quantidade_peca = scanner.nextInt();

                if (Os.quantidade_peca < 0) {
                    System.out.println("[ERRO] Quantidade nao pode ser negativa.");
                    continue;
                }

                // Valida o estoque. Se falhar, retorna null e o laço repete
                textoNovoEstoque = validacao.verificarEAtualizarEstoque(Os.codigo_peca, Os.quantidade_peca);
            }

            // Desconta a peça do estoque reescrevendo o arquivo estoque.csv automaticamente
            FileWriter fwEstoque = new FileWriter("app/data/estoque.csv", false);
            PrintWriter pwEstoque = new PrintWriter(fwEstoque);
            pwEstoque.print(textoNovoEstoque);
            pwEstoque.close();

            System.out.print("> Informe o Valor da Mao de Obra: R$ ");
            Os.valor_mao_obra = scanner.nextDouble();

            // SALVAMENTO NO ARQUIVO DA OS
            FileWriter arquivo = new FileWriter("app/data/os.csv", true);
            PrintWriter gravador = new PrintWriter(arquivo);

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