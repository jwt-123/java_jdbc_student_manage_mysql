# 数据库课设

## 系统登陆模块

包含用户信息登录界面

- 用户有三个权限

登录后有个菜单


准备的功能：

- 添加数据 
  -  添加学生 
  -  添加课程
  -  添加选课
- 编辑数据 改
  - 修改学生
  - 修改课程
  - 修改选课
- 查询数据 删
  - 删除学生 
  - 删除课程
  - 删除选课

## 系统初始化模块

添加基本的学生信息   √

## 系统数据查询模块

#### 权限--1

按课号查课程   √

按班号查学生  √

查课程不及格的名单  √

按学号查以修分数  √

按学号查各科成绩  √

#### 权限 --0

查自己分数   √

## 系统数据统计模块

#### 权限 ---2

统计各科分数   √

按班级统计各分数段人数及比例   √

按班级统计不及格人数及比例   √

## 数据库信息模块

数据库信息

准备设计三个权限接口

权限0 权限1 权限2

这些权限接口分别拥有上述查询方法

学生 老师 管理员 分别实现这些接口

CREATE TABLE s ( sno INT PRIMARY KEY, sname CHAR ( 255 ), sex INT, age INT ( 2 ), dept CHAR ( 4 ) )character set = utf8;
CREATE TABLE c ( cno INT PRIMARY KEY, cname CHAR ( 255 ), tname CHAR ( 255 ) , credit CHAR(255) )character set = utf8;
CREATE TABLE sc (
sno INT,
cno INT,
grade TINYINT,
credit INT,
PRIMARY KEY ( sno, cno ),
FOREIGN KEY ( sno ) REFERENCES s ( sno ),
FOREIGN KEY ( cno ) REFERENCES c ( cno ),
FOREIGN KEY ( credit ) REFERENCES c ( credit )
)character set = utf8;
CREATE TABLE users(hm CHAR(255),pwd CHAR(255) ,role int)character set = utf8;

INSERT INTO mysql.s (sno, sname, sex, age, dept) VALUES (1901, '张三', 1, 20, '计科');
INSERT INTO mysql.s (sno, sname, sex, age, dept) VALUES (1902, '李四', 1, 19, '计科');
INSERT INTO mysql.s (sno, sname, sex, age, dept) VALUES (1903, '王五', 0, 21, '计科');
INSERT INTO mysql.s (sno, sname, sex, age, dept) VALUES (1904, '甲一', 0, 21, '计科');
INSERT INTO mysql.s (sno, sname, sex, age, dept) VALUES (1905, '乙二', 1, 20, '计科');
INSERT INTO mysql.s (sno, sname, sex, age, dept) VALUES (1906, '丙丁', 1, 19, '计科');

INSERT INTO mysql.c (cno, cname, tname,credit) VALUES (101, '高数', '王一',3);
INSERT INTO mysql.c (cno, cname, tname,credit) VALUES (102, '英语', '王二',3);
INSERT INTO mysql.c (cno, cname, tname,credit) VALUES (103, '计网', '王三',2);
INSERT INTO mysql.c (cno, cname, tname,credit) VALUES (104, '计组', '王四',2);
INSERT INTO mysql.c (cno, cname, tname,credit) VALUES (105, '数据结构', '王五',2);

INSERT INTO mysql.sc (sno, cno, grade,credit) VALUES (1901, 101, 70,3);
INSERT INTO mysql.sc (sno, cno, grade,credit) VALUES (1901, 102, 60,3);
INSERT INTO mysql.sc (sno, cno, grade,credit) VALUES (1901, 103, 44,2);
INSERT INTO mysql.sc (sno, cno, grade,credit) VALUES (1901, 104, 88,2);
INSERT INTO mysql.sc (sno, cno, grade,credit) VALUES (1902, 101, 55,3);
INSERT INTO mysql.sc (sno, cno, grade,credit) VALUES (1902, 102, 25,3);
INSERT INTO mysql.sc (sno, cno, grade,credit) VALUES (1902, 103, 77,2);
INSERT INTO mysql.sc (sno, cno, grade,credit) VALUES (1902, 104, 97,2);
INSERT INTO mysql.sc (sno, cno, grade,credit) VALUES (1903, 102, 55,3);
INSERT INTO mysql.sc (sno, cno, grade,credit) VALUES (1903, 103, 25,2);
INSERT INTO mysql.sc (sno, cno, grade,credit) VALUES (1903, 104, 77,2);
INSERT INTO mysql.sc (sno, cno, grade,credit) VALUES (1903, 105, 47,2);
INSERT INTO mysql.sc (sno, cno, grade,credit) VALUES (1904, 101, 55,3);
INSERT INTO mysql.sc (sno, cno, grade,credit) VALUES (1904, 102, 55,3);
INSERT INTO mysql.sc (sno, cno, grade,credit) VALUES (1904, 104, 70,2);
INSERT INTO mysql.sc (sno, cno, grade,credit) VALUES (1904, 105, 53,2);
INSERT INTO mysql.sc (sno, cno, grade,credit) VALUES (1905, 101, 75,3);
INSERT INTO mysql.sc (sno, cno, grade,credit) VALUES (1905, 103, 27,2);
INSERT INTO mysql.sc (sno, cno, grade,credit) VALUES (1905, 104, 37,2);
INSERT INTO mysql.sc (sno, cno, grade,credit) VALUES (1905, 105, 17,2);
INSERT INTO mysql.sc (sno, cno, grade,credit) VALUES (1906, 101, 55,3);
INSERT INTO mysql.sc (sno, cno, grade,credit) VALUES (1906, 102, 35,3);
INSERT INTO mysql.sc (sno, cno, grade,credit) VALUES (1906, 103, 50,2);
INSERT INTO mysql.sc (sno, cno, grade,credit) VALUES (1906, 105, 73,2);

INSERT INTO mysql.users (hm,pwd,role) VALUES ('admin','admin', 2);
INSERT INTO mysql.users (hm,pwd,role) VALUES ('teacher','teacher', 1);
INSERT INTO mysql.users (hm,pwd,role) VALUES ('student','student', 0);