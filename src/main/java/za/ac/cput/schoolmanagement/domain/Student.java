/*
    Student.java
    entity for Student
    Student:Hlumelo Mpotulo
    Student Number: 215226348
    Due Date 09 June 2022
 */
package za.ac.cput.schoolmanagement.domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@IdClass(Student.StudentId.class)
public class Student implements Serializable {

    @Id
    private String studentId;
    @Column ( name = "Student Email")
    @OneToOne()
    private String email;
    @Column ( name = "Student Name")
    @ManyToOne(targetEntity = Name.class, cascade = CascadeType.ALL)
    private Name name;

    public Student(Builder builder){
    this.studentId = builder.studentId;
    this.email=builder.email;
    this.name= builder.name;
}

    public static String get() {
        return null;
    }

    public String getStudentId() {
    return this.studentId;
    }
    public String getEmail(){
    return this.email;
    }

    public Name getName(){return this.name;}

    public interface StudentId {
    }

    public static class Builder{
    private String studentId;
    private String email;
    private Name name;

    public Builder setStudentId(String studentId){
        this.studentId= studentId;
                return this;
    }
    public Builder setEmail(String email){
        this.email= email;
        return this;
    }
    public Builder setName(Name name)
    {
        this.name=name;
        return this;
    }

    public Student build()
    {
        return new Student(this);
    }

    public Builder copy (Student student) {
        this.studentId = student.studentId;
        this.email = student.email;
        this.name = student.name;
        return this;
}

    @Override
    public String toString(){
    String data = "";
    data += "{StudentId: "+studentId+",";
    data+="{Email: "+email+",";
    data += "{Name:"+name+",";
    return data;
    }
}}
