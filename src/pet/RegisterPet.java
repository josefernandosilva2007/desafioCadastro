package pet;

import service.SavePetForm;
import service.ShowForm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;


public class RegisterPet {
    Pet pet = new Pet();
    SavePetForm savePetForm = new SavePetForm();
    ShowForm showForm = new ShowForm();
    Scanner input = new Scanner(System.in);
    BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
    String userInput;

    public void register() {
        ShowForm.readSpecifyLineFile(1);
        System.out.println("NOME: ");
        pet.setName(input.nextLine());
        System.out.println("SOBRENOME: ");
        pet.setSurname(input.nextLine());
        if (pet.getName().equals("") && pet.getSurname().equals("")) {
            pet.setName(String.valueOf(pet.isInformedName.NAOINFORMADO));
        } else if (pet.getName().equals("") || pet.getSurname().equals("")) {
            throw new RuntimeException("ERROR: O ANIMAL DEVE TER NOME E SOBRONOME");
        }
        ShowForm.readSpecifyLineFile(2);
        System.out.println("TIPO: ");
        try {
            userInput = stdin.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        if (pet.animal.GATO.getTipo().equalsIgnoreCase(userInput)) {
            pet.setAnimal(AnimalType.GATO);
        } else {
            pet.setAnimal(AnimalType.CACHORRO);
        }
        ShowForm.readSpecifyLineFile(3);
        System.out.println("SEXO: ");
        try {
            userInput = stdin.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        if (pet.gender.FEMEA.getGender().equalsIgnoreCase(userInput)) {
            pet.setGender(pet.gender.FEMEA);
        } else {
            pet.setGender(pet.gender.MACHO);
        }
        ShowForm.readSpecifyLineFile(4);
        System.out.println("i.NUMERO: ");
        pet.setNumberAdress(input.nextLine());
        if (pet.getNumberAdress().equals("")) {
            pet.setNumberAdress(String.valueOf(pet.isInformedNumberAdress.NAOINFORMADO));
        }
        System.out.println("ii.CIDADE: ");
        pet.setCityAdress(input.nextLine());
        System.out.println("iii.RUA: ");
        pet.setStreetAdress(input.nextLine());
        ShowForm.readSpecifyLineFile(5);
        System.out.println("IDADE: ");
        String ageString;
        ageString = input.nextLine();
        if (ageString.equals("")) {
            pet.setAge(0);
        } else {
            pet.setAge(Integer.valueOf(ageString));
        }
        if (pet.getAge() > 20) {
            throw new RuntimeException("IDADE INVALIDA");
        } else if (pet.getAge() == 0) {
            pet.setIsInformedAge(pet.isInformedAge.NAOINFORMADO);
        }

        ShowForm.readSpecifyLineFile(6);
        System.out.println("PESO: ");
        String weightString;
        weightString = input.nextLine();
        if (weightString.equals("")) {
            pet.setWeight(0);
        } else {
            pet.setWeight(Integer.valueOf(weightString));
        }
        if (pet.getWeight() == 0) {
            pet.setIsInformedWeight(pet.isInformedWeight.NAOINFORMADO);

        } else if (pet.getWeight() > 60 || pet.getWeight() < 0.5) {
            throw new RuntimeException("PESO INVALIDO");
        }

        ShowForm.readSpecifyLineFile(7);
        System.out.println("RAÇA: ");
        pet.setBreed(input.nextLine());
        if (pet.getBreed().equals("")) {
            pet.setBreed(String.valueOf(pet.isInformedWeight.NAOINFORMADO));
        }
        savePetForm.save(pet);
    }









    public void registerBreed() {
        System.out.println("RAÇA: ");
        pet.setBreed(input.nextLine());
        if (pet.getBreed().equals("")) {
            pet.setIsInformedWeight(pet.isInformedWeight.NAOINFORMADO);
        }
    }

}
