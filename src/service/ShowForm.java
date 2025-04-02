package service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ShowForm {
    static Path pathForm = Paths.get("src\\data\\formulario.txt");
    public static File show() {
        try (FileReader fileReader = new FileReader("C:\\Users\\Fernando\\Documents\\desafioCadastro\\src\\data\\formulario.txt");
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            String line;
            while ((line=bufferedReader.readLine())!= null){
                System.out.println(line);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return null;
    }
    public static String readSpecifyLineFile(int line) {
        File file = new File(String.valueOf(pathForm.toAbsolutePath()));
        try (FileReader fr = new FileReader(file);
             BufferedReader br = new BufferedReader(fr)) {
            String linha;
            int cont = 1;
            while ((linha = br.readLine()) != null) {
                if (cont == line) {
                    System.out.println(linha);
                    return linha;
                }
                cont++;
            }
            return linha;

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
