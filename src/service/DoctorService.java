package service;

import mode.Print;
import model.Doctor;
import repository.DoctorRepository;

public class DoctorService {
    Print print;
    DoctorRepository doctorRepository;

    public DoctorService(Print print, DoctorRepository doctorRepository){
        this.print = print;
        this.doctorRepository = doctorRepository;
    }
    public void registerDoc(Doctor doctor){
        DoctorRepository doctorRepository=new DoctorRepository();
            doctorRepository.registerDoctor(doctor);
            print.printData("Welcome "+doctor.getDoctorName());
    }
}
