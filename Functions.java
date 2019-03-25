import java.util.Arrays;
public class Functions{
     public static String differentiationHelper(String toDifferentiate){
          if(toDifferentiate.contains("X")){ // if there is X's to differentiate
                return differentiation(toDifferentiate,"X"); // differentiate looking for X's
          }
          if(toDifferentiate.contains("Y")){ // if there is Y's
                return differentiation(toDifferentiate,"Y");// differentiate looking for Y's
          }
          return ("There was Not an X or Y  to Differentiate "); // if it was given items with Y in
     }
     public static String differentiation(String toDifferentiate, String checkingFor){
          String[] coeffcientPower = toDifferentiate.split(checkingFor);// split on the character given
          int coeffcient =Integer.parseInt(coeffcientPower[0]); // Take the coeffcient
          int power = Integer.parseInt(coeffcientPower[1].substring(1)); // Take the power without the ^
          int returning = coeffcient*power;// times the two
          power--; // take one off the coeffcient
          return(Integer.toString(returning)+checkingFor+"^"+Integer.toString(power));// return answer
     }
     public static String SquaringBracketsStarter(String toSquare){
          toSquare = toSquare.replaceAll("[\\[\\](){}]","");
          if(toSquare.contains("X")){ // if there is X's to differentiate
               return(SquaringBrackets(toSquare,"X"));
          }
          if(toSquare.contains("Y")){ // if there is Y's
               return(SquaringBrackets(toSquare,"Y"));
          }
          return ("Problem in SquaringBracketsStarter");
     }
     public static String SquaringBrackets(String toSquare, String checkingFor){
          if(toSquare.contains("+")){
               return(SquaringBracketsHelper(toSquare,checkingFor,"\\+","+"));
          }else if (toSquare.contains("-")) {
               return(SquaringBracketsHelper(toSquare,checkingFor,"\\-","-"));
          }else{
               return(SquaringBracketsWorker(toSquare,checkingFor));
          }
     }
     public static String SquaringBracketsHelper(String toSquare,String checkingFor, String plusOrMinusWithDash,String plusOrMinus){
          String[] splittingOnPlus =toSquare.split(plusOrMinusWithDash); // split up the terms to coeffcientX^power and + term
          String readyToSplit= splittingOnPlus[0]; // take the coeffcient and the power
          String[] coeffcientPower = readyToSplit.split(checkingFor); // split so its coeffcient and power without X
          String highPowerTerm = SquaringBracketsWorker(readyToSplit,checkingFor); // normal squaring
          highPowerTerm = highPowerTerm.replaceAll("[\\[\\](){}]",""); // get that back and this is the high power term far left
          int outsideNum = Integer.parseInt(splittingOnPlus[1]); // change the outside number to a integer not a String
          int middleNum =2*(outsideNum * Integer.parseInt(coeffcientPower[0]));
          String middleTerm = Integer.toString(middleNum)+checkingFor+coeffcientPower[1];
          String outsideTerm = Integer.toString(outsideNum * outsideNum);
          return highPowerTerm+plusOrMinus + middleTerm+plusOrMinus + outsideTerm;
     }
     public static String SquaringBracketsWorker(String toSquare, String checkingFor){
          String[] coeffcientPower = toSquare.split(checkingFor);// split on the character given
          int coeffcient =Integer.parseInt(coeffcientPower[0]); // Take the coeffcient
          int power = Integer.parseInt(coeffcientPower[1].substring(1));
          coeffcient =  coeffcient*coeffcient;
          power = power *2;
          return("("+coeffcient+checkingFor+"^"+power+")");
     }
     public static void main(String args[]){
          //System.out.println(differentiationHelper("5X^5"));//differentiate 5X^5
          //System.out.println(differentiationHelper("5Y^5"));// differentiate 5Y^5
          System.out.println(SquaringBracketsStarter("(2X^8-5)"));// attempt to square brackets
 }
}
