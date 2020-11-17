package refactorOop;

public class Main {

    public static void main(String[] args) {
        int principal = (int) Console.readNumber("Principal: ", 1000, 1_000_000);
        float annualInterest = (float) Console.readNumber("Annual Interest Rate: ", 1, 30);
        byte years = (byte) Console.readNumber("Period (Years): ", 1, 30);

        var report = new MortgageReport(new MortgageCalculator(principal, annualInterest, years));
        report.printMortgage();
        report.printPaymentSchedule();
    }

}
