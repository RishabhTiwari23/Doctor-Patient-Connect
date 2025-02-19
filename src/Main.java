import mode.ConsolePrint;
import mode.Print;
import model.Doctor;
import model.Speciality;
import repository.DoctorRepository;
import repository.PatientsRepository;
import service.DoctorService;
import service.PatientService;

import java.util.HashMap;

public class Main {
    public static void main(String[] args){
        Print print = new ConsolePrint();
        PatientsRepository patientsRepository=new PatientsRepository();
        DoctorRepository doctorRepository=new DoctorRepository();
        DoctorService doctorService=new DoctorService(print,doctorRepository);
        PatientService patientService = new PatientService(print,patientsRepository);

        // Doctors
        Doctor doctorCurious = new Doctor(1, "curious",new HashMap<>(), Speciality.Cardiologist);
        Doctor doctorDreadful = new Doctor(2, "Dreadful",new HashMap<>(), Speciality.Dermatologist);
        Doctor doctorDaring = new Doctor(3, "Daring",new HashMap<>(), Speciality.Dermatologist);

        doctorService.registerDoc(doctorCurious);
    }
}