import mode.ConsolePrint;
import mode.Print;
import model.Doctor;
import model.Speciality;
import model.TimeSlot;
import repository.DoctorRepository;
import repository.PatientsRepository;
import service.DoctorService;
import service.PatientService;

import javax.print.Doc;
import java.sql.Time;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Print print = new ConsolePrint();
        PatientsRepository patientsRepository = new PatientsRepository();
        DoctorRepository doctorRepository = new DoctorRepository();
        DoctorService doctorService = new DoctorService(print, doctorRepository);
        PatientService patientService = new PatientService(print, patientsRepository);

        // Doctors
        Scanner sc = new Scanner(System.in);

        Doctor doctor = getTheDoctorDetails(sc);

        doctorService.registerDoc(doctor);
    }

    public static Doctor getTheDoctorDetails(Scanner sc) {
        System.out.print("Enter Doctor ID: ");
        int id = sc.nextInt();
        sc.nextLine();
        // Consume newline
        System.out.println("Enter Doctor name: ");
        String name = sc.nextLine();
        System.out.println("Enter Speciality (Cardiologist/Dermatologist/Other): ");
        Speciality speciality = Speciality.valueOf(sc.nextLine());
        HashMap<TimeSlot, Boolean> availableTimeSlot = new HashMap<>();
        System.out.println("Enter available time slots (e.g., 09:00-09:30), type 'done' to finish:");
        while (true) {
            String timeInput = sc.nextLine();
            if (timeInput.equalsIgnoreCase("done")) break;
            try {
                TimeSlot timeSlot = TimeSlot.parse(timeInput);
                availableTimeSlot.put(timeSlot, true);
            } catch (Exception e) {
                System.out.println("Invalid format! Please enter in HH:mm-HH:mm format (30-minute intervals).");
            }
        }
        return new Doctor(id, name, availableTimeSlot, speciality);
    }
}