package main;

import controller.PatientRegistration;
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

    public static void main(String []args){
        System.out.println("Clinicians App: ");

        System.out.println("Register a new Patient");
        Patient patient;

        Scanner sc = new Scanner(System.in);

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

        System.out.println("would you like to create an appointment: Y | N");
        response = sc.nextLine().toUpperCase();
        System.out.println(response);
        if(response.equals("Y")){
            System.out.println("in print statement");
            System.out.println("Add the appointment's title: ");
            String title = sc.nextLine();

            Appointment appointment = new Appointment(1, title, patient, new Clinician(2, "judit", "doctor"));
        }




    }


}
