/* NameService.java
   This is a Name Service Interface
   Author: Vuyisa Nkangana
   Student No: 218192215
   Due Date: 18 June 2022
 */
package za.ac.cput.schoolmanagement.service.name;
import za.ac.cput.schoolmanagement.domain.Name;
import za.ac.cput.schoolmanagement.service.IService;

import java.util.List;

public interface NameService extends IService<Name, String> {
    List<Name> findAll();
    void delete(String lastName);

}
