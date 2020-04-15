package front;

import java.sql.SQLException;

import back.Db_connect;

public class Main {
	
	public static void main(String[] args) {
		Window window = new Window("ProjetUF", 1280, 720);
		Db_connect.connexion();
}
