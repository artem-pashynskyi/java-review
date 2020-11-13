package streams.exercises;

import static streams.exercises.DataGenerator.*;

import enums.Gender;
import enums.Status;
import oop.encapsulation.User;
import oop.inheritance.Project;

import java.time.LocalDateTime;
import java.time.Period;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamDemo {

    public static void main(String[] args) {
        System.out.println(getListOfProject()); //1
        System.out.println(getListOfProject(Status.IN_PROGRESS)); //2
        System.out.println(getListOfProject(new User(6,LocalDateTime.now(),1, LocalDateTime.now().plusHours(1),
                1,"Tracy","Wilson",managerRole,Gender.FEMALE))); //3
        System.out.println(getListOfProjectByProjectCode("PRJ004")); //4
        System.out.println(getListOfUsers()); //5
        System.out.println(getUserByFirstName("Tracy")); //6
        System.out.println(getUserByUserId(6)); //7
        System.out.println(deleteUser("Tracy")); //8
        System.out.println(updateProjectStatus(Status.IN_PROGRESS, Status.OPEN)); //9
        System.out.println(findProjectByManager(new User(6,LocalDateTime.now(),1, LocalDateTime.now().plusHours(1),
                1,"Tracy","Wilson",managerRole,Gender.FEMALE))); //10
        System.out.println(totalProjectDurationForManager(new User(6,LocalDateTime.now(),1, LocalDateTime.now().plusHours(1),
                1,"Tracy","Wilson",managerRole,Gender.FEMALE))); //11
        System.out.println(findTotalMailInCompany(Gender.MALE)); //12
        System.out.println(Stream.of(1,2,3,4).reduce(10, Integer::sum));
    }

    //Task-1 Return all
    public static List<Project> getListOfProject() {
        return getProjects();
    }

    //Task-2 Return only those with specific status
    public static List<Project> getListOfProject(Status status) {
        return getProjects().stream().filter(project -> project.getProjectStatus().equals(status))
                .collect(Collectors.toList());
    }

    //Task-3 Return all based on managers
    public static List<Project> getListOfProject(User manager) {
        return getProjects().stream().filter(project -> project.getAssignedManager().getId() == (manager.getId()))
                .collect(Collectors.toList());
    }

    //Task-4 Return all based on projectCode
    public static List<Project> getListOfProjectByProjectCode(String projectCode) {
        return getProjects().stream().filter(project -> project.getProjectCode().equals(projectCode))
                .collect(Collectors.toList());
    }

    //Task-5 All Users
    public static List<User> getListOfUsers() {
        return getUsers();
    }

    //Task-6 All Users by firstName
    public static List<User> getUserByFirstName(String firstName) {
        return getUsers().stream().filter(user -> user.getFirstName().equals(firstName))
                .collect(Collectors.toList());
    }

    //Task-7 User by id
    public static User getUserByUserId(long id) {
        return getUsers().stream().filter(user -> user.getId() == id).findFirst().get();
    }

    //Task-8 Delete the user with name and return the rest
    public static List<User> deleteUser(String firstName) {
        return getUsers().stream().filter(user -> !user.getFirstName().equals(firstName))
                .collect(Collectors.toList());
    }

    //Task-9 Update all oldStatus with newStatus and return all projects
    public static List<Project> updateProjectStatus(Status oldStatus, Status newStatus) {
        return getProjects().stream().map(project -> {
            if(project.getProjectStatus().equals(oldStatus)) {
                project.setProjectStatus(newStatus);
            }
            return project;
        }).collect(Collectors.toList());
    }

    //Task-10
    public static List<Project> findProjectByManager(User manager) {
        return getProjects().stream().filter(project -> project.getAssignedManager().getId() == manager.getId())
                .collect(Collectors.toList());
    }

    //Task-11 Get project startDate - endData = duration | Use Period (Java API)
    public static Integer totalProjectDurationForManager(User manager) {
        Project p = getProjects().stream().filter(project -> project.getAssignedManager().getId() == manager.getId())
                .findFirst().get();
        return Period.between(p.getStartDate(), p.getEndDate()).getDays();
    }

    //Task-12 Get all MALE/FEMALE in company
    public static long findTotalMailInCompany(Gender gender) {
        return getUsers().stream().filter(user -> user.getGender().equals(gender)).count();
    }

}
