/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.iespuntadelverde.registroalumnos.business.student.boundary;

import es.iespuntadelverde.registroalumnos.business.student.entity.Student;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author angelmiralles
 */
@Stateless
@Path("/students")
public class StudentsResource {
    
    @Inject
    Students students;
    
    @GET
    @Path("/{id:[1-9][0-9]*}")
    @Produces( MediaType.APPLICATION_JSON)
    public Student find(@PathParam("id") int studentId){
        return students.find(studentId);
    }
    
    @GET
    @Produces( MediaType.APPLICATION_JSON)
    public List<Student> findAll(){
        return students.findAll();
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Student add(Student request){
        return students.add(request);
    }
    
    @PUT
    @Path("/{id:[1-9][0-9]*}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void update(@PathParam("id") int studentId, Student st){
        students.update(st);
    }
    
    @DELETE
    @Path("/{id:[1-9][0-9]*}")
    public void delete(@PathParam("id") int studentId){
        Student student = students.find(studentId);
        students.delete(student);
    }
}
