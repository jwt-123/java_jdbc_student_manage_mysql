import java.util.Scanner;
import Mysqlinfo.*;

public class changeStudentInformationResult {

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

    public void addStudentInformation(){
        System.out.println("插入学生信息");
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入学号");
        int studentID =scanner.nextInt();
        System.out.println("请输入学生姓名");
        String studentName = scanner.next();
        System.out.println("请输入性别 1 为男 0 为女");
        int sex = scanner.nextInt();
        System.out.println("请输入年龄");
        int ages = scanner.nextInt();
        System.out.println("请输入专业");
        String dept = scanner.next();
        dataChange addStudent = new dataChange();
        addStudent.insertStudent( studentID,  studentName,  sex,  ages,  dept);
    }

    public void addLessonInformation(){
        System.out.println("插入课程信息");
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入课号");
        int lessonID =scanner.nextInt();
        System.out.println("请输入课程名");
        String lessonName = scanner.next();
        System.out.println("请输入老师名");
        String teacherName = scanner.next();
        System.out.println("请输入学分");
        int credit = scanner.nextInt();

        dataChange insertLesson = new dataChange();
        insertLesson.insertLesson( lessonID,  lessonName,  teacherName,  credit);
    }


}

