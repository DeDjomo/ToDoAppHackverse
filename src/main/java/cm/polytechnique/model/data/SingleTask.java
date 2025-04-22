package cm.polytechnique.model.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SingleTask {
    //attributes
    private int singleTask_id;
    private String singleTask_title;
    private String singleTask_description;
    private java.sql.Timestamp singleTask_start;
    private java.sql.Timestamp singleTask_end;
    private int singleTask_state;
    public static final String tableName = "Single_Tasks"; 

    //Constructors
    public SingleTask(String singleTask_title, String singleTask_description, java.sql.Timestamp singleTask_start, java.sql.Timestamp singleTask_end, int singleTask_state) {
        this.singleTask_title = singleTask_title;
        this.singleTask_description = singleTask_description;
        this.singleTask_start = singleTask_start;
        this.singleTask_end = singleTask_end;
        this.singleTask_state = singleTask_state;
    }

    //Method to add a single task in the database
    public int save() {
        Connection connection = DatabaseConnection.getConnection();
        
        if (connection == null) {
            return -1;
        }
        String request = "INSERT INTO " + tableName + "(title, description, start, end, state)" + "VALUES (?,?,?,?,?)";
        try {
            PreparedStatement pstmt = connection.prepareStatement(request);
            
            pstmt.setString(1, this.singleTask_title);
            pstmt.setString(2, this.singleTask_description);
            pstmt.setTimestamp(3, this.singleTask_start);
            pstmt.setTimestamp(4, this.singleTask_end);
            pstmt.setInt(5, this.singleTask_state);

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

    //Method to delete a single task in the database
    public int delete() {
        Connection connection = DatabaseConnection.getConnection();
        
        if (connection == null) {
            return -1;
        }
        String request = "DELETE FROM " + tableName + " WHERE id = ?";
        try {
            PreparedStatement pstmt = connection.prepareStatement(request);

            pstmt.setInt(1, singleTask_id);

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
                String singleTask_title = res.getString("title");

                if (singleTask_title.equals(title)) {
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

    //Method to retrieve datum from the table Single_Tasks
    public List<SingleTask> retrieve() {
        Connection connection = DatabaseConnection.getConnection();
        if (connection == null) {
            return null;
        }
        String request = "SELECT * FROM " + tableName;
        List<SingleTask> singleTasks = new ArrayList<>();
        try {
            PreparedStatement pstmt = connection.prepareStatement(request);
            ResultSet res = pstmt.executeQuery();

            String title1 = "";
            String description1 = "";
            java.sql.Timestamp start1;
            java.sql.Timestamp end1;
            int state1;

            while (res.next()) {
                title1 = res.getString("title");
                description1 = res.getString("description");
                start1 = res.getTimestamp("start");
                end1 = res.getTimestamp("end");
                state1 = res.getInt("state");

                SingleTask singleTask = new SingleTask(title1, description1, start1, end1, state1);
                singleTasks.add(singleTask);
            }
        } catch(SQLException e) {
            return null;
        }
        return singleTasks;
    }
}
