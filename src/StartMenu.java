import Mysqlinfo.mysqlinfo;

import javax.swing.*;
import java.sql.*;
import java.util.*;
import Authority.*;

public class StartMenu {
    public static void main(String[] args) throws SQLException {

        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        admin_grade adminPower = new admin_grade();
        //admin 权限
//        adminPower.selectLessonFromClass(a);//根据课号查课程名
//        adminPower.selectStudentFromClass(a);//根据学号查学生名
//        adminPower.selectFailedStudent(a);//根据课程号查不及格学生
//        adminPower.selectTotalScoreFromStudent(a); //按照学号查总分数
//        adminPower.selectEachScoreFromStudent(a); //按学号查一个人总分
//        adminPower.calculate_Each_Lesson_Total_Score();  //查所有科目总分
//        adminPower.calculate_Lesson_Score_0ver80(a); //计算比80分高的人
//        adminPower.calculate_Lesson_Score_0ver60(a); //计算比60分高的人
//        adminPower.calculate_Lesson_Score_Low60(a); //计算比60分低的人

        teacher_grade teacherPower = new teacher_grade();
        //teacher 权限
//        teacherPower.selectLessonFromClass(a);
//        teacherPower.selectEachScoreFromStudent(a);
//        teacherPower.selectFailedStudent(a);
//        teacherPower.selectTotalScoreFromStudent(a);
//        teacherPower.selectEachScoreFromStudent(a);

        student_grade studentPower = new student_grade();
//        studentPower.selectMyScore(a);


        boolean loginIfSucceed = false;
        Menu menu = new Menu();
        int choice = menu.start();
        if (choice == 0) {
            System.out.println("error");
        } else if (choice == 1) {    //管理员界面
            //初始化管理员界面
            Map<String, String> useLoginInfoAdmin = initUIAdmin();
            //验证用户名和密码
            loginIfSucceed = adminLogin(useLoginInfoAdmin);
            //最后输出结果
            System.out.println(loginIfSucceed ? "登录成功" : "登陆失败");
            if (loginIfSucceed) {
                /*
                 * 此处输入管理员权限操作
                 * */
                System.out.println("1.根据课号查课程名");
                System.out.println("2.根据学号查学生名");
                System.out.println("3.根据课程号查不及格学生");
                System.out.println("4.按照学号查总分数");
                System.out.println("5.按学号查一个人总分");
                System.out.println("6.查所有科目总分");
                System.out.println("7.计算比80分高的人");
                System.out.println("8.计算比60分高的人");
                System.out.println("9.计算比60分低的人");


                int adminChoice = 0;
                System.out.println("请输入选择");
                adminChoice = scanner.nextInt();
                switch (adminChoice){
                    case 1:{

                    }
                    case 2:{

                    }
                    case 3:{

                    }
                    case 4:{

                    }
                    case 5:{

                    }
                    case 6:{

                    }
                    case 7:{

                    }
                    case 8:{

                    }
                    case 9:{

                    }

                }

            } else if (choice == 2) {   // 教师界面
                //初始化教师界面
                Map<String, String> userLoginInfoTeacher = initUITeacher();
                //验证用户名和密码
                loginIfSucceed = teacherLogin(userLoginInfoTeacher);
                System.out.println(loginIfSucceed ? "登录成功" : "登陆失败");
                if (loginIfSucceed) {
                    /*
                     * 此处输入老师权限操作
                     * */
                }

            } else if (choice == 3) {    // 学生界面
                //初始化学生界面
                Map<String, String> userLofginstudent = initUIstudent();
                //验证用户名密码
                loginIfSucceed = studentLogin(userLofginstudent);
                System.out.println(loginIfSucceed ? "登录成功" : "登陆失败");
                if (loginIfSucceed) {
                    /*
                     * 此处输入学生权限操作
                     *
                     * */
                }

            }

        }
    }

    /*
    *验证学生登录
    * */
    private static boolean studentLogin(Map<String, String> userLofginstudent) throws SQLException {

        boolean loginsucceed = false;

        ResourceBundle bundle = ResourceBundle.getBundle("jdbc");
        String driver = bundle.getString("driver");
        String url = bundle.getString("url");
        String users = bundle.getString("users");
        String password = bundle.getString("password");





        Connection connection =null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            // 注册驱动
            Class.forName(driver);
            //获取链接
            connection=DriverManager.getConnection(url,users,password);
            //获取操作对象
            String sql = "select * from mysql.users where hm = ? and pwd = ? ";

            preparedStatement =connection.prepareStatement(sql);
            preparedStatement.setString(1,userLofginstudent.get("studentnumber"));
            preparedStatement.setString(2,userLofginstudent.get("passwd"));

            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()){
                if (resultSet.getInt(3)==0){
                    loginsucceed=true;
                    System.out.println(resultSet.getString(1));
                }else{
                    System.out.println("权限错误 重新输入");
                }

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

    /*
    *  初始学生界面
    * */
    private static Map<String, String> initUIstudent() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入学号");
        String studentnumber = scanner.next();
        System.out.println("请输入密码");
        String passwd = scanner.next();
        Map<String,String> userLofginstudent = new HashMap<>();
        userLofginstudent.put("studentnumber",studentnumber);
        userLofginstudent.put("passwd",passwd);
        return userLofginstudent;
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
            String sql = "select * from mysql.users where hm = ? and pwd = ? ";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,userLoginInfoTeacher.get("teacherName"));
            preparedStatement.setString(2,userLoginInfoTeacher.get("teacherpassword"));
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()){
                if (resultSet.getInt(3)==0){
                    loginsucceed=true;
                    System.out.println(resultSet.getString(1));
                }else{
                    System.out.println("权限错误 重新输入");
                }

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
//            statement=connection.createStatement();
            //执行sql2

            String sql = "select * from mysql.users where hm = ? and pwd = ?  ";

            preparedStatement =connection.prepareStatement(sql);
            preparedStatement.setString(1,useLoginInfo.get("loginName"));
            preparedStatement.setString(2,useLoginInfo.get("password"));

//            System.out.println(preparedStatement.toString());

            resultSet =preparedStatement.executeQuery();
            //处理结果集


            if (resultSet.next()){
                if (resultSet.getInt(3)==2){
                    loginsucceed=true;
                    System.out.println(resultSet.getString(1));
                }else{
                    System.out.println("权限错误 重新输入");
                }

            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {

            if (preparedStatement !=null){
                try {
                    preparedStatement.close();
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

            if (resultSet !=null){
                try {
                    resultSet .close();
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