package controllers;

import back.Db_connect;
import back.MenuBienController;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;
import java.util.Scanner;

public class BienController {

	static String NeededIdClient = null;
	static String NeededIdBien = null;
	static String NeededIdTypeBien = null;
	static String NeededTypeBien = null;



	public static void create() throws SQLException {

		Db_connect.connexion();

		Scanner sc = new Scanner(System.in);

		System.out.println("Entrez le nom du proprietaire :");
		String nomClient = sc.nextLine();
		System.out.println("Entrez le prenom du proprietaire :");
		String prenomClient = sc.nextLine();
		System.out.println("Entrez le numero de telephone du proprietaire :");
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

			NeededIdClient = rs.getString(1);
		}


		Statement statement2 = Db_connect.con.createStatement();
		ResultSet rs2=statement2.executeQuery("SELECT * FROM proprietaire WHERE id_client = '" + NeededIdClient + "'");

		while(rs2.next()) {
			System.out.println("| ID Bien : " + rs2.getString(2));
			System.out.println("|__________________________________________________________________________________|");

			NeededIdBien = rs2.getString(2);
		}

		Statement statement3 = Db_connect.con.createStatement();
		ResultSet rs3=statement3.executeQuery("SELECT * FROM type_bien WHERE id_bien = '" + NeededIdBien + "'");

		while(rs3.next()) {
			System.out.println("| ID Type bien : " + rs3.getString(2));
			System.out.println("|__________________________________________________________________________________|");
			System.out.println("| Type Bien : " + rs3.getString(3));
			System.out.println("|__________________________________________________________________________________|");

			NeededIdTypeBien = rs3.getString(2);
			NeededTypeBien = rs3.getString(3);

		}


			System.out.println("Entrez la superficie du bien :");
			String superficieBien = sc.nextLine();
			System.out.println("Decrivez l'etat du bien :");
			String etatBien = sc.nextLine();
			System.out.println("Entrez le nombre de piece(s) :");
			String nbPieceBien = sc.nextLine();
			System.out.println("Entrez le nombre de chambre :");
			String nbChambreBien = sc.nextLine();
			System.out.println("Entrez le nombre de salle de bain :");
			String nbSDBBien = sc.nextLine();
			System.out.println("Entrez le nombre de piece(s) ayant un acces a l'eau :");
			String nbPieceAccesEauBien = sc.nextLine();
			System.out.println("Decrivez le bien :");
			String descriptionBien = sc.nextLine();
			System.out.println("Photos :");
			String photoBien = sc.nextLine();
			System.out.println("Prix de vente conseille :");
			String prixVenteBien = sc.nextLine();
			System.out.println("Prix de vente minimum :");
			String prixVenteMinBien = sc.nextLine();
			System.out.println("Prix de vente maximum :");
			String prixVenteMaxBien = sc.nextLine();
			System.out.println("Prix de location :");
			String prixLocationBien = sc.nextLine();
			System.out.println("Frais du bien :");
			String fraisBien = sc.nextLine();
			System.out.println("Performances energetique :");
			String perfNRJBien = sc.nextLine();
			System.out.println("Emission de Gaz a effet de serre (GES) :");
			String gesBien = sc.nextLine();


			Statement statementIn = Db_connect.con.createStatement();
			statementIn.executeUpdate("INSERT INTO bien VALUES('" + NeededIdBien + "','" + NeededIdBien + "','" + superficieBien + "','" + etatBien + "','" + nbPieceBien + "','" + nbChambreBien + "','" + nbSDBBien + "','" + nbPieceAccesEauBien + "','" + descriptionBien + "','" + photoBien + "','" + prixVenteBien + "','" + prixVenteMinBien + "','" + prixVenteMaxBien + "','" + prixLocationBien + "','" + fraisBien + "','" + perfNRJBien + "','" + gesBien + "','" + NeededIdTypeBien + "','" + NeededTypeBien + "','" + NeededIdClient + "','" + NeededIdBien + "')");


			System.out.println("Le bien à ete ajoute !");

		MenuBienController.BienControllerMenu();
	}
	
	public static void read() throws SQLException {
		Db_connect.connexion();

		Scanner sc = new Scanner(System.in);

		System.out.println("Entrez le nom du proprietaire :");
		String nomClient = sc.nextLine();
		System.out.println("Entrez le prenom du proprietaire :");
		String prenomClient = sc.nextLine();
		System.out.println("Entrez le numero de telephone du proprietaire :");
		String telClient = sc.nextLine();

		Statement statement = Db_connect.con.createStatement();
		ResultSet rs = statement.executeQuery("SELECT * FROM client WHERE nom_client = '" + nomClient + "' AND prenom_client = '" + prenomClient + "' AND tel_client = '" + telClient + "'");

		while (rs.next()) {
			System.out.println(" __________________________________________________________________________________");
			System.out.println("|                                                                                  |");
			System.out.println("| ID Client : " + rs.getString(1));
			System.out.println("|----------------------------------------------------------------------------------|");
			System.out.println("| Nom : " + rs.getString(2));
			System.out.println("|----------------------------------------------------------------------------------|");
			System.out.println("| Prenom : " + rs.getString(3));
			System.out.println("|----------------------------------------------------------------------------------|");

			NeededIdClient = rs.getString(1);
		}


		Statement statement2 = Db_connect.con.createStatement();
		ResultSet rs2 = statement2.executeQuery("SELECT * FROM proprietaire WHERE id_client = '" + NeededIdClient + "'");

		while (rs2.next()) {
			System.out.println("| ID Bien : " + rs2.getString(2));
			System.out.println("|__________________________________________________________________________________|");

			NeededIdBien = rs2.getString(2);
		}

		Statement statement3 = Db_connect.con.createStatement();
		ResultSet rs3 = statement3.executeQuery("SELECT * FROM type_bien WHERE id_bien = '" + NeededIdBien + "'");

		while (rs3.next()) {
			System.out.println("| ID Type bien : " + rs3.getString(2));
			System.out.println("|__________________________________________________________________________________|");
			System.out.println("| Type Bien : " + rs3.getString(3));
			System.out.println("|__________________________________________________________________________________|");

			NeededIdTypeBien = rs3.getString(2);
			NeededTypeBien = rs3.getString(3);

		}

		Statement statement4 = Db_connect.con.createStatement();
		ResultSet rs4 = statement4.executeQuery("SELECT * FROM bien WHERE id_bien = '" + NeededIdBien + "'");


		while (rs4.next()) {

			System.out.println(" __________________________________________________________________________________");
			System.out.println("|                                                                                  |");
			System.out.println("| ID Bien : " + rs4.getString(2));
			System.out.println("|----------------------------------------------------------------------------------|");
			System.out.println("| Superficie : " + rs4.getString(3));
			System.out.println("|__________________________________________________________________________________|");
			System.out.println("| Etat : " + rs4.getString(4));
			System.out.println("|__________________________________________________________________________________|");
			System.out.println("| Nombres de pieces : " + rs4.getString(5));
			System.out.println("|__________________________________________________________________________________|");
			System.out.println("| Nombres de chambres : " + rs4.getString(6));
			System.out.println("|__________________________________________________________________________________|");
			System.out.println("| Nombres de salle de bain : " + rs4.getString(7));
			System.out.println("|__________________________________________________________________________________|");
			System.out.println("| Nombres de pieces ayant un accès à l'eau : " + rs4.getString(8));
			System.out.println("|__________________________________________________________________________________|");
			System.out.println("| Description : " + rs4.getString(9));
			System.out.println("|__________________________________________________________________________________|");
			System.out.println("| Photo : " + rs4.getString(10));
			System.out.println("|__________________________________________________________________________________|");
			System.out.println("| Prix de vente : " + rs4.getString(11));
			System.out.println("|__________________________________________________________________________________|");
			System.out.println("| Prix de vente minimum : " + rs4.getString(12));
			System.out.println("|__________________________________________________________________________________|");
			System.out.println("| Prix de vente maximum : " + rs4.getString(13));
			System.out.println("|__________________________________________________________________________________|");
			System.out.println("| Prix de location : " + rs4.getString(14));
			System.out.println("|__________________________________________________________________________________|");
			System.out.println("| Frais : " + rs4.getString(15));
			System.out.println("|__________________________________________________________________________________|");
			System.out.println("| Perfomances energetique : " + rs4.getString(16));
			System.out.println("|__________________________________________________________________________________|");
			System.out.println("| GES : " + rs4.getString(17));
			System.out.println("|__________________________________________________________________________________|");
			System.out.println("| Type de bien : " + rs4.getString(19));
			System.out.println("|__________________________________________________________________________________|");


		}

		MenuBienController.BienControllerMenu();
	}
	
	public static void update() throws SQLException {

		Db_connect.connexion();

		Scanner sc = new Scanner(System.in);

		System.out.println("Entrez le nom du proprietaire :");
		String nomClient = sc.nextLine();
		System.out.println("Entrez le prenom du proprietaire :");
		String prenomClient = sc.nextLine();
		System.out.println("Entrez le numero de telephone du proprietaire :");
		String telClient = sc.nextLine();

		Statement statement = Db_connect.con.createStatement();
		ResultSet rs = statement.executeQuery("SELECT * FROM client WHERE nom_client = '" + nomClient + "' AND prenom_client = '" + prenomClient + "' AND tel_client = '" + telClient + "'");

		while (rs.next()) {
			System.out.println(" __________________________________________________________________________________");
			System.out.println("|                                                                                  |");
			System.out.println("| ID Client : " + rs.getString(1));
			System.out.println("|----------------------------------------------------------------------------------|");
			System.out.println("| Nom : " + rs.getString(2));
			System.out.println("|----------------------------------------------------------------------------------|");
			System.out.println("| Prenom : " + rs.getString(3));
			System.out.println("|----------------------------------------------------------------------------------|");

			NeededIdClient = rs.getString(1);
		}


		Statement statement2 = Db_connect.con.createStatement();
		ResultSet rs2 = statement2.executeQuery("SELECT * FROM proprietaire WHERE id_client = '" + NeededIdClient + "'");

		while (rs2.next()) {
			System.out.println("| ID Bien : " + rs2.getString(2));
			System.out.println("|__________________________________________________________________________________|");

			NeededIdBien = rs2.getString(2);
		}

		Statement statement3 = Db_connect.con.createStatement();
		ResultSet rs3 = statement3.executeQuery("SELECT * FROM type_bien WHERE id_bien = '" + NeededIdBien + "'");

		while (rs3.next()) {
			System.out.println("| ID Type bien : " + rs3.getString(2));
			System.out.println("|__________________________________________________________________________________|");
			System.out.println("| Type Bien : " + rs3.getString(3));
			System.out.println("|__________________________________________________________________________________|");

			NeededIdTypeBien = rs3.getString(2);
			NeededTypeBien = rs3.getString(3);

		}

		Statement statement4 = Db_connect.con.createStatement();
		ResultSet rs4 = statement4.executeQuery("SELECT * FROM bien WHERE id_bien = '" + NeededIdBien + "'");


		while (rs4.next()) {

			System.out.println(" __________________________________________________________________________________");
			System.out.println("|                                                                                  |");
			System.out.println("| ID Bien : " + rs4.getString(2));
			System.out.println("|----------------------------------------------------------------------------------|");
			System.out.println("| Superficie : " + rs4.getString(3));
			System.out.println("|__________________________________________________________________________________|");
			System.out.println("| Etat : " + rs4.getString(4));
			System.out.println("|__________________________________________________________________________________|");
			System.out.println("| Nombres de pieces : " + rs4.getString(5));
			System.out.println("|__________________________________________________________________________________|");
			System.out.println("| Nombres de chambres : " + rs4.getString(6));
			System.out.println("|__________________________________________________________________________________|");
			System.out.println("| Nombres de salle de bain : " + rs4.getString(7));
			System.out.println("|__________________________________________________________________________________|");
			System.out.println("| Nombres de pieces ayant un accès à l'eau : " + rs4.getString(8));
			System.out.println("|__________________________________________________________________________________|");
			System.out.println("| Description : " + rs4.getString(9));
			System.out.println("|__________________________________________________________________________________|");
			System.out.println("| Photo : " + rs4.getString(10));
			System.out.println("|__________________________________________________________________________________|");
			System.out.println("| Prix de vente : " + rs4.getString(11));
			System.out.println("|__________________________________________________________________________________|");
			System.out.println("| Prix de vente minimum : " + rs4.getString(12));
			System.out.println("|__________________________________________________________________________________|");
			System.out.println("| Prix de vente maximum : " + rs4.getString(13));
			System.out.println("|__________________________________________________________________________________|");
			System.out.println("| Prix de location : " + rs4.getString(14));
			System.out.println("|__________________________________________________________________________________|");
			System.out.println("| Frais : " + rs4.getString(15));
			System.out.println("|__________________________________________________________________________________|");
			System.out.println("| Perfomances energetique : " + rs4.getString(16));
			System.out.println("|__________________________________________________________________________________|");
			System.out.println("| GES : " + rs4.getString(17));
			System.out.println("|__________________________________________________________________________________|");
			System.out.println("| Type de bien : " + rs4.getString(19));
			System.out.println("|__________________________________________________________________________________|");


		}

		System.out.println("Que voulez vous modifier ?");

		System.out.println(" __________________________________________________________________________________");
		System.out.println("|                                                                                  |");
		System.out.println("| 1. Superficie                                                                    |");
		System.out.println("|----------------------------------------------------------------------------------|");
		System.out.println("| 2. Etat                                                                          |");
		System.out.println("|----------------------------------------------------------------------------------|");
		System.out.println("| 3. Nombre de piece                                                               |");
		System.out.println("|----------------------------------------------------------------------------------|");
		System.out.println("| 4. Nombre de chambre                                                             |");
		System.out.println("|----------------------------------------------------------------------------------|");
		System.out.println("| 5. Nombre de salle de bain                                                       |");
		System.out.println("|----------------------------------------------------------------------------------|");
		System.out.println("| 6. Nombre de salle ayant acces a l'eau                                           |");
		System.out.println("|----------------------------------------------------------------------------------|");
		System.out.println("| 7. Description                                                                   |");
		System.out.println("|----------------------------------------------------------------------------------|");
		System.out.println("| 8. Photos                                                                        |");
		System.out.println("|----------------------------------------------------------------------------------|");
		System.out.println("| 9. Prix de vente                                                                 |");
		System.out.println("|----------------------------------------------------------------------------------|");
		System.out.println("| 10. Prix de vente minimum                                                        |");
		System.out.println("|----------------------------------------------------------------------------------|");
		System.out.println("| 11. Prix de vente maximum                                                        |");
		System.out.println("|----------------------------------------------------------------------------------|");
		System.out.println("| 12. Prix de location                                                             |");
		System.out.println("|----------------------------------------------------------------------------------|");
		System.out.println("| 13. Frais                                                                        |");
		System.out.println("|----------------------------------------------------------------------------------|");
		System.out.println("| 14. Performance energetique                                                      |");
		System.out.println("|----------------------------------------------------------------------------------|");
		System.out.println("| 15. GES                                                                          |");
		System.out.println("|----------------------------------------------------------------------------------|");
		System.out.println("| 0. Retourner au menu principal                                                   |");
		System.out.println("|__________________________________________________________________________________|");


		String choices = sc.nextLine();
		switch (choices) {
			case "1":
				superficieUpdate();
				break;
			case "2":
				etatUpdate();
				break;
			case "3":
				nbPieceUpdate();
				break;
			case "4":
				nbChambreUpdate();
				break;
			case "5":
				nbSDBUpdate();
				break;
			case "6":
				nbSalleAccesEauUpdate();
				break;
			case "7":
				descriptionUpdate();
				break;
			case "8":
				photoUpdate();
				break;
			case "9":
				prixVenteUpdate();
				break;
			case "10":
				prixVenteMinUpdate();
				break;
			case "11":
				prixVenteMaxUpdate();
				break;
			case "12":
				prixLocationUpdate();
				break;
			case "13":
				fraisUpdate();
				break;
			case "14":
				perfNRJUpdate();
				break;
			case "15":
				gesUpdate();
				break;

		}
		
	}

	public static void superficieUpdate() throws SQLException {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);

		System.out.println("Entrez la nouvelle superficie :");
		String nouv = sc.nextLine();

		String req = "UPDATE bien SET superficie ='" + nouv + "' WHERE id_bien =" + NeededIdBien + "";

		PreparedStatement preparedStmt = Db_connect.con.prepareStatement(req);
		preparedStmt.execute();

		System.out.println("La superficie a bien ete change !");

		MenuBienController.BienControllerMenu();
	}

	public static void etatUpdate() throws SQLException {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);

		System.out.println("Entrez le nouvel etat :");
		String nouv = sc.nextLine();

		String req = "UPDATE bien SET etat ='" + nouv + "' WHERE id_bien =" + NeededIdBien + "";

		PreparedStatement preparedStmt = Db_connect.con.prepareStatement(req);
		preparedStmt.execute();

		System.out.println("L'etat a bien ete change !");

		MenuBienController.BienControllerMenu();
	}

	public static void nbPieceUpdate() throws SQLException {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);

		System.out.println("Entrez le nombre de piece :");
		String nouv = sc.nextLine();

		String req = "UPDATE bien SET nb_pieces ='" + nouv + "' WHERE id_bien =" + NeededIdBien + "";

		PreparedStatement preparedStmt = Db_connect.con.prepareStatement(req);
		preparedStmt.execute();

		System.out.println("Le nombre de piece ete change !");

		MenuBienController.BienControllerMenu();
	}

	public static void nbChambreUpdate() throws SQLException {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);

		System.out.println("Entrez le nombre de chambre :");
		String nouv = sc.nextLine();

		String req = "UPDATE bien SET nb_chambre ='" + nouv + "' WHERE id_bien =" + NeededIdBien + "";

		PreparedStatement preparedStmt = Db_connect.con.prepareStatement(req);
		preparedStmt.execute();

		System.out.println("Le nombre de chambre ete change !");

		MenuBienController.BienControllerMenu();
	}

	public static void nbSDBUpdate() throws SQLException {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);

		System.out.println("Entrez le nombre de salle de bain :");
		String nouv = sc.nextLine();

		String req = "UPDATE bien SET nb_salle_bain ='" + nouv + "' WHERE id_bien =" + NeededIdBien + "";

		PreparedStatement preparedStmt = Db_connect.con.prepareStatement(req);
		preparedStmt.execute();

		System.out.println("Le nombre de salle de bain ete change !");

		MenuBienController.BienControllerMenu();
	}

	public static void nbSalleAccesEauUpdate() throws SQLException {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);

		System.out.println("Entrez le nombre de piece ayant un accès a l'eau :");
		String nouv = sc.nextLine();

		String req = "UPDATE bien SET nb_salle_eau ='" + nouv + "' WHERE id_bien =" + NeededIdBien + "";

		PreparedStatement preparedStmt = Db_connect.con.prepareStatement(req);
		preparedStmt.execute();

		System.out.println("Le nombre de piece ayant un accès à l'eau ete change !");

		MenuBienController.BienControllerMenu();
	}

	public static void descriptionUpdate() throws SQLException {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);

		System.out.println("Entrez la nouvelle description :");
		String nouv = sc.nextLine();

		String req = "UPDATE bien SET description ='" + nouv + "' WHERE id_bien =" + NeededIdBien + "";

		PreparedStatement preparedStmt = Db_connect.con.prepareStatement(req);
		preparedStmt.execute();

		System.out.println("La description a ete change !");

		MenuBienController.BienControllerMenu();
	}

	public static void photoUpdate() throws SQLException {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);

		System.out.println("Entrez la nouvelle photo :");
		String nouv = sc.nextLine();

		String req = "UPDATE bien SET photos ='" + nouv + "' WHERE id_bien =" + NeededIdBien + "";

		PreparedStatement preparedStmt = Db_connect.con.prepareStatement(req);
		preparedStmt.execute();

		System.out.println("La photo a ete change !");

		MenuBienController.BienControllerMenu();
	}

	public static void prixVenteUpdate() throws SQLException {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);

		System.out.println("Entrez le prix de vente :");
		String nouv = sc.nextLine();

		String req = "UPDATE bien SET prix_vente ='" + nouv + "' WHERE id_bien =" + NeededIdBien + "";

		PreparedStatement preparedStmt = Db_connect.con.prepareStatement(req);
		preparedStmt.execute();

		System.out.println("Le prix de vente a ete change !");

		MenuBienController.BienControllerMenu();
	}

	public static void prixVenteMinUpdate() throws SQLException {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);

		System.out.println("Entrez le prix de vente minimum :");
		String nouv = sc.nextLine();

		String req = "UPDATE bien SET prix_min_vente ='" + nouv + "' WHERE id_bien =" + NeededIdBien + "";

		PreparedStatement preparedStmt = Db_connect.con.prepareStatement(req);
		preparedStmt.execute();

		System.out.println("Le prix de vente minimum a ete change !");

		MenuBienController.BienControllerMenu();
	}


	public static void prixVenteMaxUpdate() throws SQLException {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);

		System.out.println("Entrez le prix de vente maximum :");
		String nouv = sc.nextLine();

		String req = "UPDATE bien SET prix_max_vente ='" + nouv + "' WHERE id_bien =" + NeededIdBien + "";

		PreparedStatement preparedStmt = Db_connect.con.prepareStatement(req);
		preparedStmt.execute();

		System.out.println("Le prix de vente maximum a ete change !");

		MenuBienController.BienControllerMenu();
	}

	public static void prixLocationUpdate() throws SQLException {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);

		System.out.println("Entrez le prix de location :");
		String nouv = sc.nextLine();

		String req = "UPDATE bien SET prix_location ='" + nouv + "' WHERE id_bien =" + NeededIdBien + "";

		PreparedStatement preparedStmt = Db_connect.con.prepareStatement(req);
		preparedStmt.execute();

		System.out.println("Le prix de location a ete change !");

		MenuBienController.BienControllerMenu();
	}

	public static void fraisUpdate() throws SQLException {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);

		System.out.println("Entrez les frais :");
		String nouv = sc.nextLine();

		String req = "UPDATE bien SET frais ='" + nouv + "' WHERE id_bien =" + NeededIdBien + "";

		PreparedStatement preparedStmt = Db_connect.con.prepareStatement(req);
		preparedStmt.execute();

		System.out.println("Les frais ont ete change !");

		MenuBienController.BienControllerMenu();
	}

	public static void perfNRJUpdate() throws SQLException {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);

		System.out.println("Entrez les performances energetique :");
		String nouv = sc.nextLine();

		String req = "UPDATE bien SET perf_energie ='" + nouv + "' WHERE id_bien =" + NeededIdBien + "";

		PreparedStatement preparedStmt = Db_connect.con.prepareStatement(req);
		preparedStmt.execute();

		System.out.println("Les perfomances energetique ont ete change !");

		MenuBienController.BienControllerMenu();
	}

	public static void gesUpdate() throws SQLException {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);

		System.out.println("Entrez les ges :");
		String nouv = sc.nextLine();

		String req = "UPDATE bien SET ges ='" + nouv + "' WHERE id_bien =" + NeededIdBien + "";

		PreparedStatement preparedStmt = Db_connect.con.prepareStatement(req);
		preparedStmt.execute();

		System.out.println("Les ges ont ete change !");

		MenuBienController.BienControllerMenu();
	}




	public static void delete() throws SQLException {


		Db_connect.connexion();

		Scanner sc = new Scanner(System.in);

		System.out.println("Entrez le nom du proprietaire :");
		String nomClient = sc.nextLine();
		System.out.println("Entrez le prenom du proprietaire :");
		String prenomClient = sc.nextLine();
		System.out.println("Entrez le numero de telephone du proprietaire :");
		String telClient = sc.nextLine();

		Statement statement = Db_connect.con.createStatement();
		ResultSet rs = statement.executeQuery("SELECT * FROM client WHERE nom_client = '" + nomClient + "' AND prenom_client = '" + prenomClient + "' AND tel_client = '" + telClient + "'");

		while (rs.next()) {
			System.out.println(" __________________________________________________________________________________");
			System.out.println("|                                                                                  |");
			System.out.println("| ID Client : " + rs.getString(1));
			System.out.println("|----------------------------------------------------------------------------------|");
			System.out.println("| Nom : " + rs.getString(2));
			System.out.println("|----------------------------------------------------------------------------------|");
			System.out.println("| Prenom : " + rs.getString(3));
			System.out.println("|----------------------------------------------------------------------------------|");

			NeededIdClient = rs.getString(1);
		}


		Statement statement2 = Db_connect.con.createStatement();
		ResultSet rs2 = statement2.executeQuery("SELECT * FROM proprietaire WHERE id_client = '" + NeededIdClient + "'");

		while (rs2.next()) {
			System.out.println("| ID Bien : " + rs2.getString(2));
			System.out.println("|__________________________________________________________________________________|");

			NeededIdBien = rs2.getString(2);
		}

		Statement statement3 = Db_connect.con.createStatement();
		ResultSet rs3 = statement3.executeQuery("SELECT * FROM type_bien WHERE id_bien = '" + NeededIdBien + "'");

		while (rs3.next()) {
			System.out.println("| ID Type bien : " + rs3.getString(2));
			System.out.println("|__________________________________________________________________________________|");
			System.out.println("| Type Bien : " + rs3.getString(3));
			System.out.println("|__________________________________________________________________________________|");

			NeededIdTypeBien = rs3.getString(2);
			NeededTypeBien = rs3.getString(3);

		}

		Statement statement4 = Db_connect.con.createStatement();
		ResultSet rs4 = statement4.executeQuery("SELECT * FROM bien WHERE id_bien = '" + NeededIdBien + "'");


		while (rs4.next()) {

			System.out.println(" __________________________________________________________________________________");
			System.out.println("|                                                                                  |");
			System.out.println("| ID Bien : " + rs4.getString(2));
			System.out.println("|----------------------------------------------------------------------------------|");
			System.out.println("| Superficie : " + rs4.getString(3));
			System.out.println("|__________________________________________________________________________________|");
			System.out.println("| Etat : " + rs4.getString(4));
			System.out.println("|__________________________________________________________________________________|");
			System.out.println("| Nombres de pieces : " + rs4.getString(5));
			System.out.println("|__________________________________________________________________________________|");
			System.out.println("| Nombres de chambres : " + rs4.getString(6));
			System.out.println("|__________________________________________________________________________________|");
			System.out.println("| Nombres de salle de bain : " + rs4.getString(7));
			System.out.println("|__________________________________________________________________________________|");
			System.out.println("| Nombres de pieces ayant un accès à l'eau : " + rs4.getString(8));
			System.out.println("|__________________________________________________________________________________|");
			System.out.println("| Description : " + rs4.getString(9));
			System.out.println("|__________________________________________________________________________________|");
			System.out.println("| Photo : " + rs4.getString(10));
			System.out.println("|__________________________________________________________________________________|");
			System.out.println("| Prix de vente : " + rs4.getString(11));
			System.out.println("|__________________________________________________________________________________|");
			System.out.println("| Prix de vente minimum : " + rs4.getString(12));
			System.out.println("|__________________________________________________________________________________|");
			System.out.println("| Prix de vente maximum : " + rs4.getString(13));
			System.out.println("|__________________________________________________________________________________|");
			System.out.println("| Prix de location : " + rs4.getString(14));
			System.out.println("|__________________________________________________________________________________|");
			System.out.println("| Frais : " + rs4.getString(15));
			System.out.println("|__________________________________________________________________________________|");
			System.out.println("| Perfomances energetique : " + rs4.getString(16));
			System.out.println("|__________________________________________________________________________________|");
			System.out.println("| GES : " + rs4.getString(17));
			System.out.println("|__________________________________________________________________________________|");
			System.out.println("| Type de bien : " + rs4.getString(19));
			System.out.println("|__________________________________________________________________________________|");


		}

		System.out.println("Voulez vous supprimer ce bien ? (Y/N)");
		String a = sc.nextLine();

		switch (a) {
			case "Y":
				deleteYes();

				break;
			case "y":
				deleteYes();

				break;
			case "N":
				MenuBienController.BienControllerMenu();

				break;
			case "n":
				MenuBienController.BienControllerMenu();

				break;
		}

		MenuBienController.BienControllerMenu();
	}

	public static void deleteYes() throws SQLException {

		Statement statement = Db_connect.con.createStatement();
		statement.executeUpdate("DELETE FROM bien WHERE id_bien = '" + NeededIdBien + "'");

		System.out.println("Le bien a ete supprime !");
	}
}
