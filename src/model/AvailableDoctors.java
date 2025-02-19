package model;

import java.util.List;

public class AvailableDoctors {
    Doctor doctor;
    List<TimeSlot> availableSlots;
    Speciality speciality;

    public Speciality getSpeciality() {
        return speciality;
    }
    public void setSpeciality(Speciality speciality) {
        this.speciality = speciality;
    }
    public Doctor getDoctor() {
        return doctor;
    }
    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }
    public List<TimeSlot> getAvailableSlots() {
        return availableSlots;
    }
    public void setAvailableSlots(List<TimeSlot> availableSlots) {
        this.availableSlots = availableSlots;
    }
}
