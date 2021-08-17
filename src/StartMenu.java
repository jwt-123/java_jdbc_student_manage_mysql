//import Mysqlinfo.mysqlinfo;

import javax.swing.*;
import java.sql.*;
import java.util.*;
import Authority.*;

public class StartMenu {
    public static void main(String[] args) throws SQLException {



        changeStudentInformationResult changeStudentInformationResult = new changeStudentInformationResult();
//        changeStudentInformationResult.addChooseLesson();
//        changeStudentInformationResult.deleteLessonInformation();

        Scanner scanner = new Scanner(System.in);
//        int a = scanner.nextInt();
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


        Integer choice = menu.start();


        if (choice == 0) {
            System.out.println("error");
        }


        if (choice == 1) {
            //管理员界面
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

                String nextToDo = "Y";
                while (nextToDo.equals("Y")){

                    System.out.println("===查询功能===");
                    System.out.println("1.根据课号查课程名");
                    System.out.println("2.根据学号查学生名");
                    System.out.println("3.根据课程号查不及格学生");
                    System.out.println("4.按照学号查总分数");
                    System.out.println("5.按学号查一个人总分");
                    System.out.println("6.查所有科目总分");
                    System.out.println("7.计算比80分高的人");
                    System.out.println("8.计算比60分高的人");
                    System.out.println("9.计算比60分低的人");
                    System.out.println("===添加数据===");
                    System.out.println("10.添加学生");
                    System.out.println("11.添加课程");
                    System.out.println("12.添加选课");
                    System.out.println("===编辑数据===");
                    System.out.println("13.编辑学生");
                    System.out.println("14.编辑课程");
                    System.out.println("15.编辑选课");
                    System.out.println("===删除数据===");
                    System.out.println("16.删除学生");
                    System.out.println("17.删除课程");
                    System.out.println("18.删除选课");

                    int adminChoice = 0;
                    System.out.println("请输入选择");
                    adminChoice = scanner.nextInt();
                    switch (adminChoice){
                        case 1:{
                            System.out.println("输入课号");
                            int a = scanner.nextInt();


                            adminPower.selectLessonFromClass(a);
                            break;
                        }
                        case 2:{
                            System.out.println("输入学号");
                            int a = scanner.nextInt();

                            adminPower.selectStudentFromClass(a);
                            break;
                        }
                        case 3:{
                            System.out.println("输入课程号");
                            int a = scanner.nextInt();
                            adminPower.selectFailedStudent(a);
                            break;
                        }
                        case 4:{
                            System.out.println("输入学号");
                            int a = scanner.nextInt();
                            adminPower.selectTotalScoreFromStudent(a);
                            break;
                        }
                        case 5:{
                            System.out.println("输入学号");
                            int a = scanner.nextInt();
                            adminPower.selectEachScoreFromStudent(a);
                            break;
                        }
                        case 6:{
                            int a = scanner.nextInt();
                            adminPower.calculate_Each_Lesson_Total_Score();
                            break;
                        }
                        case 7:{
                            int a = scanner.nextInt();
                            adminPower.calculate_Lesson_Score_0ver80(a);
                            break;
                        }
                        case 8:{
                            int a = scanner.nextInt();
                            adminPower.calculate_Lesson_Score_0ver60(a);
                            break;

                        }
                        case 9:{
                            int a = scanner.nextInt();
                            adminPower.calculate_Lesson_Score_Low60(a);
                            break;

                        }
                        case 10:{
                            int a = scanner.nextInt();
                            changeStudentInformationResult.addStudentInformation();
                            break;

                        }
                        case 11:{
                            int a = scanner.nextInt();
                            changeStudentInformationResult.addLessonInformation();
                            break;

                        }
                        case 12:{
                            int a = scanner.nextInt();
                            changeStudentInformationResult.addChooseLesson();
                            break;

                        }
                        case 13:{
                            int a = scanner.nextInt();
                            changeStudentInformationResult.changeStudentInformation();
                            break;

                        }
                        case 14:{
                            int a = scanner.nextInt();
                            changeStudentInformationResult.changeLessonInformation();
                            break;

                        }
                        case 15:{
                            int a = scanner.nextInt();
                            changeStudentInformationResult.changeStudentChooseLessonInformation();
                            break;

                        }
                        case 16:{
                            int a = scanner.nextInt();
                            changeStudentInformationResult.deleteStudentInformation();
                            break;

                        }
                        case 17:{
                            int a = scanner.nextInt();
                            changeStudentInformationResult.deleteLessonInformation();
                            break;

                        }
                        case 18:{
                            int a = scanner.nextInt();
                            changeStudentInformationResult.deleteChooseLessonInformation();
                            break;

                        }default:{
                            System.out.println("=====================================");
                        }

                        System.out.println("是否继续操作？按F退出");

                        nextToDo = scanner.next();
                        if (nextToDo.equals("F")|nextToDo.equals("f")){
                            break;
                        }

                    }
                }


            }
        }


        if (choice == 2) {   // 教师界面
                //初始化教师界面

                Map<String, String> userLoginInfoTeacher = initUITeacher();
                //验证用户名和密码
                loginIfSucceed = teacherLogin(userLoginInfoTeacher);
                System.out.println(loginIfSucceed ? "登录成功" : "登陆失败");
                if (loginIfSucceed) {
                    /*
                     * 此处输入老师权限操作
                     * */

                    String nextToDo = "Y";
                    while (nextToDo.equals("Y")){
                        System.out.println("1.根据课号查课程名");
                        System.out.println("2.根据学号查学生名");
                        System.out.println("3.根据课程号查不及格学生");
                        System.out.println("4.按照学号查总分数");
                        System.out.println("5.按学号查一个人总分");


                        int teacherChoice = 0;
                        System.out.println("请输入选择");
                        teacherChoice = scanner.nextInt();
                        switch (teacherChoice){
                            case 1:{
                                System.out.println("输入课号");
                                int a = scanner.nextInt();
                                adminPower.selectLessonFromClass(a);
                            }
                            case 2:{
                                System.out.println("输入学号");
                                int a = scanner.nextInt();
                                adminPower.selectStudentFromClass(a);
                            }
                            case 3:{
                                System.out.println("输入课号");
                                int a = scanner.nextInt();
                                adminPower.selectFailedStudent(a);
                            }
                            case 4:{
                                System.out.println("输入学号");
                                int a = scanner.nextInt();
                                adminPower.selectTotalScoreFromStudent(a);
                            }
                            case 5:{
                                System.out.println("输入学号");
                                int a = scanner.nextInt();
                                adminPower.selectEachScoreFromStudent(a);
                            } default:{
                                System.out.println("输入错误，请重新输入");
                            }

                            System.out.println("是否继续操作？按F退出");

                            nextToDo = scanner.next();
                            if (nextToDo.equals("F")|nextToDo.equals("f")){
                                break;
                            }

                        }

                }




                }

            }

        if (choice == 3) {    // 学生界面
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

                    String nextToDo = "Y";
                    while (nextToDo.equals("Y")){
                        System.out.println("查自己分数");
                        int a = scanner.nextInt();
                        studentPower.selectMyScore(a);

                        System.out.println("是否继续操作？按F退出");

                        nextToDo = scanner.next();
                        if (nextToDo.equals("F")|nextToDo.equals("f")){
                            break;
                        }

                    }




                }
                }


//
//            switch (choice){
//
//                case 1:{
//
//
//                }
//                case 2:{
//
//                }
//                case 3:{
//
//                }
//            }
//
//
//






















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


    public int getChoice_to_changeBUG() {
        return Choice_to_changeBUG;
    }

    public void setChoice_to_changeBUG(int choice_to_changeBUG) {
        Choice_to_changeBUG = choice_to_changeBUG;
    }

    private int Choice_to_changeBUG =2;




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
                return 1;
            }

            if (choice ==2){
                System.out.println("教师界面");

                setChoice_to_changeBUG(2);
//                int i = 2;
//                return i;
                return 2;
            }

            if (choice ==3){
                System.out.println("学生界面");

//                System.out.println("123");
                setChoice_to_changeBUG(3);
//                int i = 3;
//                return i;
                return 3;

            }else {
                choice = 0;
                System.out.println("输入有误 请重新输入");
                continue;
            }
        }
    }



}