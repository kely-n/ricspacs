package controller;

import models.Appointment;
import models.ImagingResult;
import models.Radiographer;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class XrayProcess {

    /**
     * Method saves an imaging result from radiography to database and attaches it to an appointment
     * @param appointment
     * @param imagingResult
     * @return 1 if successful, 0 otherwise
     */
    public static int saveImagingResult(Appointment appointment, ImagingResult imagingResult, Radiographer radiographer){
        DbConnection dbConnection = new DbConnection();
        try {
            Connection con = dbConnection.connectDb();

            String query = "insert into lab_result (id, image, radiographer_staff_no, appointment_id) values(?, ?, ?, ?);";
            PreparedStatement preparedStatement = con.prepareStatement(query);
            preparedStatement.setInt(1, imagingResult.getId());
            preparedStatement.setString(2, imagingResult.getImageUrl());
            preparedStatement.setInt(3, radiographer.getStaff_no());
            preparedStatement.setInt(4, appointment.getId());


            preparedStatement.execute();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return 1;
    }


}
