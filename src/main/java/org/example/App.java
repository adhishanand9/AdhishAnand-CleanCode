package org.example;

import org.example.cost.ConstructionCostOfHouse;
import org.example.interest.CompoundInterest;
import org.example.interest.SimpleInterest;

import java.util.Scanner;

public class App
{
    static void cost(){
        Scanner input = new Scanner(System.in);
        String[] objects = ConstructionCostOfHouse.getMaterials();
        for(int index = 0;index<objects.length;index++){
            System.out.println("Enter " + (index+1) + " to select " + objects[index]);
        }
        int materialChoice = (input.nextInt())-1;

        System.out.println("Enter the area of the house.");
        double area = input.nextDouble();
        boolean isAutomationRequired = false;
        if(objects[materialChoice].equals("High Standard Material")){
            System.out.println("Enter \"True\" if you need automation or else enter \"False\"...");
            isAutomationRequired = input.nextBoolean();
        }
        System.out.println(ConstructionCostOfHouse.calculateCost(objects[materialChoice],
                area, isAutomationRequired));
    }
    static void interest(){
        Scanner input = new Scanner(System.in);
        System.out.println("Enter \"SI\" for Simple Interest or \"CI\" for Compound Interest.");
        switch (input.next()){
            case "SI":
                System.out.println("Enter Principal Amount, Duration in Years and Rate of Interest");
                float si=SimpleInterest.calculateInterest(input.nextFloat(), input.nextFloat(), input.nextFloat());
                if(si<0)
                    System.out.println("Invalid Input");
                else
                    System.out.println(si);
                break;
            case "CI":
                System.out.println("Enter Principal Amount, Duration in Years and Rate of Interest");
                float ci=CompoundInterest.calculateInterest(input.nextFloat(), input.nextFloat(), input.nextFloat());
                if(ci<0)
                    System.out.println("Invalid Input");
                else
                    System.out.println(ci);
                break;
            default:
                System.err.println("Wrong Choice.");
        }
    }
    public static void main( String[] args ) {

        Scanner input = new Scanner(System.in);
        System.out.println("Enter \"COST\" to calculate the house construction cost " +
                "or \"INTEREST\" to calculate the interest.");

        switch (input.next()){
            case "cost" :
                cost();
                break;
            case "interest":
                interest();
                break;
            case "COST":
                cost();
                break;
            case "INTEREST":
                interest();
                break;
            default:
                System.err.println("Wrong Choice.");
        }
    }
}
