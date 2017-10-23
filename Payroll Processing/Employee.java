import java.text.DecimalFormat;

/**
 * Employee class.
 * @author Aditi Datta
 */
public class Employee implements Comparable {

    public static String FMT = "%-12s   %-12s   %6s  %6s  " +
            "%4s  %12s";
    public static DecimalFormat dec = new DecimalFormat("#.00");

    private String firstName;
    private String lastName;
    private char gender;
    private int tenure;
    private char rate;
    private double salary;

    /**
     * Default constructor. Creates a new instance of Employee class
     * and initializes all the instance variables to its default values.
     */
    public Employee(){

    }

    /**
     * Creates a new instance of Employee class and initializes all the
     * instance variables to the values provided to it as arguments.
     * @param fn String First Name
     * @param ln String Last Name
     * @param g char Gender
     * @param t int Tenure
     * @param r char Rate
     * @param s double Salary
     */
    public Employee(String fn, String ln, char g, int t, char r, double s){
        firstName = fn;
        lastName  = ln;
        gender    = g;
        tenure    = t;
        rate      = r;
        salary    = s;
    }

    /**
     * Returns the firstName of an employee
     * @return String
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets the first name of the employee
     * @param firstName String
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Returns the last name of the employee
     * @return String
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets the last name of the employee
     * @param lastName String
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Returns the gender of the employee
     * @return char
     */
    public char getGender() {
        return gender;
    }

    /**
     * Sets the gender of the employee
     * @param gender char
     */
    public void setGender(char gender) {
        this.gender = gender;
    }

    /**
     * Returns the tenure of the employee
     * @return int
     */
    public int getTenure() {
        return tenure;
    }

    /**
     * Sets the tenure og the employee
     * @param tenure int
     */
    public void setTenure(int tenure) {
        this.tenure = tenure;
    }

    /**
     * Returns 'W' for the employees on weekly payroll or 'H' for
     * the employees on hourly payroll
     * @return char
     */
    public char getRate() {
        return rate;
    }

    /**
     * Sets rate to 'W' for the employees on weekly payroll or 'H'
     * for the employees on hourly payroll
     * @param rate char
     */
    public void setRate(char rate) {
        this.rate = rate;
    }

    /**
     * Returns the salary of the employee
     * @return double
     */
    public double getSalary() {
        return salary;
    }

    /**
     * Sets the salary field of the Employee object
     * @param salary double
     */
    public void setSalary(double salary) {
        this.salary = salary;
    }

    /**
     * Gives a raise to employee's salary
     * @param amount double raise amount
     */
    public void giveRaise(double amount){
        salary += amount;
    }
    /**
     * Returns hourly wage of the employee
     * @return double
     */
    public double getHourlySalary(){
        if(rate == 'H'){
            return salary;
        }else{
            return salary / 40;
        }
    }

    /**
     * Returns weekly wage of the employee
     * @return double
     */
    public double getWeeklySalary(){
        if(rate == 'W'){
            return salary;
        }else{
            return 40*salary;
        }
    }

    /**
     * Returns yearly wage of the employee
     * @return double
     */
    public double getYearlySalary(){
        if(rate == 'W'){
            return 52*salary;
        }else{
            return 40*52*salary;
        }
    }

    /**
     * Compares this object with the specified object for order.  Returns a
     * negative integer, zero, or a positive integer as this object is less
     * than, equal to, or greater than the specified object.
     *
     * @param o the object to be compared.
     * @return a negative integer, zero, or a positive integer as this object
     * is less than, equal to, or greater than the specified object.
     * @throws NullPointerException if the specified object is null
     * @throws ClassCastException   if the specified object's type prevents it
     *                              from being compared to this object.
     */
    @Override
    public int compareTo(Object o) throws NullPointerException,
                                            ClassCastException{
        if(o == null){
            throw new NullPointerException("Employee is being compared " +
                    "with a null object.");
        }

        if(!(o instanceof Employee)){
            throw new ClassCastException("[ERROR] An Employee object can" +
                    " only be compared to another object of Employee" +
                    " class.");
        }
        Employee otherEmp = (Employee) o;
        int res = this.getLastName().compareTo(otherEmp.getLastName());

        if(res > 0)
            return 1;
        else if(res < 0)
            return -1;
        else{
            res = this.getFirstName().compareTo(otherEmp.getFirstName());
            if(res > 0)
                return 1;
            else if(res < 0)
                return -1;
            else{
                if(this.getGender() > otherEmp.getGender())
                    return 1;
                else if(this.getGender() < otherEmp.getGender())
                    return -1;
                else
                    return 0;
            }
        }
    }

    /**
     * Converts all the employee info to a string format
     * @return String
     */
    @Override
    public String toString() {
        return String.format(FMT,firstName, lastName, gender,
                tenure, rate, dec.format(salary));
    }
}
