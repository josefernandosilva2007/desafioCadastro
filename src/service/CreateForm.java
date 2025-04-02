package service;



import java.io.*;

public class CreateForm {

    public static File createAsk() {
        File fileForm = new File("C:\\Users\\Fernando\\Documents\\desafioCadastro\\src\\data\\formulario.txt");
        File directory = new File("C:\\Users\\Fernando\\Documents\\desafioCadastro\\src\\data");

        try {
            directory.mkdir();
            fileForm.createNewFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try (FileWriter fw = new FileWriter(fileForm);
             BufferedWriter bw = new BufferedWriter(fw)) {
            bw.write("1 - Qual o nome e sobrenome do pet?\n2 - Qual o tipo do pet (Cachorro/Gato)\n3 - Qual o sexo do animal?\n4 - Qual endereço e bairro que ele foi encontrado?\n5 - Qual a idade aproximada do pet?\n6 - Qual o peso aproximado do pet?\n7 - Qual a raça do pet?");
            bw.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return fileForm;
    }

    }

