public class Doctor extends Employee implements Payable, Treatable {

    public Doctor(String name, int age, int employeeId) {
        super(name, age, employeeId);
    }

    @Override
    public void work() {
        System.out.println("Doctor is examining patients.");
    }

    @Override
    public void treatPatient() {
        System.out.println("Doctor is treating the patient.");
    }

    @Override
    public double calculateSalary() {
        return 50000;
    }

    @Override
    public void showDetails() {
        System.out.println("Doctor Name: " + getName());
    }
}