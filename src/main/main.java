package main;



import menu.ShowMenu;
import service.CreateForm;

import java.awt.*;


public class main {
    public static void main(String[] args) {
        CreateForm.createAsk();
        ShowMenu menu = new ShowMenu();
        menu.show();


    }
}
