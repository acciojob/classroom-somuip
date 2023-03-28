package com.driver;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class StudentRepository {

    Map<String,Student> studentdb = new HashMap<>();

    Map<String,Teacher> teacherdb = new HashMap<>();

    Map<String,List<String>> teacherStudentPairdb = new HashMap<>();

    public void addStudent(Student student){
        studentdb.put(student.getName(), student);
    }

    public void addTeacher(Teacher teacher){
        teacherdb.put(teacher.getName(), teacher);
    }

    public void teacherStudentPair(String studentName, String teacherName){

        List<String> students = teacherStudentPairdb.get(teacherName);

        if(students == null){
            students = new ArrayList<>();
        }
        students.add(studentName);
        teacherStudentPairdb.put(teacherName, students);

    }
    public Student getStudentByName(String studentName){
        return studentdb.get(studentName);
    }

    public Teacher getTeacherByName(String teacherName){
        return teacherdb.get(teacherName);
    }

    public List<String> getStudnetListForteacher(String teacher){
        return teacherStudentPairdb.get(teacher);
    }

    public List<String> getListOfStudents(){
        List<String> studentList = new ArrayList<>();
        for(String student : studentdb.keySet()){
            studentList.add(student);
        }
        return studentList;
    }

    public void deleteTeacher(String teacher){
        for(String str : teacherStudentPairdb.get(teacher)){

            studentdb.remove(str);
        }
        teacherdb.remove(teacher);
        teacherStudentPairdb.remove(teacher);
    }

    public void deleteAllTeachersAndStudents() {
        for(String teacher : teacherStudentPairdb.keySet()){
            for(String str : teacherStudentPairdb.get(teacher)){

                studentdb.remove(str);
            }
            teacherdb.remove(teacher);
            teacherStudentPairdb.remove(teacher);
        }
    }
}
