package json;


import model.User;
import utils.Util;
import javax.sql.rowset.CachedRowSet;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;



@Path("/getExample")
public class Main  {

    DatabaseOperations dbOp;
    Statement stmt;
    public CachedRowSet resWanted;
    Util myUtil;
    String result;

    @GET
    @Produces(MediaType.APPLICATION_JSON) // ensures that the produced output is in JSON format
    @Path("/getTheList")  // which path we enter in the URL part will run that method
    public List<User> start() throws SQLException, IllegalAccessException, InstantiationException, ClassNotFoundException {
        ResultSet rs;
        dbOp = new DatabaseOperations();
        myUtil = new Util();

        stmt = dbOp.openConnection();
        resWanted = dbOp.createStatement();
        rs = query();
        myUtil.addUser(rs);
        return myUtil.getUserList();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/age/{age}")
    public List<User> start(@PathParam("age") int userAge) throws SQLException, IllegalAccessException, InstantiationException, ClassNotFoundException {
        ResultSet rs;
        dbOp = new DatabaseOperations();
        myUtil = new Util();

        stmt = dbOp.openConnection();
        resWanted = dbOp.createStatement();
        rs = queryAge(userAge);
        myUtil.addUser(rs);
        return myUtil.getUserList();
    }



    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/lastname/{lastname}")
    public List<User> lastname(@PathParam("lastname") String lastname) throws SQLException, IllegalAccessException, InstantiationException, ClassNotFoundException {
        ResultSet rs;
        dbOp = new DatabaseOperations();
        myUtil = new Util();

        stmt = dbOp.openConnection();
        resWanted = dbOp.createStatement();
        rs = queryLastname(lastname);
        myUtil.addUser(rs);
        return myUtil.getUserList();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/name/{name}")
    public List<User> getName(@PathParam("name") String userName)  throws SQLException, IllegalAccessException, InstantiationException, ClassNotFoundException {
        ResultSet rs;
        dbOp = new DatabaseOperations();
        myUtil = new Util();

        stmt = dbOp.openConnection();
        resWanted = dbOp.createStatement();
        rs = queryName(userName);
        myUtil.addUser(rs);
        return myUtil.getUserList();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/id/{id}")
    public List<User> doThis(@PathParam("id") int userID)  throws SQLException, IllegalAccessException, InstantiationException, ClassNotFoundException {
        ResultSet rs;
        dbOp = new DatabaseOperations();
        myUtil = new Util();

        stmt = dbOp.openConnection();
        resWanted = dbOp.createStatement();
        rs = queryID(userID);
        myUtil.addUser(rs);
        return myUtil.getUserList();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/email/{email}")
    public List<User> doThis(@PathParam("email") String userEmail)  throws SQLException, IllegalAccessException, InstantiationException, ClassNotFoundException {
        ResultSet rs;
        dbOp = new DatabaseOperations();
        myUtil = new Util();

        stmt = dbOp.openConnection();
        resWanted = dbOp.createStatement();
        rs = queryEmail(userEmail);
        myUtil.addUser(rs);
        return myUtil.getUserList();
    }

    public ResultSet query() throws SQLException{
        String query;
        query = "Select * from user";
        PreparedStatement ps = dbOp.getCon().prepareStatement(query);
        ResultSet rs = ps.executeQuery();
        return rs;
    }

    public ResultSet queryAge(int age) throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
        String query;
        query = "Select * from user where age like '" + age + "%'";
        PreparedStatement ps = dbOp.getCon().prepareStatement(query);
        ResultSet rs = ps.executeQuery();
        return rs;
    }

    public ResultSet queryID(int id) throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
        String query;
        query = "Select * from user where id like '" + id + "%'";
        PreparedStatement ps = dbOp.getCon().prepareStatement(query);
        ResultSet rs = ps.executeQuery();
        return rs;
    }

    public ResultSet queryName(String name) throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
        String query;
        query = "Select * from user where name like '" + name + "%'";
        PreparedStatement ps = dbOp.getCon().prepareStatement(query);
        ResultSet rs = ps.executeQuery();
        return rs;
    }


    public ResultSet queryLastname(String lastname) throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
        String query;
        query = "Select * from user where lastname like '" + lastname + "%'";
        PreparedStatement ps = dbOp.getCon().prepareStatement(query);
        ResultSet rs = ps.executeQuery();
        return rs;
    }

    public ResultSet queryEmail(String email) throws  SQLException{
        String query;
        query = "Select * from user where email like '" + email + "%'";
        PreparedStatement ps = dbOp.connect().prepareStatement(query);
        ResultSet rs = ps.executeQuery();
        return rs;
    }
}
