import java.util.*;

public class prac2 {
    int id;
    String name;
    ArrayList<Course> courses = new ArrayList<>();

    // Inner class
    class Course {
        String courseName;

        Course(String courseName) {
            this.courseName = courseName;
        }

        public String toString() {
            return courseName;
        }
    }

    prac2(int id, String name) {
        this.id = id;
        this.name = name;
    }

    void addCourse(String cname) {
        Course c = new Course(cname);
        courses.add(c);
    }

    // Method-local inner class
    void enrollSemester(int sem) {
        class Semester {
            int semNumber;

            Semester(int semNumber) {
                this.semNumber = semNumber;
            }

            void show() {
                System.out.println("Enrolled in Semester " + semNumber);
            }
        }

        Semester s = new Semester(sem);
        s.show();
    }

    // Anonymous inner class
    void checkScholarship() {
        Scholarship sch = new Scholarship() {
            public boolean isEligible(prac2 s) {
                return s.courses.size() >= 2; // Example: eligible if at least 2 courses
            }
        };

        if (sch.isEligible(this)) {
            System.out.println(name + " is eligible for scholarship.");
        } else {
            System.out.println(name + " is not eligible for scholarship.");
        }
    }

    // Override equals
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof prac2)) return false;
        prac2 s = (prac2) obj;
        return this.id == s.id && this.name.equals(s.name);
    }

    // Override hashCode
    public int hashCode() {
        return Objects.hash(id, name);
    }

    // Override toString
    public String toString() {
        return "Student[id=" + id + ", name=" + name + ", courses=" + courses + "]";
    }

    // Interface for scholarship
    interface Scholarship {
        boolean isEligible(prac2 s);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Student ID
        System.out.print("Enter student ID: ");
        while (!sc.hasNextInt()) {
            System.out.print("Invalid input! Enter an integer: ");
            sc.next();
        }
        int id = sc.nextInt();
        sc.nextLine();

        // Student name
        System.out.print("Enter student name: ");
        String name = sc.nextLine();

        prac2 s = new prac2(id, name);

        // Number of courses
        System.out.print("Enter number of courses: ");
        while (!sc.hasNextInt()) {
            System.out.print("Invalid input! Enter an integer: ");
            sc.next();
        }
        int n = sc.nextInt();
        sc.nextLine();

        // Course names
        for (int i = 0; i < n; i++) {
            System.out.print("Enter course name: ");
            String cname = sc.nextLine();
            s.addCourse(cname);
        }

        // Semester number
        System.out.print("Enter semester number: ");
        while (!sc.hasNextInt()) {
            System.out.print("Invalid input! Enter an integer: ");
            sc.next();
        }
        int sem = sc.nextInt();

        s.enrollSemester(sem);
        s.checkScholarship();

        System.out.println("\nStudent Details:");
        System.out.println(s);

        sc.close();
    }
}
