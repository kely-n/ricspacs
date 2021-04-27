package main;

import java.util.Scanner;

/**
 * The RadiographerProgram is used by a radiographer, who relies on appointment to perform an X-Ray on a patient.
 */
public class RadiographerProgram {

    static Scanner sc = new Scanner(System.in);
    public static void main(String ... args){
        System.out.println("Radiographers App: ");


        while(true){
            showMenu();
        }

    }

    private static void showMenu() {

        System.out.println("Menu:");
        System.out.println("Select a valid option from the menu below");
        System.out.println("1. view pending appointments");
        System.out.println("2. work on an appointment");
        System.out.println("3. view generated image results");
        System.out.println("4. delete an image result");
        System.out.println("5. update an image result");
        System.out.println("6. exit application");

        try {
            int command = sc.nextInt();
            processCommand(command);
            System.out.println(command);
        }catch(Exception e){
            System.out.println("Check that you have selected the correct input");
            showMenu();
        }
    }

    private static void processCommand(int command) {
        switch (command){
            case 1: //get pending appointments

                break;
            case 2: //enable selecting of an appointment to work on

                break;
            case 3: //view all generated image results

                break;
            case 4: //deletion of an image result

                break;
            case 5: //update an image result

                break;
            case 6: //exit from the program
                System.out.println("closing the application");
                System.exit(1);
                break;
            default:
                System.out.println("Check that you have selected the correct input");
                showMenu();
        }
    }
}
