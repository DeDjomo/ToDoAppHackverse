package cm.polytechnique.model.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class User {
    //Attributes
	private int user_id;
	private String user_name;
	private String user_email;
	private String user_password;
	private static final String tableName = "Users";

    //Getters
    public String getUserName() {
        return user_name;
    }
    public String getUserEmail() {
        return user_email;
    }
    public String getUserPassword() {
        return user_password;
    }

    //Constructors
	public User(String user_name, String user_email, String user_password) {
		this.user_name = user_name;
		this.user_email = user_email;
		this.user_password = user_password;	
	}

    public User(int user_id, String user_name, String user_email, String user_password) {
        this.user_id = user_id;
		this.user_name = user_name;
		this.user_email = user_email;
		this.user_password = user_password;	
	}

    //Metod to insert a user in the database
    public int save() {
        Connection connection = DatabaseConnection.getConnection();
        
        if (connection == null) {
            return -1;
        }
        String request = "INSERT INTO " + tableName + "(name, email, password)" + "VALUES (?,?,?)";
        try {
            PreparedStatement pstmt = connection.prepareStatement(request);
            
            pstmt.setString(1, this.user_name);
            pstmt.setString(2, this.user_email);
            pstmt.setString(3, this.user_password);

            pstmt.executeUpdate();
            return 0;
        } catch (SQLException e){
            //e.printStackTrace();
            return -1;
        }
        finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch(SQLException e) {

                }
            }
        }
    }

    //Method to delete a user in the database
    public int delete() {
        Connection connection = DatabaseConnection.getConnection();
        
        if (connection == null) {
            return -1;
        }
        String request = "DELETE FROM " + tableName + " WHERE id = ?";
        try {
            PreparedStatement pstmt = connection.prepareStatement(request);

            pstmt.setInt(1, user_id);

            pstmt.executeUpdate();
            return 0;
        } catch(SQLException e) {
            e.printStackTrace();
            return -1;
        }
        finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch(SQLException e) {
                    
                }
            }
        }
    }

    //Method to verify if a user is in the database
    public int verify(String name, String email) {
        Connection connection = DatabaseConnection.getConnection();
        if (connection == null) {
            return -1;
        }
        String request = "SELECT * FROM " + tableName;
        try {
            PreparedStatement pstmt = connection.prepareStatement(request);
            ResultSet res = pstmt.executeQuery();

            while(res.next()) {
                String name1 = res.getString("name");
                String email1 = res.getString("email");

                if (name1.equals(name) && email1.equals(email)) {
                    return 0;
                }
            }

            return 1;

        } catch (SQLException e) {
            return -1;
        }
        finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {}
            }
        }
    }

    //Method to retrieve data from the table Users
    public User retrieve() {
        Connection connection = DatabaseConnection.getConnection();
        if (connection == null) {
            return null;
        }
        String request = "SELECT * FROM " + tableName;
        String name1 = "";
        String email1 = "";
        String password1 = "";
        try {
            PreparedStatement pstmt = connection.prepareStatement(request);
            ResultSet res = pstmt.executeQuery();
            while (res.next()) {
               name1 = res.getString("name");
               email1 = res.getString("email");
               password1 = res.getString("password");  
            }
        } catch(SQLException e) {
            return null;
        }
        return new User(name1, email1, password1); 
    }
}
