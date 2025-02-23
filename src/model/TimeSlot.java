package model;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class TimeSlot {
    private LocalTime startTime;
    private LocalTime endTime;
    private static final DateTimeFormatter FORMATTER=DateTimeFormatter.ofPattern("HH:mm");

    //Constructor
    public TimeSlot(LocalTime startTime,LocalTime endTime){
        if(!startTime.plusMinutes(30).equals(endTime)){
            throw new IllegalArgumentException("Time slot should be of 30 mins");
        }
        this.startTime=startTime;
        this.endTime=endTime;
    }

    public TimeSlot() {
    }

    //Parsing input String (HH:MM-HH:MM) to Datetime format/TimeSlot Object.
    public static TimeSlot parse(String timeRange){
        String[] times=timeRange.split("-");
        if(times.length!=2) throw new IllegalArgumentException("Invalid time format! Use HH:mm-HH:mm");

        LocalTime start=LocalTime.parse(times[0].trim(),FORMATTER); //converting input to required format
        LocalTime end=LocalTime.parse(times[1].trim(),FORMATTER); //converting input to required format

        return new TimeSlot(start,end);
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }
    public LocalTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TimeSlot timeSlot = (TimeSlot) o;
        return Objects.equals(startTime, timeSlot.startTime) && Objects.equals(endTime, timeSlot.endTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(startTime, endTime);
    }

    @Override
    public String toString() {
        return "TimeSlot{" +
                "startTime=" + startTime +
                ", endTime=" + endTime +
                '}';
    }
}
