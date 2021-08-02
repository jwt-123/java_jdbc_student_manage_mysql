import com.mysql.cj.x.protobuf.MysqlxCrud;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.Scanner;
import Mysqlinfo.mysqlinfo

public class StartMenu {
    public static void main(String[] args) {
        //初始化界面
        Map<String ,String> useLoginInfo = initUI();
        //验证用户名和密码
        boolean loginIfSuccesse = login(useLoginInfo);
        //最后输出结果
        System.out.println(loginIfSuccesse?"登录成功":"登陆失败");
    }





    private static boolean login(Map<String, String> useLoginInfo) {
        //使用资源绑定器绑定属性配置文件
        ResourceBundle bundle = ResourceBundle.getBundle("jdbc");
        String driver = bundle.getString("driver");
        String url = bundle.getString("url");
        String users = bundle.getString("users");
        String password = bundle.getString("password");

        //jdbc代码
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        //注册驱动
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        //获取链接
        connection = Connection
        //获取数据库操作对象
        //执行sql
        //处理结果集
        //释放资源

    }


    /*
    * 初始用户界面
    * */
    private static Map<String, String> initUI() {
        Scanner scanner =Scanner(System.in);
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
