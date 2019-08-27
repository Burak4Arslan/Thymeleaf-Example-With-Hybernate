package burak.thymeleafexample.entity;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class EmployeeTest {

    Employee employee;

    @Before
    public void setUp() throws Exception {
        employee = new Employee(1L,"burak","arslan","bu@email.com");
    }

    @Test
    public void getId() {

        Long c = 1L;

        assertEquals(c,employee.getId());

    }

    @Test
    public void setId() {

        Long b = 2L;

        employee.setId(b);

        assertEquals(b,employee.getId());

    }

    @Test
    public void getFirstName() {

        assertEquals("burak",employee.getFirstName());

    }

    @Test
    public void setFirstName() {

        String name = "bigi";

        employee.setFirstName(name);

        assertEquals(name,employee.getFirstName());

    }

    @Test
    public void getLastName() {

        assertEquals("arslan",employee.getLastName());

    }

    @Test
    public void setLastName() {

        String name = "krtgl";

        employee.setLastName(name);

        assertEquals(name,employee.getLastName());

    }

    @Test
    public void getEmail() {

        assertEquals("bu@email.com",employee.getEmail());

    }

    @Test
    public void setEmail() {

        String name = "bigi@email.com";

        employee.setEmail(name);

        assertEquals(name,employee.getEmail());

    }
}