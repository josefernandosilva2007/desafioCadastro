package service;

import pet.Pet;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

public class ChangePet {

    public void editPet(List<Pet> petList) {
        if (petList.isEmpty()) {
            System.out.println("Nenhum PET encontrado");
            return;
        }

        Scanner input = new Scanner(System.in);
        SearchPet searchPet = new SearchPet();

        searchPet.formatListPets(petList);
        System.out.println("Digite o NUMERO do animal que deseja EDITAR");
        int petChoice = input.nextInt();
        input.nextLine();

        if (petChoice < 1 || petChoice > petList.size()) {
            System.out.println("Animal INVALIDO");
            editPet(petList);
        }

        Pet pet = petList.get(petChoice - 1);
        String oldPet = pet.getName();
        System.out.println("Editando o pet: " + pet.getName());

        System.out.println("Digite o NOVO NOME do animal(DEIXE VAZIO SE QUISER MANTER)");
        String newName = input.nextLine();


        if (newName.equals("")) {
            System.out.println("NOME mantido: " + pet.getName());
        } else {
            pet.setName(newName);
            System.out.println("NOME: " + pet.getName());
        }


        System.out.println("Digite o NOVO NUMERO DO ENDERECO do animal(DEIXE VAZIO SE QUISER MANTER)");
        String newNumberAdress = input.nextLine();
        if (newNumberAdress.equals("")) {
            System.out.println("Numero do endereco mantido: " + pet.getNumberAdress());
        } else {
            pet.setNumberAdress(newNumberAdress);
        }

        System.out.println("Digite a NOVA CIDADE do animal(DEIXE VAZIO SE QUISER MANTER)");
        String newCityAdress = input.nextLine();
        if (newCityAdress.equals("")) {
            System.out.println("Cidade mantid: " + pet.getCityAdress());
        } else {
            pet.setCityAdress(newCityAdress);
        }

        System.out.println("Digite a NOVA RUA do animal(DEIXE VAZIO SE QUISER MANTER)");
        String newStreetAdress = input.nextLine();
        if (newStreetAdress.equals("")) {
            System.out.println("Rua mantida: " + pet.getStreetAdress());
        } else {
            pet.setStreetAdress(newStreetAdress);
        }


        System.out.println("Digite a NOVA IDADE do animal(DEIXE VAZIO SE QUISER MANTER)");
        String newAge = input.nextLine();
        if (newAge.equals("")) {
            System.out.println("Idade mantida: " + pet.getAge());
        } else {
            pet.setAge(Integer.parseInt(newAge));
        }

        System.out.println("Digite o NOVO PESO do animal(DEIXE VAZIO SE QUISER MANTER)");
        String newWeight = input.nextLine();
        if (newWeight.equals("")) {
            System.out.println("Peso mantido: " + pet.getWeight());
        } else {
            pet.setWeight(Double.parseDouble(newWeight));
        }

        System.out.println("Digite a NOVA RACA do animal(DEIXE VAZIO SE QUISER MANTER)");
        String newBreed = input.nextLine();
        if (newBreed.equals("")) {
            System.out.println("Raça mantida: " + pet.getBreed());
        } else {
            pet.setBreed(newBreed);
        }




        String formattedName = pet.getName().replace(" ", "").toUpperCase();
        LocalDateTime agora = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd'T'HHmm");
        String dataHoraFormatada = agora.format(formatter);

        String fileName = dataHoraFormatada + "-" + formattedName + ".txt";
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("C:\\Users\\Fernando\\Documents\\desafioCadastro\\src\\petCadastrados\\" + fileName))) {
            bw.write("1 - " + pet.getName());
            bw.newLine();
            bw.write("2 - " + pet.getAnimal());
            bw.newLine();
            bw.write("3 - " + pet.getGender());
            bw.newLine();
            bw.write("4 - " + pet.getStreetAdress() + ", " + pet.getNumberAdress() + ", " + pet.getCityAdress());
            bw.newLine();
            bw.write("5 - " + pet.getAge() + " anos");
            bw.newLine();
            bw.write("6 - " + pet.getWeight() + "kg");
            bw.newLine();
            bw.write("7 - " + pet.getBreed());
            bw.newLine();
        } catch (IOException e) {
            System.out.println("Erro substituir o arquivo: " + e.getMessage());
        }
    }
}
