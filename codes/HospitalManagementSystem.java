// Abstract class: Cannot be instantiated
abstract class Staff {
    String name;
    int id;

    Staff(String name, int id) {
        this.name = name;
        this.id = id;
    }

    abstract void work(); // Abstract method
}

// Abstract subclass for Medical Staff
abstract class MedicalStaff extends Staff {
    MedicalStaff(String name, int id) {
        super(name, id);
    }
}

// Doctor class inherits from MedicalStaff
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

// Nurse class inherits from MedicalStaff
class Nurse extends MedicalStaff {
    Nurse(String name, int id) {
        super(name, id);
    }

    @Override
    void work() {
        System.out.println("Nurse " + name + " assists doctors and takes care of patients.");
    }
}

// Administrative staff class
class AdminStaff extends Staff {
    AdminStaff(String name, int id) {
        super(name, id);
    }

    @Override
    void work() {
        System.out.println("Admin Staff " + name + " manages hospital records and appointments.");
    }
}

// Final class: Cannot be extended further
final class FinanceTeam extends Staff {
    FinanceTeam(String name, int id) {
        super(name, id);
    }

    @Override
    void work() {
        System.out.println("Finance Team member " + name + " manages hospital finances.");
    }
}

// Main class
public class HospitalManagementSystem {
    public static void main(String[] args) {

        // Runtime Polymorphism using upcasting
        Staff s1 = new Doctor("shreeja", 1, "Cardiology");
        Staff s2 = new Nurse("vishwa", 2);
        Staff s3 = new AdminStaff("pratham", 3);
        Staff s4 = new FinanceTeam("ridham", 4);

        // All calls will go to the overridden version
        s1.work();
        s2.work();
        s3.work();
        s4.work();

        System.out.println("\n--- Downcasting Example ---");

        // Downcasting s1 (which is a Doctor) back to Doctor type
        if (s1 instanceof Doctor) {
            Doctor doc = (Doctor) s1; // Downcasting
            doc.prescribeMedicine(); // Accessing subclass specific method
        }

        System.out.println("\n--- Attempt to Inherit Final Class (Invalid) ---");
        System.out.println("FinanceTeam is final and cannot be extended.");

        // Trying to instantiate abstract class will cause error (uncomment to test)
        // Staff staff = new Staff("Test", 999); // Error
    }
}
