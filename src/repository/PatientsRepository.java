package repository;

import advice.PatientNotPresentException;
import model.Patients;

import java.util.HashMap;
import java.util.Map;

public class PatientsRepository {

    Map<Integer,Patients> patientsMap=new HashMap<>();

    public void registerPatient(Patients patients){
        if(patientsMap.containsKey(patients.getPatientId())){
            throw new PatientNotPresentException();
        }
        patientsMap.put(patients.getPatientId(),patients);
    }

    public boolean isPatientRegistered(Integer patientId){
        return patientsMap.containsKey(patientId);
    }
}
