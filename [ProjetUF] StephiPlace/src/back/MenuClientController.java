package back;

import java.sql.SQLException;
import java.util.Scanner;

import controllers.ClientController;

public class MenuClientController {
	
	public static void ClientControllerMenu() throws SQLException {
		
		Scanner sc = new Scanner(System.in);
		System.out.println(" __________________________________________________________________________________");
		System.out.println("|                                                                                  |");
		System.out.println("| 0. Quitter le programme                                                          |");
		System.out.println("|----------------------------------------------------------------------------------|");
		System.out.println("| 1. Créer un client                                                               |");
		System.out.println("|----------------------------------------------------------------------------------|");
		System.out.println("| 2. Voir un client                                                                |");
		System.out.println("|----------------------------------------------------------------------------------|");
		System.out.println("| 3. Modifier un client                                                            |");
		System.out.println("|----------------------------------------------------------------------------------|");
		System.out.println("| 4. Supprimer un client                                                           |");
		System.out.println("|__________________________________________________________________________________|");
        
		String choices = sc.nextLine();
			switch(choices) {
			
			case "0":
				System.out.println("Closing");
				System.exit(0);
				break;
			
			case "1":
				ClientController.create();
				break;
			
			case "2":
				ClientController.read();
				break;
			
			case "3":
				ClientController.update();
				break;
			
			case "4":
				ClientController.delete();
				break;
			
		}

	}
}
