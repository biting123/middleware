package student;

import air.JdbcUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class StudentDaoImpl implements StudentDAo{
    private static Connection dbConn = null;
    @Override
    public void insertStudent(Student student) {
        Connection conn= JdbcUtils.getConnection();

        String dbURL = "jdbc:sqlserver://localhost:1433;DatabaseName=student";
        //操作数据库
        try {
            String sql="insert into Student values("+student.getId()+","+student.getName()+","+student.getGender()+","+student.getBorndate()+","+student.getClassnum()+")";
            //获取连接对象
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            //2.连接
            dbConn = DriverManager.getConnection(dbURL, "biting", "36004551biting");
            PreparedStatement statement=null;
            statement=dbConn.prepareStatement(sql);
            ResultSet rs=null;
            rs=statement.executeQuery();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void updateStudent(Student student, Long studentID) {
        Connection conn=JdbcUtils.getConnection();

        String dbURL = "jdbc:sqlserver://localhost:1433;DatabaseName=student";
        //操作数据库
        try {
            String sql="update Student set 学号="+student.getId()+",姓名='"+student.getName()+"',性别='"+student.getGender()+"',出生日期='"+student.getBorndate()+"',班级号='"+student.getClassnum()+"'where 学号=studentID";
            //获取连接对象
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            //2.连接
            dbConn = DriverManager.getConnection(dbURL, "biting", "36004551biting");
            PreparedStatement statement=null;
            statement=dbConn.prepareStatement(sql);
            ResultSet rs=null;
            rs=statement.executeQuery();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteStudent(Student student) {

        String dbURL = "jdbc:sqlserver://localhost:1433;DatabaseName=student";
        //操作数据库
        try {
            String sql="delete from Student where 学号="+student.getId();
            //获取连接对象
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            //2.连接
            dbConn = DriverManager.getConnection(dbURL, "biting", "36004551biting");
            PreparedStatement statement=null;
            statement=dbConn.prepareStatement(sql);
            ResultSet rs=null;
            rs=statement.executeQuery();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Student findByStudentID(Long StudentID) {
        String dbURL = "jdbc:sqlserver://localhost:1433;DatabaseName=student";
        //操作数据库
        try {
            String sql ="select * from Student where 学号="+StudentID;
            //获取连接对象
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            //2.连接
            dbConn = DriverManager.getConnection(dbURL, "biting", "36004551biting");
            PreparedStatement statement=null;
            statement=dbConn.prepareStatement(sql);
            ResultSet rs=null;
            rs=statement.executeQuery();
            Student student = null ;
            while(rs.next()){
                student = new Student() ;
                //查询一行,将这条学生信息封装到学生类中
                int id = rs.getInt("学号");
                String name = rs.getString("姓名");
                String gender = rs.getString("性别") ;
                String borndate = rs.getString("出生日期");
                String classnum = rs.getString("班级号");

                student.setId(id);
                student.setName(name);
                student.setGender(gender);
                student.setBorndate(borndate);
                student.setClassnum(classnum);
            }
            return student;
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    return null;
    }

    @Override
    public List<Student> findAll() {
        String dbURL = "jdbc:sqlserver://localhost:1433;DatabaseName=student";
        //操作数据库
        try {
            List<Student> list = new ArrayList<>() ;
            //获取连接对象


            String sql = "select * from Student" ;
            //获取连接对象
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            //2.连接
            dbConn = DriverManager.getConnection(dbURL, "biting", "36004551biting");
            PreparedStatement statement=null;
            statement=dbConn.prepareStatement(sql);
            ResultSet rs=null;
            rs=statement.executeQuery();
            Student student = null ;
            while(rs.next()){
                student = new Student() ;
                //查询一行,将这条学生信息封装到学生类中
                int id = rs.getInt("学号");
                String name = rs.getString("姓名");
                String gender = rs.getString("性别") ;
                String borndate = rs.getString("出生日期");
                String classnum = rs.getString("班级号");

                student.setId(id);
                student.setName(name);
                student.setGender(gender);
                student.setBorndate(borndate);
                student.setClassnum(classnum);

                list.add(student) ;
            }
            return list ;
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
