import java.io.File;

public class Dados {
    public static void criarPastaDados() {
        File data = new File("data");

        if (!data.exists()) {
            data.mkdir();

            return;
        }

        return;
    }
}
