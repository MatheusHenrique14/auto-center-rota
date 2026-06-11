import java.util.Scanner;

public class Tela {
    public static void main(String[] args) throws Exception {

        Scanner scanner = new Scanner(System.in);

        int escolha;

        Dados.criarPastaDados();

        do {
            System.out.println("==================================");
            System.out.println("Auto Center Rota 381");
            System.out.println("==================================");
            System.out.println("--- Cadastros ---");
            System.out.println("1. Cadastrar Mecânico");
            System.out.println("2. Cadastrar Cliente");
            System.out.println("3. Cadastrar Estoque");
            System.out.println("--- Operação Diária ---");
            System.out.println("4. Abrir OS");
            System.out.println("--- Relatórios ---");
            System.out.println("5. Comissão da Equipe");
            System.out.println("6. Inventário Crítico");
            System.out.println("7. Faturamento de Peças");
            System.out.println("==================================");
            System.out.println("0. Sair");
            System.out.print("> Escolha uma opção: ");
            escolha = scanner.nextInt();

            switch (escolha) {
                case 1:
                    MecanicoFuncoes.cadastrarMecanico();
                    break;
                case 2:
                    ClienteFuncoes.cadastrarCliente();
                    break;
                case 3:
                    EstoqueFuncoes.cadastrarEstoque();
                    break;
                case 4:
                    OsFuncoes.cadastrarOrdemServico();
                    break;
                case 5:
                    System.out.println("Comissão.");
                    break;
                case 6:
                    System.out.println("Inventário.");
                    break;
                case 7:
                    System.out.println("Faturamento.");
                    break;
                case 0:
                    System.out.println("==================================");
                    System.out.println("Saindo...");
                    System.out.println("==================================");
                    return;
                default:
                    System.out.println("Opção Inválida.");
                    break;
            }
        } while (escolha != 0);
        scanner.close();
    }
}
