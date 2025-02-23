import mode.ConsolePrint;
import mode.Print;
import model.*;
import repository.DoctorRepository;
import repository.PatientsRepository;
import service.DoctorService;
import service.PatientService;

import java.util.*;

public class Main {
    public static void main(String[] args) throws CloneNotSupportedException {
        Print print = new ConsolePrint();
        PatientsRepository patientsRepository = new PatientsRepository();
        DoctorRepository doctorRepository=new DoctorRepository();
        DoctorService doctorService = new DoctorService(print,doctorRepository);
        PatientService patientService = new PatientService(print, patientsRepository);
        // Doctors
        Scanner sc = new Scanner(System.in);

        Doctor doctor = getTheDoctorDetails(sc);

        doctorService.registerDoc(doctor);
        System.out.print("addAvailability: ");
        doctorService.addAvailability(doctor.getDoctorId(),sc.nextLine());
        //Patient
        System.out.print("showAvailBySpeciality: ");
        doctorService.showAvailableSlotsBySpeciality(Speciality.valueOf(sc.nextLine()));
    }

    public static Doctor getTheDoctorDetails(Scanner sc) {
        Doctor doctor=new Doctor();
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
                availableTimeSlot.put(timeSlot,true);
            } catch (Exception e) {
                System.out.println("Invalid format! Please enter in HH:mm-HH:mm format (30-minute intervals).");
            }
        }
        return new Doctor(id, name, availableTimeSlot, speciality);
    }
//    public static Patients getThePatientsDetails(Scanner sc){
//        System.out.print("Enter Patient ID: ");
//        int id = sc.nextInt();
//        sc.nextLine();
//        // Consume newline
//        System.out.println("Enter Patient name: ");
//        String name = sc.nextLine();
//        HashMap<Doctor, List<TimeSlot>> bookSlot=new HashMap<>();
//
//
//    }
}