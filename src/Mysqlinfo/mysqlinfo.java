package Mysqlinfo;

import java.sql.*;
import java.util.ResourceBundle;

public class mysqlinfo {
    public static void main(String[] args) {

        //使用资源绑定器绑定属性配置文件
        ResourceBundle bundle = ResourceBundle.getBundle("jdbc");
        String driver = bundle.getString("driver");
        String url = bundle.getString("url");
        String users = bundle.getString("users");
        String password = bundle.getString("password");

        Statement statement = null;
        Connection connection = null;
        ResultSet resultSet = null;
        //注册驱动
        try {
            //注册驱动
            try{
                Class.forName(driver);
            }catch (ClassNotFoundException e){
                e.printStackTrace();
            }
            //获取链接
            connection = DriverManager.getConnection(url, users, password);
            //获取数据库操作对象
            statement = connection.createStatement();

            //执行sql语句
            String sql= "select * from mysql.db ";
            //不是以列的下标获取，是以列的名字获取的
            //如果对列as重命名，需要用重命名后的列名
            resultSet = statement.executeQuery(sql);
            boolean flag =resultSet.next();
            resultSet.next();
            if (flag){
                String A = resultSet.getString(1);
                String B = resultSet.getString(2);
                String C = resultSet.getString(3);
                System.out.println(A+"+"+B+C);
            }


        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (resultSet != null){
                try {
                    resultSet.close();
                }catch (SQLException e){
                    e.printStackTrace();
                }
            }


            if (statement != null){
                try {
                    statement.close();
                }catch (SQLException e){
                    e.printStackTrace();
                }


            if (connection != null){
                try {
                    connection.close();
                }catch (SQLException e){
                    e.printStackTrace();
                }
            }
            }

        }


//        //获取数据库操作对象
//        Statement stmt = null;
//        Connection connection = null;
//
//        try{
//
//            //注册驱动
////            Driver driver = new com.mysql.cj.jdbc.Driver();
////            DriverManager.registerDriver(driver);
//
//
//            //链接数据库
//            String url = "jdbc:mysql://127.0.0.1:3306/";
//            String user = "root";
//            String password= "123456";
//            connection = DriverManager.getConnection(url,user,password);
//            System.out.println("数据库链接对象"+connection);
//
//            //获取数据库操作对象
//            stmt = connection.createStatement();
//
//            //执行sql
//            //jdbc sql语句不提供分号，写上报错
//            String sql = "select  * from tables";//sql语句
//
//            //专门执行dml语句
//            int count = stmt.executeUpdate(sql);
//            System.out.println(count==1?"保存成功":"保存失败");
//
//        }catch (
//                SQLException e){
//            e.printStackTrace();
//        }finally {
//            //保证资源释放
//            //在finally中释放资源
//            //分别对其 try catch
//            try {
//                if (stmt != null){
//                    stmt.close();
//                }
//            }catch (SQLException e){
//                e.printStackTrace();
//            }
//
//            try {
//                if (connection !=null){
//                    connection.close();
//                }
//            }catch (SQLException e){
//                e.printStackTrace();
//            }
//        }
    }
}
