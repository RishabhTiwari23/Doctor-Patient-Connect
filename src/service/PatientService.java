package service;

import mode.Print;
import model.Patients;
import repository.PatientsRepository;

public class PatientService {
    PatientsRepository patientsRepository;
    Print print;

    public PatientService(Print print, PatientsRepository patientsRepository) {
        this.print=print;
        this.patientsRepository=patientsRepository;
    }

    public void registerPatient(Patients patients){
        patientsRepository.registerPatient(patients);
        print.printData(patients.getPatientName()+" registered successfully");
    }
}
