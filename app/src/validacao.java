import java.io.File;
import java.util.Scanner;

public class validacao {

    // Procura a placa dentro do arquivo cliente.csv
    public static boolean placaExiste(String placa) {
        try {
            File arquivo = new File("app/data/cliente.csv");
            if (!arquivo.exists()) return false;

            Scanner leitor = new Scanner(arquivo);
            while (leitor.hasNextLine()) {
                String linha = leitor.nextLine();
                String[] colunas = linha.split(";");
                
                if (colunas.length > 0 && colunas[0].trim().equalsIgnoreCase(placa.trim())) {
                    leitor.close();
                    return true; 
                }
            }
            leitor.close();
        } catch (Exception e) {
            System.out.println("Erro ao validar placa: " + e.getMessage());
        }
        return false;
    }

    // Procura o código do mecânico dentro de mecanico.csv
    public static boolean mecanicoExiste(int codigoMecanico) {
        try {
            File arquivo = new File("app/data/mecanico.csv");
            if (!arquivo.exists()) return false;

            Scanner leitor = new Scanner(arquivo);
            while (leitor.hasNextLine()) {
                String linha = leitor.nextLine();
                String[] colunas = linha.split(";");
                
                if (colunas.length > 0 && colunas[0].trim().equals(String.valueOf(codigoMecanico))) {
                    leitor.close();
                    return true; 
                }
            }
            leitor.close();
        } catch (Exception e) {
            System.out.println("Erro ao validar mecanico: " + e.getMessage());
        }
        return false;
    }

    // Verifica a quantidade no estoque.csv e retorna o arquivo atualizado em texto puro (ou null se der erro)
    public static String verificarEAtualizarEstoque(int codigoPeca, int quantidadePedida) {
        try {
            File arquivo = new File("app/data/estoque.csv");
            if (!arquivo.exists()) {
                System.out.println("[ERRO] Arquivo estoque.csv nao encontrado!");
                return null;
            }

            Scanner leitor = new Scanner(arquivo);
            String novoConteudoArquivo = "";
            boolean pecaEncontrada = false;
            boolean temEstoque = false;

            while (leitor.hasNextLine()) {
                String linha = leitor.nextLine();
                String[] colunas = linha.split(";");

                if (colunas.length > 2 && colunas[0].trim().equals(String.valueOf(codigoPeca))) {
                    pecaEncontrada = true;
                    int estoqueAtual = Integer.parseInt(colunas[2].trim());

                    if (estoqueAtual >= quantidadePedida) {
                        temEstoque = true;
                        int novoEstoque = estoqueAtual - quantidadePedida;
                        // Remonta a linha com o estoque atualizado (Quantidade fica na 3ª coluna, índice 2)
                        linha = colunas[0] + ";" + colunas[1] + ";" + novoEstoque + ";" + colunas[3];
                    } else {
                        System.out.println("\n[ERRO BLOQUEADO] Estoque insuficiente!");
                        System.out.println("Solicitado: " + quantidadePedida + " | Disponivel: " + estoqueAtual);
                    }
                }
                novoConteudoArquivo += linha + "\n";
            }
            leitor.close();

            if (!pecaEncontrada) {
                System.out.println("\n[ERRO] Codigo de peca " + codigoPeca + " nao localizado no estoque.");
                return null;
            }

            if (temEstoque) {
                return novoConteudoArquivo;
            }

        } catch (Exception e) {
            System.out.println("Erro ao processar estoque: " + e.getMessage());
        }
        return null;
    }
}