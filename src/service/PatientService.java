package service;

import advice.PatientNotPresentException;
import mode.Print;
import model.Patients;
import repository.PatientsRepository;

import java.util.HashMap;
import java.util.Map;

public class PatientService {
    PatientsRepository patientsRepository;
    Print print;

    public PatientService(Print print, PatientsRepository patientsRepository) {
        this.print=print;
        this.patientsRepository=patientsRepository;
    }

    public void registerPatient(Patients patients){
        patientsRepository.registerPatient(patients);
        print.printData(patients.getPatientName()+" register successfully");
    }
}
