import java.util.Scanner;

public class Generator{

    /**represents the possible letters and characters possible*/
    Alphabet alphabet;

    /*** introduces a scanner class, allowing users to input their own data*/
    public static Scanner keyboard;

    /**
     * creates a scanner and assigns it to the previously declared attribute "keyboard"
     * @param scanner a scanner to be used 
     */
    public Generator(Scanner scanner){
        keyboard = scanner;
    }

    /**
     * creates a string containing uppercase letters, lowercase letters, numbers, or/and symbols
     * @param includeUpper includes uppercase letters
     * @param includeLower includes lowercase letters
     * @param includeNum includes numbers (0-9)
     * @param includeSym includes symbols
     */
    public Generator(boolean includeUpper, boolean includeLower, boolean includeNum, boolean includeSym){
        alphabet = new Alphabet(includeUpper, includeLower, includeNum, includeSym);
    }

    /**
     * Outputs the menu with 4 options for the user to select
     * The user's input will direct them to a new "screen"
     * to fillfull the commands they have requested
     * 1.)User creates new password
     * 2.)User checks this current password strength against common (somewhat out of date) criteria
     * 3.)User recieves lines of helpful tips (again somewhat out of date) for strong passwords
     * 4.)Closes program
     */
    public void mainLoop() {
        System.out.println("welcome to Hery Kain Password Services");
        printMenu(); //prints available options for user to select

        String userOption = "-1";//sets initial userOption to -1

        while(!userOption.equals("4")){//while the user has not selected 4 keep the loop running

            userOption = keyboard.next();//allows userOption to be user inputed

            //switch is similar to an if-then-else, but more simplistic. IMO Ziz chose it 
            //because its more readable and simplisitc
            //went for an alternative swtich syntax
            //compare his to https://docs.oracle.com/javase/tutorial/java/nutsandbolts/switch.html example

            switch(userOption){
                case "1" -> { //if userOption is 1 run following code
                System.out.println("Hello, welcome to the password generator :) answer"
                + " the following questions by Yes or No\n");
                requestPassword(); //this method allows user to create a randomy generated password
                }

                case "2" -> { //if userOption is 2 run following code
                checkPassword(); //this method allows user to enter their password and check its strength
                printMenu(); //prints available options for user to select
                }

                case "3" -> { //if userOption is 3 run following code
                printUsefulInfo();//this method prints tips for creating strong passwords
                printMenu();//prints available options for user to select
                }

                case "4" -> { //if userOption is 4 run following code
                printQuitMessage();//closes the program and gives the user a goodbye message :)
                }

                default -> {//is user does not enter a number 1-4 the following code runs
                System.out.println();
                System.out.println("Kindly, select one of the available commands");
                printMenu();//prints available options for user to select
                }

                }
            }
    }

    /**
     * This method is of the class Password and is called from within
     * the method is called within the requestPassword method
     * It creates a random password of user entered length
     * @param length the length of the password
     * @return
     */
    private Password GeneratePassword(int length){
        
        final StringBuilder pass = new StringBuilder(""); //StringBuilder is a method that builds a mutable string. 
 
        final int alphabetLength = alphabet.getAlphabet().length(); //gets the total number of all optionable characters the user selected

        int max = alphabetLength - 1;
        int min = 0;
        int range = max-min+1;

        for (int i = 0; i < length; i++){ //iterate through the length assigned by the user and at each iteration append a random character to the mutable string
            int index = (int) (Math.random() * range) + min; //index is found in an equation that prevents it from exceding the given alphabet's length
            pass.append(alphabet.getAlphabet().charAt(index));//appends a random character to the string at the given index
        }
        return new Password(pass.toString());  //returns a new password as a string
    }

    /**
     * Prints useful information for building strong passwords
     */
    private void printUsefulInfo(){
        System.out.println();
        System.out.println("Use a minimum password length of 8 or more characters if permitted");
        System.out.println("include lowercase and uppercase alphabetic characters, numbers and symbols if permitted");
        System.out.println("Generate passwords randomly where feasible");
        System.out.println("Avoid using the same password twice (e.g., across multiple user accounts and/or software systems");
        System.out.println("Avoic character repetition, keyboard patterns, dictionary words, letter or number sequences," + 
                            "\nusernames, relative or pet names, romantic links (current or past)" +
                            "and biographical information (e.g., ID numbers, ancestors'names or dates");
        System.out.println("avoid using information that the user's colleagues and/or"+
                            "acquaintances might nknow to be associated with the user");
        System.out.println("Do not use passwords which consist wholly of any simple combination of the aforementioned weak components");
    }

    /**
     * reads the user's inputs and creates a randomly generated password
     */
    private void requestPassword(){
        boolean includeUpper = false; //attribute for including uppercase letters
        boolean includeLower = false; //attribute for including lowercase letters
        boolean includeNum = false; //attribute for including numbers
        boolean includeSym = false; //attribute for including symbols

        boolean correctParams = false; //attribute used as the while-loop parameter
                 
        while(!correctParams){

            String input = keyboard.nextLine(); //put an initial nextLine() method to prevent the following nextLine() from being skipped (decoy)

            System.out.println("Do you want lowercase letters \"abcd...\" to be used? ");
            input = keyboard.nextLine(); //user enters yes or no if they want the characters to be included in password generator

            if(isInclude(input)) includeLower = true; //if input is yes, the attribute is now True and its characters are used

            System.out.println("Do you want Uppercase letters \"ABCD...\" to be used? ");
            input = keyboard.nextLine(); //user enters yes or no if they want the characters to be included in password generator

            if(isInclude(input)) includeUpper = true; //if input is yes, the attribute is now True and its characters are used

            System.out.println("Do you want numbers \"1234...\" to be used?");
            input = keyboard.nextLine();//user enters yes or no if they want the characters to be included in password generator

            if(isInclude(input)) includeNum = true; //if input is yes, the attribute is now True and its characters are used

            System.out.println("Do you want Symbols \"!@#$...\" to be used?");
            input = keyboard.nextLine();//user enters yes or no if they want the characters to be included in password generator

            if(isInclude(input)) includeSym = true; //if input is yes, the attribute is now True and its characters are used

            if(!includeUpper && !includeLower && !includeNum && !includeSym){ //if none of the previous character options are selected then the following code executes
                System.out.println("You have selected no chracters to generate your " +
                                    "password \nat least one of your answers should have been Yes\n" +
                                    "Press enter twice to try again or q to quit to the main menu");
                String insert = keyboard.nextLine(); //allows the user to make a new decision
                if(insert.equalsIgnoreCase("q")){ //if user inputs q or Q then they quit to the main menu
                    printMenu(); //opens up the main menu
                }
            }else{
                correctParams = true; //the user has selected to try again and it will allow them to select characters again
            }
        }
        try{ //this is built for sausage finger users who don't enter a number 
            System.out.println("Great! Now enter the length of the password");
            int length = keyboard.nextInt();

            final Generator generator = new Generator(includeUpper, includeLower, includeNum, includeSym); //using the characters selected above create Generator object
            final Password password = generator.GeneratePassword(length); //using the previously made Generator object create a Password object

            System.err.println("Your generated password -> " + password); //print password
            printMenu(); //open up the menu
        }catch (Exception ex){ //if user does not enter a number a input mismatch exception is thrown and they are forced to select characters agin
            System.out.println("You have entered something incorrect, please try again and enter a number");
            requestPassword(); //calls the request password method so user can re-select the methods
        }
    } 
    //does not seem doable

    // public void passwordLength(){
    //     System.out.println("Great! Now enter the length of the password");
    //     int length = keyboard.nextInt();

    //     final Generator generator = new Generator(includeUpper, includeLower, includeNum, includeSym);
    //     final Password password = generator.GeneratePassword(length);

    //     System.err.println("Your generated password -> " + password);
    // }

    /**
     * This method takes in a string. If the string is equal to yes (ignore case) then it returns true 
     * if the user did not enter yes or no (ignore case) then the method PasswordRequestError() is called and isInclude returns false
     * if no is entered then it returns false without calling the method PasswordRequestError()
     * @param Input is the yes, no, or other the user inputs during the requestPassword() method
     * @return a boolean value which will determine if the user has selected the group of characters to use in the password generation
     */
    private boolean isInclude(String Input){
        if(Input.equalsIgnoreCase("yes")){//if yes (ignore case) following code executes
            return true;
        }else{
            if(!Input.equalsIgnoreCase("no")){ //if not no then(ignore case) following code executes
                PasswordRequestError();//method returns a string
            }
            return false;
        }
        
    }

    /**
     * method is only called from within the isInclude method
     * prints a string telling user they have entered an incorrect statement
     */
    private void PasswordRequestError() {
        System.out.println("you have entered something incorrect let's go over it again \n");
    }

    /**
     * method takes in a password and cross checks it with the system's
     * own criteria for a strong password and returns a score and an 
     * evaluation of the entered password (grading and criteria found in Password class)
     */
    private void checkPassword(){
        String input; //creates string attribute to be filled by user

        final Scanner in = new Scanner(System.in); //creates scanner object

        System.out.println("\nEnter your password");

        input = in.nextLine(); //user enters their password

        final Password p = new Password(input); //takes the string the user entered and castes it as a Password type in the Password class constructor

        System.out.println(p.calculateScore()); //using the string the user entered the Password class calculates the strength of the password
                                                //and prints a score
    }

    /**
     * This method prints the program paths for the user to select
     */
    private void printMenu(){
        System.out.println();
        System.out.println("Enter 1 - Password Generator");
        System.out.println("Enter 2 - Password Strength Check");
        System.out.println("Enter 3 - Useful Information");
        System.out.println("Enter 4 - Quit");
        System.out.print("Choice: ");
    }

    /**
     * If 4 is entered from the printMenu method options then the following method 
     * prints a goodbye message and the program ends
     */
    private void printQuitMessage(){
        System.out.println("Closing the program see ya!");
    }

}