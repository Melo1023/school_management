package za.ac.cput.schoolmanagement.domain.employee;

/*
    Student: Ian Louw
    Student Number: 216250773
    Class for the EmployeeAddress entity.
    Date: 9 June 2022
 */

import za.ac.cput.schoolmanagement.domain.Address;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Entity
public class EmployeeAddress implements Serializable {

    @Id
    private String staffId;
    @ManyToOne(targetEntity = Address.class, cascade = CascadeType.ALL)
    private Address address;

    public EmployeeAddress() {
    }

    private EmployeeAddress (Builder builder) {

        this.staffId = builder.staffId;
        this.address = builder.address;
    }

    public String getStaffId() {
        return staffId;
    }

    public Address getAddress() {
        return address;
    }

    @Override
    public String toString() {
        return "EmployeeAddress{" +
                "staffId='" + staffId + '\'' +
                ", address=" + address +
                '}';
    }

    public static class Builder {

        private String staffId;
        private Address address;

        public Builder setStaffId(String staffId) {
            this.staffId = staffId;

            return this;
        }

        public Builder setAddress(Address address) {
            this.address = address;

            return this;
        }

        public EmployeeAddress build () {

            return new EmployeeAddress(this);
        }

        public Builder copy (EmployeeAddress employeeAddress) {
            this.staffId = employeeAddress.staffId;
            this.address = employeeAddress.address;

            return this;
        }
    }
}
