package student;

public class Student {
    private int id;
    private String name;
    private String gender;
    private String borndate;
    private String classnum;
    public Student(){
    }
    public Student(int id,String name,String gender,String borndate,String classnum){
        this.id=id;
        this.name=name;
        this.gender=gender;
        this.borndate=borndate;
        this.classnum=classnum;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getBorndate() {
        return borndate;
    }

    public void setBorndate(String borndate) {
        this.borndate = borndate;
    }

    public String getClassnum() {
        return classnum;
    }

    public void setClassnum(String classnum) {
        this.classnum = classnum;
    }
}
