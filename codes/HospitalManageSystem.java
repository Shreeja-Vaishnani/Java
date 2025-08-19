import java.util.Scanner;

// Abstract class
abstract class Staff {
    String name;
    int id;

    Staff(String name, int id) {
        this.name = name;
        this.id = id;
    }

    abstract void work(); // Abstract method
}

// Abstract subclass
abstract class MedicalStaff extends Staff {
    MedicalStaff(String name, int id) {
        super(name, id);
    }
}

class Doctor extends MedicalStaff {
    String specialization;

    Doctor(String name, int id, String specialization) {
        super(name, id);
        this.specialization = specialization;
    }

    @Override
    void work() {
        System.out.println("Dr. " + name + " treats patients in " + specialization + " department.");
    }

    void prescribeMedicine() {
        System.out.println("Dr. " + name + " prescribes medicine.");
    }
}

class Nurse extends MedicalStaff {
    Nurse(String name, int id) {
        super(name, id);
    }

    @Override
    void work() {
        System.out.println("Nurse " + name + " assists doctors and takes care of patients.");
    }
}

class AdminStaff extends Staff {
    AdminStaff(String name, int id) {
        super(name, id);
    }

    @Override
    void work() {
        System.out.println("Admin Staff " + name + " manages hospital records and appointments.");
    }
}

// Final class
final class FinanceTeam extends Staff {
    FinanceTeam(String name, int id) {
        super(name, id);
    }

    @Override
    void work() {
        System.out.println("Finance Team member " + name + " manages hospital finances.");
    }
}

public class HospitalManageSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Doctor input
        System.out.print("Enter Doctor's Name: ");
        String dName = sc.nextLine();
        System.out.print("Enter Doctor's ID: ");
        int dId = sc.nextInt();
        sc.nextLine(); // consume newline
        System.out.print("Enter Specialization: ");
        String specialization = sc.nextLine();

        Staff s1 = new Doctor(dName, dId, specialization);

        // Nurse input
        System.out.print("\nEnter Nurse's Name: ");
        String nName = sc.nextLine();
        System.out.print("Enter Nurse's ID: ");
        int nId = sc.nextInt();
        sc.nextLine();

        Staff s2 = new Nurse(nName, nId);

        // AdminStaff input
        System.out.print("\nEnter Admin Staff's Name: ");
        String aName = sc.nextLine();
        System.out.print("Enter Admin Staff's ID: ");
        int aId = sc.nextInt();
        sc.nextLine();

        Staff s3 = new AdminStaff(aName, aId);

        // FinanceTeam input
        System.out.print("\nEnter Finance Member's Name: ");
        String fName = sc.nextLine();
        System.out.print("Enter Finance Member's ID: ");
        int fId = sc.nextInt();

        Staff s4 = new FinanceTeam(fName, fId);

        // Runtime polymorphism
        System.out.println("\n--- Staff Duties ---");
        s1.work();
        s2.work();
        s3.work();
        s4.work();

        // Downcasting
        System.out.println("\n--- Downcasting Example ---");
        if (s1 instanceof Doctor) {
            Doctor doc = (Doctor) s1;
            doc.prescribeMedicine();
        }

        System.out.println("\n--- Final Class Note ---");
        System.out.println("FinanceTeam is final and cannot be extended.");

        sc.close();
    }
}