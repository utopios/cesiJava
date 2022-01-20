import tools.DataConnection;

import java.sql.Connection;

public class Main {
    public  static void main(String[] args) {
        try {
            Connection connection = new DataConnection().getConnection();
            if(connection != null) {
                System.out.println("Connection OK");
            }
        }catch (Exception ex) {
            System.out.println(ex);
        }
    }
}
