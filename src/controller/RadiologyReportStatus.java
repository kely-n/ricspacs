package controller;

import models.ImagingResult;
import models.Patient;
import models.Report;

import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 * The RadiologyReportStatus enables a radiologist to observe an ImagingResult and write reports according to what he/she
 * finds on the result.
 */
public class RadiologyReportStatus {

    /**
     * method adds a report to database
     * @param report
     * @return 1 if successful, else 0
     */
    public static int createReport( Report report){
        DbConnection dbConnection = new DbConnection();
        try {
            Connection con = dbConnection.connectDb();

            String query = "insert into result (id, description, lab_result_id, radiologist_staff_no ) values(?, ?, ?, ?);";
            PreparedStatement preparedStatement = con.prepareStatement(query);
            preparedStatement.setInt(1, report.getId());
            preparedStatement.setString(1, report.getDescription());
            preparedStatement.setInt(2, report.getImagingResult().getId());
            preparedStatement.setInt(3, report.getRadiologist().getStaff_no());

            preparedStatement.execute();

            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return 1;
    }

    /**
     * gets the report of the patient based on radiologist report
     * @param patient
     * @return
     */
    public static int getReport(Patient patient){

        return 1;
    }


}
