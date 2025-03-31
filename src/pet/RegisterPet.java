package pet;

import org.w3c.dom.ls.LSOutput;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;


public class RegisterPet  {
    Pet pet = new Pet();
    AnimalType animalType;

    Scanner input = new Scanner(System.in);
    private String completeName;
    private String animal;

    public void registerName(){
        System.out.println("NOME: ");
        pet.setName(input.nextLine());
        System.out.println("SOBRENOME: ");
        pet.setSurname(input.nextLine());
        if (pet.getSurname().equals("")){
            System.out.println("ERROR: O ANIMAL PRECISA DE NOME E SOBRENOME");
            registerName();
        }
        setCompleteName(pet.getName().concat(pet.getSurname()));
        System.out.println(getCompleteName().toUpperCase());
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
        if(animalType.GATO.getTipo().equalsIgnoreCase(userInput)){
            animal = userInput.toUpperCase();
        } else {
            animal = userInput.toUpperCase();
        }
        System.out.println(animal);

    }

    public String getCompleteName() {
        return completeName;
    }

    public void setCompleteName(String completeName) {
        this.completeName = completeName;
    }
}
