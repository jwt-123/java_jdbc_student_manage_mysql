import javax.swing.*;
import java.sql.*;
import java.util.*;

public class StartMenu {
    public static void main(String[] args) throws SQLException {
        boolean loginIfSuccesse = false;
        Menu menu = new Menu();
        int choice = menu.start();
        if (choice == 0){
            System.out.println("error");
        }else if (choice == 1){    //管理员界面
            //初始化管理员界面
            Map<String ,String> useLoginInfoAdmin = initUIAdmin();
            //验证用户名和密码
            loginIfSuccesse = adminLogin(useLoginInfoAdmin);
            //最后输出结果
            System.out.println(loginIfSuccesse?"登录成功":"登陆失败");
            if (loginIfSuccesse){
                /*
                * 此处输入管理员权限操作
                * */
            }

        }else if (choice == 2){   // 教师界面
            //初始化教师界面
            Map<String ,String > userLoginInfoTeacher = initUITeacher();
            //验证用户名和密码
            loginIfSuccesse = teacherLogin(userLoginInfoTeacher);
            System.out.println(loginIfSuccesse?"登录成功":"登陆失败");
            if (loginIfSuccesse){
                /*
                 * 此处输入老师权限操作
                 * */
            }

        }else if (choice ==3){    // 学生界面
            //初始化学生界面
            Map<String,String> userLofginstudent = initUIstudent();
            //验证用户名密码
            loginIfSuccesse = studentLogin(userLofginstudent);
            System.out.println(loginIfSuccesse?"登录成功":"登陆失败");
            if (loginIfSuccesse){
                /*
                 * 此处输入学生权限操作
                 *
                 * */
            }

        }
    }

    private static boolean studentLogin(Map<String, String> userLofginstudent) throws SQLException {
        ResourceBundle bundle = ResourceBundle.getBundle("jdbc");
        String driver = bundle.getString("driver");
        String url = bundle.getString("url");
        String users = bundle.getString("users");
        String password = bundle.getString("password");

        boolean loginsucceed = false;

        Connection connection =null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            Class.forName(driver);
            connection=DriverManager.getConnection(url,users,password);
            String sql = "select * from mysql.userpasswdteacher where user = ? and passwd = ?";  //暂时未改动
            preparedStatement =connection.prepareStatement(sql);
            preparedStatement.setString(1,initUITeacher().get("teacherName"));
            preparedStatement.setString(2,initUITeacher().get("teacherpassword"));
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()){
                loginsucceed = true;
            }

        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            if (resultSet !=null){
                try {
                    resultSet.close();
                }catch (SQLException e){
                    e.printStackTrace();
                }
            }

            if (preparedStatement !=null){
                try {
                    resultSet.close();
                }catch (SQLException e){
                    e.printStackTrace();
                }
            }

            if (connection !=null){
                try {
                    resultSet.close();
                }catch (SQLException e){
                    e.printStackTrace();
                }
            }
        }
        return loginsucceed;
    }

    private static Map<String, String> initUIstudent() {
        System.out.println("请输入学号");
        Scanner scanner = new Scanner(System.in);
        String studentnumber = scanner.next();
        System.out.println("请输入密码");
        String passwd = scanner.next();
        Map<String,String> userLofginstudent = initUIstudent();
        userLofginstudent.put("studentnumber",studentnumber);
        userLofginstudent.put("passwd",passwd);
        return initUIAdmin();
    }

    /*
    * 验证老师登录
    * */
    private static boolean teacherLogin(Map<String, String> userLoginInfoTeacher) {
        boolean loginsucceed = false;

        //绑定
        ResourceBundle bundle = ResourceBundle.getBundle("jdbc");
        String driver = bundle.getString("driver");
        String url = bundle.getString("url");
        String users = bundle.getString("users");
        String password = bundle.getString("password");

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            // 注册驱动
            Class.forName(driver);
            //获取链接
            connection =DriverManager.getConnection(url,users,password);
            //获取操作对象
            String sql = "select * from mysql.userpasswdteacher where user = ? and passwd = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,initUITeacher().get("teacherName"));
            preparedStatement.setString(2,initUITeacher().get("teacherpassword"));
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()){
                loginsucceed = true;
            }
            //顶


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }catch (SQLException f){
            f.printStackTrace();
        }finally {
            if (resultSet != null){
                try {
                    resultSet.close();
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
            if (connection != null){
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return loginsucceed;
    }

    /*
    * 初始老师界面
    * */
    private static Map<String, String> initUITeacher() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("用户名");
        String username = scanner.next();
        System.out.println("密码");
        String password = scanner.next();
        Map<String,String> useLoginInfoTeacher = new HashMap<>();
        useLoginInfoTeacher.put("teacherName",username);
        useLoginInfoTeacher.put("teacherpassword",password);
        return useLoginInfoTeacher;
    }

    /*
    * 验证admin登录
    * */
    private static boolean adminLogin(Map<String, String> useLoginInfo) {

        boolean loginsucceed = false;

        //使用资源绑定器绑定属性配置文件
        ResourceBundle bundle = ResourceBundle.getBundle("jdbc");
        String driver = bundle.getString("driver");
        String url = bundle.getString("url");
        String users = bundle.getString("users");
        String password = bundle.getString("password");

        //jdbc代码
        Connection connection = null;
        Statement statement = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            //注册驱动
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            //获取链接
            connection = DriverManager.getConnection(url,users,password);
            //获取数据库操作对象
            statement=connection.createStatement();
            //执行sql2

            String sql = "select * from mysql.userpasswdadmin where user = ? and passwd = ? ";

            preparedStatement =connection.prepareStatement(sql);
            preparedStatement.setString(1,useLoginInfo.get("loginName"));
            preparedStatement.setString(2,useLoginInfo.get("password"));

//            System.out.println(preparedStatement.toString());

            resultSet =preparedStatement.executeQuery();
            //处理结果集

            if (resultSet.next()){
                loginsucceed=true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {

            if (resultSet !=null){
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if (connection !=null){
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if (statement !=null){
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

        }
        //释放资源

    return loginsucceed;
    }

    /*
    * 初始Admin界面
    * */
    private static Map<String, String> initUIAdmin() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("用户名");
        String username = scanner.next();
        System.out.println("密码");
        String password = scanner.next();
        Map<String,String > useLoginInfo = new HashMap<>();
        useLoginInfo.put("loginName",username);
        useLoginInfo.put("password",password);
        return useLoginInfo;
    }
}


class Menu{
    Menu(){{
        System.out.println("请输入要登录的用户");
        System.out.println("1.管理员");
        System.out.println("2.教师");
        System.out.println("3.学生");}

    }

    public int start(){
        Scanner scanner = new Scanner(System.in);
        while (true) {
            int choice = scanner.nextInt();
            if (choice ==1){
                System.out.println("管理员界面");
                return choice;
            }else if (choice ==2){
                System.out.println("教师界面");
                return choice;
            }else if (choice ==3){
                System.out.println("学生界面");
                return choice;
            }else {
                choice = 0;
                System.out.println("输入有误 请重新输入");
                continue;
            }

        }
    }



}