package service;

import java.io.*;
import java.util.Scanner;

public class Form {
    public File createForm() {
        File file = new File("C:\\Users\\Fernando\\Documents\\desafioCadastro\\src\\data\\formulario.txt");
        File directory = new File("C:\\Users\\Fernando\\Documents\\desafioCadastro\\src\\data");

        try {
            directory.mkdir();
            file.createNewFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try (FileWriter fw = new FileWriter("C:\\Users\\Fernando\\Documents\\desafioCadastro\\src\\data\\formulario.txt");) {
            fw.write("1 - Qual o nome e sobrenome do pet?\n2 - Qual o tipo do pet (Cachorro/Gato)?\n3 - Qual o sexo do animal?\n4 - Qual endereço e bairro que ele foi encontrado?\n5 - Qual a idade aproximada do pet?\n6 - Qual o peso aproximado do pet?\n7 - Qual a raça do pet?");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return file;
    }

    public File showForm() {
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
