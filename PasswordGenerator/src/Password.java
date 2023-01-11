public class Password {
    String Value; //attribute used in the toString method
    int Length; //attribute used to tell length of string passed to class

    /**
     * Constructor used to find the value and length of the string
     * @param s string is passed and graded with the following scale
     */
    public Password(String s){
        Value = s; //the given string
        Length = s.length(); //the length of the string
    }
    public int CharType(char C){
        int val; //to be used as a counter, implemented when the conditionals pass

        if((int) C >= 65&&(int) C<=90) //ASCII uppercase letters
        val = 1;

        else if((int) C >= 97&&(int) C <= 122){ //lowercase letters
            val = 2;
        }
        else if((int) C >= 48 && (int) C <= 57){ //numbers
            val = 3;
        }
        else if((int) C >= 33 && (int) C <= 47){
            val = 4; //all other characters 
        }
        else if((int) C >= 58 && (int) C <= 64){
            val = 4; //all other characters
        }
        else if((int) C >= 91 && (int) C <= 96){
            val = 4; //all other characters
        }
        else if((int) C >= 123 && (int) C <= 126){
            val = 4; //all other characters
        } 
        else {
            val = -1;
        }
        return val; //return the value that will be used in the PasswordStrength() method to determine the characters used
    }

    /**
     * This method is used to determine the strength of the password. It takes in various information
     * Things such as the length of the password and if the password used multiple types of characters
     * from there is awards a point for each password modification that makes your password stronger
     * @return an int Score that is used to rank the strength of your password
     */
    public int PasswordStrength() {
        String s = this.Value; //
        boolean UsedUpper = false; //if uppercase is used
        boolean UsedLower = false; //if lowercase is used
        boolean UsedNum = false; //if numbers are used
        boolean UsedSym = false; //if symbols are used
        int type; //assigned to the character the index is on
        int Score = 0; //the total score of the password

        for (int i = 0; i<s.length(); i++){ //iterates through the string that is being tested as a password
            char c = s.charAt(i); //assigned to the character that the index is on
            type = CharType(c); //assigned to the type of character that the index is on

            if (type == 1) UsedUpper = true; //if the char type is 1 then uppercased is used
            if (type == 2) UsedLower = true; //if the char type is 2 then lowercase is used
            if (type == 3) UsedNum = true; //if the char type is 3 then numbers are used
            if (type == 4) UsedSym = true; //if the char type is 4 then symbols are used
        }
        if (UsedUpper) Score += 1; //add one to score if uppercase is used
        if (UsedLower) Score += 1; //add one to score if lowercase is used
        if (UsedNum) Score += 1; //add one to score if numbers are used
        if (UsedSym) Score += 1; //add one to score if symbols are used

        if (s.length() >= 8 && s.length() <= 15) Score += 1; //if length is greater than 7 but less than 16 add one
        if(s.length() >= 16) Score += 1; //if length is greater than 15 add one

        return Score; //return the accumulated score
    }

    /**
     * Calculates the score by using the method PasswordStrength()
     * @return a string that is determined by the attribute Score numerical value
     */
    public String calculateScore(){
        int Score = this.PasswordStrength();//calls the method PasswordStrength() on the attribute Score

        if (Score == 5) {//if Score is equal to 5 then following code runs
            return "This is a very good password :D check the Useful Information section to make sure it satisfies the guidelines";
        } else if (Score == 4) {//if Score is equal to 4 then following code runs
            return "This is a  good password :) but you can do still do better";
        }else if (Score == 3){//if Score is equal to 3 then following code runs
            return "This is a medium password :/ try making it better";
        }else{//if Score is not equal to 3,4, or 5 then the following code runs
            return "This is a weak password :( definitely find a new one";
        }
    }
    @Override
    public String toString(){
        return Value;
    }
}
