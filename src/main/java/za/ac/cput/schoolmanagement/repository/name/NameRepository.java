package za.ac.cput.schoolmanagement.repository.name;

import org.springframework.data.jpa.repository.JpaRepository;
import za.ac.cput.schoolmanagement.domain.Name;

import java.util.List;

public interface NameRepository extends JpaRepository <Name, String> {
    List<Name> findAll();
}
