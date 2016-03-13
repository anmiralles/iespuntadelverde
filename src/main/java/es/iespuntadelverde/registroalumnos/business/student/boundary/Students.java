/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.iespuntadelverde.registroalumnos.business.student.boundary;

import es.iespuntadelverde.registroalumnos.business.student.entity.Student;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author angelmiralles
 */
@Stateless
public class Students {
    
    @PersistenceContext
    EntityManager em;
    
    public Student find(int studentId){
        return this.em.find(Student.class, studentId);
    }
    
    public List<Student> findAll(){
        return this.em.createNamedQuery("Student.findAll").getResultList();
    }
    
    public Student add(Student request){
        return this.em.merge(request);
    }
    
    public void update(Student request){
        this.em.merge(request);
    }
    
    public void delete(Student request){
        this.em.remove(this.em.merge(request));
    }
    
}
