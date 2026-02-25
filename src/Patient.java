public class Patient extends Person {

    private String disease;

    public Patient(String name, int age, String disease) {
        super(name, age);
        this.disease = disease;
    }

    public String getDisease() {
        return disease;
    }

    @Override
    public void showDetails() {
        System.out.println("Patient Name: " + getName());
        System.out.println("Disease: " + disease);
    }
}