/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.tester;

/**
 *
 * @author kavin
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * The BloodSugar class represents an individual's blood sugar information.
 */

class BloodSugar {
    private int id;
    private String name;
    private int yob;
    private int sugarLevel;
    
    // Constructor to initialize a BloodSugar object

    public BloodSugar(int id, String name, int yob, int sugarLevel) {
        this.id = id;
        this.name = name;
        this.yob = yob;
        this.sugarLevel = sugarLevel;
    }
    // Getter and setter methods for BloodSugar properties

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYob() {
        return yob;
    }

    public void setYob(int yob) {
        this.yob = yob;
    }

    public int getSugarLevel() {
        return sugarLevel;
    }

    public void setSugarLevel(int sugarLevel) {
        this.sugarLevel = sugarLevel;
    }
    
    // Display method to print BloodSugar information

    public void display() {
        System.out.println("BloodSugar{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", yob=" + yob +
                ", sugarLevel=" + sugarLevel +
                '}');
    }
}
 
 //The Tester class is the main class for the blood sugar monitoring application.
 

public class Tester {
    private static List<BloodSugar> bloodSugarList = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        displayMenu();
    }
    
     
     //Display the main menu of the blood sugar monitoring application.
     

    public static void displayMenu() {
        int choice;
        do {
            System.out.println("1. Create a record");
            System.out.println("2. Show blood sugar data for all users");
            System.out.println("3. Show blood sugar data for a selected user");
            System.out.println("4. Delete all");
            System.out.println("5. Exit application");
            System.out.print("Enter your choice: ");
            choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    create();
                    break;
                case 2:
                    index();
                    break;
                case 3:
                    view(getID());
                    break;
                case 4:
                    delete();
                    break;
                case 5:
                    exit();
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 5);
    }
    
    
     //Create a new blood sugar record and add it to the list.
     

    private static void create() {
        System.out.print("Enter user ID: ");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        System.out.print("Enter year of birth: ");
        int yob = Integer.parseInt(scanner.nextLine());
        System.out.print("Enter blood sugar level: ");
        int sugarLevel = Integer.parseInt(scanner.nextLine());
        BloodSugar bloodSugar = new BloodSugar(id, name, yob, sugarLevel);
        bloodSugarList.add(bloodSugar);
        System.out.println("Record created successfully.");
    }
     
     //Display blood sugar data for all users.

    private static void index() {
        for (BloodSugar bloodSugar : bloodSugarList) {
            bloodSugar.display();
        }
    }

    private static int getID() {
        System.out.print("Enter user ID: ");
        return Integer.parseInt(scanner.nextLine());
    }
    
//Get user ID from the user and display blood sugar data for the selected user.
    
    private static void view(int id) {
        for (BloodSugar bloodSugar : bloodSugarList) {
            if (bloodSugar.getId() == id) {
                bloodSugar.display();
                return;
            }
        }
        System.out.println("No record found for user ID " + id);
    }

    private static void delete() {
        bloodSugarList.clear();
        System.out.println("All records deleted successfully.");
    }
//Exit the blood sugar monitoring application.
    private static void exit() {
        System.out.println("Exiting...");
        System.exit(0);
    }
}
