package com.kshrd.views;

public class Validate {
    public static boolean isNumber(String number){
        try{
            double num = Integer.valueOf(number);
            if(num>0){
                return true;
            } else {
                System.out.println("Number must be greater than 0");
                return false;
            }

        }catch (Exception e){
            System.out.println("Please input number...!");
            return false;
        }
    }


}
