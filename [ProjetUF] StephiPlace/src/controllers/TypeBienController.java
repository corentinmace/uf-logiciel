package controllers;

import back.Db_connect;
import back.MenuTypeBienController;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;
import java.util.Scanner;

public class TypeBienController {


    static String NeededIdClient = null;
    static String NeededIdBien = null;

    public static void create() throws SQLException {

        Random rand = new Random();
        int idTypeBien = rand.nextInt((99999 - 1) + 1) + 1;
        System.out.println(idTypeBien);

        Db_connect.connexion();

        @SuppressWarnings("resource")
        Scanner sc = new Scanner(System.in);

        System.out.println("Entrez le nom du client (existant) :");
        String nomClient = sc.nextLine();
        System.out.println("Entrez le prenom du client (existant) :");
        String prenomClient = sc.nextLine();
        System.out.println("Entrez le numero de telephone du client  (existant) :");
        String telClient = sc.nextLine();

        Statement statement = Db_connect.con.createStatement();
        ResultSet rs=statement.executeQuery("SELECT id_client, nom_client, prenom_client FROM client WHERE nom_client = '" + nomClient + "' AND prenom_client = '" + prenomClient + "' AND tel_client = '" + telClient + "'");

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


        Statement Statement2 = Db_connect.con.createStatement();
        ResultSet rs2=Statement2.executeQuery("SELECT * FROM proprietaire WHERE id_client = '" + NeededIdClient + "'");

        while(rs2.next()) {
            System.out.println("| ID Bien : " + rs2.getString(2));
            System.out.println("|__________________________________________________________________________________|");
            NeededIdBien = rs2.getString(2);
        }

        System.out.println("Entrez le type de bien :");
        String typeBien = sc.nextLine();

        Statement statementIn = Db_connect.con.createStatement();
        statementIn.executeUpdate("INSERT INTO type_bien (id_bien, id_type_bien, type_bien) VALUES ('" + NeededIdBien + "','" + idTypeBien + "','" + typeBien + "')");

        System.out.println("Vous avez ajouté le type de bien " + typeBien + "(id bien : " + NeededIdBien +", id type bien :" + idTypeBien);

        MenuTypeBienController.TypeBienControllerMenu();

    }

    public static void read() throws SQLException {

        Db_connect.connexion();

        @SuppressWarnings("resource")
        Scanner sc = new Scanner(System.in);

        System.out.println(" __________________________________");
        System.out.println("|                                  |");
        System.out.println("|   1. Chercher un type de bien    |");
        System.out.println("|----------------------------------|");
        System.out.println("|2. Afficher tout les type de bien |");
        System.out.println("|__________________________________|");

        String choices = sc.nextLine();
        switch(choices) {
            case "1":
                System.out.println(" __________________________________");
                System.out.println("|                                  |");
                System.out.println("|   Recherche d'un type de bien    |");
                System.out.println("|__________________________________|");


                Db_connect.connexion();

                System.out.println("Entrez le nom du client (existant) :");
                String nomClient = sc.nextLine();
                System.out.println("Entrez le prenom du client (existant) :");
                String prenomClient = sc.nextLine();
                System.out.println("Entrez le numero de telephone du client  (existant) :");
                String telClient = sc.nextLine();

                Statement statement = Db_connect.con.createStatement();
                ResultSet rs=statement.executeQuery("SELECT id_client, nom_client, prenom_client FROM client WHERE nom_client = '" + nomClient + "' AND prenom_client = '" + prenomClient + "' AND tel_client = '" + telClient + "'");

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


                Statement Statement2 = Db_connect.con.createStatement();
                ResultSet rs2=Statement2.executeQuery("SELECT * FROM proprietaire WHERE id_client = '" + NeededIdClient + "'");

                while(rs2.next()) {
                    System.out.println("| ID Bien : " + rs2.getString(2));
                    System.out.println("|__________________________________________________________________________________|");
                    NeededIdBien = rs2.getString(2);
                }

                Statement statement3 = Db_connect.con.createStatement();
                ResultSet rs3=statement3.executeQuery("SELECT * FROM type_bien WHERE id_bien = '" + NeededIdBien + "'");

                while(rs3.next()) {
                    System.out.println("| Id Type Bien : " + rs3.getString(2));
                    System.out.println("|__________________________________________________________________________________|");
                    System.out.println("| Type Bien : " + rs3.getString(3));
                    System.out.println("|__________________________________________________________________________________|");
                }

                break;

            case "2":


                System.out.println(" __________________________________");
                System.out.println("|                                  |");
                System.out.println("|Affichage de tout les type de bien|");
                System.out.println("|__________________________________|");

                Statement statement4 = Db_connect.con.createStatement();
                ResultSet rs4 = statement4.executeQuery("SELECT * FROM type_bien");

                while(rs4.next()) {
                    System.out.println(" __________________________________");
                    System.out.println("|                                  |");
                    System.out.println("| Id bien : " + rs4.getString(1));
                    System.out.println("|----------------------------------|");
                    System.out.println("| Id Type Bien : " + rs4.getString(2));
                    System.out.println("|----------------------------------|");
                    System.out.println("| Type Bien : " + rs4.getString(3));
                    System.out.println("|__________________________________|");
                }
        }

        MenuTypeBienController.TypeBienControllerMenu();
    }

    public static void update() throws SQLException {
        Scanner sc = new Scanner(System.in);
        Db_connect.connexion();

        System.out.println("Entrez le nom du client (existant) :");
        String nomClient = sc.nextLine();
        System.out.println("Entrez le prenom du client (existant) :");
        String prenomClient = sc.nextLine();
        System.out.println("Entrez le numero de telephone du client  (existant) :");
        String telClient = sc.nextLine();

        Statement statement = Db_connect.con.createStatement();
        ResultSet rs=statement.executeQuery("SELECT id_client, nom_client, prenom_client FROM client WHERE nom_client = '" + nomClient + "' AND prenom_client = '" + prenomClient + "' AND tel_client = '" + telClient + "'");

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


        Statement Statement2 = Db_connect.con.createStatement();
        ResultSet rs2=Statement2.executeQuery("SELECT * FROM proprietaire WHERE id_client = '" + NeededIdClient + "'");

        while(rs2.next()) {
            System.out.println("| ID Bien : " + rs2.getString(2));
            System.out.println("|__________________________________________________________________________________|");
            NeededIdBien = rs2.getString(2);
        }

        Statement statement3 = Db_connect.con.createStatement();
        ResultSet rs3=statement3.executeQuery("SELECT * FROM type_bien WHERE id_bien = '" + NeededIdBien + "'");

        while(rs3.next()) {
            System.out.println("| Id Type Bien : " + rs3.getString(2));
            System.out.println("|__________________________________________________________________________________|");
            System.out.println("| Type Bien : " + rs3.getString(3));
            System.out.println("|__________________________________________________________________________________|");
        }



        System.out.println("Rentrez le nouveau type de bien :");
        String nouv = sc.nextLine();

        String req = "UPDATE type_bien SET type_bien ='" + nouv + "' WHERE id_bien =" + NeededIdBien + "";

        PreparedStatement preparedStmt = Db_connect.con.prepareStatement(req);
        preparedStmt.execute();

        System.out.println("Le type de bien a bien ete change !");

        MenuTypeBienController.TypeBienControllerMenu();

    }
      public static void delete() throws SQLException {

        Db_connect.connexion();

        @SuppressWarnings("resource")
        Scanner sc = new Scanner(System.in);

        System.out.println("Entrez le nom du client (existant) :");
        String nomClient = sc.nextLine();
        System.out.println("Entrez le prenom du client (existant) :");
        String prenomClient = sc.nextLine();
        System.out.println("Entrez le numero de telephone du client  (existant) :");
        String telClient = sc.nextLine();

        Statement statement = Db_connect.con.createStatement();
        ResultSet rs=statement.executeQuery("SELECT id_client, nom_client, prenom_client FROM client WHERE nom_client = '" + nomClient + "' AND prenom_client = '" + prenomClient + "' AND tel_client = '" + telClient + "'");

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


        Statement Statement2 = Db_connect.con.createStatement();
        ResultSet rs2=Statement2.executeQuery("SELECT * FROM proprietaire WHERE id_client = '" + NeededIdClient + "'");

        while(rs2.next()) {
            System.out.println("| ID Bien : " + rs2.getString(2));
            System.out.println("|__________________________________________________________________________________|");
            NeededIdBien = rs2.getString(2);
        }

        Statement statement3 = Db_connect.con.createStatement();
        statement3.executeUpdate("DELETE FROM type_bien WHERE id_bien = '" + NeededIdBien + "'");

        System.out.println("Type de bien supprimé");

        MenuTypeBienController.TypeBienControllerMenu();

    }
}
