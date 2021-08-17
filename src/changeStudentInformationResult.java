import java.util.Scanner;

import Authority.admin_grade;
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
//- 删除数据 删
//  - 删除学生
//  - 删除课程
//  - 删除选课


    /*


    添加数据



     */

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

    public void addChooseLesson(){
        System.out.println("插入选课信息");
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入学号");
        int sno = scanner.nextInt();
        System.out.println("请输入课号");
        int cno = scanner.nextInt();
        System.out.println("请输入成绩");
        int grade = scanner.nextInt();
        System.out.println("请输入学分");
        int credit = scanner.nextInt();

        dataChange insertChooseLesson = new dataChange();
        insertChooseLesson.insertChooseLesson(sno, cno, grade, credit);
    }


        /*


    修改数据



     */
        public void changeStudentInformation(){

            admin_grade admin_grade =new admin_grade();
//            admin_grade.selectAllStudentAndTheirScore();

            /*
            *本来此处应该再加一个select * 所有学生科目成绩的函数 ，用用户看，但是我太懒了不想写了（主要功能太多了，加上这只是一个控制台界面，
            * 总结一句话就是    可以，但没必要）
             */
            System.out.println("修改学生信息");
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
            dataChange changeStudent = new dataChange();
            changeStudent.changeStudent( studentID,  studentName,  sex,  ages,  dept);
        }

        public void changeLessonInformation(){
            admin_grade admin_grade =new admin_grade();
//            admin_grade.selectAllStudentAndTheirScore();

            /*
             *此处应该再加一个select * 科目信息的函数
             * 原因同上
             */
            System.out.println("修改课程信息");
            Scanner scanner = new Scanner(System.in);
            System.out.println("请输入课程号");
            int cno =scanner.nextInt();
            System.out.println("请输入课程名");
            String cname = scanner.next();
            System.out.println("请输入老师名");
            String teacherName = scanner.next();
            System.out.println("请输入学分");
            int credit = scanner.nextInt();
            dataChange changeLesson = new dataChange();
            changeLesson.changeLesson(cno,cname,teacherName,credit);
        }

        public void changeStudentChooseLessonInformation(){
            admin_grade admin_grade =new admin_grade();
            System.out.println("修改选课信息");
            Scanner scanner = new Scanner(System.in);
            System.out.println("请输入课程号");
            int lessonID =scanner.nextInt();
            System.out.println("请输入学号");
            int studentID =scanner.nextInt();
            System.out.println("请输入成绩");
            int grade = scanner.nextInt();
            System.out.println("请输入学分 两位数");
            int credit = scanner.nextInt();
            dataChange changeChooseLesson = new dataChange();
            changeChooseLesson.changeChooseLesson(studentID,lessonID,grade,credit);

        }


                /*


    删除数据



     */

    public void deleteStudentInformation(){
        System.out.println("删除学生信息");
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入学号");
        int sno =scanner.nextInt();
        dataChange deleteStudent = new dataChange();
        deleteStudent.deleteStudent(sno);
    }

    public void deleteLessonInformation(){
        System.out.println("删除学生信息");
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入学号");
        int cno =scanner.nextInt();
        dataChange deleteLesson = new dataChange();
        deleteLesson.deleteLesson(cno);

    }

    public void deleteChooseLessonInformation(){
        System.out.println("删除学生信息");
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入学号");
        int sno =scanner.nextInt();
        System.out.println("请输入课号");
        int cno =scanner.nextInt();
        dataChange deleteChooseLesson = new dataChange();
        deleteChooseLesson.deleteChooseLesson(sno,cno);

    }
}

