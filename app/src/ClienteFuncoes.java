import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class ClienteFuncoes {
    public static void cadastrarCliente() {
        Scanner scanner = new Scanner(System.in);

        try {
            FileWriter arquivo = new FileWriter("app/data/cliente.csv", true);
            PrintWriter gravador = new PrintWriter(arquivo);

            System.out.println("==================================");
            System.out.println("Cadastro de Cliente");
            System.out.println("==================================");
            System.out.print("> Informe a Placa do Veículo: ");
            Cliente.placa_veiculo = scanner.nextLine();

            System.out.print("> Informe o Modelo do Veículo: ");
            Cliente.modelo_veiculo = scanner.nextLine();

            System.out.print("> Informe o Nome do Cliente: ");
            Cliente.nome = scanner.nextLine();

            String dado = Cliente.placa_veiculo + ";" + Cliente.modelo_veiculo + ";" + Cliente.nome;

            gravador.println(dado);

            gravador.close();
            System.out.println("==================================");
            System.out.println("Cliente Cadastrado com Sucesso.");
            System.out.println("==================================");
        } catch (Exception e) {
            System.out.println("Erro ao Cadastrar Cliente: " + e.getMessage());
        }
    }
}
