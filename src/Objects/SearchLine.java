/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objects;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Crivano
 */
public class SearchLine {
    
    private String name;
    private List<Teacher> teachers;

    public SearchLine(String name) {
        this.name = name;
        this.teachers = new ArrayList<Teacher>();
    }

    public SearchLine() {
        this("");
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public void addTeacher(Teacher teacher) {
        teachers.add(teacher);
    }
    
    public Teacher getTeacherByIndex(int index) {
        return teachers.get(index);
    }
    
    public List<Teacher> getListOfTeachers() {
        return teachers;
    }    
    
    public int countTeachers() {
        return teachers.size();
    }
        
    public Iterable<Teacher> getTeachers() {
        return teachers;
    }
}
