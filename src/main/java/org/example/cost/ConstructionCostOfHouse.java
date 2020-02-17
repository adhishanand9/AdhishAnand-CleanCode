package org.example.cost;
import org.example.cost.exceptions.InvalidArea;
import org.example.cost.exceptions.InvalidMaterial;

public class ConstructionCostOfHouse {

    private static final int STANDARD_MATERIAL_COST = 1200;
    private static final int ABOVE_STANDARD_MATERIAL_COST = 1500;
    private static final int HIGH_STANDARD_MATERIAL_COST = 1800;
    private static final int HIGH_STANDARD_MATERIAL_AUTOMATION_COST = 2500;

    private static String[] materials = new String[]{"Standard Material","Above Standard Material","High Standard Material"};

    public static double calculateCost(String materialChoice, double area, boolean isAutomationRequired){
        if(area==0){
            throw new InvalidArea();
        }
        if(materialChoice.equalsIgnoreCase(materials[0])){
            return area*STANDARD_MATERIAL_COST;
        }else if(materialChoice.equalsIgnoreCase(materials[1])){
            return area*ABOVE_STANDARD_MATERIAL_COST;
        }else if(materialChoice.equalsIgnoreCase(materials[2])){
            if(isAutomationRequired){
                return area*HIGH_STANDARD_MATERIAL_AUTOMATION_COST;
            }
            return area*HIGH_STANDARD_MATERIAL_COST;
        }else{
            throw new InvalidMaterial();
        }
    }

    public static String[] getMaterials(){
        return materials;
    }
}
