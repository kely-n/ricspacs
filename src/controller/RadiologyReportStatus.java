package controller;

import models.ImagingResult;
import models.Patient;
import models.Report;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

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

    public int createReport( Report report){
        DbConnection dbConnection = new DbConnection();
        try {
            Connection con = dbConnection.connectDb();

            String query = "insert into result ( description, lab_result_id, radiologist_staff_no ) values(?, ?, ?, ?);";
            PreparedStatement preparedStatement = con.prepareStatement(query);
            preparedStatement.setString(1, report.getDescription());
            preparedStatement.setInt(2, report.getImagingResult().getId());
            preparedStatement.setInt(3, report.getRadiologist().getStaff_no());

            preparedStatement.execute();

            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * gets the report of the patient based on radiologist report
     * @param id
     * @return
     */
    public Report getReport(int id){
        DbConnection dbConnection = new DbConnection();
        HospitalSystem hospitalSystem = new HospitalSystem();
        XrayProcess xrayProcess = new XrayProcess();

        try {
            Connection con = dbConnection.connectDb();
            Statement stmnt = con.createStatement();
            ResultSet rs = stmnt.executeQuery("Select * from report where id = "+id+";");

            if(rs.next()){
                Report report = new Report(
                        rs.getInt(1),
                        rs.getString(2),
                        xrayProcess.getImagingResultOfId(rs.getInt(4)),
                        hospitalSystem.getRadiologist(rs.getInt(5))
                );
                return report;
            }

        }catch (Exception e){
            e.printStackTrace();
        }

        return null;
    }

    /**
     * gets all the reports of the patients in the system
     * @return
     */
    public ArrayList<Report> getAllReports(){
        DbConnection dbConnection = new DbConnection();
        HospitalSystem hospitalSystem = new HospitalSystem();
        XrayProcess xrayProcess = new XrayProcess();

        ArrayList<Report> reports = new ArrayList<>();
        try {
            Connection con = dbConnection.connectDb();
            Statement stmnt = con.createStatement();
            ResultSet rs = stmnt.executeQuery("Select * from report;");

            while(rs.next()){
                Report report = new Report(
                        rs.getInt(1),
                        rs.getString(2),
                        xrayProcess.getImagingResultOfId(rs.getInt(4)),
                        hospitalSystem.getRadiologist(rs.getInt(5))
                );
                reports.add(report);
            }

        }catch (Exception e){
            e.printStackTrace();
        }

        return reports;
    }


}
