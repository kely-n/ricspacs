package main;

import controller.HospitalSystem;
import controller.RadiologyAppointmentStatus;
import controller.XrayProcess;
import models.*;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * The RadiographerProgram is used by a radiographer, who relies on appointment to perform an X-Ray on a patient.
 */
public class RadiographerProgram {


        static Radiographer radiographer;

        public static void main (String ...args){
            System.out.println("Radiographers App: ");
            HospitalSystem hospitalsytem = new HospitalSystem();
            radiographer = hospitalsytem.getRadiographer(1);

            while (true) {
                showMenu();
            }

        }

        private static void showMenu () {

            System.out.println("Menu:");


            Scanner sc = new Scanner(System.in);

            System.out.println("Select a valid option from the menu below");
            System.out.println("1. view pending appointments");
            System.out.println("2. exit application");

            try {
                int command = sc.nextInt();
                processCommand(command);
            } catch (Exception e) {
                System.out.println("Check that you have selected the correct input");
                showMenu();
            }
        }

        private static void processCommand ( int command){
            switch (command) {
                case 1: //get pending appointments
                    RadiographerProgram radiographerprogram = new RadiographerProgram();
                    radiographerprogram.viewPendingAppointments();
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

        private void viewPendingAppointments () {
            //display all pending appointments

            System.out.println("Pending Appointments");
            //display all registered patients
            RadiologyAppointmentStatus radiologyappointmentstatus = new RadiologyAppointmentStatus();
            ArrayList<Appointment> appointments = radiologyappointmentstatus.getAllPendingAppointments();
            if (appointments.isEmpty()) {
                System.out.println("no pending appointments");
                showMenu();
            }
            for (Appointment appointment : appointments) {
                System.out.println(appointment.toString());
            }

            Scanner sc = new Scanner(System.in);
            System.out.println("Select an appointment to work on (enter appointment id) : ");


            try {
                int id = sc.nextInt();
                appointmentMenu(id);

            } catch (Exception e) {
                System.out.println("Check that you have selected the correct input");
            }

        }

        private void appointmentMenu ( int id){
            RadiologyAppointmentStatus radiologyappointmentstatus = new RadiologyAppointmentStatus();
            Appointment appointment = radiologyappointmentstatus.getAppointment(id);
            appointment.setStatus("processing");
            radiologyappointmentstatus.updateAppointment(appointment);

            Scanner sc = new Scanner(System.in);
            System.out.println("Menu:");
            System.out.println("Select a valid option from the menu below");
            System.out.println("1. attach an imaging result to appointment");
            System.out.println("2. back to main menu");

            int command = 2;

            try {
                command = sc.nextInt();

            } catch (Exception e) {
                System.out.println("Check that you have selected the correct input");
            }

            if (command == 1) {
                HospitalSystem hospitalsystem = new HospitalSystem();
                Radiographer radiographer = hospitalsystem.getRadiographer(1);
                XrayProcess xrayprocess = new XrayProcess();
                sc = new Scanner(System.in);

                System.out.println("Enter the Imaging result url: ");

                String imageResult = sc.nextLine();

                ImagingResult imagingResult = new ImagingResult(imageResult, radiographer, appointment);
                xrayprocess.saveImagingResult(imagingResult);

                appointment.setStatus("complete");
                radiologyappointmentstatus.updateAppointment(appointment);

                System.out.println("imaging result successfully added to appointment. ");
            } else if (command == 2) {
                appointment.setStatus("pending");
                radiologyappointmentstatus.updateAppointment(appointment);
                showMenu();
            }


        }
    }

