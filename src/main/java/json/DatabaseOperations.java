package json;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetProvider;
import java.sql.*;
import java.util.Properties;
import java.util.logging.Logger;
import java.util.logging.Level;
import java.sql.DriverManager;

public class DatabaseOperations {

    private Connection con;
    private Connection connection;
    private final String url;
    private final String databaseName;
    private final String driver;
    private final String userName;
    private final String password;
    Statement stmt;
    private Properties properties;



    public DatabaseOperations() {

        con = null;
        url = "jdbc:mysql://localhost:3306/restapi?useTimezone=true&serverTimezone=UTC";
        databaseName = "restapi";
        driver = "com.mysql.cj.jdbc.Driver";
        userName = "root";
        password = "";
        stmt = null;
    }

    public Connection getCon() {
        return con;
    }

    // create properties
    private Properties getProperties() {
        if (properties == null) {
            properties = new Properties();
            properties.setProperty("user", userName);
            properties.setProperty("password", password);

        }
        return properties;
    }


    public Statement openConnection() throws ClassNotFoundException, SQLException, IllegalAccessException, InstantiationException {
        Class.forName(driver);
        con = DriverManager.getConnection(url, getProperties());
        return con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
    }

    public void closeConnection() throws SQLException {
        con.close();
    }

    // connect database
    public Connection connect() {
        if (connection == null) {
            try {
                Class.forName(driver);
                connection = DriverManager.getConnection(url, getProperties());
            } catch (ClassNotFoundException | SQLException e) {
                e.printStackTrace();
            }
        }
        return connection;
    }

    public CachedRowSet createStatement() throws SQLException {
        Statement st1;
        CachedRowSet crs = null;

        try {
            st1 = con.createStatement();
            crs = RowSetProvider.newFactory().createCachedRowSet();
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseOperations.class.getName()).log(Level.SEVERE, null, ex);
        }
        return crs;
    }
}
