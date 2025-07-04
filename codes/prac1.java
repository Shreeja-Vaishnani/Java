
import java.util.Scanner;

class employee
{
int id;
String name;
String deptname;
int salary;

public employee(int id,String name,String deptname,int salary)
{
    this.id=id;
    this.name=name;
    this.deptname=deptname;
    this.salary=salary;
}

 public String toString()
 {
     return"ID:"+id+'\n'+"Name:"+name+'\n'+"DeptName:"+deptname+'\n'+"Salary:"+salary;
 }
}
public class prac1{   

public static void main(String[] args) {

    
    int n=2;
    for (int i=0;i<n;i++)
    {
        Scanner sc=new Scanner(System.in);
       System.out.println("Enter ID:");
    int id = sc.nextInt();
     System.out.println("Enter Name:");
    String name = sc.next();
     System.out.println("Enter DeptName:");
    String deptname = sc.next();
     System.out.println("Enter Salary:");
    int salary = sc.nextInt();
     emp[i] = new Employee(id, name, deptname, salary);
   
    }
    for (int i = 0; i < n; i++)
        {
            System.out.println("\nEmployee " + (i + 1) + " details:");
            System.out.println(employee[i]);
        }
}
}
