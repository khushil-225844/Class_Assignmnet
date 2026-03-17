import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        

        Doctor d1 = new Doctor("Khushil", 24, 101);
        Nurse n1 = new Nurse("Vekaria", 30, 201);

        Scanner scanner = new Scanner(System.in);
        
        System.out.println("=== Hospital Management System ===");
        System.out.println("Please enter the new Patient's details below.\n");

        try {
            // 1. here i have put dynamic imputs
            System.out.print("Enter Patient Name: ");
            String name = scanner.nextLine();

            // this part makes sure there is no numbres or blank
            if (name.matches(".*\\d.*") || name.trim().isEmpty()) {
                throw new IllegalArgumentException("Name cannot be empty or contain numbers.");
            }

            System.out.print("Enter Patient Age: ");
            String ageInput = scanner.nextLine();
            int age = Integer.parseInt(ageInput); 

            // this makes sure age is not negatuve
            if (age < 0) {
                throw new IllegalArgumentException("Age cannot be negative or blank.");
            }

            System.out.print("Enter Patient Disease: ");
            String disease = scanner.nextLine();

            // if all works we com here
            System.out.println("\n--- Processing Registration ---");
            Patient newPatient = new Patient(name, age, disease);
            newPatient.showDetails();
            System.out.println("Registration Successful!");

            // 2. Display Doctor and Nurse details ONLY if registration succeeded
            System.out.println("\n--- Assigned Medical Staff ---");
            d1.showDetails();
            d1.work();
            d1.treatPatient();
            System.out.println("Doctor Salary: " + d1.calculateSalary());

            System.out.println();

            n1.showDetails();
            n1.work();
            System.out.println("Nurse Salary: " + n1.calculateSalary());

        } catch (NumberFormatException e) {
            // Exception Handling: Catches text entered instead of numbers
            System.out.println("\nSYSTEM ERROR: You entered text or space where a number was expected for the age.");
        } catch (IllegalArgumentException e) {
            // Exception Handling: Catches negative ages or numbers in the name
            System.out.println("\nSYSTEM ERROR: " + e.getMessage());
        } finally {
            // Exception Handling: Always runs to close resources securely
            System.out.println("\nSuccecfull yeahhhk.");
            scanner.close();
        }
    }
}