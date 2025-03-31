package main;




import menu.ShowMenu;
import pet.Pet;
import service.CreateForm;
import pet.RegisterPet;


public class main {
    public static void main(String[] args) {
        CreateForm.create();
        RegisterPet registerPet = new RegisterPet();
        Pet pet = new Pet();
        ShowMenu menu = new ShowMenu();
        menu.show();





    }
}
