package za.ac.cput.schoolmanagement.factory;
/* NameFactory.java
  This is a Name Factory test case
  Author : Vuyisa Nkangana
  Student no: 218192215
  Due Date: 18 June 2022
 */

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import za.ac.cput.schoolmanagement.domain.Name;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

class NameFactoryTest {
    private Name name1;
    private Name name2;
    private Name name3;

    @BeforeEach
    void setUp(){
        Name name1 = new Name.Builder().setFirstName("Vuyisa").setLastName("Nkangana").build();
        Name name2 = name1;
    }
    @Test
    public void test(){
        Name name = NameFactory.createName("Vuyisa","Alunamda", "Nkangana");
        System.out.println(name.toString());
    }
   @Test
   public void testIdentity(){
        assertSame(name1, name2);
       System.out.println("name1 and name2 are identical");
   }
   @Test
    void testTimeOut(){
        assertTimeout(Duration.ofMinutes(100), ()->{
            Thread.sleep(2000);
            System.out.println("Test Timed out");
        });
   }
   @Test
    @Disabled
    void testDisable(){
        assertEquals(name1, name2);
   }
}