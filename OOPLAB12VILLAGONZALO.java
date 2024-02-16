package com.mycompany.ooplab1.villagonzalo;

import java.util.Scanner;

public class OOPLAB12VILLAGONZALO {

    public static void main(String[] args) {
 Scanner inputData = new Scanner(System.in);
        System.out.print("Enter the message: ");
        String message = inputData.nextLine();
        Misplaced(message);
    }
public static void Misplaced(String message){
    boolean misplaced = false;
    
    for(int i=1; i< message.length();i++){
        char currentChar= message.charAt(i);
        char prevChar = message.charAt(i-1);
        
        if(Character.isUpperCase(currentChar)){
            if(!Character.isWhitespace(prevChar)){
                misplaced=true;
                break;
            }
        }
    }
    if (misplaced){
        System.out.println("JEJE!");
        
    }else{ System.out.println("uWu");
}
}
}
    
