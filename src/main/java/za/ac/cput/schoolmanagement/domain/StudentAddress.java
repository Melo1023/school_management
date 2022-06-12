/*
    StudentAddress.java
    entity for StudentAddress
    Student:Hlumelo Mpotulo
    Student Number: 215226348
    Due Date 09 June 2022
 */
package za.ac.cput.schoolmanagement.domain;

import com.sun.nio.sctp.PeerAddressChangeNotification;

public class StudentAddress {

private String studentId;
private PeerAddressChangeNotification.AddressChangeEvent Address;


private StudentAddress(Builder builder){
    this.studentId = builder.studentId;
    this.Address = builder.Address;
}

    public String getStudentId() {
    return this.studentId;
    }
    public PeerAddressChangeNotification.AddressChangeEvent getAddress(){
    return this.Address;
    }


    public static class Builder{

        private PeerAddressChangeNotification.AddressChangeEvent Address;

        private String studentId;

    public Builder setStudentId(String studentId){
        this.studentId= studentId;
                return this;
    }
    public Builder setAddress(PeerAddressChangeNotification.AddressChangeEvent Address){
        this.Address= Address;
        return this;
    }


    public StudentAddress build()
    {
        return new StudentAddress(this);
    }

    public Builder copy (StudentAddress student) {
        this.studentId = student.studentId;
        this.Address = student.Address;
        return this;
}

    @Override
    public String toString(){
    String data = "";
    data += "{StudentId: "+studentId+",";
    data+="{Address: "+Address+",";
    return data;
    }
}}
