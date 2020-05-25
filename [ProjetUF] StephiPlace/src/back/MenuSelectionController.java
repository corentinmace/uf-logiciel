package back;

import java.sql.SQLException;
import java.util.Scanner;


public class MenuSelectionController {
	
	public static void MainMenuControllers() throws SQLException {
		
		Scanner sc = new Scanner(System.in);
		System.out.println(" __________________________________________________________________________________");
		System.out.println("|                                                                                  |");
		System.out.println("| 0. Quitter le programme                                                          |");
		System.out.println("|----------------------------------------------------------------------------------|");
		System.out.println("| 1. ClientController                                                              |");
		System.out.println("|----------------------------------------------------------------------------------|");
		System.out.println("| 2. BienController                                                                |");
		System.out.println("|----------------------------------------------------------------------------------|");
		System.out.println("| 3. ProrietaireController                                                         |");
		System.out.println("|----------------------------------------------------------------------------------|");
		System.out.println("| 4. VilleController                                                               |");
		System.out.println("|----------------------------------------------------------------------------------|");
		System.out.println("| 5. QuartierController                                                            |");
		System.out.println("|__________________________________________________________________________________|");
        
		String choices = sc.nextLine();
			switch(choices) {
			
			case "0":
				System.out.println("Closing");
				System.exit(0);
				break;
			
			case "1":
				MenuClientController.ClientControllerMenu();
				break;
			
			case "2":
				MenuBienController.BienControllerMenu();
				break;
			
			case "3":
				MenuProprietaireController.ProprietaireControllerMenu();
				break;
				
			case "4":
				MenuVilleController.VilleControllerMenu();
				break;
			
			case "5":
				MenuQuartierController.QuartierControllerMenu();
		}

		
	}

}
