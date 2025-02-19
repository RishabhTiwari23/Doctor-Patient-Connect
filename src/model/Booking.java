package model;

public class Booking {
    Integer bookingId;
    Doctor doctor;
    Patients patient;
    TimeSlot slot;
    Boolean waitList;

    public Integer getBookingId() {
        return bookingId;
    }

    public void setBookingId(Integer bookingId) {
        this.bookingId = bookingId;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Patients getPatient() {
        return patient;
    }

    public void setPatient(Patients patient) {
        this.patient = patient;
    }

    public TimeSlot getSlot() {
        return slot;
    }

    public void setSlot(TimeSlot slot) {
        this.slot = slot;
    }

    public Boolean getWaitList() {
        return waitList;
    }

    public void setWaitList(Boolean waitList) {
        this.waitList = waitList;
    }
}
