import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Use a List (Collection) to manage multiple Patient objects [cite: 771, 775]
        // Unlike arrays, ArrayLists can resize dynamically as you add data [cite: 779, 783]
        List<Patient> patientList = FileManager.loadPatients();
        
        Doctor d1 = new Doctor("Khushil", 24, 101);
        Nurse n1 = new Nurse("Vekaria", 30, 201);
        Scanner scanner = new Scanner(System.in);
        
        String choice; // Declare variable once outside the loop to avoid "duplicate" errors 
        boolean running = true;

        while (running) {
            System.out.println("\n=== Hospital Management System ===");
            System.out.println("1. Register New Patient");
            System.out.println("2. View All Patients");
            System.out.println("3. Save and Exit");
            System.out.println("4. Delete All Data (Reset System)");
            System.out.print("Select an option: ");
            
            choice = scanner.nextLine(); // Assign value to the existing 'choice' variable

            switch (choice) {
                case "1":
                    try {
                        System.out.print("Enter Patient Name: ");
                        String name = scanner.nextLine();
                        // Validation logic to prevent numbers in names [cite: 31, 933]
                        if (name.matches(".*\\d.*") || name.trim().isEmpty()) {
                            throw new IllegalArgumentException("Name cannot be empty or contain numbers.");
                        }

                        System.out.print("Enter Patient Age: ");
                        int age = Integer.parseInt(scanner.nextLine()); 
                        if (age < 0) throw new IllegalArgumentException("Age cannot be negative.");

                        System.out.print("Enter Patient Disease: ");
                        String disease = scanner.nextLine();

                        Patient newPatient = new Patient(name, age, disease);
                        patientList.add(newPatient); // Add the new object to the ArrayList [cite: 805]
                        System.out.println("Registration Successful!");
                        
                    } catch (Exception e) {
                        // Catching errors like non-numeric input for age [cite: 89, 95]
                        System.out.println("SYSTEM ERROR: " + e.getMessage());
                    }
                    break;

                case "2":
                    System.out.println("\n--- Current Patient List ---");
                    if (patientList.isEmpty()) {
                        System.out.println("No patients registered.");
                    } else {
                        // Use a for-each loop to iterate through the Collection [cite: 852, 856]
                        for (Patient p : patientList) {
                            p.showDetails();
                            System.out.println("--------------------");
                        }
                    }
                    break;

                case "3":
                    // Persist data to the file before closing the program [cite: 608, 755]
                    FileManager.savePatients(patientList);
                    running = false;
                    break;

                case "4":
                    System.out.print("WARNING: This will erase all records. Type 'YES' to confirm: ");
                    // You MUST read the line here to initialize the 'confirmation' variable
                    String confirmation = scanner.nextLine();
                    
                    if (confirmation.equalsIgnoreCase("YES")) {
                        // 1. Clear the ArrayList in RAM [cite: 782]
                        patientList.clear(); 
                        
                        // 2. Delete the actual file from the disk [cite: 696, 699]
                        FileManager.deleteAllData(); 
                        
                        System.out.println("All data has been wiped.");
                    } else {
                        System.out.println("Deletion cancelled.");
                    }
                    break;

                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
        // Always close resources like Scanner to prevent memory leaks 
        scanner.close(); 
        System.out.println("System Closed.");
    }
}