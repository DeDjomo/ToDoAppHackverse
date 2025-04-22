package cm.polytechnique.model.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TeamProjectTask {
    //Attributes
    private int teamProjectTask_id;
    private String teamProjectTask_title;
    private String teamProjectTask_description;
    private java.sql.Timestamp teamProjectTask_start;
    private java.sql.Timestamp teamProjectTask_end;
    private int teamProjectTask_project; //Clé étrangère identifiant de la table Team_Projects
    private int teamProjectTask_state;
    public static final String tableName = "Team_Project_Tasks";

    //Constructors
    public TeamProjectTask(String teamProjectTask_title, String teamProjectTask_description, java.sql.Timestamp teamProjectTask_start, java.sql.Timestamp teamProjectTask_end, int teamProjectTask_project, int teamProjectTask_state) {
        this.teamProjectTask_title = teamProjectTask_title;
        this.teamProjectTask_description = teamProjectTask_description;
        this.teamProjectTask_start = teamProjectTask_start;
        this.teamProjectTask_end = teamProjectTask_end;
        this.teamProjectTask_project = teamProjectTask_project;
        this.teamProjectTask_state = teamProjectTask_state;
    }

    //Method to add a team project task in the database
    public int save() {
        Connection connection = DatabaseConnection.getConnection();
        
        if (connection == null) {
            return -1;
        }
        String request = "INSERT INTO " + tableName + "(title, description, start, end, project, state)" + "VALUES (?,?,?,?,?,?)";
        try {
            PreparedStatement pstmt = connection.prepareStatement(request);

            pstmt.setString(1, this.teamProjectTask_title);
            pstmt.setString(2, this.teamProjectTask_description);
            pstmt.setTimestamp(3, this.teamProjectTask_start);
            pstmt.setTimestamp(4, this.teamProjectTask_end);
            pstmt.setInt(5, this.teamProjectTask_project);
            pstmt.setInt(6, this.teamProjectTask_state);

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

    //Method to delete a team project task in the database
    public int delete() {
        Connection connection = DatabaseConnection.getConnection();
        
        if (connection == null) {
            return -1;
        }
        String request = "DELETE FROM " + tableName + " WHERE id = ?";
        try {
            PreparedStatement pstmt = connection.prepareStatement(request);

            pstmt.setInt(1, teamProjectTask_id);

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

    //Method to verify if a single task is in the database
    public int verify(String title) {
        Connection connection = DatabaseConnection.getConnection();
        if (connection == null) {
            return -1;
        }
        String request = "SELECT * FROM " + tableName;
        try {
            PreparedStatement pstmt = connection.prepareStatement(request);
            ResultSet res = pstmt.executeQuery();

            while(res.next()) {
                String title1 = res.getString("title");

                if (title1.equals(title)) {
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
