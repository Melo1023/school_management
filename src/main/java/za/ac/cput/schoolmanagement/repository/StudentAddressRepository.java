/*
    StudentAddress.java
    Repository for StudentAddress
    Student:Hlumelo Mpotulo
    Student Number: 215226348
    Due Date 09 June 2022
 */


package za.ac.cput.schoolmanagement.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.schoolmanagement.domain.StudentAddress;

import java.util.List;

@Repository
public interface StudentAddressRepository extends JpaRepository<StudentAddress, StudentAddress.StudentId> {
  List<StudentAddress> findByStudentId (String studentId);
  void deleteById (String id);

    Object save(StudentAddress studentAddress, za.ac.cput.schoolmanagement.service.StudentAddress studentAddress1);
}
