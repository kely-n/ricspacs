package main;

import controller.HospitalSystem;
import controller.RadiologyReportStatus;
import controller.XrayProcess;
import models.ImagingResult;
import models.Radiologist;
import models.Report;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * The RadiologistProgram is used by the radiologist to view imagingResults and add reports to them
 */
public class RadiologistProgram {

    static Radiologist radiologist;

    public static void main(String []args){
        System.out.println("Radiologist App: ");
        HospitalSystem hospitalsytem = new HospitalSystem();
        radiologist = hospitalsytem.getRadiologist(1);

        while(true){
            showMenu();
        }

    }

    private static void showMenu() {

        System.out.println("Menu:");


        Scanner sc = new Scanner(System.in);
        System.out.println("Select a valid option from the menu below");
        System.out.println("1. view Image Results");
        System.out.println("2. exit application");

        String input = sc.nextLine();

        try {
            int command = Integer.parseInt(input);
            processCommand(command);

        }catch(Exception e){
            System.out.println("Check that you have selected the correct input");
            showMenu();
        }
    }

    private static void processCommand(int command) {
        switch (command){
            case 1: //get all image
                RadiologistProgram radioligistprogram = new RadiologistProgram();
                radioligistprogram.viewRadiographerImageResult();
                break;
            case 2: //exit from the program
                System.out.println("closing the application");
                System.exit(1);
                break;
            default:
                System.out.println("Check that you have selected the correct input");
                showMenu();
        }
    }

    private  void viewRadiographerImageResult() {
//        ArrayList<Report> reports = RadiologyReportStatus.getAllReports();
//        if(reports.isEmpty()){
//            System.out.println("No current reports in the system");
//        }else {
//            for (Report report : reports){
//                System.out.println(report);
//            }
//            System.out.println("");
//        }
        System.out.println("confirm reach");
        XrayProcess xrayprocess = new XrayProcess();
        ArrayList<ImagingResult> imagingResults = xrayprocess.getImageResults();
        System.out.println(imagingResults);
        if(imagingResults.isEmpty()){
            System.out.println("No current imagingResults in the system");
            showMenu();
        }

        for(ImagingResult imagingResult : imagingResults){
            System.out.println(imagingResult);
        }

        Scanner sc = new Scanner(System.in);
        System.out.println("Select an image result to write a report on (enter image result id) :");
        String input = sc.nextLine();
        try {
            int id = Integer.parseInt(input);
            writeReportOn(id);
        }catch(Exception e){
            System.out.println("Check that you have selected the correct input");
            showMenu();
        }
    }

    private  void writeReportOn(int id) {
        XrayProcess xrayprocess = new XrayProcess();
        ImagingResult imagingResult = xrayprocess.getImagingResultOfId(id);

        Scanner sc = new Scanner(System.in);
        System.out.println("Type a description for the image: ");
        String description = sc.nextLine();

        Report report = new Report(description, imagingResult, radiologist);
        RadiologyReportStatus radiologyreportstatus = new RadiologyReportStatus();
        radiologyreportstatus.createReport(report);
        System.out.println("Report added");
    }

}
