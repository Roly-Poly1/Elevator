/*
Assignment 7
Gator Hall Elevator Algorithm
Millinh Apilado
920649519
CSC 210-03
Spring 2020
 */

import java.util.Scanner;
import java.lang.Math;

public class HallElevators {
    //Creating an array containing integer elements of the floors with elevators
    static int[] elevArr = {1, 3, 5, 9};

    //Declared and initiated variable maxDist of data type integer 8
    //It will be used to compare the distance for the elevators as it is the maximum possible distance in this situation
    static int maxDist = 8;

    static int lowDiff = 0;

    static int selectElev = 0;

    static int currentFl;
    static int destinFl;

    static int x = 1;

    public static void main(String[] args) {
        Scanner elevSc = new Scanner(System.in);

        //While loop has to be always true so the program won't terminate after one execution
        while (x == 1) {

            //Asks user for current floor input and assigns it to int var currentFl
            System.out.println("What is your current floor? (1 to 9): ");
            currentFl = elevSc.nextInt();

            //To make sure user inputs numbers that are only between 1 and 9
            if (currentFl <= 9 && currentFl >= 1) {

                //Method that selects the lowest numbered elevator
                selectElevFc();

                //Displays what elevator was chosen which is the selectElev var
                System.out.println("Elevator " + selectElev + " is ready");

                //Method that shows the elevator's floor as it travels to user
                showElevFl();

                //This prints out a prompt to ask the user for the floor they wish to go to
                System.out.println("What floor do you wish to go to (1 to 9)?: ");
                destinFl = elevSc.nextInt();

                //This is to make sure user doesn't enter any number outside the 1 to 9 spectrum
                if (destinFl >= 1 && destinFl <= 9) {

                    //Method that shows the elevator's current floor as user goes to their intended floor
                    showTravFl();

                    //Replaces the value of the destinFl into the array
                    replaceElevArrI();
                }
            }
        }
    }
    public static void selectElevFc() {
        //For loop that iterates until the elevator with the lowest number is found
        //It decrements as it starts with index 3 down to 0 of the array
        for (int i = elevArr.length - 1; i >= 0; i--) {

            //The value of the elevator floor from array subtracted from user input is assigned to int variable distance1
            //Since current floor may be lesser than the floor of the elevator in array, Math.abs() function is necessary to get the absolute value\
            //This is to get the distance difference between the floor input and and the floor with the elevator
            int distance1 = Math.abs(currentFl - elevArr[i]);

            //This condition always needs to be true to make sure it iterates to else
            // This conditional statement will have a nested if which will compare and determine distance
            if (i == 3) {

                //This conditional statement will execute if distance1 is less than or equal to maxDist
                if (distance1 <= maxDist) {

                    //Since i + 1 is the value of the array index to return to the appropriate elevator number
                    //It gets assigned to int var selectElev
                    selectElev = i + 1;

                    //If condition above is true, then distance1 gets reassigned to the lowest difference value
                    //This value will be used on the following iteration to else statement
                    lowDiff = distance1;
                }
            } else {
                //This conditional statement will execute on the next iteration once i != 3
                //This compares the distance1 before the if statement to the now current lowest difference variable
                if (distance1 <= lowDiff) {

                    //The same thing happens as the one above the nested if condition^^
                    selectElev = i + 1;
                    lowDiff = distance1;
                }
            }
        }
    }
    public static void showElevFl() {
        //This condition displays the floor numbers the elevator passes through
        //If the current floor is greater than the [selected elevator - 1] (which is the index in the array and meaning going up), then it executes
        if (currentFl > elevArr[selectElev - 1]) {

            //This for loop increments and displays the floor i starting from what floor the selected elevator is currently at
            for (int i = elevArr[selectElev - 1]; i <= currentFl; i++) {
                System.out.println("Elevator is now at floor " + i);
            }
        }

        //If the current floor is less than the [selected elevator - 1] (which is the index in the array and is going down), then it executes
        if (currentFl < elevArr[selectElev - 1]) {

            //This for loop decrements and displays the floor i from the elevator's current floor down to user's floor input
            for (int i = elevArr[selectElev - 1]; i >= currentFl; i--) {
                System.out.println("Elevator is now at floor " + i);
            }
        }

        //This is just to let the user know if the elevator is already on their floor
        if (currentFl == elevArr[selectElev - 1]) {
            System.out.println("Elevator is now here");
        }
    }
    public static void showTravFl(){
        //This condition compares the floor user wishes to go to and the current floor
        //If destinFl is greater than or equal to currentFl (going up) then it executes
        if (destinFl >= currentFl) {

            //This increments as the loop iterates through the execution until it reaches destinFl
            //The loop must begin from the user's current floor where the elevator is now at
            for (int i = currentFl; i <= destinFl; i++) {

                //If i is equal to destinFl, it lets the user know they've reached their floor
                if (i == destinFl) {
                    System.out.println("You are now here at floor " + i);
                }
                //else it continues to iterate and display the floors the elevator passes through
                else {
                    System.out.println("Elevator is now at floor " + i);
                }
            }
        }

        //This condition compares the floor user wishes to go to and the current floor but
        //This is when destinFl is lessthan or equal to currentFl (going down)
        if (destinFl <= currentFl) {

            //This loop decrements from the currentFl until it reaches the destinFl
            for (int i = currentFl; i >= destinFl; i--) {

                //Again, displays the floors as it passes by through it
                //and lets the user know once it has reached user's destined floor
                if (i == destinFl) {
                    System.out.println("You are now here at floor " + i);
                } else {
                    System.out.println("Elevator is now at floor " + i);
                }
            }
        }
    }
    public static void replaceElevArrI(){
        //The user's destined floor is now reassigned to the elevator floor on the array index of the selected elevator subtracted from one
        //This is to make sure the elevator used by user is now at the floor it last went to
        elevArr[selectElev - 1] = destinFl;
    }
}
