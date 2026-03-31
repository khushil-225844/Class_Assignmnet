import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileManager {
    private static final String FILE_NAME = "patients.txt";

    // SAVE: Must be public static to be seen by Main
    public static void savePatients(List<Patient> patients) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (Patient p : patients) {
                writer.write(p.getName() + "," + p.getAge() + "," + p.getDisease());
                writer.newLine();
            }
            System.out.println("Data saved successfully.");
        } catch (IOException e) {
            System.out.println("Error saving file: " + e.getMessage());
        }
    }

    // LOAD: Must be public static
    public static List<Patient> loadPatients() {
        List<Patient> patients = new ArrayList<>();
        File file = new File(FILE_NAME);
        if (!file.exists()) return patients;

        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 3) {
                    patients.add(new Patient(parts[0], Integer.parseInt(parts[1]), parts[2]));
                }
            }
        } catch (IOException e) {
            System.out.println("Error loading file.");
        }
        return patients;
    }

    public static void deleteAllData() {
        File file = new File(FILE_NAME);
        if (file.exists()) file.delete();
    }
}