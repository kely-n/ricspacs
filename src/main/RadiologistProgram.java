package main;

import controller.HospitalSystem;
import models.Radiologist;

import java.util.Scanner;

/**
 * The RadiologistProgram is used by the radiologist to view imagingResults and add reports to them
 */
public class RadiologistProgram {

    static Radiologist radiologist;

    static Scanner sc = new Scanner(System.in);
    public static void main(String ... args){
        System.out.println("Radiographers App: ");

        radiologist = HospitalSystem.getRadiologist(1);

        while(true){
            showMenu();
        }

    }

    private static void showMenu() {

        System.out.println("Menu:");


        System.out.println("Select a valid option from the menu below");
        System.out.println("1. view Image Results");
        System.out.println("2. exit application");

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
            case 1: //get all image results
                viewRadiographerImageResult();
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

    private static void viewRadiographerImageResult() {

    }

}
