package pet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;


public class RegisterPet {
    Pet pet = new Pet();
    Scanner input = new Scanner(System.in);

    private NaoInformado isInformedName;
    private NaoInformado isInformedAge;
    private NaoInformado isInformedNumberAdress;
    private NaoInformado isInformedWeight;
    private NaoInformado isInformedBreed;
    private AnimalType animal;
    private Gender gender;
    private String completeName;
    private String breed;
    private String numberAndress;
    private String cityAdress;
    private String streetAndress;
    private double weight;
    private int age;


    public void registerName() {
        System.out.println("NOME: ");
        pet.setName(input.nextLine());
        System.out.println("SOBRENOME: ");
        pet.setSurname(input.nextLine());
        if (pet.getName().equals("") && pet.getSurname().equals("")) {
            setIsInformedName(isInformedName.NAOINFORMADO);
        } else if (pet.getName().equals("") || pet.getSurname().equals("")) {
            throw new RuntimeException("ERROR: O ANIMAL DEVE TER NOME E SOBRONOME");
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
        if (animal.GATO.getTipo().equalsIgnoreCase(userInput)) {
            setAnimal(AnimalType.GATO);
        } else {
            setAnimal(AnimalType.CACHORRO);
        }
        System.out.println(getAnimal());

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
        if (gender.FEMEA.getGender().equalsIgnoreCase(userInput)) {
            setGender(gender.FEMEA);
        } else {
            setGender(gender.MACHO);
        }
        System.out.println(getGender());
    }


    public void registerAdress() {
        System.out.println("i.NUMERO: ");
        setNumberAndress(input.nextLine());
        if (getNumberAndress().equals("")) {
            setIsInformedNumberAdress(isInformedNumberAdress.NAOINFORMADO);
        }
        System.out.println("ii.CIDADE: ");
        setCityAdress(input.nextLine());
        System.out.println("iii.RUA: ");
        setStreetAndress(input.nextLine());
    }

    public void registerAge() {
        System.out.println("IDADE: ");
        String ageString;
        ageString = input.nextLine();
        if (ageString.equals("")){
            setAge(0);
        }else {
        setAge(Integer.valueOf(ageString));}
        if (getAge() > 20) {
            throw new RuntimeException("IDADE INVALIDA");
        } else if (getAge() == 0) {
            setIsInformedAge(isInformedAge.NAOINFORMADO);
        }
    }

    public void registerWeight(){
        System.out.println("PESO: ");
        String weightString;
        weightString = input.nextLine();
        if (weightString.equals("")){
            setAge(0);
        }else {
            setAge(Integer.valueOf(weightString));}
        if (getWeight() > 60 || getWeight() <0.5){
            throw new RuntimeException("PESO INVALIDO");
        } else if (getWeight() == 0) {
            setIsInformedWeight(isInformedWeight.NAOINFORMADO);
        }
    }

    public void registerBreed(){
        System.out.println("RAÇA: ");
        setBreed(input.nextLine());
        if (getBreed().equals("")){
            setIsInformedWeight(isInformedWeight.NAOINFORMADO);
        }
    }



    // GETTERS AND SETTERS


    public NaoInformado getIsInformedBreed() {
        return isInformedBreed;
    }

    public void setIsInformedBreed(NaoInformado isInformedBreed) {
        this.isInformedBreed = isInformedBreed;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public NaoInformado getIsInformedWeight() {
        return isInformedWeight;
    }

    public void setIsInformedWeight(NaoInformado isInformedWeight) {
        this.isInformedWeight = isInformedWeight;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public NaoInformado getIsInformedAge() {
        return isInformedAge;
    }

    public void setIsInformedAge(NaoInformado isInformedAge) {
        this.isInformedAge = isInformedAge;
    }

    public NaoInformado getIsInformedNumberAdress() {
        return isInformedNumberAdress;
    }

    public void setIsInformedNumberAdress(NaoInformado isInformedNumberAdress) {
        this.isInformedNumberAdress = isInformedNumberAdress;
    }

    public NaoInformado getIsInformedName() {
        return isInformedName;
    }

    public void setIsInformedName(NaoInformado isInformedName) {
        this.isInformedName = isInformedName;
    }

    public int getAge() {

        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public AnimalType getAnimal() {
        return animal;
    }

    public void setAnimal(AnimalType animal) {
        this.animal = animal;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getNumberAndress() {
        return numberAndress;
    }

    public void setNumberAndress(String numberAndress) {
        this.numberAndress = numberAndress;
    }

    public String getCityAdress() {
        return cityAdress;
    }

    public void setCityAdress(String cityAdress) {
        this.cityAdress = cityAdress;
    }

    public String getStreetAndress() {
        return streetAndress;
    }

    public void setStreetAndress(String streetAndress) {
        this.streetAndress = streetAndress;
    }

    public String getCompleteName() {
        return completeName;
    }

    public void setCompleteName(String completeName) {
        this.completeName = completeName;
    }
}
