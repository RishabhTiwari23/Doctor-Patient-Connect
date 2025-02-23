package repository;

import advice.PatientAlreadyPresentException;
import model.AvailableDoctors;
import model.Doctor;
import model.Patients;
import model.Speciality;

import java.util.HashMap;
import java.util.Map;

public class PatientsRepository {

    Map<Integer,Patients> patientsMap=new HashMap<>();

    public void registerPatient(Patients patients){
        if(patientsMap.containsKey(patients.getPatientId())){
            throw new PatientAlreadyPresentException();
        }
        patientsMap.put(patients.getPatientId(),patients);
    }

    public boolean isPatientRegistered(Integer patientId){
        return patientsMap.containsKey(patientId);
    }
}
