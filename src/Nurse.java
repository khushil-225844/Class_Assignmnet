public class Nurse extends Employee implements Payable {

    public Nurse(String name, int age, int employeeId) {
        super(name, age, employeeId);
    }

    @Override
    public void work() {
        System.out.println("Nurse is assisting the doctor.");
    }

    @Override
    public double calculateSalary() {
        return 30000;
    }

    @Override
    public void showDetails() {
        System.out.println("Nurse Name: " + getName());
    }
}