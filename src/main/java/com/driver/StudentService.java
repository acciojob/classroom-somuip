package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    public void addStudent(Student student){
        studentRepository.addStudent(student);
    }

    public void addTeacher(Teacher teacher){
        studentRepository.addTeacher(teacher);
    }

    public void techerStudentPair(String studentName, String teacherName){
        studentRepository.teacherStudentPair(studentName, teacherName);
    }
    public Student getStudentByName(String studentName){
        return studentRepository.getStudentByName(studentName);
    }

    public Teacher getTeacherByName(String teacherName){
        return studentRepository.getTeacherByName(teacherName);
    }

    public List<String> getListOfStudentOfTeacher(String teacher){
        return studentRepository.getStudnetListForteacher(teacher);
    }

    public List<String> getListOfStudents(){
        return studentRepository.getListOfStudents();
    }

    public void deleteTeacher(String teacher){
        studentRepository.deleteTeacher(teacher);
    }

    public void deleteAllTeachersAndStudents(){
        studentRepository.deleteAllTeachersAndStudents();
    }
}
