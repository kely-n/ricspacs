package controller;

import models.Appointment;

/**
 * The RadiologyAppointmentStatus class enables a clinician to create an appointment and follow up the appointment to see
 * its status.
 * This class also enables a radiographer to attach
 */
public class RadiologyAppointmentStatus {

    /**
     * methods adds an active appointment to the Radiology department. It does this by adding an appointment to the database
     * @param appointment contains details of the appointment
     * @return 1 is appointment is created successfully else 0
     */
    public static int placeAppointment(Appointment appointment){

        return 1;
    }

    /**
     * method returns the status of the appointment.
     * @param appointment is the appointment whose state is to be confirmed
     * @return if the appointment is in pending state, it returns 'pending', if appointment is being worked on,
     * it returns 'running' and if complete, it returns 'ready'
     */
    public static String checkAppointmentStatus(Appointment appointment){

        return "pending";
    }

    /**
     * method adds an imaging result from a radiographer to an appointment
     * @param appointment is the appointment to attached the imagingResult to
     * @param imagingResult is the path to the image from the radiographer
     * @return 1 if successful, else 0
     */
    public static int attachImagingResult(Appointment appointment, String imagingResult){

        return 1;
    }

    /**
     * method deletes an appointment saved in database already
     * @param appointment is the appointment to be deleted
     * @return
     */
    public static int deleteAppointment(Appointment appointment){

        return 1;
    }

    public static  int updateAppointment(Appointment appointment){

        return 1;
    }
}
