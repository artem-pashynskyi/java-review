package core;

public class SelectionStatements {

    public static void demoIfStatement() {

        String userName = "Artem";
        if(userName.equals("Artem")) {
            System.out.println("PASS");
        } else if(userName.equals("Mike")){
            System.out.println("FAIL");
        } else {
            System.out.println("Not Valid");
        }
    }

    public static void demoSwitchCaseStatement() {
        String userName = "Mike";
        switch(userName) {
            case "Artem":
                System.out.println("PASS");
                break;
            case "Mike":
                System.out.println("FAIL");
                break;
            default:
                System.out.println("Not Valid");
        }
    }
}
