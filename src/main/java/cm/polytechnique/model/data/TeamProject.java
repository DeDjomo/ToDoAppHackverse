package cm.polytechnique.model.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TeamProject {
    //attributes
    private int teamProject_id;
    private String teamProject_name;
    private String teamProject_description;
    private java.sql.Timestamp teamProject_start;
    private java.sql.Timestamp teamProject_end;
    private static int teamProject_scope = 0;
    private int teamProject_team;
    private int teamProject_state;
    public static final String tableName = "Team_Projects";

    //Constructors
    public TeamProject(String teamProject_name, String teamProject_description, java.sql.Timestamp teamProject_start, java.sql.Timestamp teamProject_end, int teamProject_scope, int teamProject_team, int teamProject_state) {
        this.teamProject_name = teamProject_name;
        this.teamProject_description = teamProject_description;
        this.teamProject_start = teamProject_start;
        this.teamProject_end = teamProject_end;
        TeamProject.teamProject_scope = teamProject_scope;
        this.teamProject_team = teamProject_team;
        this.teamProject_state = teamProject_state;
    }

    //Method to add a team project in the database
    public int save() {
        Connection connection = DatabaseConnection.getConnection();
        
        if (connection == null) {
            return -1;
        }
        String request = "INSERT INTO " + tableName + "(name, description, start, end, team, state)" + "VALUES (?,?,?,?,?,?)";
        try {
            PreparedStatement pstmt = connection.prepareStatement(request);
            
            pstmt.setString(1, this.teamProject_name);
            pstmt.setString(2, this.teamProject_description);
            pstmt.setTimestamp(3, this.teamProject_start);
            pstmt.setTimestamp(4, this.teamProject_end);
            pstmt.setInt(5, this.teamProject_team);
            pstmt.setInt(6, this.teamProject_state);

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

    //Method to delete a team project in the database
    public int delete() {
        Connection connection = DatabaseConnection.getConnection();
        
        if (connection == null) {
            return -1;
        }
        String request = "DELETE FROM " + tableName + " WHERE id = ?";
        try {
            PreparedStatement pstmt = connection.prepareStatement(request);

            pstmt.setInt(1, teamProject_id);

            pstmt.executeUpdate();
            return 0;
        } catch(SQLException e) {
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

    //Method to verify if a team project is in the database
    public int verify(String name) {
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

                if (name1.equals(name)) {
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
}
