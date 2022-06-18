package za.ac.cput.schoolmanagement.domain.employee;

/*
    Student: Ian Louw
    Student Number: 216250773
    Class for the Employee entity.
    Date: 9 June 2022
 */

import za.ac.cput.schoolmanagement.domain.Name;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Entity
public class Employee implements Serializable {

    @Id
    private String staffId;
    private String email;
    @ManyToOne(targetEntity = Name.class, cascade = CascadeType.ALL)
    private Name name;

    public Employee() {
    }

    private Employee (Builder builder) {

        this.staffId = builder.staffId;
        this.email = builder.email;
        this.name = builder.name;
    }

    public String getStaffId() {

        return staffId;
    }

    public String getEmail() {
        return email;
    }

    public Name getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "staffId='" + staffId + '\'' +
                ", email='" + email + '\'' +
                ", name=" + name +
                '}';
    }

    public static class Builder {

        private String staffId;
        private String email;
        private Name name;

        public Builder setStaffId(String staffId) {
            this.staffId = staffId;

            return this;
        }

        public Builder setEmail(String email) {
            this.email = email;

            return this;
        }

        public Builder setName(Name name) {
            this.name = name;

            return this;
        }

        public Employee build() {
            return new Employee(this);
        }

        public Builder copy (Employee employee) {
            this.staffId = employee.staffId;
            this.email = employee.email;
            this.name = employee.name;

            return this;
        }
    }

}
