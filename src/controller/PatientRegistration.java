package controller;

import models.Patient;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;


/**
 *  The PatientRegistration program is an application that enables a patient to be
 *  added to the hospital system so that they can undergo the treatment process
 */
public class PatientRegistration {


    /**
     * adds patient to the database
     * @return 0 if adding to database fails, 1 if successful
     */
    public static int registerPatient(Patient patient){
        DbConnection dbConnection = new DbConnection();
        try {
            Connection con = dbConnection.connectDb();

            String query = "insert into patient (reg_no, name, billing_status, diagnosis) values(?, ?, ?, ?);";
            PreparedStatement preparedStatement = con.prepareStatement(query);
            preparedStatement.setInt(1, patient.getReq_no());
            preparedStatement.setString(2, patient.getName());
            preparedStatement.setString(3, patient.getBilling_status());
            preparedStatement.setString(4, patient.getDiagnosis());

            preparedStatement.execute();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    /**
     * updates a patient payment status id the database to paid
     * @return 0 if addingPayment fails, 1 if successful
     */
    public static int updatePatientData(Patient patient){
        DbConnection dbConnection = new DbConnection();
        try {
            Connection con = dbConnection.connectDb();

            String query = "update patient set name=?, billing_status=?, diagnosis=? where reg_no=?;";
            PreparedStatement preparedStatement = con.prepareStatement(query);
            preparedStatement.setString(1, patient.getName());
            preparedStatement.setString(2, patient.getBilling_status());
            preparedStatement.setString(3, patient.getDiagnosis());
            preparedStatement.setInt(4, patient.getReq_no());

            preparedStatement.execute();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    /**
     * adds or updates diagnosis of a patient
     * @return 0 if addingPayment fails, 1 if successful
     */
    public static int deletePatient(Patient patient){
        DbConnection dbConnection = new DbConnection();
        try {
            Connection con = dbConnection.connectDb();

            String query = "delete from patient  where reg_no=?;";
            PreparedStatement preparedStatement = con.prepareStatement(query);
            preparedStatement.setInt(1, patient.getReq_no());

            preparedStatement.execute();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public static Patient getPatient(int reg_no) {
        DbConnection dbConnection = new DbConnection();
        try {
            Connection con = dbConnection.connectDb();
            Statement stmnt = con.createStatement();
            ResultSet rs = stmnt.executeQuery("Select * from patient where reg_no = "+reg_no+";");

            if (rs.next()){
                Patient patient = new Patient(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4)
                );
                return patient;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public static ArrayList<Patient> getAllPatients(){
        DbConnection dbConnection = new DbConnection();
        ArrayList<Patient> patients = new ArrayList<>();
        try {
            Connection con = dbConnection.connectDb();
            Statement stmnt = con.createStatement();
            ResultSet rs = stmnt.executeQuery("Select * from patient;");

            while (rs.next()){
                Patient patient = new Patient(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4)
                );
                patients.add(patient);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return patients;
    }


    public static void main(String ... args){
        Patient patient = new Patient(2, "patient 2", "paid");

        registerPatient(patient);
        patient.setDiagnosis("leg amputation");
        updatePatientData(patient);
        //deletePatient(patient);
    }

}
