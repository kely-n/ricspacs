package controller;

import models.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

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
        DbConnection dbConnection = new DbConnection();
        try {
            Connection con = dbConnection.connectDb();

            String query = "insert into appointment (id, status, title, patient_reg_no, clinician_staff_no) values(?, ?, ?, ?, ?);";
            PreparedStatement preparedStatement = con.prepareStatement(query);
            preparedStatement.setInt(1, appointment.getId());
            preparedStatement.setString(2, appointment.getStatus());
            preparedStatement.setString(3, appointment.getTitle());
            preparedStatement.setInt(4, appointment.getPatient().getReq_no());
            preparedStatement.setInt(5, appointment.getClinician().getStaff_no());




            preparedStatement.execute();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
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
        DbConnection dbConnection = new DbConnection();
        try {
            Connection con = dbConnection.connectDb();

            String query = "delete from appointment where id=?;";
            PreparedStatement preparedStatement = con.prepareStatement(query);
            preparedStatement.setInt(1, appointment.getId());


            preparedStatement.execute();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return 1;
    }

    public static  int updateAppointment(Appointment appointment, Patient patient, Clinician clinician){
        DbConnection dbConnection = new DbConnection();
        try {
            Connection con = dbConnection.connectDb();

            String query = "update appointment set  status=?, title=?, patient_reg_no=?, clinician_staff_no=? where id=?;";
            PreparedStatement preparedStatement = con.prepareStatement(query);
            preparedStatement.setString(1, appointment.getStatus());
            preparedStatement.setString(2, appointment.getTitle());
            preparedStatement.setInt(3, patient.getReq_no());
            preparedStatement.setInt(4, clinician.getStaff_no());
            preparedStatement.setInt(5, appointment.getId());





            preparedStatement.execute();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return 1;
    }
    public static  void getAllAppointments(Appointment appointment, Patient patient, Clinician clinician){
        DbConnection  dbConnection = new DbConnection();
        try {
            Connection con = dbConnection.connectDb();

            String query = "select * from appointment";






            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
      System.out.print(query);
    }
      public static void main(String[] args){
        Patient patient = new Patient(3,"Patient 3","paid");
          Clinician clinician = new Clinician(4, "Hesron Mburu","Brokefingers");
          Radiographer radiographer = new Radiographer(4,"Radio 1","radiology");

        Appointment appointment = new Appointment(1,"Brian",patient,clinician);
          appointment.setStatus("pending");
        //  placeAppointment(appointment);
        //  appointment.setTitle("Kelyn");
         // updateAppointment(appointment,patient,clinician);
          deleteAppointment(appointment);



      }
}
