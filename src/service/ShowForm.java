package service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class ShowForm {
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
}
