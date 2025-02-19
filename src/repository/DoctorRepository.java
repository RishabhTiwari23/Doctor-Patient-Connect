package repository;

import advice.PatientNotPresentException;
import model.Doctor;
import model.Speciality;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DoctorRepository {
    Map<Integer, Doctor> doctors = new HashMap<>();
    Map<Speciality, List<Doctor>> doctorsForSpecialization = new HashMap<>();

    public void registerDoctor(Doctor doctor){
        if(doctors.containsKey(doctor.getDoctorId())){
            throw new PatientNotPresentException();
        }
        doctors.put(doctor.getDoctorId(), doctor);
        if(!doctorsForSpecialization.containsKey(doctor.getSpeciality())){
            doctorsForSpecialization.put(doctor.getSpeciality(), new ArrayList<>());
        }
        doctorsForSpecialization.get(doctor.getSpeciality()).add(doctor);
    }
}
