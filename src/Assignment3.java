import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class Assignment3 {

    private static Connection myConnection = null;
    public static Connection getConnection() throws Exception {

        if(myConnection != null)
            return myConnection;

        try {
            String url = "jdbc:mysql://localhost:3306/sqlandjava?serverTimezone=UTC";
            String username = "karin";
            String password = "sorlin";

            Connection conn =DriverManager.getConnection(url, username, password);
            System.out.println("Connection Established to MySQL Database sqlandjava");
            myConnection = conn;
            return myConnection;
        } catch(Exception e) {System.out.println(e);}
        return null;
    }

    public static ArrayList<String> getPeople() throws Exception {
        Connection conn = getConnection();

        Statement statement = conn.createStatement();

        ResultSet res = statement.executeQuery("select * from sqlandjava.people");

        ArrayList<String> persons = new ArrayList<>();
        persons.add("nollindex");
        while(res.next()){
            persons.add(res.getString("firstname") +" " + res.getString("lastname"));
        }
        return persons;
    }

    public static ArrayList<String> getCars() throws Exception{
        Connection conn = getConnection();

        Statement statement = conn.createStatement();

        ResultSet res = statement.executeQuery("select * from sqlandjava.cars");
        ArrayList<String> cars = new ArrayList<>();
        cars.add("nollindex");
        while(res.next()){
            cars.add(res.getString("color") +" " + res.getString("brand"));
        }
        return cars;
    }

    public static void main(String[] args) throws Exception {
        Connection conn = getConnection();

        Statement statement = conn.createStatement();

        ResultSet res = statement.executeQuery("select * from sqlandjava.owners");
        ArrayList<String> cars = getCars();
        ArrayList<String> persons = getPeople();
        while(res.next()){
            System.out.println(res.getString("owner_id") + ": " +
                    persons.get(res.getInt("person_id"))+ " owns a " + cars.get(res.getInt("car_id")));

        }
    }
}
