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

    Map<String,String> teacherStudentPairdb = new HashMap<>();

    public void addStudent(Student student){
        studentdb.put(student.getName(), student);
    }

    public void addTeacher(Teacher teacher){
        teacherdb.put(teacher.getName(), teacher);
    }

    public void teacherStudentPair(String studentName, String teacherName){
        teacherStudentPairdb.put(studentName, teacherName);
    }
    public Student getStudentByName(String studentName){
        return studentdb.get(studentName);
    }

    public Teacher getTeacherByName(String teacherName){
        return teacherdb.get(teacherName);
    }

    public List<String> getStudnetListForteacher(String teacher){
        List<String> list = new ArrayList<>();
        for(Map.Entry<String,String> entry : teacherStudentPairdb.entrySet()){
            if(entry.getValue().equals(teacher)){
                String studentName = entry.getKey();
                list.add(studentName);
            }
        }
        return list;
    }

    public List<String> getListOfStudents(){
        List<String> studentList = new ArrayList<>();
        for(String student : studentdb.keySet()){
            studentList.add(student);
        }
        return studentList;
    }

    public void deleteTeacher(String teacher){
        teacherdb.remove(teacher);
        for(Map.Entry<String, String> entry : teacherStudentPairdb.entrySet()){
            if(entry.getValue().equals(teacher)){
                String student = entry.getKey();
                studentdb.remove(student);
                teacherStudentPairdb.remove(student, teacher);
            }
        }
    }

    public void deleteAllTeachersAndStudents(){

        for(Map.Entry<String,String> entry : teacherStudentPairdb.entrySet()){
            String student = entry.getKey();
            String teacher = entry.getValue();
            teacherStudentPairdb.remove(student, teacher);
            studentdb.remove(student);
            teacherdb.remove(teacher);
        }
    }
}
