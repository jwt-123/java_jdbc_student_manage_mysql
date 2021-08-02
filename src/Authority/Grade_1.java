package Authority;

//老师权限
public interface Grade_1 {

    void selectLessonFromClass();    //按照班号查课程

    void selectStudentFromClass();      //按照班号查学生

    void selectFailedStudent();    //查找不及格学生

    void selectTotalScoreFromStudent();  //按照学号查总分数

    void selectEachScoreFromStudent();  //按照学号查总分数
}
