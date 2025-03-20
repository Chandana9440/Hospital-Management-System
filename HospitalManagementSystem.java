import java.util.*;

public class HospitalManagementSystem {

    private List<Patient> patients = new ArrayList<>();
    private List<Doctor> doctors = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        HospitalManagementSystem hms = new HospitalManagementSystem();
        hms.start();
    }

    public void start() {
        while (true) {
            System.out.println("\n---- Hospital Management System ----");
            System.out.println("1. Add Patient");
            System.out.println("2. View Patients");
            System.out.println("3. Delete Patient");
            System.out.println("4. Update Patient");
            System.out.println("5. Add Doctor");
            System.out.println("6. View Doctors"); 
            System.out.println("7. Delete Doctor");
            System.out.println("8. Update Doctor");
            System.out.println("9. Exit");
            System.out.print("Enter choice: ");
            try{
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    addPatient();
                    break;
                case 2:
                    viewPatients();
                    break;
                case 3:
                    deletePatientById();
                    break;
                case 4:
                    updatePatientById();
                    break;
                case 5:
                    addDoctor();
                    break;
                case 6:
                    viewDoctors();
                    break;
                    case 7:
                    deleteDoctorById();
                    break;
                case 8:
                    updateDoctorById();
                    break;
                case 9:
                    System.out.println("Exiting... Thank you!");
                    return;
                default:
                    System.out.println("Invalid choice. Try again!");
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid input! Please enter a number.");
            scanner.next(); // Clear invalid input
        }
        }
    }

    private void addPatient() {
        System.out.println("Enter Patient ID:");
        int id = scanner.nextInt();
        scanner.nextLine();  // Consume newline
        System.out.println("Enter Name:");
        String name = scanner.nextLine();
        System.out.println("Enter Age:");
        int age = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter Disease:");
        String disease = scanner.nextLine();
        Patient patient = new Patient(id, name, age, disease);
        patients.add(patient);
        System.out.println("Patient added successfully!");
    }

    private void viewPatients() {
        if (patients.isEmpty()) {
            System.out.println("No patients found.");
        } else {
            System.out.println("--- Patient List ---");
            for (Patient p : patients) {
                System.out.println(p);
            }
        }
    }
    private void deletePatientById() {
        System.out.println("Enter Patient ID to delete:");
        int id = scanner.nextInt();
        boolean found = false;
    
        for (Patient p : patients) {
            if (p.getPatientId() == id) {
                patients.remove(p);
                System.out.println("Patient with ID " + id + " deleted.");
                found = true;
                break;
            }
        }
    
        if (!found) {
            System.out.println("Patient with ID " + id + " not found.");
        }
    }
    private void updatePatientById() {
        System.out.println("Enter Patient ID to update:");
        int id = scanner.nextInt();
        boolean found = false;
    
        for (Patient p : patients) {
            if (p.getPatientId() == id) {
                scanner.nextLine(); // Consume newline
                System.out.println("Enter new name:");
                String name = scanner.nextLine();
                System.out.println("Enter new age:");
                int age = scanner.nextInt();
                scanner.nextLine();
                System.out.println("Enter new disease:");
                String disease = scanner.nextLine();
    
                p.setName(name);
                p.setAge(age);
                p.setDisease(disease);
    
                System.out.println("Patient updated successfully!");
                found = true;
                break;
            }
        }
    
        if (!found) {
            System.out.println("Patient with ID " + id + " not found.");
        }
    }
    
    private void addDoctor() {
        System.out.println("Enter Doctor ID:");
        int id = scanner.nextInt();
        scanner.nextLine();  // Consume newline
        System.out.println("Enter Name:");
        String name = scanner.nextLine();
        System.out.println("Enter Specialization:");
        String specialization = scanner.nextLine();

        Doctor doctor = new Doctor(id, name, specialization);
        doctors.add(doctor);
        System.out.println("Doctor added successfully!");
    }

    private void viewDoctors() {
        if (doctors.isEmpty()) {
            System.out.println("No doctors found.");
        } else {
            System.out.println("--- Doctor List ---");
            for (Doctor d : doctors) {
                System.out.println(d);
            }
        }
    }
    private void deleteDoctorById() {
        System.out.println("Enter Doctor ID to delete:");
        int id = scanner.nextInt();
        boolean found = false;
    
        for (Doctor d : doctors) {
            if (d.getDoctorId() == id) {
                doctors.remove(d);
                System.out.println("Doctor with ID " + id + " deleted.");
                found = true;
                break;
            }
        }
    
        if (!found) {
            System.out.println("Doctor with ID " + id + " not found.");
        }
    }
    private void updateDoctorById() {
        System.out.println("Enter Doctor ID to update:");
        int id = scanner.nextInt();
        boolean found = false;
    
        for (Doctor d : doctors) {
            if (d.getDoctorId() == id) {
                scanner.nextLine(); // consume newline
                System.out.println("Enter new name:");
                String name = scanner.nextLine();
                System.out.println("Enter new specialization:");
                String specialization = scanner.nextLine();
    
                d.setName(name);
                d.setSpecialization(specialization);
    
                System.out.println("Doctor updated successfully!");
                found = true;
                break;
            }
        }
    
        if (!found) {
            System.out.println("Doctor with ID " + id + " not found.");
        }
    }    
    
}
