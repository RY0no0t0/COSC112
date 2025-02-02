import java.util.Random;

public class SubstitutionCipher extends Cipher {

    public SubstitutionCipher (long key) {
        super(key);
    }

    public NiceList<Character> encrypt (NiceList<Character> cleartext) {

        NiceList<Character> ciphertext = Cipher.createList();

        Random r = new Random(getKey());

        // Shift each character of the cleartext, appending the result to the
        // ciphertext.  Assume an English encoding with 256 possible character
        // values, wrapping around any shifts beyond a value of 255.
        for (int i = 0; i < cleartext.length(); i += 1) {
    
            char clearchar  = cleartext.get(i);
            // int thekey = r.nextInt(256);
            // char cipherchar = (char)((clearchar + thekey));
            char cipherchar = (char)((clearchar + r.nextInt(256)));
            ciphertext.insert(i, cipherchar);
    
        }
    
        return ciphertext;
        
    } // encrypt ()

        public NiceList<Character> decrypt (NiceList<Character> ciphertext) {

            NiceList<Character> cleartext = Cipher.createList();

            Random r = new Random(getKey());
        
            // Shift each character of the cleartext, appending the result to the
            // ciphertext.  Assume an English encoding with 256 possible character
            // values, wrapping around any shifts beyond a value of 255.
            for (int i = 0; i < ciphertext.length(); i += 1) {
        
                char cipherchar = ciphertext.get(i);
                // System.out.println("char is "+ cipherchar);
                // int thekey = r.nextInt(256);
                // char clearchar  = (char)((cipherchar - thekey));
                char clearchar  = (char)((cipherchar - (r.nextInt(256))));
                // System.out.println("char is "+ clearchar+" and int is "+thekey);
                cleartext.insert(i, clearchar);
        
            }
        
            return cleartext;
            
        } // decrypt ()
}