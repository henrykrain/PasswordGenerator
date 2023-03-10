import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class GeneratorTest {
    //attributes like these should be inside the tests

    @Test //KZarzour original test, made some minor refactorations, but its still the same concept
    public void test_does_the_method_toString_return_the_correct_value() {
        Password password = new Password("Secret");
        assertEquals("Secret", password.toString());
    }
    @Test //KZarzour original test, made some minor refactorations, but its still the same concept
    public void test_are_the_characters_being_used_only_caps(){
        Alphabet firstAlphabet = new Alphabet(true,false,false,false);
        assertEquals(firstAlphabet.getAlphabet(), Alphabet.UPPERCASE_LETTERS);
    }

    @Test //KZarzour original test, made some minor refactorations, but its still the same concept
    public void test_are_the_characters_being_used_everything_but_caps(){
        Alphabet secondAlphabet = new Alphabet(false,true,true,true);
        assertEquals(secondAlphabet.getAlphabet(), Alphabet.LOWERCASE_LETTERS + Alphabet.NUMBERS + Alphabet.SYMBOLS);
    }

    @Test //KZarzour original test, made some minor refactorations, but its still the same concept
    public void test_is_the_generator_creating_an_alphabet_with_only_caps(){
        Generator generator = new Generator (true, false, false, false);
        assertEquals(generator.alphabet.getAlphabet(), Alphabet.UPPERCASE_LETTERS);
    }

    @Test //KZarzour original test, made some minor refactorations, but its still the same concept
    public void test_is_the_generator_creating_an_alphabet_of_length_26(){  
        Generator generator = new Generator (true, false, false, false);
        assertEquals(generator.alphabet.getAlphabet().length(),26);
    }

    @Test 
    public void test_is_the_password_scoring_method_correct(){
        Password password = new Password("JingleBellKeys12!");
        int actual = password.PasswordStrength();
        assertEquals(5,actual);
    }
    @Test
    public void test_is_the_password_scoring_method_correct_2(){
        Password password = new Password("1");
        int actual = password.PasswordStrength();
        assertEquals(1, actual);
    }
    @Test
    public void test_is_the_password_scoring_method_correct_3(){
        Password password = new Password("hhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhh");
        int actual = password.PasswordStrength();
        assertEquals(2, actual);
    }
}
