package Authority;

import java.sql.*;
import java.util.ResourceBundle;

import static java.lang.Class.forName;

public class teacher_grade implements Grade_1 {
    public void selectLessonFromClass(int a) {
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

            String sql = "select cname from mysql.c where cno = ?";

            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1,a);
            resultSet= preparedStatement.executeQuery();
            while (resultSet.next()){
                System.out.println(resultSet.getString(1));
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

    public void selectStudentFromClass(int a) {
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

            String sql = "select distinct s.sno,sname,sex,age,dept from mysql.s,mysql.sc where mysql.sc.sno=mysql.s.sno and cno = ?";

            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1,a);
            resultSet= preparedStatement.executeQuery();
            System.out.println("学号 姓名 性别 年龄 专业 （性别1为男，0为女）");
            while (resultSet.next()) {
                System.out.println(resultSet.getInt(1) + " " + resultSet.getString(2) + " " + resultSet.getInt(3) + "   " + resultSet.getInt(4) + "  " + resultSet.getString(5));
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

    public void selectFailedStudent(int a) {
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

            String sql = "select distinct sc.sno,sname from mysql.sc,mysql.s where sc.sno=s.sno and grade<60 and cno = ?";

            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1,a);
            resultSet= preparedStatement.executeQuery();
            System.out.println("学号 姓名");
            while (resultSet.next()){
                System.out.println(resultSet.getString(1)+resultSet.getString(2));
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

    public void selectTotalScoreFromStudent(int a) {
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

            String sql = "select sum(grade) from mysql.sc where sno = ?";

            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1,a);
            resultSet= preparedStatement.executeQuery();
            System.out.println("总分");
            while (resultSet.next()){
                System.out.println(resultSet.getString(1));
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

    public void selectEachScoreFromStudent(int a) {
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

