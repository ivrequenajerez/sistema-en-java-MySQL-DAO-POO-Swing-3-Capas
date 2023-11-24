package database;

public class PruebaConexion {

	public static void main(String[] args) {
		
		Conexion con = Conexion.getInstancia();

		try {
			con.conectar();

			if (con.cadena != null) {
				System.out.println("Conectado");
			} else {
				System.out.println("Desconectado");
			}

		} catch (Exception e) {
			System.out.println("Error al conectar: " + e.getMessage());

		} finally {
			con.desconectar();
		}
		
	}
	
}
