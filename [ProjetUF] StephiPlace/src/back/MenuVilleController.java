package back;

import java.sql.SQLException;
import java.util.Scanner;

import controllers.VilleController;

public class MenuVilleController {
	
	public static void VilleControllerMenu() throws SQLException {
		
		Scanner sc = new Scanner(System.in);
		System.out.println(" __________________________________________________________________________________");
		System.out.println("|                                                                                  |");
		System.out.println("| 0. Quitter le programme                                                          |");
		System.out.println("|----------------------------------------------------------------------------------|");
		System.out.println("| 1. Créer une ville                                                               |");
		System.out.println("|----------------------------------------------------------------------------------|");
		System.out.println("| 2. Voir une ville                                                                |");
		System.out.println("|----------------------------------------------------------------------------------|");
		System.out.println("| 3. Modifier une ville                                                            |");
		System.out.println("|----------------------------------------------------------------------------------|");
		System.out.println("| 4. Supprimer une ville                                                           |");
		System.out.println("|__________________________________________________________________________________|");
		
		String choices = sc.nextLine();
			switch(choices) {
			
			case "0":
				System.out.println("Closing");
				System.exit(0);
				break;
				
			case "1":
				VilleController.create();
				break;
				
			case "2":
				VilleController.read();
				break;
			
			case "3":
				VilleController.update();
				break;
			
			case "4":
				VilleController.delete();
				break;
				
				

			}
		
	}

}
