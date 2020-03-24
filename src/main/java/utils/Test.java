package utils;

import json.DatabaseOperations;
import json.Main;
import javax.sql.rowset.*;
import javax.xml.crypto.Data;

import java.sql.SQLException;

public class Test {

    public static void main(String[] args) throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
        DatabaseOperations databaseOperations = new DatabaseOperations();
        databaseOperations.openConnection();
        Main main = new Main();
        String email = "onur_hzln@hotmail.com";
        main.queryEmail(email);

    }

}
