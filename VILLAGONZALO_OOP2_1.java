package com.mycompany.villagonzalo_oop2_1;

import java.util.Scanner;

public class VILLAGONZALO_OOP2_1 {
    private final String firstName;
    private final String lastName;
    private int age;
    private boolean isMinor;

    public VILLAGONZALO_OOP2_1(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.isMinor = age < 18;
    }

    public String getName() {
        return lastName + ", " + firstName;
    }

    public void increaseAge() {
        age++;
        isMinor = age < 18;
    }
    
    @Override
    public String toString() {
        String status = isMinor ? "minor" : "adult";
        return getName() + " - " + age + " - " + status;
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            VILLAGONZALO_OOP2_1 student1 = null;
            
            while (true) {
                System.out.println("Enter test case number (1, 2, or 3): ");
                int testCase = scanner.nextInt();
                scanner.nextLine();
                
                switch (testCase) {
                    case 1 -> {
                        System.out.println("Test Case " + testCase + ": Student under 18");
                        System.out.print("Enter first name: ");
                        String firstName1 = scanner.nextLine();
                        System.out.print("Enter last name: ");
                        String lastName1 = scanner.nextLine();
                        System.out.print("Enter age: ");
                        int age1 = scanner.nextInt();
                        student1 = new VILLAGONZALO_OOP2_1(firstName1, lastName1, age1);
                        System.out.println(student1);
                    }
                    case 2 -> {
                        if (student1 != null) {
                            System.out.println("Test Case " + testCase + ": Increase age of student1");
                            student1.increaseAge();
                            System.out.println(student1);
                        } else {
                            System.out.println("Error: Student1 is not initialized. Please enter test case 1 first.");
                        }
                    }
                    case 3 -> {
                        System.out.println("Test Case " + testCase + ": Student over 18");
                        System.out.print("Enter first name: ");
                        String firstName2 = scanner.nextLine();
                        System.out.print("Enter last name: ");
                        String lastName2 = scanner.nextLine();
                        System.out.print("Enter age: ");
                        int age2 = scanner.nextInt();
                        VILLAGONZALO_OOP2_1 student2 = new VILLAGONZALO_OOP2_1(firstName2, lastName2, age2);
                        System.out.println(student2);
                    }
                    default -> System.out.println("Invalid test case number. Please enter 1, 2, or 3.");
                }
                
                System.out.println("Do you want to continue? (yes/no)");
                String continueInput = scanner.next();
                if (!continueInput.equalsIgnoreCase("yes")) {
                    break;
                }
                scanner.nextLine();
            }
        }
    }
}
