import java.util.Scanner;

public class Generator{

    /**
     * represents the possible letters and characters possible
     */
    Alphabet alphabet;

    /**
     * introduces a scanner class, allowing users to input their own data
     */
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

    public void mainLoop() {
        System.out.println("welcome to Hery Kain Password Services");
        printMenu();

        String userOption = "-1";

        while(!userOption.equals("4")){
            userOption = keyboard.next();

            //switch is similar to an if-then-else, but more simplistic. IMO Ziz chose it 
            //because its more readable and simplisitc
            //went for an alternative swtich syntax
            //compare his to https://docs.oracle.com/javase/tutorial/java/nutsandbolts/switch.html example

            switch(userOption){
                case "1" -> { 
                System.out.println("Hello, welcome to the password generator :) answer"
                + " the following questions by Yes or No\n");
                requestPassword();
                }

                case "2" -> {
                checkPassword();
                printMenu();
                }

                case "3" -> {
                printUsefulInfo();
                printMenu();
                }

                case "4" -> {
                printQuitMessage();
                }

                default -> {
                System.out.println();
                System.out.println("Kindly, select one of the available commands");
                printMenu();
                }

                }
            }
    }

    private Password GeneratePassword(int length){
        //StringBuilder is a method that builds a mutuabe string. 
        final StringBuilder pass = new StringBuilder("");

        final int alphabetLength = alphabet.getAlphabet().length();

        int max = alphabetLength - 1;
        int min = 0;
        int range = max-min+1;

        for (int i = 0; i < length; i++){
            int index = (int) (Math.random() * range) + min;
            pass.append(alphabet.getAlphabet().charAt(index));
        }
        return new Password(pass.toString());
    }
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
    private void requestPassword(){
        boolean includeUpper = false;
        boolean includeLower = false;
        boolean includeNum = false;
        boolean includeSym = false;

        boolean correctParams = false;
                 
        while(!correctParams){
            //put an intial 
            String input = keyboard.nextLine();

            System.out.println("Do you want lowercase letters \"abcd...\" to be used? ");
            input = keyboard.nextLine();

            if(isInclude(input)) includeLower = true;

            System.out.println("Do you want Uppercase letters \"ABCD...\" to be used? ");
            input = keyboard.nextLine();

            if(isInclude(input)) includeUpper = true;

            System.out.println("Do you want numbers \"1234...\" to be used?");
            input = keyboard.nextLine();

            if(isInclude(input)) includeNum = true;

            System.out.println("Do you want Symbols \"!@#$...\" to be used?");
            input = keyboard.nextLine();

            if(isInclude(input)) includeSym = true;

            //no pool selected, this is an issue 

            if(!includeUpper && !includeLower && !includeNum && !includeSym){
                System.out.println("You have selected no chracters to generate your " +
                                    "password \nat least one of your answers should have been Yes\n" +
                                    "Press enter twice to try again or q to quit to the main menu");
                String insert = keyboard.nextLine();
                if(insert.equalsIgnoreCase("q")){
                    return;
                }
                correctParams = false;
            }else{
                correctParams = true;
            }
        }
        try{   
            //need to make this following try block a method but how???
            //if its a method I can continously call it in the catch block so users can 
            //try to enter in a number until they fail, the users must be apes or 
            //have sausages for fingers
            System.out.println("Great! Now enter the length of the password");
            int length = keyboard.nextInt();

            final Generator generator = new Generator(includeUpper, includeLower, includeNum, includeSym);
            final Password password = generator.GeneratePassword(length);

            System.err.println("Your generated password -> " + password);
            printMenu();
        }catch (Exception ex){
            System.out.println("You have entered something incorrect, please try again and enter a number");

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
    private boolean isInclude(String Input){
        if(Input.equalsIgnoreCase("yes")){
            return true;
        }else{
            if(!Input.equalsIgnoreCase("no")){
                PasswordRequestError();
            }
            return false;
        }
        
    }
    private void PasswordRequestError() {
        System.out.println("you have entered something incorrect let's go over it again \n");
        //requestPassword();
    }

    private void checkPassword(){
        String input;
        final Scanner in = new Scanner(System.in);

        System.out.println("\nEnter your password");
        input = in.nextLine();

        final Password p = new Password(input);

        System.out.println(p.calculateScore());
    }

    private void printMenu(){
        System.out.println();
        System.out.println("Enter 1 - Password Generator");
        System.out.println("Enter 2 - Password Strength Check");
        System.out.println("Enter 3 - Useful Information");
        System.out.println("Enter 4 - Quit");
        System.out.print("Choice: ");
    }

    private void printQuitMessage(){
        System.out.println("Closing the program see ya!");
    }

}