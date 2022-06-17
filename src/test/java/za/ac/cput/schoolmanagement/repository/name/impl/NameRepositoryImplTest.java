package za.ac.cput.schoolmanagement.repository.name.impl;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import za.ac.cput.schoolmanagement.domain.Name;
import za.ac.cput.schoolmanagement.repository.name.NameRepository;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class NameRepositoryImplTest {

    private final Name name = new Name.Builder()
            .setFirstName("Vuyisa")
            .setMiddleName("Alunamda")
            .setLastName("Nkangana")
            .build();
    @Autowired
    private NameRepository repository;

    @AfterEach
    void tearDown() {
        repository.delete(name);
    }

    @Test
    void save() {
       Name saved = repository.save(name);
        assertNotNull(saved);
        assertSame(name, saved);
    }

    @Test
    void read() {
        Name saved = repository.save(name);
        Optional<Name> read = repository.findById(saved.getMiddleName());
        assertAll(
                () -> assertTrue(read.isPresent()),
                () -> assertSame(saved, read.get())
        );
    }

    @Test
    void delete() {
        Name saved = repository.save(name);
        List<Name> getAll = repository.findAll();
        repository.delete(saved);
        getAll = repository.findAll();
        assertEquals(0, getAll.size());
    }

    @Test
    void getAll() {
        repository.save(name);
        List<Name> getAll = repository.findAll();
        assertEquals(1, getAll.size());
    }

}