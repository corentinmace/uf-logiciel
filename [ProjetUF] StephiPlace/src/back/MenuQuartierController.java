package back;

import java.sql.SQLException;
import java.util.Scanner;

import controllers.QuartierController;

public class MenuQuartierController {
	
	public static void QuartierControllerMenu() throws SQLException {
		
		Scanner sc = new Scanner(System.in);
		System.out.println(" __________________________________________________________________________________");
		System.out.println("|                                                                                  |");
		System.out.println("| 0. Quitter le programme                                                          |");
		System.out.println("|----------------------------------------------------------------------------------|");
		System.out.println("| 1. Créer un quartier                                                             |");
		System.out.println("|----------------------------------------------------------------------------------|");
		System.out.println("| 2. Voir un quartier                                                              |");
		System.out.println("|----------------------------------------------------------------------------------|");
		System.out.println("| 3. Modifier un quartier                                                          |");
		System.out.println("|----------------------------------------------------------------------------------|");
		System.out.println("| 4. Supprimer une quartier                                                        |");
		System.out.println("|__________________________________________________________________________________|");
		
		String choices = sc.nextLine();
			switch(choices) {
			
			case "0":
				System.out.println("Closing");
				System.exit(0);
				break;
				
			case "1":
				QuartierController.create();
				break;
				
			case "2":
				QuartierController.read();
				break;
			
			case "3":
				QuartierController.update();
				break;
			
			case "4":
				QuartierController.delete();
				break;
				
				

			}
		
	}

}
