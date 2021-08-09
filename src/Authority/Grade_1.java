package Authority;

//老师权限
public interface Grade_1 {

    void selectLessonFromClass(int a);    //按照课号查课名

    void selectStudentFromClass(int a);      //按照课号查学生

    void selectFailedStudent(int a);    //查找不及格学生

    void selectTotalScoreFromStudent(int a);  //按照学号查总分数

    void selectEachScoreFromStudent(int a);  //按照学号查总分数
}
