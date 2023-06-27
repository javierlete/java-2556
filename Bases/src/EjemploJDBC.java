import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

import java.math.BigDecimal;

public class EjemploJDBC {

	public static void main(String[] args) throws SQLException {
		final String URL = "jdbc:sqlite:sql/bases.db";
		
		final String SQL_SELECT = "SELECT * FROM productos";
		final String SQL_SELECT_ID = "SELECT * FROM productos WHERE id=?";
		final String SQL_INSERT = "INSERT INTO productos (nombre, precio, caducidad) VALUES (?,?,?)";
		final String SQL_UPDATE = "UPDATE productos SET nombre=?, precio=?, caducidad=? WHERE id=?";
		final String SQL_DELETE = "DELETE FROM productos WHERE id=?";
		
		// Establece el canal de comunicaciones con la base de datos
		Connection con = DriverManager.getConnection(URL);
		// Crea una orden de SQL
		PreparedStatement pst = con.prepareStatement(SQL_SELECT);
		// Envía un texto de SQL en la sentencia
		// Esto devuelve un conjunto de resultados (filas)
		ResultSet rs = pst.executeQuery();
		
		while(rs.next()) {
			System.out.printf("%s, %s, %s, %s\n", rs.getInt("id"), rs.getString("nombre"), rs.getBigDecimal("precio"), LocalDate.parse(rs.getString("caducidad")));
		}
		
		rs.close();
		pst.close();
		
		int id = 1;
		
		pst = con.prepareStatement(SQL_SELECT_ID);
		
		pst.setInt(1, id);
		
		rs = pst.executeQuery();
		
		if(rs.next()) {
			System.out.printf("%s, %s, %s, %s\n", rs.getInt("id"), rs.getString("nombre"), rs.getBigDecimal("precio"), LocalDate.parse(rs.getString("caducidad")));
		} else {
			System.out.println("No se ha encontrado el id " + id);
		}
		
		rs.close();
		pst.close();
		
		pst = con.prepareStatement(SQL_INSERT);
		
		pst.setString(1, "Nuevo");
		pst.setBigDecimal(2, new BigDecimal("345"));
		pst.setString(3, LocalDate.now().toString());
		
		int numeroRegistrosModificados = pst.executeUpdate();
		
		pst.close();
		
		System.out.println(numeroRegistrosModificados);
		
		pst = con.prepareStatement(SQL_UPDATE);
		
		pst.setString(1, "Modificado");
		pst.setBigDecimal(2, new BigDecimal("2345234"));
		pst.setString(3, LocalDate.now().toString());
		pst.setInt(4, id);
		
		numeroRegistrosModificados = pst.executeUpdate();
		
		pst.close();
		
		System.out.println(numeroRegistrosModificados);
		
		pst = con.prepareStatement(SQL_DELETE);
		
		pst.setInt(1, id);
		
		numeroRegistrosModificados = pst.executeUpdate();
		
		pst.close();
		
		System.out.println(numeroRegistrosModificados);
		
		con.close();
	}

}
