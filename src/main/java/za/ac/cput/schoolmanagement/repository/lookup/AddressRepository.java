package za.ac.cput.schoolmanagement.repository.lookup;

/*
    Student: Bongisa Mpahleni
    Student Number: 216205999
    Date: 9 June 2022
 */

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.schoolmanagement.domain.Address;
import java.util.List;

@Repository
public interface AddressRepository extends JpaRepository<Address,String> {
        List<Address> findAll();
}

