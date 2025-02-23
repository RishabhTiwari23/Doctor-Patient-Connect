This is a starting of me creating a Doctor-Pateint App. 
It's current scope is limited to the following points
2.1 A new doctor should be able to register, and mention his/her speciality among (Cardiologist, Dermatologist, Orthopedic, General Physician)
2.2 A doctor should be able to declare his/her availability in each slot for the day. For example, the slots will be of 30 mins like 9am-9.30am, 9.30am-10am..
2.3 Patients should be able to register. Patients should be able to search available slots based on speciality.  
2.4 The slots should be displayed in a ranked fashion. Default ranking strategy should be to rank by start time. But we should be able to plugin more strategies like Doctor’s rating etc in future.
2.5 Patients should be able to book appointments with a doctor for an available slot.A patient can book multiple appointments in a day.  A patient cannot book two appointments with two different doctors in the same time slot.
2.6 Patients can also cancel an appointment, in which case that slot becomes available for someone else to book.
2.7 Build a waitlist feature:
   * If the patient wishes to book a slot for a particular doctor that is already booked, then add this patient to the waitlist.
   * If the patient with whom the appointment was booked originally cancels the appointment, then the first in the waitlist gets the appointment.
2.8 A patient/doctor should be able to view his/her booked appointments for the day.
