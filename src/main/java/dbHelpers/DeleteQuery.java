package dbHelpers;

import connection.SingleConnection;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Objects;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DeleteQuery {

    public void doDelete(int id) {


        String query = "DELETE FROM student WHERE id = ?";


        PreparedStatement ps = null;


        try {
            ps = SingleConnection.getConnection().prepareStatement(query);

            ps.setInt(1, id);

            ps.executeUpdate();
        } catch (SQLException e) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, e);

        }


    }


}
