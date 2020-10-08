package dbworker;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DBWorker {

	public boolean insertDB(int idfile, String fileName) {
		Connection conn = null;
		PreparedStatement stmt = null;

		try {
			conn = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test", "user", "");

			try {
				stmt = conn.prepareStatement("INSERT INTO testfiles(idfile, file) " + "VALUES(?, ?)");
				File file = new File("C:\\Users\\Konstantin\\eclipse-workspace\\PipelineSystem\\" + fileName);
				FileInputStream fis = new FileInputStream(file);
				stmt.setBinaryStream(2, fis);
				stmt.setInt(1, idfile);
				stmt.execute();
				fis.close();

			} catch (SQLException ex) {
				ex.printStackTrace();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {

				if (stmt != null) {
					try {
						stmt.close();
					} catch (SQLException sqlEx) {
						sqlEx.printStackTrace();
					}

					stmt = null;
				}
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException se2) {
			} // nothing we can do
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}
		return true;
	}
}
