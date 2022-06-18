/* NameRepository.java
   This is a Name repository class
   Author: Vuyisa Nkangana
   Student No: 218192215
   Due Date: 18 June 2022
 */

package za.ac.cput.schoolmanagement.repository.name.impl;
import za.ac.cput.schoolmanagement.domain.Name;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class NameRepositoryImpl {
    private static NameRepositoryImpl repository = null;
    private List<Name> nameDB;

    private NameRepositoryImpl() {
        nameDB = new ArrayList<>();
    }

    public Name save(Name name) {
        Optional<Name> read = read(name.getLastName());
        if (read.isPresent()) {
            delete(read.get());
        }
        nameDB.add(name);
        return name;
    }

    public Optional<Name> read(String lastName) {
        return nameDB.stream().
                filter(e -> e.getLastName() == lastName).
                findAny();
    }

    public void delete(Name name) {
        nameDB.remove(name);
    }

    public List<Name> getAll() {
        return repository.getAll();

    }
}