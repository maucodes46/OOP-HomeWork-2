class Employee {
    // Encapsulation: Private fields protect data access
    private String employeeId;
    private String name;
    private String email;
    private double baseSalary;

    // Parameterized constructor to initialize employee attributes
    public Employee(String employeeId, String name, String email, double baseSalary) {
        this.employeeId = employeeId;
        this.name = name;
        this.email = email;
        this.baseSalary = baseSalary;
    }

    // Returns the base salary of the employee
    public double calculatePay() {
        return baseSalary;
    }

    // Updates the employee's email address
    public void updateContactInfo(String newEmail) {
        this.email = newEmail;
        System.out.println("Email updated successfully for " + name);
    }

    // Returns a formatted string containing employee details
    public String getEmployeeDetails() {
         return "Employee ID: " + employeeId
                + "\nName: " + name
                + "\nEmail: " + email
                + "\nBase Salary: " + baseSalary;
    }
}
// Inheritance: Professor class inherits properties and methods from Employee
class Professor extends Employee {
    private String department;
    private int publicationsCount;
    private boolean isTenured;

    // Constructor using super() to initialize parent fields
    public Professor(String employeeId, String name,
                     String email, double baseSalary,
                     String department, int publicationsCount,
                     boolean isTenured) {
        super(employeeId, name, email, baseSalary);
        this.department = department;
        this.publicationsCount = publicationsCount;
        this.isTenured = isTenured;
    }

    // Simulates conducting a lecture for a specific course
    public void conductLectures(String courseName) {
         System.out.println("Teaching course: " + courseName);
    }

    // Increments the publication count when a paper is published
    public void publishPaper() {
        publicationsCount++;
        System.out.println("Paper Published!");
    }

    // Method Overriding: Modifies calculatePay to add a 10% bonus if tenured
    @Override 
    public double calculatePay() {
        if (isTenured) {
            return super.calculatePay() + (super.calculatePay() * 0.10);
        }
        return super.calculatePay();
    }
}
public class Main1 {
    public static void main(String[] args) {
        Professor P = new Professor("CP-1", "Maheen", "maheen@gmail.com",1200,"CPED", 0, false);
        System.out.println(P.getEmployeeDetails());
        P.publishPaper();
        System.out.println("Calculate Pay: "+P.calculatePay());

    }
}
