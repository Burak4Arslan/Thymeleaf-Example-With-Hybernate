package burak.thymeleafexample.controller;

import burak.thymeleafexample.entity.Employee;
import burak.thymeleafexample.service.EmployeeService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.ui.Model;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class EmployeeControllerTest {

    @Mock
    EmployeeService employeeService;

    EmployeeController employeeController;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);

        employeeController = new EmployeeController(employeeService);
    }

    @Test
    public void getEmployeeTable() {

        Employee emp1 = new Employee();
        emp1.setId(1L);
        Employee emp2 = new Employee();
        emp2.setId(2L);
        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(emp1);
        employeeList.add(emp2);

        System.out.println(employeeList);

        when(employeeService.getEmployees()).thenReturn(employeeList);

        Model model = new ExtendedModelMap();

        employeeController.getEmployeeTable(model);

        assertEquals(true,model.containsAttribute("employees"));

        verify(employeeService,times(1)).getEmployees();
        assertEquals(employeeList,employeeController.employees);

    }

    @Test
    public void getSpecificEmployees() {
    }
}