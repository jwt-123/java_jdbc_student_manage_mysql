package Authority;

import java.sql.*;
import java.util.ResourceBundle;

import static java.lang.Class.forName;

public class student_grade implements Grade_0 {
    public void selectMyScore(int a) {
        ResourceBundle bundle = ResourceBundle.getBundle("jdbc");

        String driver = bundle.getString("driver");
        String url = bundle.getString("url");
        String users = bundle.getString("users");
        String password = bundle.getString("password");

        Connection connection = null;
        PreparedStatement preparedStatement =null;
        ResultSet resultSet =null;

        try {
            forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            connection = DriverManager.getConnection(url,users,password);

            String sql = "select cname,grade from mysql.sc,mysql.c where c.cno=sc.cno and  sno = ?";

            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1,a);
            resultSet= preparedStatement.executeQuery();
            System.out.println("科目 分数");
            while (resultSet.next()){
                System.out.println(resultSet.getString(1)+" "+resultSet.getInt(2));
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if (connection != null){
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if (preparedStatement != null){
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if (resultSet != null){
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

