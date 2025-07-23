import java.util.Scanner;

class Student {
    int rollNo;
    String name;
    int[] marks = new int[3];
    int total;
    float average;

    void inputDetails() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Roll Number: ");
        rollNo = sc.nextInt();
        sc.nextLine(); // consume newline

        System.out.print("Enter Name: ");
        name = sc.nextLine();

        for (int i = 0; i < 3; i++) {
            System.out.print("Enter marks for subject " + (i + 1) + ": ");
            marks[i] = sc.nextInt();
            total += marks[i];
        }

        average = total / 3.0f;
    }

    void displayDetails() {
        System.out.println("\n--- Student Details ---");
        System.out.println("Roll Number: " + rollNo);
        System.out.println("Name: " + name);
        for (int i = 0; i < 3; i++) {
            System.out.println("Marks in subject " + (i + 1) + ": " + marks[i]);
        }
        System.out.println("Total Marks: " + total);
        System.out.println("Average Marks: " + average);
    }
}

public class StudentDetails {
    public static void main(String[] args) {
        Student s = new Student();
        s.inputDetails();
        s.displayDetails();
    }
}
