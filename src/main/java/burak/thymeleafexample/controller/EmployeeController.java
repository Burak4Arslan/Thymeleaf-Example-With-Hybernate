package burak.thymeleafexample.controller;

import burak.thymeleafexample.entity.Employee;
import burak.thymeleafexample.service.EmployeeService;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import javax.annotation.PostConstruct;
import org.hibernate.cfg.Configuration;
import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
    SessionFactory sessionFactory = new Configuration()
            .configure("hibernate.cfg.xml")
            .addAnnotatedClass(Employee.class)
            .buildSessionFactory();

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    List<Employee> employees;

    @PostConstruct
    private void loadData() {

        employees = employeeService.getEmployees();

    }

    @GetMapping(value = {"/list"})
    public String getEmployeeTable(Model model) {

        employees = employeeService.getEmployees();
        model.addAttribute("employees", employees);

        return "employees";

    }

    @GetMapping("/list/search")
    public String getSpecificEmployees(Model model, @RequestParam String name) {

        Session session = sessionFactory.getCurrentSession();

        try {

            session.beginTransaction();
            Criteria cr = session.createCriteria(Employee.class);
            cr.add(Restrictions.like("firstName",name+"%"));
            List<Employee> searchedEmployees = cr.list();

            session.getTransaction().commit();

            model.addAttribute("employees", searchedEmployees);

        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            session.close();
//            sessionFactory.close();
        }


        return "employees";
    }


}


