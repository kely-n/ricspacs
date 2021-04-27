package controller;

import models.ImagingResult;

import java.sql.Connection;
import java.sql.PreparedStatement;

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


}
