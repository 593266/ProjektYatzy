package no.hvl.dat109.proj2.yatzy.services;

public class MyValidator {

    public static final String ANY_LETTER_SPACE_OR_HYPHEN = "[a-zA-ZæøåÆØÅ -]";
    public static final String ANY_LETTER_OR_HYPHEN = "[a-zA-ZæøåÆØÅ-]";
    public static final String ANY_CAPITAL_LETTER = "[A-ZÆØÅ]";
    public static final String ANY_DIGIT = "[0-9]";

    public static final String ZERO_OR_MORE_TIMES = "*";
    public static final String ONE_TO_NINETEEN_TIMES = "{1,19}";
    public static final String EIGHT_TIMES = "{8}";

    public static boolean isValidUsername(String username) {
    	return username != null;
    }

    public static boolean isValidEmail(String email) {
    	return email != null;
    	
    	//FIKS
    }

    /**
     * @param fornavn
     * @return
     */
    public static boolean isValidName(String name) {
        return name != null 
        		&& name.matches("^" + ANY_CAPITAL_LETTER
                + ANY_LETTER_SPACE_OR_HYPHEN + ONE_TO_NINETEEN_TIMES + "$");
    }

    


	public static boolean isValidPassword(String passord) {
		return passord != null && passord.length() >= 4; //Ikke helt bra, men ...
	}
    
 }
