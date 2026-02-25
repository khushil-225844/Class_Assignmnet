public class Main {
    public static void main(String[] args) {

        Doctor d1 = new Doctor("Khushil", 24, 101);
        Nurse n1 = new Nurse("Vekaria", 30, 201);
        Patient p1 = new Patient("Dhruv", 22, "corona-14");

        d1.showDetails();
        d1.work();
        d1.treatPatient();
        System.out.println("Doctor Salary: " + d1.calculateSalary());

        System.out.println();

        n1.showDetails();
        n1.work();
        System.out.println("Nurse Salary: " + n1.calculateSalary());

        System.out.println();

        p1.showDetails();
    }
}