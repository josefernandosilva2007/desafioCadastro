package service;

import menu.ShowMenu;
import pet.AnimalType;
import pet.Gender;
import pet.NaoInformado;
import pet.Pet;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SearchPet {
    public int choice;

    ArrayList<Pet> listPets = listPet();
    List<Pet> filterList = null;


    public ArrayList<Pet> listPet() {
        AnimalType type;
        Gender gender;

        File directory = new File("C:\\Users\\Fernando\\Documents\\desafioCadastro\\src\\petCadastrados");
        File[] files = directory.listFiles();
        ArrayList<Pet> petList = null;
        if (files != null) {
            petList = new ArrayList<>();
            for (int i = 0; i < files.length; i++) {
                if (files[i].getName().endsWith(".txt")) {
                    try (BufferedReader br = new BufferedReader(new FileReader(files[i]))) {
                        String name = br.readLine().split("-")[1];
                        type = AnimalType.valueOf(br.readLine().split("-")[1]);
                        gender = Gender.valueOf(br.readLine().split("-")[1]);
                        String adress = br.readLine().split("-")[1];
                        String ageString = br.readLine().split("-")[1];
                        String weight = br.readLine().split("-")[1];
                        String breed = br.readLine().split("-")[1];

                        Pet pet = new Pet();
                        String[] adressSplit = adress.split(",");
                        String street = adressSplit[0].trim();
                        String houseNumber = String.valueOf(adressSplit[1].trim());
                        String city = adressSplit[2].trim();


                        try {
                            pet.setName(name);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        pet.setNumberAdress(houseNumber);
                        pet.setCityAdress(city);
                        pet.setStreetAdress(street);
                        pet.setAnimal(type);
                        pet.setBreed(breed);
                        pet.setGender(gender);
                        if (!ageString.equals("NAOINFORMADO")) {
                            pet.setAge(Integer.parseInt(ageString));
                        } else {
                            pet.setIsInformedAge(NaoInformado.valueOf(ageString));
                        }
                        if (!weight.equals("NAOINFORMADO")) {
                            pet.setWeight(Double.parseDouble(weight));
                        } else {
                            pet.setIsInformedWeight(NaoInformado.valueOf(weight));
                        }


                        petList.add(pet);


                    } catch (IOException e) {
                        e.printStackTrace();
                    }


                }

            }
        }
        return petList;
    }

    public void printSearchMenu() {
        System.out.println("1-Nome\n" +
                "2-Sexo\n" +
                "3-Endereço\n" +
                "4-Idade\n" +
                "5-Peso\n" +
                "6-Raça");
        searchMenu();
    }

public void setContinue(){
        Scanner input = new Scanner(System.in);
    System.out.println("-Deseja usar outro criterio?");
    System.out.println("-[1]SIM ou [2]NAO");
    int choiceContinue = input.nextInt();
    if (choiceContinue == 1){
        setFilter();
    }
}
    public void setFilter() {
        Scanner input = new Scanner(System.in);
        System.out.println("=====RESPOSTA=====");
        System.out.println("-Digite apenas o numero");
        choice = input.nextInt();
        answer();
    }

    public void answer(){
        ShowMenu showMenu = new ShowMenu();
        Scanner input = new Scanner(System.in);
        switch (choice){
            case 1:
                System.out.println("-Digite o NOME ou SOBRENOME do animal");
                String searchPetName = input.nextLine().trim().toUpperCase();
                if (searchPetName.equals("")){
                    System.out.println("Nenhum NOME ou SOBRENOME digitado");
                } else {
                    filterList = filterName(searchPetName, filterList);
                }
                setContinue();
                break;
            case 2:
                System.out.println("-Digite o SEXO do animal");
                System.out.println("-[1]FEMEA ou [2]MACHO");
                int typeFilter = input.nextInt();
                Gender gender = null;
                if (typeFilter == 1){
                    gender = gender.FEMEA;
                } else if (typeFilter == 2) {
                    gender = gender.MACHO;
                } else {
                        System.out.println("Digite Apenas: 1 ou 2");
                        showMenu.show();
                    }
                Gender finalGender = gender;
                filterList = listPets.stream().filter(pet -> pet.getGender() == finalGender).toList();
                setContinue();
                break;
            case 3:
                System.out.println("-Digite a CIDADE do animal");
                String searchCity = input.nextLine().trim().toUpperCase();
                if (searchCity.equals("")){
                    System.out.println("Nenhuma CIDADE digitada");
                } else {
                    filterList = filterAdress(searchCity, filterList);
                }
                setContinue();
                break;
            case 4:
                System.out.println("-Digite a IDADE do animal");
                int searchAge = input.nextInt();
                if (searchAge <= 0 || searchAge > 20){
                    System.out.println("IDADE INVALIDA");
                } else {
                    filterList = filterAge(searchAge, filterList);
                }
                setContinue();
                break;
            case 5:
                System.out.println("-Digite o PESO do animal");
                double searchWeight = input.nextDouble();
                if (searchWeight < 0.5 || searchWeight > 60){
                    System.out.println("PESO INVALIDO");
                } else {
                    filterList = filterWeight(searchWeight, filterList);
                }
                setContinue();
                break;
            case 6:
                System.out.println("-Digite a RAÇA do animal");
                String searchBreed = input.nextLine().trim().toUpperCase();
                if (searchBreed.equals("")){
                    System.out.println("Nenhuma RAÇA digitada");
                } else {
                    filterList = filterBreed(searchBreed, filterList);
                }
                setContinue();

                break;

        }

    }


    public void searchAnimalType(){
        ShowMenu showMenu = new ShowMenu();
        Scanner input = new Scanner(System.in);
        System.out.println("- Qual o tipo do animal?");
        System.out.println("- [1] Cachorro" + "[2] Gato");
        int typeFilter = input.nextInt();
        AnimalType animalType = null;
        if (typeFilter == 1) {
            animalType = animalType.CACHORRO;
        } else if (typeFilter == 2) {
            animalType = animalType.GATO;
        } else {
            System.out.println("Digite Apenas: 1 ou 2");
            showMenu.show();
        }
        AnimalType finalAnimalType = animalType;
        filterList = listPets.stream().filter(pet -> pet.getAnimal() == finalAnimalType).toList();
    }


    public void searchMenu() {
        ShowMenu showMenu = new ShowMenu();
        searchAnimalType();
        setFilter();

        formatListPets(filterList);

    }




    private List<Pet> filterName(String nameSearch, List<Pet> petArrayList) {
        return petArrayList.stream()
                .filter(pet -> pet.getName().toUpperCase().contains(nameSearch)).toList();
    }

    private List<Pet> filterAge(int searchAge, List<Pet> petArrayList) {
        return petArrayList.stream()
                .filter(pet -> pet.getAge() == searchAge)
                .toList();
    }

    private List<Pet> filterWeight(double searchWeight, List<Pet> petArrayList) {
        return petArrayList.stream()
                .filter(pet -> pet.getWeight() == searchWeight)
                .toList();
    }

    private List<Pet> filterBreed(String searchBreed, List<Pet> petArrayList) {
        return petArrayList.stream()
                .filter(pet -> pet.getBreed().contains(searchBreed)).toList();
    }

    private List<Pet> filterAdress(String searchAdress, List<Pet> petArrayList) {
        return petArrayList.stream()
                .filter(pet -> String.valueOf(pet.getStreetAdress()).contains(searchAdress) ||
                        String.valueOf(pet.getCityAdress()).contains(searchAdress))
                .toList();
    }

    public void formatListPets(List<Pet> listaFiltrada) {
        if (listaFiltrada.isEmpty()) {
            System.out.println("Nenhum pet encontrado com os critérios selecionados.");
            return;
        }

        int contador = 1;
        for (Pet pet : listaFiltrada) {
            String formattedPet = String.format(
                    "%d. %s - %s - %s - %s, %s - %s - %d anos - %s.kg - %s",
                    contador++,
                    pet.getName(),
                    pet.getAnimal(),
                    pet.getGender(),
                    pet.getStreetAdress(),
                    pet.getNumberAdress(),
                    pet.getCityAdress(),
                    pet.getAge(),
                    pet.getWeight(),
                    pet.getBreed()
            );
            System.out.println(formattedPet);
        }
    }
}


