package back;

import java.sql.SQLException;
import java.util.Scanner;

import controllers.BienController;

public class MenuBienController {
	
	public static void BienControllerMenu() throws SQLException {
		
		Scanner sc = new Scanner(System.in);
		System.out.println(" __________________________________________________________________________________");
		System.out.println("|                                                                                  |");
		System.out.println("| 0. Quitter le programme                                                          |");
		System.out.println("|----------------------------------------------------------------------------------|");
		System.out.println("| 1. Créer un bien                                                                 |");
		System.out.println("|----------------------------------------------------------------------------------|");
		System.out.println("| 2. Voir un bien                                                                  |");
		System.out.println("|----------------------------------------------------------------------------------|");
		System.out.println("| 3. Modifier un bien                                                              |");
		System.out.println("|----------------------------------------------------------------------------------|");
		System.out.println("| 4. Supprimer un bien                                                             |");
		System.out.println("|__________________________________________________________________________________|");
        
		String choices = sc.nextLine();
			switch(choices) {
			
			case "0":
				System.out.println("Closing");
				System.exit(0);
				break;
			
			case "1":
				BienController.create();
				break;
			
			case "2":
				BienController.read();
				break;
			
			case "3":
				BienController.update();
				break;
			
			case "4":
				BienController.delete();
				break;
			
		}

		
	}

}
