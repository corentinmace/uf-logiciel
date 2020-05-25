package controllers;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import java.util.Random;

import back.Db_connect;
import back.MenuClientController;

public class ClientController {
	
	static String NeededIdClient = null;

	public static void create() throws SQLException {
		
		Db_connect.connexion();
		
		Random rand = new Random(); 
		int idClient = rand.nextInt((99999 - 1) + 1) + 1;
		System.out.println(idClient);
		
		Scanner sc = new Scanner(System.in);
		System.out.println(" __________________________________");
		System.out.println("|                                  |");
		System.out.println("|      Création d'un client        |");
		System.out.println("|__________________________________|");
		
		/* 
		 * ---------------------------------------
		 * Insertion du salaire du client
		 * ---------------------------------------
		 */
		
		System.out.println("Rentrez la profession du client :");
		String professionClient = sc.nextLine();
		System.out.println("Rentrez le salaire du client :");
		String salaireClient = sc.nextLine();
		
		Statement statement = Db_connect.con.createStatement();
		statement.executeUpdate("INSERT INTO Salaire (id_client, salaire, profession) VALUES ('" + idClient + "','" + salaireClient + "','" + professionClient + "')");
		
		/* 
		 * ---------------------------------------
		 * Insertion des informations du client
		 * ---------------------------------------
		 */
		
		System.out.println("Rentrez le nom du client :");
		String nomClient = sc.nextLine();
		System.out.println("Rentrez le prenom du client :");
		String prenomClient = sc.nextLine();
		System.out.println("Rentrez le genre du client (Homme/Femme/Autre) :");
		String genreClient = sc.nextLine();
		System.out.println("Rentrez la date de naissance du client (AAAA/MM/JJ) :");
		String naissanceClient = sc.nextLine();
		System.out.println("Rentrez l'image du client (si aucune, passez :");
		String imageClient = sc.nextLine();
		System.out.println("Rentrez le téléphone du client :");
		String telClient = sc.nextLine();
		System.out.println("Rentrez l'email du client :");
		String emailClient = sc.nextLine();
		System.out.println("Rentrez un mot de passe pour le client");
		String passwordClient = sc.nextLine();
		
		
		Statement statement1 = Db_connect.con.createStatement();
		statement1.executeUpdate("INSERT INTO client (id_client, nom_client, prenom_client, genre_client, naissance_client, img_client, tel_client, email_client, password_client, id_client_salaire) VALUES ('" + idClient + "','" + nomClient + "','" + prenomClient + "','" + genreClient + "','" + naissanceClient + "','" + imageClient + "','" + telClient + "','" + emailClient + "','" + passwordClient + "','" + idClient + "')");
		
		System.out.println("Le client " + nomClient + " " + prenomClient + " à été ajouté (numéro de client : " + idClient +")" );
		
		Db_connect.con.close();
		MenuClientController.ClientControllerMenu();
	}
	
	public static void read() throws SQLException {
		
		Db_connect.connexion();
		
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		
		System.out.println(" __________________________________");
		System.out.println("|                                  |");
		System.out.println("|     1. Chercher un client        |");
		System.out.println("|----------------------------------|");
		System.out.println("|   2. Afficher tout les clients   |");
		System.out.println("|__________________________________|");
		
		
		String choices = sc.nextLine();
		switch(choices) {
		
		case "1":
			System.out.println(" __________________________________");
			System.out.println("|                                  |");
			System.out.println("|      Recherche d'un client       |");
			System.out.println("|__________________________________|");
			
			System.out.println("Entrez le nom du client :");
			String nomClient = sc.nextLine();
			System.out.println("Entrez le prenom du client :");
			String prenomClient = sc.nextLine();
			System.out.println("Entrez le numero de téléphone du client :");
			String telClient = sc.nextLine();
			
	        Statement statement = Db_connect.con.createStatement();    
	        ResultSet rs=statement.executeQuery("SELECT * FROM client WHERE nom_client = '" + nomClient + "' AND prenom_client = '" + prenomClient + "' AND tel_client = '" + telClient + "'");
	        
	        while(rs.next()) {
	        	System.out.println(" __________________________________________________________________________________");
				System.out.println("|                                                                                  |");
				System.out.println("| ID Client : " + rs.getString(1));
				System.out.println("|----------------------------------------------------------------------------------|");
				System.out.println("| Nom : " + rs.getString(2));
				System.out.println("|----------------------------------------------------------------------------------|");
				System.out.println("| Prenom : " + rs.getString(3));
				System.out.println("|----------------------------------------------------------------------------------|");
				System.out.println("| Genre : " + rs.getString(4));
				System.out.println("|----------------------------------------------------------------------------------|");
				System.out.println("| Date de naissance : " + rs.getString(5));
				System.out.println("|----------------------------------------------------------------------------------|");
				System.out.println("| Image : " + rs.getString(6));
				System.out.println("|----------------------------------------------------------------------------------|");
				System.out.println("| Telephone : " + rs.getString(7));
				System.out.println("|----------------------------------------------------------------------------------|");
				System.out.println("| Email : " + rs.getString(8));
				System.out.println("|__________________________________________________________________________________|");
	        }
		

			break;
		
		case "2":
			
			System.out.println(" __________________________________");
			System.out.println("|                                  |");
			System.out.println("|  Affichage de tout les clients   |");
			System.out.println("|__________________________________|");
			
			Statement statement2 = Db_connect.con.createStatement();
			ResultSet rs2 = statement2.executeQuery("SELECT id_client, nom_client, prenom_client FROM client");
			
			while(rs2.next()) {
				System.out.println(" __________________________________");
				System.out.println("|                                  |");
				System.out.println("| Id Client : " + rs2.getString(1));
				System.out.println("|----------------------------------|");
				System.out.println("| Nom : " + rs2.getString(2));
				System.out.println("|----------------------------------|");
				System.out.println("| Prenom : " + rs2.getString(3));
				System.out.println("|__________________________________|");
			}
			
			Db_connect.con.close();
			break;
		
		}
		
		
		
		
		MenuClientController.ClientControllerMenu();
	}
	
	public static void update() throws SQLException {
		
		Db_connect.connexion();
		
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		
		System.out.println(" __________________________________");
		System.out.println("|                                  |");
		System.out.println("|     Modification d'un client     |");
		System.out.println("|__________________________________|");
		
		System.out.println("Entrez le nom du client :");
		String nomClient = sc.nextLine();
		System.out.println("Entrez le prenom du client :");
		String prenomClient = sc.nextLine();
		System.out.println("Entrez le numero de téléphone du client :");
		String telClient = sc.nextLine();
		
        Statement statement = Db_connect.con.createStatement();    
        ResultSet rs=statement.executeQuery("SELECT * FROM client WHERE nom_client = '" + nomClient + "' AND prenom_client = '" + prenomClient + "' AND tel_client = '" + telClient + "'");
        
        while(rs.next()) {
        	System.out.println(" __________________________________________________________________________________");
			System.out.println("|                                                                                  |");
			System.out.println("| ID Client : " + rs.getString(1));
			System.out.println("|----------------------------------------------------------------------------------|");
			System.out.println("| Nom : " + rs.getString(2));
			System.out.println("|----------------------------------------------------------------------------------|");
			System.out.println("| Prenom : " + rs.getString(3));
			System.out.println("|----------------------------------------------------------------------------------|");
			System.out.println("| Genre : " + rs.getString(4));
			System.out.println("|----------------------------------------------------------------------------------|");
			System.out.println("| Date de naissance : " + rs.getString(5));
			System.out.println("|----------------------------------------------------------------------------------|");
			System.out.println("| Image : " + rs.getString(6));
			System.out.println("|----------------------------------------------------------------------------------|");
			System.out.println("| Telephone : " + rs.getString(7));
			System.out.println("|----------------------------------------------------------------------------------|");
			System.out.println("| Email : " + rs.getString(8));
			System.out.println("|----------------------------------------------------------------------------------|");
			
			
			NeededIdClient = rs.getString(1);
        }
        
        Statement salaireStatement = Db_connect.con.createStatement();    
        ResultSet rsSalaire=salaireStatement.executeQuery("SELECT * FROM salaire WHERE id_client = '" + NeededIdClient + "'");
        
        while(rsSalaire.next()) {
			System.out.println("| Salaire : " + rsSalaire.getString(2));
			System.out.println("|----------------------------------------------------------------------------------|");
			System.out.println("| Profession : " + rsSalaire.getString(3));
			System.out.println("|__________________________________________________________________________________|");
        	}
        
        
        
        System.out.println("Que voulez vous modifier ?");
        
		System.out.println(" __________________________________________________________________________________");
		System.out.println("|                                                                                  |");
		System.out.println("| 1. Nom                                                                           |");
		System.out.println("|----------------------------------------------------------------------------------|");
		System.out.println("| 2. Prenom                                                                        |");
		System.out.println("|----------------------------------------------------------------------------------|");
		System.out.println("| 3. Genre                                                                         |");
		System.out.println("|----------------------------------------------------------------------------------|");
		System.out.println("| 4. Date de naissance                                                             |");
		System.out.println("|----------------------------------------------------------------------------------|");
		System.out.println("| 5. Image                                                                         |");
		System.out.println("|----------------------------------------------------------------------------------|");
		System.out.println("| 6. Telephone                                                                     |");
		System.out.println("|----------------------------------------------------------------------------------|");
		System.out.println("| 7. Email                                                                         |");
		System.out.println("|----------------------------------------------------------------------------------|");
		System.out.println("| 8. Salaire                                                                       |");
		System.out.println("|----------------------------------------------------------------------------------|");
		System.out.println("| 9. Profession                                                                    |");
		System.out.println("|----------------------------------------------------------------------------------|");
		System.out.println("| 0. Retourner au menu principal                                                   |");
		System.out.println("|__________________________________________________________________________________|");
		
		
		String choices = sc.nextLine();
			switch(choices) {
			case "0": 
				MenuClientController.ClientControllerMenu();
				
				break;
				
			case "1":
				
				nomClientUpdate();
				break;
				
			case "2":
				
				prenomClientUpdate();
				break;
				
			case "3":
				
				genreClientUpdate();
				break;
				
			case "4":
				
				naissanceClientUpdate();
				break;
			
			case "5":
				
				imageClientUpdate();
				break;
				
			case "6": 
				
				telephoneClientUpdate();
				break;
			
			case "7":
				
				emailClientUpdate();
				break;
				
			case "8":
				
				salaireClientUpdate();
				break;
				
			case "9":
				
				professionClientUpdate();
				break;
				
				
				
			}
			
		
		
		
		Db_connect.con.close();
		MenuClientController.ClientControllerMenu();
	}
	
	public static void nomClientUpdate() throws SQLException {
		
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Entrez le nouveau nom du client :");
		String nouv = sc.nextLine();
		
		String req = "UPDATE client SET nom_client ='" + nouv + "' WHERE id_client =" + NeededIdClient + "";
		
		PreparedStatement preparedStmt = Db_connect.con.prepareStatement(req);
		preparedStmt.execute();
		
		System.out.println("Le nom du client à bien été changé !");
		
		MenuClientController.ClientControllerMenu();
		
	}
	
	public static void prenomClientUpdate() throws SQLException {
		
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Entrez le nouveau prenom du client :");
		String nouv = sc.nextLine();
		
		String req = "UPDATE proprietaire SET id_client ='" + NeededIdClient + "' WHERE id_client =" + NeededIdClient + "";
		
		PreparedStatement preparedStmt = Db_connect.con.prepareStatement(req);
		preparedStmt.execute();
		
		System.out.println("Le prenom du client à bien été changé !");
		
		MenuClientController.ClientControllerMenu();
		
	}
	
	public static void genreClientUpdate() throws SQLException {
		
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Entrez le nouveau genre du client :");
		String nouv = sc.nextLine();
		
		String req = "UPDATE client SET genre_client ='" + nouv + "' WHERE id_client =" + NeededIdClient + "";
		
		PreparedStatement preparedStmt = Db_connect.con.prepareStatement(req);
		preparedStmt.execute();
		
		System.out.println("Le genre du client à bien été changé !");
		
		MenuClientController.ClientControllerMenu();
		
	}
	
	public static void naissanceClientUpdate() throws SQLException {
		
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Entrez la nouvelle date de naissance du client :");
		String nouv = sc.nextLine();
		
		String req = "UPDATE client SET naissance_client ='" + nouv + "' WHERE id_client =" + NeededIdClient + "";
		
		PreparedStatement preparedStmt = Db_connect.con.prepareStatement(req);
		preparedStmt.execute();
		
		System.out.println("La date de naissance du client à bien été changée !");
		
		MenuClientController.ClientControllerMenu();
		
	}
	
	public static void imageClientUpdate() throws SQLException {
		
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Entrez la nouvelle image du client :");
		String nouv = sc.nextLine();
		
		String req = "UPDATE client SET img_client ='" + nouv + "' WHERE id_client =" + NeededIdClient + "";
		
		PreparedStatement preparedStmt = Db_connect.con.prepareStatement(req);
		preparedStmt.execute();
		
		System.out.println("L'image du client à bien été changée !");
		
		MenuClientController.ClientControllerMenu();
		
	}
	
	public static void telephoneClientUpdate() throws SQLException {
		
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Entrez le nouveau numéro de téléphone du client :");
		String nouv = sc.nextLine();
		
		String req = "UPDATE client SET tel_client ='" + nouv + "' WHERE id_client =" + NeededIdClient + "";
		
		PreparedStatement preparedStmt = Db_connect.con.prepareStatement(req);
		preparedStmt.execute();
		
		System.out.println("Le numéro de téléphone du client à bien été changé !");
		
		MenuClientController.ClientControllerMenu();
		
	}
	
	public static void emailClientUpdate() throws SQLException {
		
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Entrez le nouvel email du client :");
		String nouv = sc.nextLine();
		
		String req = "UPDATE client SET email_client ='" + nouv + "' WHERE id_client =" + NeededIdClient + "";
		
		PreparedStatement preparedStmt = Db_connect.con.prepareStatement(req);
		preparedStmt.execute();
		
		System.out.println("L'email du client à bien été changé !");
		
		MenuClientController.ClientControllerMenu();
		
	}
	
	public static void salaireClientUpdate() throws SQLException {
		
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Entrez le nouveau salaire du client :");
		String nouv = sc.nextLine();
		
		String req = "UPDATE salaire SET salaire ='" + nouv + "' WHERE id_client =" + NeededIdClient + "";
		
		PreparedStatement preparedStmt = Db_connect.con.prepareStatement(req);
		preparedStmt.execute();
		
		System.out.println("Le salaire du client à bien été changé !");
		
		MenuClientController.ClientControllerMenu();
		
	}
	
	public static void professionClientUpdate() throws SQLException {
		
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Entrez la nouvelle profession du client :");
		String nouv = sc.nextLine();
		
		String req = "UPDATE salaire SET profession ='" + nouv + "' WHERE id_client =" + NeededIdClient + "";
		
		PreparedStatement preparedStmt = Db_connect.con.prepareStatement(req);
		preparedStmt.execute();
		
		System.out.println("La profession du client à bien été changée !");
		
		MenuClientController.ClientControllerMenu();
		
	}


	public static void delete() throws SQLException {
		
		Db_connect.connexion();
		
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		
		
		System.out.println(" __________________________________");
		System.out.println("|                                  |");
		System.out.println("|     Suppression d'un client      |");
		System.out.println("|__________________________________|");
		
		System.out.println("Entrez le nom du client :");
		String delNomClient = sc.nextLine();
		System.out.println("Entrez le prenom du client :");
		String delPrenomClient = sc.nextLine();
		System.out.println("Entrez le numero de téléphone du client :");
		String delTelClient = sc.nextLine();
		
		
        Statement deleteStatement = Db_connect.con.createStatement();   
        ResultSet rs=deleteStatement.executeQuery("SELECT * FROM client WHERE nom_client = '" + delNomClient + "' AND prenom_client = '" + delPrenomClient + "' AND tel_client = '" + delTelClient + "'");
        
        while(rs.next()) {
        	
        	System.out.println(" __________________________________________________________________________________");
			System.out.println("|                                                                                  |");
			System.out.println("| ID Client : " + rs.getString(1));
			System.out.println("|----------------------------------------------------------------------------------|");
			System.out.println("| Nom : " + rs.getString(2));
			System.out.println("|----------------------------------------------------------------------------------|");
			System.out.println("| Prenom : " + rs.getString(3));
			System.out.println("|----------------------------------------------------------------------------------|");
			System.out.println("| Genre : " + rs.getString(4));
			System.out.println("|----------------------------------------------------------------------------------|");
			System.out.println("| Date de naissance : " + rs.getString(5));
			System.out.println("|----------------------------------------------------------------------------------|");
			System.out.println("| Image : " + rs.getString(6));
			System.out.println("|----------------------------------------------------------------------------------|");
			System.out.println("| Telephone : " + rs.getString(7));
			System.out.println("|----------------------------------------------------------------------------------|");
			System.out.println("| Email : " + rs.getString(8));
			System.out.println("|__________________________________________________________________________________|");
			
	       	NeededIdClient = rs.getString(1);
        }
        
     	System.out.println("Voulez vous supprimer ce client ? (Y/N)");
        String a = sc.nextLine();
		
		switch(a) {
		case "Y":
			deleteYes();

			break;
		case "y":
			deleteYes();
			
			break;
		case "N":
			MenuClientController.ClientControllerMenu();
			
			break;
		case "n":
			MenuClientController.ClientControllerMenu();
			
			break;
			
		}
        
		Db_connect.con.close();
		
		MenuClientController.ClientControllerMenu();
		
		}
	
	public static void deleteYes() throws SQLException {
		  Statement statement2 = Db_connect.con.createStatement();    
	        statement2.executeUpdate("DELETE FROM client WHERE id_client = '" + NeededIdClient + "'");
	        
	        Statement statement3 = Db_connect.con.createStatement();    
	        statement3.executeUpdate("DELETE FROM salaire WHERE id_client = '" + NeededIdClient + "'");
	}
	

}
