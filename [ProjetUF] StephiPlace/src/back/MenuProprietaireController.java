package back;

import java.sql.SQLException;
import java.util.Scanner;

import controllers.ProprietaireController;


public class MenuProprietaireController {
	
	public static void ProprietaireControllerMenu() throws SQLException {
		
		Scanner sc = new Scanner(System.in);
		System.out.println(" __________________________________________________________________________________");
		System.out.println("|                                                                                  |");
		System.out.println("| 0. Quitter le programme                                                          |");
		System.out.println("|----------------------------------------------------------------------------------|");
		System.out.println("| 1. Créer un proprietaire                                                         |");
		System.out.println("|----------------------------------------------------------------------------------|");
		System.out.println("| 2. Voir un proprietaire                                                          |");
		System.out.println("|----------------------------------------------------------------------------------|");
		System.out.println("| 3. Supprimer un proprietaire                                                     |");
		System.out.println("|__________________________________________________________________________________|");
        
		String choices = sc.nextLine();
			switch(choices) {
			
			case "0":
				System.out.println("Closing");
				System.exit(0);
				break;
			
			case "1":
				ProprietaireController.create();
				break;
			
			case "2":
				ProprietaireController.read();
				break;
				
			case "3":
				ProprietaireController.delete();
				break;
			
		}
	
	}

}
