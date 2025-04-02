package menu;

import pet.RegisterPet;
import service.SavePetForm;

import java.util.Scanner;

public class ShowMenu {
    Scanner input = new Scanner(System.in);
    SavePetForm savePetForm = new SavePetForm();

    AnswerMenu answerMenu = new AnswerMenu();
    RegisterPet registerPet = new RegisterPet();

    public void show() {
        System.out.println("----------------------------------------------------");
        System.out.println("1 - Qual o nome e sobrenome do pet?\n" +
                "2 - Qual o tipo do pet (Cachorro/Gato)?\n" +
                "3 - Qual o sexo do animal?\n" +
                "4 - Qual endereço e bairro que ele foi encontrado?\n" +
                "5 - Qual a idade aproximada do pet?\n" +
                "6 - Qual o peso aproximado do pet?\n" +
                "7 - Qual a raça do pet?");
        System.out.println("----------------------------------------------------");
        aswer();
    }

    public void aswer() {
        System.out.println("RESPOSTA");
        answerMenu.aswer(input.nextInt());
        System.out.println("----------------------------------------------------");
        if (answerMenu.asw <= 0 || answerMenu.asw > 7) {
            show();
        }
        switch (answerMenu.asw) {
            case 1:
                registerPet.register();
                break;

        }
    }
}
