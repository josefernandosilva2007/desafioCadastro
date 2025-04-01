package main;


import menu.ShowMenu;

import pet.RegisterPet;
import service.CreateForm;


public class main {
    public static void main(String[] args) {
        CreateForm.create();
        RegisterPet registerPet = new RegisterPet();
        registerPet.registerAge();


    }
}
