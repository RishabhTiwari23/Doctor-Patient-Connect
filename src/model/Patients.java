package model;

import java.util.HashMap;
import java.util.List;
import java.util.Objects;

public class Patients {
    Integer patientId;
    String patientName;
    HashMap<Doctor, List<TimeSlot>> bookedSlots;

    public Integer getPatientId() {
        return patientId;
    }

    public void setPatientId(Integer patientId) {
        this.patientId = patientId;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public HashMap<Doctor, List<TimeSlot>> getBookedSlots() {
        return bookedSlots;
    }

    public void setBookedSlots(HashMap<Doctor, List<TimeSlot>> bookedSlots) {
        this.bookedSlots = bookedSlots;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Patients patients = (Patients) o;
        return Objects.equals(patientId, patients.patientId) && Objects.equals(patientName, patients.patientName) && Objects.equals(bookedSlots, patients.bookedSlots);
    }

    @Override
    public int hashCode() {
        return Objects.hash(patientId, patientName, bookedSlots);
    }

    @Override
    public String toString() {
        return "Patients{" +
                "patientId=" + patientId +
                ", patientName=" + patientName +
                ", bookedSlots=" + bookedSlots +
                '}';
    }
}
