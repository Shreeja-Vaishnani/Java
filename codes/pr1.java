import java.util.Scanner;

class Employee
{
    int id;
    String name;
    String deptname;
    int salary;

    public Employee(int id, String name, String deptname, int salary)
    {
        this.id = id;
        this.name = name;
        this.deptname = deptname;
        this.salary = salary;
    }

    public String toString()
    {
        return "ID: " + id + '\n' +
               "Name: " + name + '\n' +
               "DeptName: " + deptname + '\n' +
               "Salary: " + salary;
    }
}

public class pr1
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        int n = 2; // You can change this value or take from user if needed

        Employee[] emp = new Employee[n];

        for (int i = 0; i < n; i++)
        {
            System.out.println("Enter ID:");
            int id = sc.nextInt();
            sc.nextLine(); // consume leftover newline

            System.out.println("Enter Name:");
            String name = sc.nextLine();

            System.out.println("Enter DeptName:");
            String deptname = sc.nextLine();

            System.out.println("Enter Salary:");
            int salary = sc.nextInt();
            sc.nextLine(); // consume leftover newline

            emp[i] = new Employee(id, name, deptname, salary);
        }

        // Print employee details
        for (int i = 0; i < n; i++)
        {
            System.out.println("\nEmployee " + (i + 1) + " details:");
            System.out.println(emp[i]);
        }

        sc.close();
    }
}
