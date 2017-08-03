package dev.arsensys.cipher;
/**
 *
 * @author Arsen_Toor arsensys@gmail.com
 */
public class Main {

    public static void main(String[] args) {
     CabcAlgorithm ca = new CabcAlgorithm();
     System.out.println(ca.wrapper("Sandwich."));    
     System.out.println(ca.inverseCabc("11065847472C3E0D2C2147460A"));    
     }
}
