import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Payroll class.
 * @author Aditi Datta
 */
public class Payroll {

    private int numEmployees;
    private PrintWriter pw;
    private ObjectList list;

    private String payfile = "payfile.txt";
    private String hirefile = "hirefile.txt";
    private String firefile = "firefile.txt";

    /**
     * Creates a new instance of Payroll class and assigns the
     * PrintWriter object where all the output is channeled
     * @param pw PrintWriter
     */
    public Payroll(PrintWriter pw) {
        this.pw = pw;
        numEmployees = 0;
        list = new ObjectList();
    }

    /**
     * Reads all the employee information from a file and creates
     * employee objects and stores them into a list
     * @throws IOException if there are file errors
     */
    public void loadEmployees() throws IOException{
        Scanner sc = new Scanner(new File(payfile));
        while(sc.hasNextLine()){
            String str[] = sc.nextLine().trim().split("\\s+");
            String fn = str[0];
            String ln = str[1];
            char    g = str[2].toUpperCase().charAt(0);
            int     t = Integer.parseInt(str[3]);
            char    r = str[4].toUpperCase().charAt(0);
            double  s = Double.parseDouble(str[5]);

            Employee emp = new Employee(fn, ln, g, t, r, s);

            list.addLast(emp);
            numEmployees++;
        }
    }

    /**
     * Displays all the employees
     */
    public void displayEmployees(){
        String header = String.format(Employee.FMT,"First Name",
                "last Name", "Gender","Tenure","Rate","Salary");
        pw.println(header);
        pw.println();
        ObjectListNode temp = list.getFirstNode();
        while(temp != null){
            pw.println(temp.getInfo());
            temp = temp.getNext();
        }
        pw.println();
    }

    /**
     * Displays the total number of employees
     */
    public void displayNumEmployees(){
        pw.println("Total Number of Employees: " + numEmployees);
        pw.println();
    }

    /**
     * Displays the first name of all women employees
     */
    public void displayFemaleEmployees(){
        pw.println("First name of all women on the payroll: ");
        ObjectListNode temp = list.getFirstNode();
        while(temp != null){
            Employee emp = (Employee) temp.getInfo();
            if(emp.getGender() == 'F') {
                pw.println(emp.getFirstName());
            }
            temp = temp.getNext();
        }
        pw.println();
    }

    /**
     * Displays the first and last names and salary of all weekly
     * employees who make more than 35,000 per year and who have
     * been with the company for at least 5 years.
     */
    public void dispWeeklyEmployees(){
        pw.println("***** Employees (on Weekly payroll) with a "
                + "salary more than 35,000.00 per year and "
                + "have been working for at least 5 years: ");

        String format = "%-12s %-12s %12s";
        pw.println(String.format(format, "First Name",
                "Last Name", "Salary"));
        ObjectListNode temp = list.getFirstNode();
        while(temp != null){
            Employee emp = (Employee) temp.getInfo();
            if(emp.getRate() == 'W' && emp.getTenure() >= 5
                    && emp.getYearlySalary() > 35000) {
                pw.println(String.format(format, emp.getFirstName(),
                        emp.getLastName(),
                        Employee.dec.format(emp.getSalary()))
                );
            }
            temp = temp.getNext();
        }
        pw.println();
    }

    /**
     * This method takes an amount and a number of years and displays
     * the first and last names and salary of all weekly employees
     * who make more than that amount per year and who have been with
     * the company for at least that number of years.
     * @param amount double
     * @param years int
     */
    public void dispWeeklyEmployees(double amount, int years){
        pw.println("***** Employees (on Weekly payroll) with a "
                + "salary more than "+Employee.dec.format(amount)
                + " per year and have been working for at least "
                + years + " years: ");
        String format = "%-12s %-12s %12s";
        pw.println(String.format(format, "First Name",
                "Last Name", "Salary"));
        ObjectListNode temp = list.getFirstNode();
        while(temp != null){
            Employee emp = (Employee) temp.getInfo();
            if(emp.getRate() == 'W' && emp.getTenure() >= years
                    && emp.getYearlySalary() > amount) {
                pw.println(String.format(format, emp.getFirstName(),
                            emp.getLastName(),
                            Employee.dec.format(emp.getSalary()))
                            );
            }
            temp = temp.getNext();
        }
        pw.println();
    }

    /**
     * Gives a raise of $0.75 to all employees who are on an hourly
     * basis and make less than $10.00 per hour and also gives a
     * raise of $50.00 per week to all employees who are paid on a
     * weekly basis and make less than $350.00 per week. Then it
     * displays the first and last names and new salaries for each
     * employee on the payroll who has received a raise.
     */
    public void raiseToEmployeeSalaries(){
        pw.println("***** Giving a raise of $0.75 to all employees who are " +
                   "on an hourly basis and make less than $10.00 per hour " +
                   "and also a raise of $50.00 per week to all employees " +
                   "who are paid on a weekly basis and make less than " +
                   "$350.00 per week\n");

        pw.println("After the raise: ");

        String format = "%-12s %-12s %4s %12s";

        pw.println(String.format(format, "First Name",
                "Last Name", "Rate", "Salary"));

        ObjectListNode temp = list.getFirstNode();
        while(temp != null){
            Employee emp = (Employee) temp.getInfo();
            if(emp.getRate() == 'W' && emp.getSalary() < 350.00) {
                emp.giveRaise(50);
                pw.println(String.format(format, emp.getFirstName(),
                        emp.getLastName(), 'W',
                        Employee.dec.format(emp.getSalary()))
                );
            }
            else if(emp.getRate() == 'H' && emp.getSalary() < 10.00){
                emp.giveRaise(0.75);
                pw.println(String.format(format, emp.getFirstName(),
                        emp.getLastName(), 'H',
                        Employee.dec.format(emp.getSalary()))
                );
            }
            temp = temp.getNext();
        }
        pw.println();
    }

    /**
     * Sorts all the employees into alphabetical order according to
     * last name and print the first and last names and salaries
     * for each employee on the payroll.
     */
    public void sortEmployees(){
        pw.println("***** Sorting all the employees into alphabetical " +
                "order according to last name.\n");

        pw.println("After Sort: ");

        String format = "%-12s %-12s %12s";
        pw.println(String.format(format, "First Name",
                "Last Name", "Salary"));

        ObjectList sortedList = new ObjectList();

        while(!list.isEmpty()){
            Object ob = list.removeFirst();
            sortedList.insert(ob);
        }
        list = sortedList;

        ObjectListNode temp = list.getFirstNode();
        while(temp != null){
            Employee emp = (Employee) temp.getInfo();
            pw.println(String.format(format, emp.getFirstName(),
                                    emp.getLastName(),
                                    Employee.dec.format(emp.getSalary()))
                        );
            temp = temp.getNext();
        }
        pw.println();
    }

    /**
     * Reads hire information from a file and inserts each of the
     * new employees into the correct location in the sorted list
     * of the Employees and prints the first and last names of all
     * the employees on the payroll.
     * @throws IOException if there are file errors
     */
    public void hireEmployees() throws IOException{

        pw.println("\n***** Hiring new employees\n");
        Scanner sc = new Scanner(new File(hirefile));
        while(sc.hasNextLine()){
            String str[] = sc.nextLine().trim().split("\\s+");
            String fn = str[0];
            String ln = str[1];
            char    g = str[2].toUpperCase().charAt(0);
            int     t = Integer.parseInt(str[3]);
            char    r = str[4].toUpperCase().charAt(0);
            double  s = Double.parseDouble(str[5]);

            Employee emp = new Employee(fn, ln, g, t, r, s);

            list.insert(emp);
            numEmployees++;
        }

        pw.println("After hire:\n");
        String format = "%-12s %-12s";
        pw.println(String.format(format, "First Name","Last Name"));

        ObjectListNode temp = list.getFirstNode();
        while(temp != null){
            Employee emp = (Employee) temp.getInfo();
            pw.println(String.format(format, emp.getFirstName(),
                    emp.getLastName()));
            temp = temp.getNext();
        }
        pw.println();

    }

    /**
     * Reads fire information from a file and deletes those employees
     * from the sorted list of the Employees and prints the first and
     * last names of all the employees on the payroll.
     * @throws IOException if there are file errors
     */
    public void fireEmployees() throws IOException{
        pw.println("\n***** Firing two employees\n");
        Scanner sc = new Scanner(new File(firefile));
        while(sc.hasNextLine()){
            String str[] = sc.nextLine().trim().split("\\s+");
            String fn = str[0];
            String ln = str[1];
            char    g = str[2].toUpperCase().charAt(0);

            Employee emp = new Employee(fn, ln, g, 0, 'H', 0);

            list.remove(emp);
            numEmployees--;
        }

        pw.println("After fire:\n");
        String format = "%-12s %-12s";
        pw.println(String.format(format, "First Name","Last Name"));

        ObjectListNode temp = list.getFirstNode();
        while(temp != null){
            Employee emp = (Employee) temp.getInfo();
            pw.println(String.format(format, emp.getFirstName(),
                    emp.getLastName()));
            temp = temp.getNext();
        }
        pw.println();
    }

}
