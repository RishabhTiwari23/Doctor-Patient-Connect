package model;

import java.util.HashMap;
import java.util.Objects;

public class Doctor {
    Integer doctorId;
    String doctorName;
    HashMap<TimeSlot,Boolean> availability;
    Speciality speciality;

    public <V, K> Doctor(int doctorId, String doctorName, HashMap<TimeSlot,Boolean> availability, Speciality speciality) {
        this.doctorId=doctorId;
        this.doctorName=doctorName;
        this.availability=availability;
        this.speciality=speciality;
    }

    public Integer getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(Integer doctorId) {
        this.doctorId = doctorId;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Doctor doctor = (Doctor) o;
        return Objects.equals(doctorId, doctor.doctorId) && Objects.equals(doctorName, doctor.doctorName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(doctorId, doctorName);
    }


    public HashMap<TimeSlot, Boolean> getAvailability() {
        return availability;
    }

    public void setAvailability(HashMap<TimeSlot, Boolean> availability) {
        this.availability = availability;
    }

    public Speciality getSpeciality() {
        return speciality;
    }

    public void setSpeciality(Speciality speciality) {
        this.speciality = speciality;
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "doctorId=" + doctorId +
                ", doctorName='" + doctorName + '\'' +
                ", availability=" + availability +
                ", speciality=" + speciality +
                '}';
    }
}
