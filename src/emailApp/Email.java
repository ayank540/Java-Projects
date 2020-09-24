/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package emailApp;

import java.util.Scanner;

/**
 *
 * @author Ayan Khan
 */
public class Email {

    private String firstName;
    private String lastName;
    private String department;
    private String email;
    private String password;
    private int defaultPasswordLength = 8;
    private int mailBoxCapacity = 500;
    private String alternateEmail;
    private String companySuffix = "company.com";

    // Constructor to receive firstName and lastName
    Email(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;

        // Call a method asking for department
        this.department = setDepartment();

        // call a method that returns random password
        this.password = randomPassword(defaultPasswordLength);
        System.out.println("Password: " + this.password);

        // combine elements to generate email
        email = firstName.toLowerCase() + lastName.toLowerCase() + "@" + department + "." + companySuffix;
    }

    // setting department
    private String setDepartment() {
        System.out.print("New worker: "+this.firstName+"\nDEPARTMENT CODES:\n1. Sales\n2. Development\n3. Accounting\n0. None\n");
        System.out.print("Enter department code: ");
        Scanner scan = new Scanner(System.in);
        int deptChoice = scan.nextInt();
        if (deptChoice == 1) {
            return "sales";
        } else if (deptChoice == 2) {
            return "development";
        } else if (deptChoice == 3) {
            return "accounting";
        } else {
            return "";
        }
    }

    // Generate a random password
    private String randomPassword(int length) {
        String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ!@#$%&*";
        char[] password = new char[length];
        for (int i = 0; i < length; i++) {
            int rand = (int) (Math.random() * passwordSet.length());
            password[i] = passwordSet.charAt(rand);
        }
        return new String(password);
    }

    // Set the mailbox capacity
    public void setMailboxCapacity(int capacity) {
        this.mailBoxCapacity = capacity;
    }

    // set alternate email
    public void setAltEmail(String altEmail) {
        this.alternateEmail = altEmail;
    }

    // change password
    public void changePassword(String password){
        this.password = password;
    }
    
    // getters
    public int getMailboxCapacity() {return this.mailBoxCapacity;}
    public String getAlternateEmail() {return this.alternateEmail;}
    public String getPassword() {return this.password;}
    
    public void showInfo(){
        System.out.println("DISPLAY NAME: "+firstName+" "+lastName+"\n"+
                "COMPANY EMAIL: "+email+"\n"+
                "MAILBOX CAPACITY: "+mailBoxCapacity+"mb");
    }
}
