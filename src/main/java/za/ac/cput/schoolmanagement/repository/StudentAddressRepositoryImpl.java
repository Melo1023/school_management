
/*
    Student.java
    Repository for StudentAddress
    Student:Hlumelo Mpotulo
    Student Number: 215226348
    Due Date 09 June 2022
 */

package za.ac.cput.schoolmanagement.repository;

import za.ac.cput.schoolmanagement.domain.StudentAddress;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


public class StudentAddressRepositoryImpl implements IStudentAddress {

    private List<za.ac.cput.schoolmanagement.domain.StudentAddress> StudentAddress;
    private static StudentRepositoryImpl repository;
    private final ArrayList<Object> StudentAddressList;

    public StudentAddressRepositoryImpl (){
        this.StudentAddressList = new ArrayList<>();
    }

    public static StudentRepositoryImpl getRepository() {
        if (repository == null)
            repository = new StudentRepositoryImpl();
        return repository;

    }

    @Override
    public void delete(String studentId) {
        this.StudentAddressList.remove(studentId);
    }

    @Override
    public za.ac.cput.schoolmanagement.domain.StudentAddress update(String studentId) {
        return null;
    }

    @Override
    public Optional<Object> readAll(String studentId) {
        return this.StudentAddressList.stream().filter(g ->  g.getClass().equals(studentId)).findFirst();
    }

    @Override
    public List<za.ac.cput.schoolmanagement.domain.StudentAddress> save(String studentId) {
        Optional<StudentAddress> read;
        read = read(StudentAddress.getClass());
        if (read.isPresent()){
            delete(String.valueOf(read.get()));
        }
        this.StudentAddressList.add(StudentAddress);
        return StudentAddress;
    }

    private Optional<za.ac.cput.schoolmanagement.domain.StudentAddress> read(Class<? extends List> aClass) {
        return null;
    }

}
