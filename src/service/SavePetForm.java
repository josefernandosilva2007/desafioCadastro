package service;
import pet.Pet;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class SavePetForm {
    Pet pet = new Pet();
    public File save(Pet pet){
        String formattedName = pet.getName().toUpperCase()+pet.getSurname().toUpperCase();
        if (formattedName==""){
            formattedName = String.valueOf(pet.getIsInformedName());
        }
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd'T'Hm");
        String dataFormated = now.format(formatter);

        String fileName = dataFormated+"-"+formattedName+".txt";

        File directory = new File("C:\\Users\\Fernando\\Documents\\desafioCadastro\\src\\petCadastrados");
        directory.mkdir();

        try(BufferedWriter bw = new BufferedWriter(new FileWriter("C:\\Users\\Fernando\\Documents\\desafioCadastro\\src\\petCadastrados\\"+fileName))){
            bw.write("1-"+pet.getName()+" "+ pet.getSurname());
            bw.newLine();
            bw.write("2-"+pet.getAnimal());
            bw.newLine();
            bw.write("3-"+pet.getGender());
            bw.newLine();
            bw.write("4-"+pet.getStreetAdress()+", "+pet.getNumberAdress()+", "+pet.getCityAdress());
            bw.newLine();
            if (pet.getIsInformedAge() == pet.getIsInformedAge().NAOINFORMADO){
                bw.write("5-"+pet.getIsInformedAge());
            }else {
                bw.write("5-"+pet.getAge());
            }
            bw.newLine();

            if (pet.getIsInformedWeight() == pet.getIsInformedWeight().NAOINFORMADO){
                bw.write("6-"+pet.getIsInformedWeight());
            }else {
                bw.write("6-"+pet.getWeight());
            }
            bw.newLine();
            bw.write("7-"+pet.getBreed());
        }catch (IOException e){
            e.printStackTrace();
        }

        return null;
    }
}
