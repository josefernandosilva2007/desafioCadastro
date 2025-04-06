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
                "2-Tipo\n" +
                "3-Sexo\n" +
                "4-Endereço\n" +
                "5-Idade\n" +
                "6-Peso\n" +
                "7-Raça");
        searchMenu();
    }


    public int setFilter() {

        Scanner input = new Scanner(System.in);
        System.out.println("=====RESPOSTA=====");
        System.out.println("-Digite apenas o numero");
        choice = input.nextInt();
        return choice;
    }

    public void answer(){
        Scanner input = new Scanner(System.in);


    }



    public void searchMenu() {
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
        int filterChoice = setFilter();
        input.nextLine();
        switch (filterChoice){
            case 1:
                System.out.println("-Digite o NOME ou SOBRENOME do animal");
                String searchPet = input.nextLine().trim().toUpperCase();
                if (searchPet.equals("")){
                    System.out.println("Nenhum NOME ou SOBRENOME digitado");
                } else {
                    filterList = filterName(searchPet, filterList);
                    System.out.println(filterList);
                }

        }

        formatListPets(filterList);

    }




    private List<Pet> filterName(String nameSearch, List<Pet> petArrayList) {
        return petArrayList.stream()
                .filter(pet -> pet.getName().toUpperCase().contains(nameSearch)).toList();
    }

    private List<Pet> filterAge(int idadeBuscada, List<Pet> petArrayList) {
        return petArrayList.stream()
                .filter(pet -> pet.getAge() == idadeBuscada)
                .toList();
    }

    private List<Pet> filterWeight(double pesoBuscado, List<Pet> petArrayList) {
        return petArrayList.stream()
                .filter(pet -> pet.getWeight() == pesoBuscado)
                .toList();
    }

    private List<Pet> filterBreed(String nomeBuscado, List<Pet> petArrayList) {
        return petArrayList.stream()
                .filter(pet -> pet.getBreed().contains(nomeBuscado)).toList();
    }

    private List<Pet> filterAdress(String enderecoBuscado, List<Pet> petArrayList) {
        return petArrayList.stream()
                .filter(pet -> String.valueOf(pet.getStreetAdress()).contains(enderecoBuscado) ||
                        String.valueOf(pet.getCityAdress()).contains(enderecoBuscado))
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


