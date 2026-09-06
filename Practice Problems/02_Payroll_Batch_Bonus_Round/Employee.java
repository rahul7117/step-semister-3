public class Employee {
    String empId;
    String empName;
    double salary;

    Employee(String empId, String empName, double salary) {
        this.empId = empId;
        this.empName = empName;
        this.salary = salary;
    }

    void raiseSalary(double salary) {
        this.salary += salary;
    }

    public static void main(String[] args) {
        Employee[] employees = {
            new Employee("E-101", "Divya", 40000),
            new Employee("E-102", "Arjun", 55000),
            new Employee("E-103", "Priya", 62000),
            new Employee("E-104", "Ravi", 48000)
        };

        for (Employee employee : employees) {
            employee.raiseSalary(5000);
            System.out.println(employee.empId + " | Final Salary: Rs " + employee.salary);
        }
    }
}
