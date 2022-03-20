package student;

import java.util.List;

public interface StudentDAo {
    public void insertStudent(Student student);
    void updateStudent(Student student, Long studentID);

    public void deleteStudent(Student student);
    public Student findByStudentID(Long StudentID);
    public List<Student> findAll();
}
