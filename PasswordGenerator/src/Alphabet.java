public class Alphabet {
    public static final String UPPERCASE_LETTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"; //all possible uppercase letters contained in a singular string
    public static final String LOWERCASE_LETTERS = "abcdefghijklmnopqrstuvwxyz";//all possible lowercase letters contained in a singular string
    public static final String NUMBERS = "1234567890";//numbers 0-9 contained in a singular string
    public static final String SYMBOLS = "!@#$%^&*()-_=+\\/~?";//all symbols contained in a singular string

    private final StringBuilder pool;//attribute that utilizes the StringBuilder class

    /**
     * This method takes in four parameters and creates an attribute with a new StringBuilder() method
     * from there it uses multiple conditionals to decide what type of characters it should append with
     * to the attribute using the StringBuilder() method
     * @param uppercaseIncluded //boolean type for including uppercase letters
     * @param lowercaseIncluded //boolean type for including lowercase letters
     * @param numbersIncluded //boolean type for including numbers
     * @param specialCharactersIncluded //boolean type for including symbols
     */
    public Alphabet (boolean uppercaseIncluded, boolean lowercaseIncluded, boolean numbersIncluded, boolean specialCharactersIncluded){
        pool = new StringBuilder(); //creates an attribute that utilizes the string builder method
        if(uppercaseIncluded) pool.append(UPPERCASE_LETTERS); //if uppercase letters are to be included it appends them to the attribute
        if(lowercaseIncluded) pool.append(LOWERCASE_LETTERS); //if lowercase letters are to be included it appends them to the attribute
        if(numbersIncluded) pool.append(NUMBERS); //if numbers are to be included it appends them to the attribute
        if(specialCharactersIncluded) pool.append(SYMBOLS); //if symbols are to be included it appends them to the attribute
    }

    /**
     * This is a getter method
     * @return a type String using the toString() method for the Alphabet's attribute that had been appended
     */
    public String getAlphabet(){
        return pool.toString();
    }
}
