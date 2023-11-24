package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class Conexion {

	// Variables

	private final String DRIVER = "com.mysql.cj.jdbc.Driver"; // Ruta en donde se encuentra Driver.class
	private final String URL = "jdbc:mysql://localhost:3306/";
	private final String DB = "dbsistema";
	private final String USER = "root";
	private final String PASSWORD = "1234";

	public Connection cadena;
	public static Conexion instancia;

	// Constructores

	public Conexion() {
		this.cadena = null;

	}

	// Funciones - Métodos

	public Connection conectar() {
		try {
			Class.forName(DRIVER);
			this.cadena = DriverManager.getConnection(URL + DB, USER, PASSWORD);
		} catch (ClassNotFoundException | SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
			System.exit(0);
		}
		return this.cadena;
	}

	public void desconectar() {
		try {
			this.cadena.close();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}
	
	public static synchronized Conexion getInstancia() {
		if (instancia==null) {
			instancia = new Conexion();
		}
		return instancia;
	}

}
