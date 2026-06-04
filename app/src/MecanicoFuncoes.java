import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class MecanicoFuncoes {

    public static void cadastrarMecanico() {
        Scanner scanner = new Scanner(System.in);

        try {
            FileWriter arquivo = new FileWriter("data/mecanico.csv", true);
            PrintWriter gravador = new PrintWriter(arquivo);

            System.out.println("==================================");
            System.out.println("Cadastro de Mecânico");
            System.out.println("==================================");
            System.out.print("> Informe o Código do Mecânico: ");
            Mecanico.codigo = scanner.nextInt();

            scanner.nextLine();

            System.out.print("\n> Informe o Nome do Mecânico: ");
            Mecanico.nome = scanner.nextLine();

            escolherEspecialidade();

            String dado = Mecanico.codigo + ";" + Mecanico.nome + ";" + Mecanico.especialidade;

            gravador.println(dado);

            gravador.close();
            scanner.close();
        } catch (Exception e) {
            System.out.println("Error ao Cadastrar o Mecânico: " + e.getMessage());
        }
    }

    public static String escolherEspecialidade() {
        Scanner scanner = new Scanner(System.in);

        int escolha;

        System.out.println("Informe a Especialidade do Mecânico: ");
        System.out.println("1. Motor");
        System.out.println("2. Suspensão");
        System.out.println("3. Elétrica");
        System.out.print("> Informe a opção: ");
        escolha = scanner.nextInt();

        switch (escolha) {
            case 1:
                Mecanico.especialidade = "Motor";
                break;
            case 2:
                Mecanico.especialidade = "Suspensão";
                break;
            case 3:
                Mecanico.especialidade = "Elétrica";
                break;
            default:
                System.out.println("Opção Inválida.");
                break;
        }

        scanner.close();

        return Mecanico.especialidade;
    }
}
