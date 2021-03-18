package com.smt.kata.code;

import java.util.*;

/****************************************************************************
 * <b>Title</b>: MorseCodeTranslator.java
 * <b>Project</b>: SMT-Kata
 * <b>Description: </b> Morse Code converter.  Take any phrase and convert it to 
 * its morse code equivelant and decode a morse code phrase back to english.  In morse
 * code, spaces separate the letters and " / " separates words
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Mar 15, 2021
 * @updates:
 ****************************************************************************/
public class MorseCodeTranslator {
	Map<String,String> morse;
    /**
     * 
     */
    public MorseCodeTranslator() {
        super();
        
        Map<String, String> morse = new HashMap<String, String>();
        morse.put("A", ".-");
        morse.put("B", "-...");
        morse.put("C", "-.-.");
        morse.put("D", "-..");
        morse.put("E", ".");
        morse.put("F", "..-.");
        morse.put("G", "--.");
        morse.put("H", "....");
        morse.put("I", "..");
        morse.put("J", ".---");
        morse.put("K", "-.-");
        morse.put("L", ".-..");
        morse.put("M", "--");
        morse.put("N", "-.");
        morse.put("O", "---");
        morse.put("P", ".--.");
        morse.put("Q", "--.-");
        morse.put("R", ".-.");
        morse.put("S", "...");
        morse.put("T", "-");
        morse.put("U", "..-");
        morse.put("V", "...-");
        morse.put("W", ".--");
        morse.put("X", "-..-");
        morse.put("Y", "-.--");
        morse.put("Z", "--..");
        morse.put("1", ".----");
        morse.put("2", "..---");
        morse.put("3", "...--");
        morse.put("4", "....-");
        morse.put("5", ".....");
        morse.put("6", "-....");
        morse.put("7", "--...");
        morse.put("8", "---..");
        morse.put("9", "----.");
        morse.put("0", "-----");
        
        this.morse = morse;
    }
    
    /**
     * Converts a phrase or word into morse code
     * @param phrase any set of characters or numbers
     * @return Morse code as a space delimited document
     */
    public String encode(String phrase) {
        if(phrase == null || phrase.length() == 0) return "";
        
        String output = "";
        String[] words = phrase.split(" ");
        for(int x = 0; x < words.length; x++) {
            char[] letters = words[x].toCharArray();
            for(int y = 0; y < letters.length; y++) {
                String val = this.morse.get(letters[y] + "");
                if(val != null) {
                    output += val;
                    if(y != letters.length - 1) output += " ";
                }
            }
            if(x != words.length - 1)  output += " / ";
        }
        
        return output;
    }
    
    /**
     * Decodes a morse code encoded phrase
     * @param encodedPhrase Uses spaces as the letter delimiter and / as the word delimiter
     * @return English phrase decoded form the morse code snippet
     */
    public String decode(String encodedPhrase) {
        if(encodedPhrase == null || encodedPhrase.length() == 0) return "";
        String output = "";
        String[] words = encodedPhrase.split(" / ");
        for(int x = 0; x < words.length; x++) {
            String[] letters = words[x].split(" ");
            for(int y = 0; y < letters.length; y++) {
                String xx = getKeyByValue(letters[y]);
                if(xx != null) output += xx;
            }
            
            if(x != words.length - 1) output += " ";
        }
        
        return output;
    }
    
    public String getKeyByValue(String value) {
        for (Entry<String, String> entry : this.morse.entrySet()) {
            if (value.equals(entry.getValue())) return entry.getKey();
        }
        return null;
    }
}
