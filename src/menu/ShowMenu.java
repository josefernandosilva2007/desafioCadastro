package menu;

import pet.RegisterPet;
import service.ChangePet;
import service.DeletePet;
import service.SavePetForm;
import service.SearchPet;
import pet.Pet;

import java.util.List;
import java.util.Scanner;

public class ShowMenu {
    Scanner input = new Scanner(System.in);
    DeletePet deletePet = new DeletePet();
    SavePetForm savePetForm = new SavePetForm();
    SearchPet searchPet =new SearchPet();
    ChangePet changePet = new ChangePet();
    List<Pet> pets = searchPet.listPet();
    AnswerMenu answerMenu = new AnswerMenu();
    RegisterPet registerPet = new RegisterPet();

    public void show() {
        System.out.println("=============================================================");
        System.out.println("1 - Cadastrar um novo pet\n" +
                "2 - Listar pets por algum critério (idade, nome, raça)\n" +
                "3 - Deletar um pet cadastrado\n" +
                "4 - Listar todos os pets cadastrados\n" +
                "5 - Alterar os dados do pet cadastrado\n" +
                "6 - Sair\n");
        System.out.println("=============================================================");
        aswer();
    }

    public void aswer() {
        System.out.println("=========RESPOSTA============");
        answerMenu.aswer(input.nextInt());
        if (answerMenu.asw <= 0 || answerMenu.asw > 7) {
            show();
        }
        switch (answerMenu.asw) {
            case 1:
                registerPet.register();
                break;
            case 2:
                searchPet.printSearchMenu();
                break;
            case 3:
                deletePet.delete(pets);
                break;
            case 4:
                searchPet.formatListPets(pets);
                break;
            case 5: changePet.editPet(pets);
                break;
        }
    }
}
