import core.Loops;
import core.Methods;
import core.SelectionStatements;
import enums.Gender;
import enums.Status;
import oop.abstraction.implementation.UserServiceImplementation;
import oop.abstraction.service.UserService;
import oop.encapsulation.Role;
import oop.encapsulation.User;
import oop.inheritance.BaseEntity;
import oop.inheritance.Project;
import oop.polimorphism.Employee;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Main {

    public static void main(String[] args) {

        //*************Core*************//
        Methods methods = new Methods();
        methods.methodA();
        methods.methodA("Apple");
        System.out.println(methods.methodB());
        System.out.println(methods.methodB(5));
        Methods.methodC();

        //*************Core*************//
        Loops.demoForEach();
        Loops.demoForIterator();
        SelectionStatements.demoIfStatement();
        SelectionStatements.demoSwitchCaseStatement();

        //************OOP-Encapsulation***********//
        User user = new User("Artem", "Pashynskyi", new Role(1, "Test Engineer"), Gender.MALE);
        System.out.println(user.getFirstName());
        System.out.println(user.getLastName());
        System.out.println(user.getRole().getId());
        System.out.println(user.getRole().getDescription());

        //************OOP-Encapsulation***********//
        Project project = new Project(1, LocalDateTime.now(), 1,
                LocalDateTime.now().minusHours(5), 1, "PRJ001", "Human Resource CRM",
                new User("Artem", "Pashynskyi", new Role(1, "Manager"), Gender.MALE),
                LocalDate.now(), LocalDate.now(), Status.IN_PROGRESS, "HCRM Detail Information");

        //************OOP-interface***********//
        UserService userService = new UserService();
        System.out.println(userService.userByFirstName("Mike").getLastName());

        //************OOP-Polimorphism***********//
        Employee employee = new Employee();
        BaseEntity employee2 = new Employee();
        UserServiceImplementation userServiceImplementation = new UserService();
        employee.getEmployeeHours();
        ((Employee)employee2).getEmployeeHours(); // Down Casting

        //************Enums***********//
        System.out.println(Gender.FEMALE);
        System.out.println(Status.IN_PROGRESS.getValue());
    }



}
