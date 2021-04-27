package main;

import controller.PatientRegistration;
import controller.RadiologyAppointmentStatus;
import models.Appointment;
import models.Clinician;
import models.Patient;

import java.util.Scanner;

/**
 * The ClinicianProgram is used by a doctor or a clinician, who in turn adds a patient diagnosis, and decides whether the
 * patient needs to undergo an X-ray. If an X-Ray is need, then the doctor creates an appointment to the Radiology
 * department
 * The clinician the waits for the appointment to be worked on then gets an imagingResult and a report from a radiologist
 * based on the imaging result
 */
public class ClinicianProgram {

    static Scanner sc =  new Scanner(System.in);

    public static void main(String []args){
        System.out.println("Clinicians App: ");

        while (true){
            showMenu();
        }

    }
    private static void showMenu() {

        System.out.println("Menu:");
        System.out.println("Select a valid option from the menu below");
        System.out.println("1. Register a new patient");
        System.out.println("2. view all patients");
        System.out.println("3. exit application");

        String input = sc.nextLine();

        try {
            int command = Integer.parseInt(input);
            processCommand(command);
            System.out.println(command);
        }catch(Exception e){
            System.out.println("Check that you have selected the correct input");
            showMenu();
        }
    }

    private static void processCommand(int command) {
        switch (command){
            case 1: //register new patient
                registerPatient();
                break;
            case 2: //view all patients
                showPatients();
                break;
            case 3: //exit from the program
                System.out.println("closing the application");
                System.exit(1);
                break;
            default:
                System.out.println("Check that you have selected the correct input");
                showMenu();
        }
    }

    private static void showPatients() {

        System.out.println("registered patients");
        //display all registered patients
        System.out.println("Select a patient (enter patients reg_no) : ");

        try {
            int reg_no = sc.nextInt();
            patientMenu(reg_no);
            System.out.println(reg_no);
        }catch(Exception e){
            System.out.println("Check that you have selected the correct input");
        }



    }

    private static void patientMenu(int reg_no) {
        //get the selected patient from database
        Patient patient = PatientRegistration.getPatient(reg_no);

        System.out.println("Patient Sub-Menu");
        System.out.println("Select a valid option");
        System.out.println("1. Add and edit the patient's diagnosis");
        System.out.println("2. create the patient's appointment for an X-Ray");
        System.out.println("3. check appointment status of the patient");
        System.out.println("4. request for imaging result and radiologist report");
        System.out.println("5. back to main menu");


        try {
            int command = sc.nextInt();
            processPatientCommands(command, patient);
            System.out.println(command);
        }catch(Exception e){
            System.out.println("Check that you have selected the correct input");
        }


    }

    private static void processPatientCommands(int command, Patient patient) {
        switch (command){
            case 1: //Add and edit the patient's diagnosis
                System.out.println("enter Patients diagnosis");
                String diagnosis = sc.nextLine();
                patient.setDiagnosis(diagnosis);

                //update data
                PatientRegistration.updatePatientData(patient);
                break;
            case 2: //create the patient's appointment for an X-Ray
                createAppointment(patient);
                break;
            case 3: //check appointment status of the patient

                break;
            case 4: //request for imaging result and radiologist report

                break;
            case 5: //home
                showMenu();
                break;
            default:
                System.out.println("Check that you have selected the correct input");
                patientMenu(patient.getReq_no());
        }
    }

    private static void createAppointment(Patient patient) {

        System.out.println("Appointment title: ");
        String title = sc.nextLine();

        Appointment appointment = new Appointment(1, title, patient, new Clinician(2, "judit", "doctor"));
        RadiologyAppointmentStatus.placeAppointment(appointment);

}

    private static void registerPatient() {
        System.out.println("Register a new Patient");
        Patient patient;

        System.out.println("Enter Patients Name:");
        String name = sc.nextLine();

        System.out.println("Patients identification number: ");
        String input = sc.nextLine();
        int reg_no = Integer.parseInt(input);

        System.out.println("Enter the patients diagnosis");
        String diagnoss = sc.nextLine();


        System.out.println("Has patient paid?(Y | N)");

        String bilingStatus = "unpaid";

        String response = sc.nextLine().toUpperCase();
        System.out.println(response);
        if(response.equals("Y")) {
            bilingStatus = "paid";
        }

        patient = new Patient(reg_no,name,bilingStatus );
        PatientRegistration.registerPatient(patient);
        System.out.println("patient registered");

    }

}
