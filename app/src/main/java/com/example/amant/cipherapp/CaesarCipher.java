package com.example.amant.cipherapp;

/**
 * Created by amant on 22-01-2018.
 */

public class CaesarCipher {

    private String input;
    private String cryptedInput;
    private Integer shiftValue;

    public CaesarCipher () {}

    public void setInput (String input){
        this.input = input;
    }

    public void setShiftValue (Integer shiftValue){
        this.shiftValue = shiftValue;
    }

    public String getCryptedInput() {
        return this.cryptedInput;
    }

    public void caesar() {

        String cryptedInput = " ";
        char letter;
        int ascii;

        for(int i =0; i < this.input.length(); i++){

            letter = this.input.charAt(i);

            if(letter != ' '){
                ascii = (int) letter;

                ascii = ascii + (this.shiftValue%26);
                ascii = ascii > 'Z' ? ascii-26 : ascii;

                cryptedInput = cryptedInput + (char) ascii;
            }
            else{
                cryptedInput = cryptedInput + ' ';
            }
        }
        this.cryptedInput = cryptedInput;
    }

}
