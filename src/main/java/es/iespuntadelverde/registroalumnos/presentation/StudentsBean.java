/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.iespuntadelverde.registroalumnos.presentation;

import es.iespuntadelverde.registroalumnos.business.student.boundary.Students;
import es.iespuntadelverde.registroalumnos.business.student.entity.Student;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.inject.Inject;
import org.primefaces.event.SelectEvent;

/**
 *
 * @author angelmiralles
 */
@ManagedBean
public class StudentsBean {
    
    @Inject
    Students students;
    
    private Student selectedStudent;

    public Student getSelectedStudent() {
        return selectedStudent;
    }

    public void setSelectedStudent(Student selectedStudent) {
        this.selectedStudent = selectedStudent;
    }
    
    @PostConstruct
    public void initStudent(){
        this.selectedStudent = new Student();
    }
    
    public void onRowSelect(SelectEvent event) {
        this.selectedStudent = (Student) event.getObject();
    }
    
    public String showStudent(){
        return "student";
    }
    
    /**
     * Method for listing all students
     * @return 
     */
    public List<Student> getStudents(){
        return students.findAll();
    }
    
}
