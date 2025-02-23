package service;

import advice.SlotException;
import jdk.jshell.execution.Util;
import mode.Print;
import model.AvailableDoctors;
import model.Doctor;
import model.Speciality;
import model.TimeSlot;
import repository.DoctorRepository;
import util.utils;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.List;

public class DoctorService {
    Print print;
    DoctorRepository doctorRepository;

    public DoctorService(Print print,DoctorRepository doctorRepository){
        this.print = print;
        this.doctorRepository=doctorRepository;
    }

    public void registerDoc(Doctor doctor){
            doctorRepository.registerDoctor(doctor);
            print.printData("Welcome "+doctor.getDoctorName());
    }
    public void addAvailability(Integer doctorId, String timeSlot){
        TimeSlot parse = TimeSlot.parse(timeSlot);
        // Check Slot 30 mins
        if(ChronoUnit.MINUTES.between(parse.getStartTime(),parse.getEndTime())%60 == 30){
            doctorRepository.addAvailability(doctorId,parse);
            print.printData("Done Doc!");
        } else {
            throw new SlotException(
                    "Sorry"+doctorRepository.getDoctorDetails(doctorId).getDoctorName() +" slots are 30 mins only"
            );
        }

    }
    public void showAvailableSlotsBySpeciality(Speciality specialization) throws CloneNotSupportedException {
        List<Doctor> doctorsBySpeciality = doctorRepository.getDoctorsBySpeciality(specialization);
        List<AvailableDoctors> availableTimeSlots = doctorRepository.getAvailableTimeSlotsForAllDoctorsForSpecialization(doctorsBySpeciality);
        if(availableTimeSlots.size() > 0){
            print.printData("Available Doctors With time Slots");
            for(AvailableDoctors doctor: availableTimeSlots){
                for(TimeSlot slot: doctor.getAvailableSlots()){
                    print.printData(doctor.getDoctor().getDoctorName()+" "+slot.getStartTime()+" - "+slot.getEndTime());
                }
            }
        } else {
            print.printData("No slots available");
        }
    }
}
