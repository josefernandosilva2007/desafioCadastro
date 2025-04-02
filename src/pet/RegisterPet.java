package pet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;


public class RegisterPet {
    Pet pet = new Pet();
    Scanner input = new Scanner(System.in);

    public void registerName() {
        System.out.println("NOME: ");
        pet.setName(input.nextLine());
        System.out.println("SOBRENOME: ");
        pet.setSurname(input.nextLine());
        if (pet.getName().equals("") && pet.getSurname().equals("")) {
            pet.setIsInformedName(pet.isInformedName.NAOINFORMADO);
        } else if (pet.getName().equals("") || pet.getSurname().equals("")) {
            throw new RuntimeException("ERROR: O ANIMAL DEVE TER NOME E SOBRONOME");
        }
        pet.setCompleteName(pet.getName().concat(pet.getSurname()));
        System.out.println(pet.getCompleteName().toUpperCase());
    }

    public void registerType() {
        System.out.println("TIPO: ");
        BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
        String userInput;
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
        System.out.println(pet.getAnimal());

    }

    public void registerGender() {
        System.out.println("SEXO: ");
        BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
        String userInput;
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
        System.out.println(pet.getGender());
    }

    public void registerAdress() {
        System.out.println("i.NUMERO: ");
        pet.setNumberAndress(input.nextLine());
        if (pet.getNumberAndress().equals("")) {
            pet.setIsInformedNumberAdress(pet.isInformedNumberAdress.NAOINFORMADO);
        }
        System.out.println("ii.CIDADE: ");
        pet.setCityAdress(input.nextLine());
        System.out.println("iii.RUA: ");
        pet.setStreetAndress(input.nextLine());
    }

    public void registerAge() {
        System.out.println("IDADE: ");
        String ageString;
        ageString = input.nextLine();
        if (ageString.equals("")){
            pet.setAge(0);
        }else {
            pet.setAge(Integer.valueOf(ageString));}
        if (pet.getAge() > 20) {
            throw new RuntimeException("IDADE INVALIDA");
        } else if (pet.getAge() == 0) {
            pet.setIsInformedAge(pet.isInformedAge.NAOINFORMADO);
        }
    }

    public void registerWeight(){
        System.out.println("PESO: ");
        String weightString;
        weightString = input.nextLine();
        if (weightString.equals("")){
            pet.setWeight(0);
        }else {
            pet.setWeight(Integer.valueOf(weightString));}
        if (pet.getWeight() > 60 || pet.getWeight() <0.5){
            throw new RuntimeException("PESO INVALIDO");
        } else if (pet.getWeight() == 0) {
            pet.setIsInformedWeight(pet.isInformedWeight.NAOINFORMADO);
        }
    }

    public void registerBreed(){
        System.out.println("RAÇA: ");
        pet.setBreed(input.nextLine());
        if (pet.getBreed().equals("")){
            pet.setIsInformedWeight(pet.isInformedWeight.NAOINFORMADO);
        }
    }

}
