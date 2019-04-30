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


    public static boolean isValidFloor(String floor,int maxFloor){
        try{
            int f = Integer.valueOf(floor);
            if(f>0&&f<=maxFloor){
                return true;
            }else if(f>maxFloor&&maxFloor==1){
                System.out.println("There are only 1 floor.");
                return false;
            }else if(f<=0){
                System.out.println("Number of floor must be greater than 0.");
                return false;
            }else {
                System.out.println("There are only "+maxFloor+" floors.");
                return false;
            }

        }catch (Exception e){
            System.out.println("Invalid number of floor...!");
            return false;
        }
    }

    public static boolean isValidRoom(String room,int maxRoom){
        try{
            int r = Integer.valueOf(room);
            if(r>0&&r<=maxRoom){
                return true;
            }else if(r>maxRoom&&maxRoom==1){
                System.out.println("There are only 1 room.");
                return false;
            }else if(r<=0){
                System.out.println("Number of room must be greater than 0.");
                return false;
            }else {
                System.out.println("There are only "+maxRoom+" rooms.");
                return false;
            }

        }catch (Exception e){
            System.out.println("Invalid number of room...!");
            return false;
        }
    }

//    public static boolean isValidName(String name){
//        Pattern pattern =  Pattern.compile("[a-zA-Z\\s]{2,15}");
//        Matcher matcher = pattern.matcher(name);
//        if(matcher.matches()){
//            return true;
//        }
//        else{
//            if(!name.matches("[a-zA-Z]{1,15}")){
//                System.out.println("Name is not valid!");
//            }else if(name.length()>15){
//                System.out.println("Name must be less than 15 characters.");
//            }else if(name.length()<2) {
//                System.out.println("Name must be more than 1 characters.");
//            }
//        }
//
//        return false;
//
//    }
}
