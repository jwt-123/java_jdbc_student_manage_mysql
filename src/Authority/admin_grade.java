package Authority;

import java.sql.*;
import java.util.ResourceBundle;

import static java.lang.Class.forName;

public class admin_grade implements Grade_2, Grade_1 {


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

    public void selectFailedStudent(int a) {  //此处a是课程号
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


    public void selectTotalScoreFromStudent(int a) { //按照学号查总分数
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

    public void calculate_Each_Lesson_Total_Score() {
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

            String sql = "select cname,sum(grade) from mysql.sc,mysql.c where c.cno=sc.cno group by  1";

            preparedStatement = connection.prepareStatement(sql);


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

    public void calculate_Lesson_Score_0ver80(int a) {
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

            String sql = "select s.sno,sname,grade from mysql.sc,mysql.s where s.sno=sc.sno and cno = ? and grade >80";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,a);

            resultSet= preparedStatement.executeQuery();
            System.out.println("学号  姓名  分数 ");
            while (resultSet.next()){
                System.out.println(""+resultSet.getInt(1)+" "+resultSet.getString(2)+" "+resultSet.getInt(3));
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

    public void calculate_Lesson_Score_0ver60(int a ) {
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

            String sql = "select s.sno,sname,grade from mysql.sc,mysql.s where s.sno=sc.sno and cno = ? and grade >60";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,a);

            resultSet= preparedStatement.executeQuery();
            System.out.println("学号  姓名  分数 ");
            while (resultSet.next()){
                System.out.println(""+resultSet.getInt(1)+" "+resultSet.getString(2)+" "+resultSet.getInt(3));
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

    public void calculate_Lesson_Score_Low60(int a ) {
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

            String sql = "select s.sno,sname,grade from mysql.sc,mysql.s where s.sno=sc.sno and cno = ? and grade <60";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,a);

            resultSet= preparedStatement.executeQuery();
            System.out.println("学号  姓名  分数 ");
            while (resultSet.next()){
                System.out.println(""+resultSet.getInt(1)+" "+resultSet.getString(2)+" "+resultSet.getInt(3));
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

    public void selectAllStudentAndTheirScore() {  //此处a是课程号
        //虽然已经废弃，但是东西别乱删，指不定删了哪里就报错了  =)
        //我大概估摸着有至少仨处报错，但是我懒得删，代码写了我不用，哎，就是玩儿
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

            String sql = "select distinct sc.sno,sname from mysql.sc,mysql.s where sc.sno=s.sno  and cno = ?";

            preparedStatement = connection.prepareStatement(sql);

//            preparedStatement.setInt(1,a);
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
    } //已废弃，太麻烦不想写

}

