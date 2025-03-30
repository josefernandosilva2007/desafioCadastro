package menu;

import java.util.Scanner;

public class ShowMenu {

    public String show(){
        Scanner input = new Scanner(System.in);
        AnswerMenu menu = new AnswerMenu();
        System.out.println("----------------------------------------------------");
        System.out.println("1 - Qual o nome e sobrenome do pet?\n" +
                "2 - Qual o tipo do pet (Cachorro/Gato)?\n" +
                "3 - Qual o sexo do animal?\n" +
                "4 - Qual endereço e bairro que ele foi encontrado?\n" +
                "5 - Qual a idade aproximada do pet?\n" +
                "6 - Qual o peso aproximado do pet?\n" +
                "7 - Qual a raça do pet?");
        System.out.println("----------------------------------------------------");
        menu.aswer(input.nextInt());
        if (menu.asw<=0) {
            return show();
        }
        return null;
    }
}
