package Authority;

//管理员权限
public interface Grade_2 {
    public void calculate_Each_Lesson_Total_Score();   //统计各科分数

//    按班级统计各分数段人数及比例

    void calculate_Lesson_Score_0ver80(int a);    //超过80分的人

    void calculate_Lesson_Score_0ver60( int a);    //超过60分的人

    void calculate_Lesson_Score_Low60( int a);    //低于60分的人


}
