package back;

import controllers.TypeBienController;

import java.sql.SQLException;
import java.util.Scanner;

public class MenuTypeBienController {

    public static void TypeBienControllerMenu() throws SQLException {
        Scanner sc = new Scanner(System.in);
        System.out.println(" __________________________________________________________________________________");
        System.out.println("|                                                                                  |");
        System.out.println("| 0. Quitter le programme                                                          |");
        System.out.println("|----------------------------------------------------------------------------------|");
        System.out.println("| 1. Créer un type de bien                                                         |");
        System.out.println("|----------------------------------------------------------------------------------|");
        System.out.println("| 2. Voir un type de bien                                                          |");
        System.out.println("|----------------------------------------------------------------------------------|");
        System.out.println("| 3. Modifier un type de bien                                                      |");
        System.out.println("|----------------------------------------------------------------------------------|");
        System.out.println("| 4. Supprimer un type de bien                                                     |");
        System.out.println("|__________________________________________________________________________________|");

        String choices = sc.nextLine();
        switch(choices) {
            case "0":
                System.out.println("Closing");
                System.exit(0);
                break;

            case "1":
                TypeBienController.create();
                break;

            case "2":
                TypeBienController.read();
                break;

            case "3":
                TypeBienController.update();
                break;

            case "4":
                TypeBienController.delete();
                break;

        }
    }
}
