/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.realestate;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 *
 * @author Lenovo Ideapad
 */
public class tryIdString {

    public tryIdString() {

        int intNumberofId = 1;
        int intLengthofId = 10;

        Set<String> uniqueID = new HashSet<>();
        Random random = new Random();

        String charactersForID = "ABCDEFGHIJ0123456789";

        while (uniqueID.size() < intNumberofId) {
            StringBuilder randomID = new StringBuilder();
            for (int i = 0; i < intLengthofId; i++) {
                int randomIndex = random.nextInt(charactersForID.length());
                randomID.append(charactersForID.charAt(randomIndex));
            }
            uniqueID.add(randomID.toString());
        }

        for (String str : uniqueID) {
            System.out.println(str);
        }

    }

public static void main (String[] args){
    new tryIdString();
    
    }
}