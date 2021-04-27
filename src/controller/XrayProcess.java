package controller;

import models.Appointment;
import models.ImagingResult;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class XrayProcess {

    /**
     * Method saves an imaging result from radiography to database and attaches it to an appointment
     * @param imagingResult
     * @return 1 if successful, 0 otherwise
     */
    public static int saveImagingResult(ImagingResult imagingResult){
        DbConnection dbConnection = new DbConnection();
        try {
            Connection con = dbConnection.connectDb();

            String query = "insert into imaging_result (image, radiographer_staff_no, appointment_id) values( ?, ?, ?);";
            PreparedStatement preparedStatement = con.prepareStatement(query);
            preparedStatement.setString(1, imagingResult.getImageUrl());
            preparedStatement.setInt(2, imagingResult.getRadiographer().getStaff_no());
            preparedStatement.setInt(3, imagingResult.getAppointment().getId());

            preparedStatement.execute();

            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return 1;
    }



    public static ArrayList<ImagingResult> getImageResults() {
        DbConnection dbConnection = new DbConnection();
        ArrayList<ImagingResult> imagingResults = new ArrayList<>();
        try {
            Connection con = dbConnection.connectDb();
            Statement stmnt = con.createStatement();
            ResultSet rs = stmnt.executeQuery("Select * from imaging_result;");

            while (rs.next()){
                ImagingResult imagingResult = new ImagingResult(
                        rs.getInt(1),
                        rs.getString(2),
                        HospitalSystem.getRadiographer(rs.getInt(3)),
                        RadiologyAppointmentStatus.getAppointment(rs.getInt(4))
                );
                imagingResults.add(imagingResult);
            }

        }catch (Exception e){
            e.printStackTrace();
        }

        return imagingResults;
    }


    public static ImagingResult getImagingResultOfId(int id) {
        DbConnection dbConnection = new DbConnection();

        try {
            Connection con = dbConnection.connectDb();
            Statement stmnt = con.createStatement();
            ResultSet rs = stmnt.executeQuery("Select * from imaging_result where id = "+id+";");

            if(rs.next()){
                ImagingResult imagingResult = new ImagingResult(
                        rs.getInt(1),
                        rs.getString(2),
                        HospitalSystem.getRadiographer(rs.getInt(4)),
                        RadiologyAppointmentStatus.getAppointment(rs.getInt(5))
                );
                return imagingResult;
            }

        }catch (Exception e){
            e.printStackTrace();
        }

        return null;
    }

}
