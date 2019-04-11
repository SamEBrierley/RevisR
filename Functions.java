import java.util.Arrays;
public class Functions{
     public static String differentiationHelper(String toDifferentiate){
       toDifferentiate = toDifferentiate.replaceAll("[\\[\\](){}]","");
          if(toDifferentiate.contains("X")){ // if there is X's to differentiate
                return differentiation(toDifferentiate,"X"); // differentiate looking for X's
          }
          if(toDifferentiate.contains("Y")){ // if there is Y's
                return differentiation(toDifferentiate,"Y");// differentiate looking for Y's
          }
          return ("There was Not an X or Y  to Differentiate "); // if it was given items with Y in
     } // starts by detecting which X's or Y's exsist
     public static String differentiation(String toDifferentiate, String checkingFor){ //Differentiate's the given term
          String[] coeffcientPower = toDifferentiate.split(checkingFor);// split on the character given
          int coeffcient =Integer.parseInt(coeffcientPower[0]); // Take the coeffcient
          int power = Integer.parseInt(coeffcientPower[1].substring(1)); // Take the power without the ^
          int returning = coeffcient*power;// times the two
          power--; // take one off the coeffcient
          return(Integer.toString(returning)+checkingFor+"^"+Integer.toString(power));// return answer
     } //
     public static String MultiplyingBracketsStarter(String toSquare){
          toSquare = toSquare.replaceAll("[\\[\\](){}]","");
          return(MultiplyingBracketsStarter(toSquare,toSquare));
     } // if the bracket is to be Squared just send one
     public static String MultiplyingBracketsStarter(String leftHandSideBracket, String rightHandSideBracket){ // checks X's or Y's Calls MultiplyingBrackets
          if (leftHandSideBracket.contains("X")&&(rightHandSideBracket.contains("X"))){
               if(!(leftHandSideBracket.contains("Y")&&(rightHandSideBracket.contains("Y")))){
                    return(MultiplyingBrackets(leftHandSideBracket,rightHandSideBracket,"X"));
               }
          }else if(leftHandSideBracket.contains("Y")&&(rightHandSideBracket.contains("Y"))){
               if (!(leftHandSideBracket.contains("X")&&(rightHandSideBracket.contains("X")))){
                    return(MultiplyingBrackets(leftHandSideBracket,rightHandSideBracket,"Y"));
               }
          }
          return("MultiplyingBrackets");
     }
     public static String MultiplyingBrackets(String leftHandSideBracket,String rightHandSideBracket, String checkingFor){
          char checkingForChar =checkingFor.charAt(0); // get the checking as a char not a string
          String outputMessage=""; //start the ooutput message
          leftHandSideBracket = leftHandSideBracket.replaceAll("[\\[\\](){}]",""); // get rid of any brackets
          rightHandSideBracket = rightHandSideBracket.replaceAll("[\\[\\](){}]","");// get rid of any brackets
          String leftSideSplit[] = SplitTheTerms(leftHandSideBracket).split(",");//  get the left side  in a [highest term, next term, etc]
          String rightSideSplit[] = SplitTheTerms(rightHandSideBracket).split(",");//  get the left side  in a [highest term, next term, etc]

          for(int i =0;i< leftSideSplit.length;i++){ // go through all the left hand side
               for(int j = 0; j <rightSideSplit.length;j++){ // go through all the right hand side
                    if(leftSideSplit[i].contains(checkingFor)&&(rightSideSplit[j].contains(checkingFor))){ // checking if its got X's in both parts
                         outputMessage = outputMessage +TimesXsByXs(leftSideSplit[i],rightSideSplit[j],checkingFor); // times them together
                    }else if(leftSideSplit[i].contains(checkingFor)&&(!(rightSideSplit[j].contains(checkingFor)))){ //lefthand side has an X and right doesnt
                         outputMessage = outputMessage + TimesCoeffcientConstantStart(leftSideSplit[i],rightSideSplit[j],0);
                    }else if(rightSideSplit[j].contains(checkingFor)&&(!(leftSideSplit[i].contains(checkingFor)))){ // right hand side has an X and left hand side doesnt
                         outputMessage = outputMessage + TimesCoeffcientConstantStart(rightSideSplit[j],leftSideSplit[i],0);
                    }else{
                         outputMessage = outputMessage+"+" +Integer.parseInt(rightSideSplit[j]) * Integer.parseInt(leftSideSplit[i]);// its the last part +c by +c
                    }

               }
          }
          // work on checking how many terms the brackets has, x+c ,x , x^2+c etc should be able to deal with all of these cases.
          outputMessage =removeExcess(outputMessage);// sort out extra -'s and +'s

          if(outputMessage.charAt(0)=='+'){ // if the first one is a + take it away
               outputMessage = outputMessage.substring(1);
          }

          outputMessage = GroupAlikeTerms(outputMessage,checkingFor); // sort out the X^ terms to be all the same
          return (outputMessage);
     }
     public static String SplitTheTerms(String toSplit){
          String SplitTerms ="";
          for(int i = 0; i<toSplit.length();i++){

                    if((toSplit.charAt(i))=='-'){
                         if(i==0){
                              SplitTerms =""+ toSplit.charAt(i);
                         }else{
                              SplitTerms = SplitTerms+","+toSplit.charAt(i);
                         }
                    }else if(toSplit.charAt(i)=='+'){
                         SplitTerms =SplitTerms + "," + toSplit.charAt(i);
                    }else{
                      SplitTerms = SplitTerms +toSplit.charAt(i);
                    }

          }
          return(SplitTerms);
     }
     public static String removeExcess(String toRemove){
          //String OutputWithoutExtras = "";
          for(int i =0;i<(toRemove.length()-1);i++){
               if(toRemove.charAt(i)=='+'){
                    if(toRemove.charAt(i+1)=='-'){
                         toRemove =removeExcessPT2(toRemove,i);
                    }
               }
          }
          return(toRemove);
     }
     public static String removeExcessPT2(String toRemove, int p){ // remove extra stuff
          return(toRemove.substring(0,p)+toRemove.substring(p+1));
     }
     public static String RaisePowerByOneStart(String toBeRaised){
          if(toBeRaised.contains("X")){ // if there is X's to differentiate
               return(RaisePowerByOneMain(toBeRaised,"X"));
          }
          if(toBeRaised.contains("Y")){ // if there is Y's
               return(RaisePowerByOneMain(toBeRaised,"Y"));
          }
          return("Problem in RaisePowerByOneStart"); // its not been given in X's or Y's
     } // not used
     public static String RaisePowerByOneMain(String toBeRaised,String whatCharacter){ // this function takes a postive/negative number and increase power by 1
          int isThereAMinus = 0;
          int power =1;
          if(toBeRaised.contains("\\-")){ // if there is a minus, move one across more for the constant
               isThereAMinus = 1;
          }
          toBeRaised = toBeRaised.replaceAll("[\\[\\](){}]",""); // get rid of all the brackets
          String[] splittingOnChar = toBeRaised.split(whatCharacter); // split up based on the character, gets the power and the constant
          int coeffcient =Integer.parseInt(splittingOnChar[0].substring(isThereAMinus)); // gets the coeffcient
          if(toBeRaised.contains("^")){ // if there is a power already
               power = Integer.parseInt(splittingOnChar[1].substring(1)); // if so get it
          }
          power ++; // increase the power
          if(isThereAMinus==0){ // if there is not a minus
               return(coeffcient+whatCharacter+"^"+power); // no minus needed in the return
          }else{
               return("-"+coeffcient+whatCharacter+"^"+power); // minus needed in the return
          }

     }
     public static String TimesCoeffcientConstantStart(String toBeTimesed, String byWhat, int CalledByXS){
          if(toBeTimesed.contains("X")){ // if its in X's
               return(TimesCoeffcientConstantMain(toBeTimesed,"X",byWhat,CalledByXS));
          }
          if(toBeTimesed.contains("Y")){ // if there is Y's
               return(TimesCoeffcientConstantMain(toBeTimesed,"Y",byWhat,CalledByXS));
          }
          return ("Problem in TimeCoeffcient");
     }
     public static String TimesCoeffcientConstantMain(String toBeTimesed,String whatCharacter, String byWhat,int CalledByXS){// times a x without power by a constant .
          int toBeTimesedHasAMinus = 0; // if there is a minus is 1
          int byWhatHasAMinus = 0; // if there is a minus is a 1, from byWhat
          int byWhatInteger = 0; // useful for conversion
          int toBeTimesedHasPower = 0;
          int coeffcient = 1;
          if(toBeTimesed.contains("\\-")){// if there is a minus
              toBeTimesedHasAMinus= 1; // flag
          }
          if(byWhat.contains("\\-")){ // if there is a minus
               byWhatHasAMinus = 1;
          }
          if(toBeTimesed.contains("^")){
               toBeTimesedHasPower = 1;
          }
          toBeTimesed = toBeTimesed.replaceAll("[\\[\\](){}]","");
          String[] splittingOnChar = toBeTimesed.split(whatCharacter);
          try{
                coeffcient =Integer.parseInt(splittingOnChar[0].substring(toBeTimesedHasAMinus));
          }
          catch(Exception e){
                coeffcient = 1;
          }

          if(CalledByXS==1){

               if((toBeTimesedHasAMinus==1)&&(byWhatHasAMinus==1)){

                    byWhatInteger = Integer.parseInt(byWhat.substring(1));
                    return(coeffcient*byWhatInteger+whatCharacter);
               }else if((toBeTimesedHasAMinus==0)&&(byWhatHasAMinus==0)){
                    try{

                              byWhatInteger = Integer.parseInt(byWhat);
                    }
                    catch(Exception e){

                          byWhatInteger =1;
                    }

                    return("+"+coeffcient*byWhatInteger+whatCharacter);
               }else{
                    byWhatInteger = Integer.parseInt(byWhat.substring(1));

                    return("-"+coeffcient*byWhatInteger+whatCharacter);
               }
          }else{
               if(toBeTimesedHasPower==1){

                    if((toBeTimesedHasAMinus==1)&&(byWhatHasAMinus==1)){
                         byWhatInteger = Integer.parseInt(byWhat.substring(1));
                         return(coeffcient*byWhatInteger+whatCharacter+splittingOnChar[1]);
                    }else if((toBeTimesedHasAMinus==0)&&(byWhatHasAMinus==0)){
                         byWhatInteger = Integer.parseInt(byWhat);
                         return("+"+coeffcient*byWhatInteger+whatCharacter+splittingOnChar[1]);
                    }else{
                         byWhatInteger = Integer.parseInt(byWhat.substring(1));
                         return("-"+coeffcient*byWhatInteger+whatCharacter+splittingOnChar[1]);
                    }
               }else{

                    if((toBeTimesedHasAMinus==1)&&(byWhatHasAMinus==1)){
                         byWhatInteger = Integer.parseInt(byWhat.substring(1));
                         return(coeffcient*byWhatInteger+whatCharacter);
                    }else if((toBeTimesedHasAMinus==0)&&(byWhatHasAMinus==0)){
                         byWhatInteger = Integer.parseInt(byWhat);
                         return("+"+coeffcient*byWhatInteger+whatCharacter);
                    }else{
                         byWhatInteger = Integer.parseInt(byWhat.substring(1));
                         return("-"+coeffcient*byWhatInteger+whatCharacter);
                    }
               }
          }

     }
     public static String GroupAlikeTerms(String groupMe,String whatCharacter){ //  sorts out terms which are next to each other +'s and -'s
          groupMe = SplitTheTerms(groupMe);
          //groupMe = groupMe.substring(1);
          String leftHandSide ="";
          String rightHandSide="";
          int leftHandSideInt =0;
          int rightHandSideInt = 0;
          String[] groupMeSplit = groupMe.split("\\,");
          String[] outputArray = new String[groupMeSplit.length];
          String store = "";
          int replacementArrayCount = 0;
          String outputString = "";
          int constantAddEnd = 0;
          int n = (groupMeSplit.length-1);
               for(int i = 0;i< n;i++){ // sort the powers into an arrange order
                    for(int j=0;j<(n-i);j++){
                         leftHandSide = GetPower(groupMeSplit[j],whatCharacter);
                         rightHandSide = GetPower(groupMeSplit[j+1],whatCharacter);
                         leftHandSideInt = Integer.parseInt(leftHandSide);
                         rightHandSideInt = Integer.parseInt(rightHandSide);
                         if(leftHandSideInt<rightHandSideInt){
                              store = groupMeSplit[j];
                              groupMeSplit[j] = groupMeSplit[j+1];
                              groupMeSplit[j+1] = store;
                         }
                    }
               }

               for(int k = 0;k<n;k++){
                    if(Integer.parseInt(GetPower(groupMeSplit[k],whatCharacter))==(Integer.parseInt(GetPower(groupMeSplit[k+1],whatCharacter ) ) ) ){
                         if(Integer.parseInt(GetPower(groupMeSplit[k],whatCharacter))==0) {
                         //     constantAddEnd = Integer.parseInt(groupMeSplit[k+1]); //wokrs without
                         }else if(Integer.parseInt(GetPower(groupMeSplit[k],whatCharacter))==1) {
                              groupMeSplit[k] = (AddTwo(GetCoeffcient(groupMeSplit[k],whatCharacter),GetCoeffcient(groupMeSplit[k+1],whatCharacter) )+whatCharacter);

                         }else{
                              groupMeSplit[k] = (AddTwo(GetCoeffcient(groupMeSplit[k],whatCharacter),GetCoeffcient(groupMeSplit[k+1],whatCharacter) )+whatCharacter+"^"+GetPower(groupMeSplit[k],whatCharacter));
                         }
                    }
                    if(k>0){
                         if(Integer.parseInt(GetPower(groupMeSplit[k-1],whatCharacter))==(Integer.parseInt(GetPower(groupMeSplit[k],whatCharacter ) ) ) ){
                              groupMeSplit[k]="";
                         }
                    }
               }

               for(int j =0; j<groupMeSplit.length ; j++){
                    if(groupMeSplit[j].contains("Remove")){
                         groupMeSplit[j]="";
                         groupMeSplit[j+1]="";

                    }else{
                         outputArray[replacementArrayCount]=groupMeSplit[j];
                         replacementArrayCount++;
                    }
               }

          for(int usageForReform = 0 ; usageForReform<replacementArrayCount ; usageForReform++){
               outputString += outputArray[usageForReform];
          }
           return(outputString);
        }
     public static String GetPower(String fullPart,String whatCharacter){
          if(fullPart.contains("^")){
               String[] power = fullPart.split("\\^");

               return(power[1]);
          }else{
               if(fullPart.contains(whatCharacter)){

                    return("1");
               }
          }

          return("0");
     } // not used could be useful
     public static String GetCoeffcientStarter(String fullPart){ // not used could be useful
          if(fullPart.contains("X")){ // if there is X's to differentiate
               return(GetCoeffcient(fullPart,"X"));
          }
          if(fullPart.contains("Y")){ // if there is Y's
               return(GetCoeffcient(fullPart,"Y"));
          }
          return("Problem in GetCoeffcientStarter"); // its not been given in X's or Y's
     }
     public static String GetCoeffcient(String fullPart, String whatCharacter){

          if(fullPart.contains(whatCharacter)){
               String[] coeffcient = fullPart.split(whatCharacter);
               return(coeffcient[0]);
          }else{
               return fullPart;
          }

     }// get the coeffcient and
     public static String AddTwo(String leftHandSide, String rightHandSide){ // add two sides together 
          int plusCount = 0;
          int minusCount = 0;

          if(leftHandSide.contains("-")){

               leftHandSide = leftHandSide.substring(1);
               minusCount++;
          }
          if(rightHandSide.contains("-")){

               rightHandSide = rightHandSide.substring(1);
               minusCount++;
          }
          if(leftHandSide.contains("+")){
               leftHandSide = leftHandSide.substring(1);
          }
          if(rightHandSide.contains("+")){
               rightHandSide = rightHandSide.substring(1);
          }

          int left = Integer.parseInt(leftHandSide);
          int right = Integer.parseInt(rightHandSide);

          if((minusCount==1)){
               int outputMinus =left-right;
               if(outputMinus == 0){
                    return("Remove");
               }else{
                    return("-"+outputMinus);
               }

          }else if(minusCount==2) {
               int outputPlus = left +right;

               return("-"+outputPlus);
          }else{
               int outputPlus = left +right;

               return("+"+outputPlus);
          }

     }
     public static String TimesXsByXs(String leftHandSide, String rightHandSide, String checkingFor){ // times any X^power by any X^power
          String[] constantLeft = leftHandSide.split(checkingFor);// get rid of X/Y
          String[] constantRight = rightHandSide.split(checkingFor);// get rid of the X/Y
          String[] powerLeft; // used later for a split to get the power
          String[] powerRight;
          int leftPower= 1; // standard power if none is found for leftPower
          int rightPower= 1; // standard power if none is found for rightPower
          int power =1; // overal power for output
          if(leftHandSide.contains("^")){ // get the
               powerLeft= leftHandSide.split("\\^");
               leftPower = Integer.parseInt(powerLeft[1]);
          }
          if(rightHandSide.contains("^")){
               powerRight = rightHandSide.split("\\^");
               rightPower = Integer.parseInt(powerRight[1]);
          }
          power = rightPower + leftPower;
          return((TimesCoeffcientConstantStart(leftHandSide,constantRight[0],1))+"^"+power);
     }
     public static String TimesConstantByConstant(String leftHandSide, String rightHandSide){
          int minusCount =0;

          if(leftHandSide.contains("-")){

               leftHandSide = leftHandSide.substring(1);
               minusCount++;
          }
          if(rightHandSide.contains("-")){

               rightHandSide = rightHandSide.substring(1);
               minusCount++;
          }
          if(leftHandSide.contains("+")){
               leftHandSide = leftHandSide.substring(1);
          }
          if(rightHandSide.contains("+")){
               rightHandSide = rightHandSide.substring(1);
          }

          int left = Integer.parseInt(leftHandSide);
          int right = Integer.parseInt(rightHandSide);

          int minusCountModTwo = minusCount %2;
          if(minusCountModTwo==0){

               return("+"+left*right);
          }else{
               return("-"+left*right);
          }

     }
     public static void main(String args[]){
          System.out.println(MultiplyingBracketsStarter("-1X^5-5X-5","-1X^5-5X-5"));
          System.out.println(MultiplyingBracketsStarter("-1X^5-5X+5","3X^3-3X"));
          System.out.println(MultiplyingBracketsStarter("1X^5-5X-5","-1X^5-5X-5"));
          System.out.println(MultiplyingBracketsStarter("-1X^5+5X-5","-1X^5-5X-5"));
          System.out.println(MultiplyingBracketsStarter("-1X^5-5X+5","-1X^5-5X-5"));
          System.out.println(MultiplyingBracketsStarter("-1X^5-5X-5","-1X^5-5X-5"));
          System.out.println(MultiplyingBracketsStarter("X^5+5X+5"));
          System.out.println(MultiplyingBracketsStarter("X^5-5X-5"));
          System.out.println();

     }
}
