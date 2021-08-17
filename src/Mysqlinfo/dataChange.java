package Mysqlinfo;

import com.mysql.cj.exceptions.ClosedOnExpiredPasswordException;

import java.sql.*;
import java.util.ResourceBundle;

public class dataChange {

//    - 添加数据
//  -  添加学生
//  -  添加课程
//  -  添加选课
//- 编辑数据 改
//  - 修改学生
//  - 修改课程
//  - 修改选课
//- 查询数据 删
//  - 删除学生
//  - 删除课程
//  - 删除选课


    /*
    *添加数据
     */

    public void insertStudent(int studentID, String studentName, int sex, int ages, String dept) {
        //////////////////////////////////////////////////////////////////////
        ResourceBundle bundle = ResourceBundle.getBundle("jdbc");

        String driver = bundle.getString("driver");
        String url = bundle.getString("url");
        String users = bundle.getString("users");
        String password = bundle.getString("password");

        Connection connection = null;
        PreparedStatement preparedStatement =null;

        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }



        try {

            connection = DriverManager.getConnection(url,users,password);

            String sql = "INSERT INTO mysql.s (sno, sname, sex, age, dept) VALUES (?, ?, ?, ?, ?)";//sql语句

            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1,studentID);
            preparedStatement.setString(2,studentName);
            preparedStatement.setInt(3,sex);
            preparedStatement.setInt(4,ages);
            preparedStatement.setString(5,dept);

//            preparedStatement.execute();//此处有问题

            System.out.println( preparedStatement.executeUpdate());

            //        preparedStatement.setString();

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

        }

////////////////////////////////////


    }

    public void insertLesson(int lessonID,String lessonName,String teacherName,int credit){
        //////////////////////////////////////////////////////////////////////
        ResourceBundle bundle = ResourceBundle.getBundle("jdbc");

        String driver = bundle.getString("driver");
        String url = bundle.getString("url");
        String users = bundle.getString("users");
        String password = bundle.getString("password");

        Connection connection = null;
        PreparedStatement preparedStatement =null;

        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }



        try {

            connection = DriverManager.getConnection(url,users,password);

            String sql = "INSERT INTO mysql.c (cno, cname, tname, credit) VALUES (?, ?, ?, ?) ";//sql语句

            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1,lessonID);
            preparedStatement.setString(2,lessonName);
            preparedStatement.setString(3,teacherName);
            preparedStatement.setInt(4,credit);

            System.out.println( preparedStatement.executeUpdate());
            //        preparedStatement.setString();

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

        }

////////////////////////////////////
    }

    public void insertChooseLesson(int studentID,int lessonID,int grade,int credit){ //插入选课信息
        //////////////////////////////////////////////////////////////////////
        ResourceBundle bundle = ResourceBundle.getBundle("jdbc");

        String driver = bundle.getString("driver");
        String url = bundle.getString("url");
        String users = bundle.getString("users");
        String password = bundle.getString("password");

        Connection connection = null;
        PreparedStatement preparedStatement =null;

        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }



        try {

            connection = DriverManager.getConnection(url,users,password);

            String sql = "INSERT INTO mysql.sc (sno, cno, grade, credit) VALUES (?, ?, ?, ?)";//sql语句

            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1,studentID);
            preparedStatement.setInt(2,lessonID);
            preparedStatement.setInt(3,grade);
            preparedStatement.setInt(4,credit);

            preparedStatement.executeUpdate();

            //        preparedStatement.setString();

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

        }

////////////////////////////////////
    }


    /*
    *修改数据
     */



    public void changeStudent(int studentID, String studentName, int sex, int ages, String dept) {
        //////////////////////////////////////////////////////////////////////
        ResourceBundle bundle = ResourceBundle.getBundle("jdbc");

        String driver = bundle.getString("driver");
        String url = bundle.getString("url");
        String users = bundle.getString("users");
        String password = bundle.getString("password");

        Connection connection = null;
        PreparedStatement preparedStatement =null;

        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }



        try {

            connection = DriverManager.getConnection(url,users,password);

            String sql = "update mysql.s set  sname=?, sex=?, age=?, dept=? where sno = ? ORDER BY SNO";//sql语句

            preparedStatement = connection.prepareStatement(sql);


            preparedStatement.setString(1,studentName);
            preparedStatement.setInt(2,sex);
            preparedStatement.setInt(3,ages);
            preparedStatement.setString(4,dept);
            preparedStatement.setInt(5,studentID);

//            preparedStatement.execute();//此处有问题

            System.out.println( preparedStatement.executeUpdate());

            //        preparedStatement.setString();

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

        }

////////////////////////////////////


    }

    public void changeLesson(int cno,String cname,String teacherName,int credit){
        //////////////////////////////////////////////////////////////////////
        ResourceBundle bundle = ResourceBundle.getBundle("jdbc");

        String driver = bundle.getString("driver");
        String url = bundle.getString("url");
        String users = bundle.getString("users");
        String password = bundle.getString("password");

        Connection connection = null;
        PreparedStatement preparedStatement =null;

        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }



        try {

            connection = DriverManager.getConnection(url,users,password);

//            String sql = "INSERT INTO mysql.c (cno, cname, tname, credit) VALUES (?, ?, ?, ?) ";//sql语句

            String sql = "update mysql.c set cname=?,tname=?,credit=?  where cno = ? ORDER BY cNO";

            /*
            cno 作为主键是不能改变的
             */

            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1,cname);
            preparedStatement.setString(2,teacherName);
            preparedStatement.setInt(3,credit);
            preparedStatement.setInt(4,cno);

            System.out.println( preparedStatement.executeUpdate());
            //        preparedStatement.setString();

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

        }

////////////////////////////////////
    }

    public void changeChooseLesson(int studentID,int lessonID,int grade,int credit){ //插入选课信息
        //////////////////////////////////////////////////////////////////////
        ResourceBundle bundle = ResourceBundle.getBundle("jdbc");

        String driver = bundle.getString("driver");
        String url = bundle.getString("url");
        String users = bundle.getString("users");
        String password = bundle.getString("password");

        Connection connection = null;
        PreparedStatement preparedStatement =null;

        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }



        try {

            connection = DriverManager.getConnection(url,users,password);

//            String sql = "INSERT INTO mysql.c (cno, cname, tname, credit) VALUES (?, ?, ?, ?) ";//sql语句

            String sql = "update mysql.sc set grade=?,credit=?  where cno = ? and sno =? ORDER BY cno";

            /*
            cno  sno 作为主键是不能改变的
             */

            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1,grade);
            preparedStatement.setInt(2,credit);
            preparedStatement.setInt(3,lessonID);
            preparedStatement.setInt(4,studentID);

            System.out.println( preparedStatement.executeUpdate());
            //        preparedStatement.setString();

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

        }


////////////////////////////////////
    }



    /*
    *删除数据
     */

    public void deleteStudent(int studentID){
        //////////////////////////////////////////////////////////////////////
        ResourceBundle bundle = ResourceBundle.getBundle("jdbc");

        String driver = bundle.getString("driver");
        String url = bundle.getString("url");
        String users = bundle.getString("users");
        String password = bundle.getString("password");

        Connection connection = null;
        PreparedStatement preparedStatement =null;

        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }



        try {

            connection = DriverManager.getConnection(url,users,password);

            String sql = "delete from mysql.s where sno = ?";//sql语句

            preparedStatement = connection.prepareStatement(sql);

            //        preparedStatement.setString();
            preparedStatement.setInt(1,studentID);
            System.out.println( preparedStatement.executeUpdate());


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

        }

////////////////////////////////////
    }

    public void deleteLesson(int lessonID){
        ResourceBundle bundle = ResourceBundle.getBundle("jdbc");

        String driver = bundle.getString("driver");
        String url = bundle.getString("url");
        String users = bundle.getString("users");
        String password = bundle.getString("password");

        Connection connection = null;
        PreparedStatement preparedStatement =null;

        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }



        try {

            connection = DriverManager.getConnection(url,users,password);

            String sql = "delete from mysql.c where cno = ?";//sql语句

            preparedStatement = connection.prepareStatement(sql);

            //        preparedStatement.setString();
            preparedStatement.setInt(1,lessonID);
            System.out.println( preparedStatement.executeUpdate());


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

        }

////////////////////////////////////
    }

    public void deleteChooseLesson(int studentID,int lessonID){
        //////////////////////////////////////////////////////////////////////
        ResourceBundle bundle = ResourceBundle.getBundle("jdbc");

        String driver = bundle.getString("driver");
        String url = bundle.getString("url");
        String users = bundle.getString("users");
        String password = bundle.getString("password");

        Connection connection = null;
        PreparedStatement preparedStatement =null;

        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }



        try {

            connection = DriverManager.getConnection(url,users,password);

            String sql = "delete from mysql.sc where cno = ? and sno =?";//sql语句

            preparedStatement = connection.prepareStatement(sql);

            //        preparedStatement.setString();
            preparedStatement.setInt(1,lessonID);
            preparedStatement.setInt(2,studentID);
            System.out.println( preparedStatement.executeUpdate());


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

        }

////////////////////////////////////

    }


}
