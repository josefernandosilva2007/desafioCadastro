package service;

import pet.Pet;

import java.io.File;
import java.util.List;
import java.util.Scanner;

public class DeletePet {
    public void delete(List<Pet> petList) {


        if (petList.isEmpty()) {
            System.out.println("Nenhum PET encontrado");
            return;
        }
        SearchPet searchPet = new SearchPet();
        Scanner input = new Scanner(System.in);
        searchPet.formatListPets(petList);
        System.out.println("Digite o NUMERO do animal que deseja DELETAR");
        int petChoice = input.nextInt();

        if (petChoice < 1 || petChoice > petList.size()) {
            System.out.println("Animal INVALIDO");
            delete(petList);
        }

        Pet pet = petList.get(petChoice - 1);
        String oldPet = pet.getName();
        System.out.println("DELETANDO o pet: " + pet.getName());
        System.out.println("VOCE TEM CERTEZA DE DELETAR ESSE PET?");
        System.out.println("- [1] SIM [2]NAO");
        int deleteChoice = input.nextInt();

        if (deleteChoice == 1) {
            File dir = new File("C:\\Users\\Fernando\\Documents\\desafioCadastro\\src\\petCadastrados");
            File[] listFiles = dir.listFiles();

            if (listFiles == null) {
                System.out.println("Erro ao acessar diretório ou diretório vazio.");
                return;
            }

            String formattedName = oldPet.trim().replaceAll("\\s+", "").toUpperCase();
            boolean fileDeleted = false;

            for (File listFile : listFiles) {
                String fileNameClean = listFile.getName().replaceAll("\\s+", "").toUpperCase();
                if (fileNameClean.contains(formattedName)) {
                    System.out.println("Arquivo encontrado: " + listFile.getName());
                    if (listFile.delete()) {
                        System.out.println("Arquivo deletado com sucesso: " + listFile.getName());
                        petList.remove(pet); // remover da lista
                        fileDeleted = true;
                    } else {
                        System.out.println("Erro ao deletar: " + listFile.getName());
                    }
                    break;
                }
            }

            if (!fileDeleted) {
                System.out.println("Arquivo correspondente ao pet não encontrado.");
            }
        }
        else if (deleteChoice == 2) {
            delete(petList);
        } else {
            System.out.println("OPCAO INVALIDA");
        }
    }
}
