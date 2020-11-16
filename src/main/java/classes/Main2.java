package classes;

public class Main2 {
    public static void main(String[] args) {
        var employee = new Employee(50_000, 20);
        var wageWithExtra = employee.calculateWage(10);
        var wageWithNoExtra = employee.calculateWage(0);
        System.out.println(wageWithExtra);
        System.out.println(wageWithNoExtra);
    }

}
