package controller;

import models.Clinician;
import models.Patient;
import models.Radiographer;
import models.Radiologist;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class HospitalSystem {

    public Patient getPatient(int reg_no){
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

    public Radiographer getRadiographer(int staff_no){
        DbConnection dbConnection = new DbConnection();
        try {
            Connection con = dbConnection.connectDb();
            Statement stmnt = con.createStatement();
            ResultSet rs = stmnt.executeQuery("Select * from radiographer where staff_no = "+staff_no+";");

            if (rs.next()){
                Radiographer radiographer = new Radiographer(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3)
                );
                return radiographer;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public Clinician getClinician(int staff_no) {
        DbConnection dbConnection = new DbConnection();
        try {
        Connection con = dbConnection.connectDb();
        Statement stmnt = con.createStatement();
        ResultSet rs = stmnt.executeQuery("Select * from radiographer where staff_no = "+staff_no+";");

        if (rs.next()){
            Clinician clinician = new Clinician(
                    rs.getInt(1),
                    rs.getString(2),
                    rs.getString(3)
            );
            return clinician;
        }
    }catch (Exception e){
        e.printStackTrace();
    }
        return null;
    }

    public Radiologist getRadiologist(int staff_no){
        DbConnection dbConnection = new DbConnection();
        try {
            Connection con = dbConnection.connectDb();
            Statement stmnt = con.createStatement();
            ResultSet rs = stmnt.executeQuery("Select * from radiologist where staff_no = "+staff_no+";");

            if (rs.next()){
                Radiologist radiologist  = new Radiologist(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3)
                );
                return radiologist;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
