import java.io.IOException;
import java.io.PrintWriter;

/**
 * Driver class for Payroll Processing.
 * @author Aditi Datta
 */
public class Driver {
    public static void main(String[] args) throws IOException{
        PrintWriter pw = new PrintWriter("csis.txt");

        Payroll payroll = new Payroll(pw);

        payroll.loadEmployees();
        payroll.displayEmployees();
        payroll.displayNumEmployees();
        payroll.displayFemaleEmployees();
        payroll.dispWeeklyEmployees();
        payroll.raiseToEmployeeSalaries();
        payroll.sortEmployees();
        payroll.hireEmployees();
        payroll.fireEmployees();

        pw.close();
    }
}
