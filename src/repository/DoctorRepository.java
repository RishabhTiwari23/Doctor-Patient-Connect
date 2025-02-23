package repository;

import advice.DoctorNotPresentException;
import advice.NoSpecializationPresentException;
import advice.PatientAlreadyPresentException;
import mode.Print;
import model.AvailableDoctors;
import model.Doctor;
import model.Speciality;
import model.TimeSlot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DoctorRepository {
    Map<Integer, Doctor> doctors = new HashMap<>();
    Map<Speciality, List<Doctor>> doctorsForSpecialization = new HashMap<>();
    AvailableDoctors availableDoctors=new AvailableDoctors();

    public void registerDoctor(Doctor doctor){
        if(doctors.containsKey(doctor.getDoctorId())){
            throw new PatientAlreadyPresentException();
        }
        doctors.put(doctor.getDoctorId(), doctor);

        if(!doctorsForSpecialization.containsKey(doctor.getSpeciality())){
            doctorsForSpecialization.put(doctor.getSpeciality(), new ArrayList<>());
        }
        doctorsForSpecialization.get(doctor.getSpeciality()).add(doctor);
    }
    public void addAvailability(Integer docId,TimeSlot timeSlot,HashMap<TimeSlot, Boolean> availableTimeSlot){
        if(!doctors.containsKey(docId)){
            throw new DoctorNotPresentException();
        }
        Doctor doctor=doctors.get(docId);
        availableTimeSlot.put(timeSlot,true);
        doctors.put(docId,doctor);
    }
    public List<Doctor> getDoctorsBySpeciality(Speciality specialization){
        if(!doctorsForSpecialization.containsKey(specialization)){
            throw new NoSpecializationPresentException();
        }
        return doctorsForSpecialization.get(specialization);
    }
    public List<AvailableDoctors> getAvailableTimeSlotsForAllDoctorsForSpecialization(List<Doctor> specializedDoctors) throws CloneNotSupportedException {
        List<AvailableDoctors> doctorsWithAvailableSlots = new ArrayList<>();
        for(Doctor doctor: specializedDoctors){
            availableDoctors.setDoctor(doctor);
            List<TimeSlot> aSlots = new ArrayList<>();
            HashMap<TimeSlot, Boolean> slots=doctor.getAvailability();
            for(Map.Entry<TimeSlot, Boolean> entry: slots.entrySet()){
                if(entry.getValue()){
                    aSlots.add(entry.getKey());
                }
            }
            availableDoctors.setAvailableSlots(aSlots);
            doctorsWithAvailableSlots.add(availableDoctors);
        }
        return doctorsWithAvailableSlots;
    }

    public Doctor getDoctorDetails(Integer doctorId) {
        return doctors.get(doctorId);
    }
}
