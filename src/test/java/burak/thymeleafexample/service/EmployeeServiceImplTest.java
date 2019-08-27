package burak.thymeleafexample.service;

import burak.thymeleafexample.entity.Employee;
import burak.thymeleafexample.repository.EmployeeRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class EmployeeServiceImplTest {

    @Mock
    EmployeeRepository employeeRepository;

    EmployeeService employeeService;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);

        employeeService = new EmployeeServiceImpl(employeeRepository);
    }


    @Test
    public void getEmployees() {

        Employee emp1 = new Employee();
        emp1.setId(1L);
        Employee emp2 = new Employee();
        emp2.setId(2L);

        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(emp1);
        employeeList.add(emp2);

        when(employeeRepository.findAll()).thenReturn(employeeList);

        assertEquals(employeeList,employeeService.getEmployees());
        verify(employeeRepository,times(1)).findAll();
    }


}