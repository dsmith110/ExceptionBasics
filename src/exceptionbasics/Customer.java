package exceptionbasics;

import javax.swing.JOptionPane;

public class Customer {
    private String state;
    private String ssn;

    /*
     * Add these lName, fName, zip validate setters 
     */
    public String getSsn() {
        return ssn;
    }
    
    /**
     * Sets a social security number.
     * 
     * @param ssn - the value
     * @throws IllegalArgumentException if ssn does not contain 9 digits and 
     * optionally, two "-" characters.
     */
    public void setSsn(String ssn) throws IllegalArgumentException {
        if(ssn == null) {
            throw new IllegalArgumentException("SSN cannot be null");
        }
        
        String[] pieces = ssn.split("-");
        
        if(ssn.contains("-") && pieces.length != 3) {
            throw new IllegalArgumentException("Must have 2 hyphens");
        }
        
        ssn = ssn.replaceAll("-", "");
        
        if(ssn.length() != 9) {
            throw new IllegalArgumentException("Must have 9 digits");
        }
        
        char[] chars = ssn.toCharArray();
        
        for (char c : chars) {
            if(!Character.isDigit(c)) {
                throw new IllegalArgumentException("Must have 9 digits");
            }
        }
        this.ssn = ssn;
    }
    
    

    public String getState() {
        return state;
    }

    /**
     * A method that sets the state for this customer.
     * @param state - a two-character abbreviation for state
     * @throws IllegalArgumentException if state is not 2 characters in length
     */
    public void setState(String state) throws IllegalArgumentException {

        if(state == null || state.length() != 2) {
            throw new IllegalArgumentException (
                    "state must be 2 characters in length");

        }
        this.state = state;
    }


}
