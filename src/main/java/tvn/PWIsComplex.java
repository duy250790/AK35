package tvn;

public class PWIsComplex {
    public boolean pwIsComplex(String myStr){
        boolean isOverSix = false;
        boolean isNumber = false;
        boolean isUpperCase = false;
        boolean isLowerCase = false;
        if (myStr.length() > 6){
            isOverSix = true;
        }
        for(int i = 0; i < myStr.length(); i ++){
            if (Character.isDigit(myStr.charAt(i))){
                isNumber = true;
            }
            else if (Character.isUpperCase(myStr.charAt(i))){
                isUpperCase = true;
            }
            else if (Character.isLowerCase(myStr.charAt(i))){
                isLowerCase= true;
            }
        }

        if(isOverSix == true && isNumber ==true && isUpperCase == true && isLowerCase == true){
            return true;
        }
        else return false;
    }


}
