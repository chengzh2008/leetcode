package src.main.test;

import org.junit.Test;
import src.main.java.PalindromePartitionI;
import src.main.java.PalindromePartitionIDP;
import src.main.java.PalindromePartitionII;

public class PalindromePartitionITest {
    @Test
    public void shouldPrintSet() {
        String s = "aaaabbbb";
        PalindromePartitionI palindromePartitionI = new PalindromePartitionI(s);
        System.out.println(palindromePartitionI.getListRecursive());

        PalindromePartitionIDP palindromePartitionIDP = new PalindromePartitionIDP();
        System.out.println(palindromePartitionIDP.getListDP(s));

        PalindromePartitionII palindromePartitionII = new PalindromePartitionII();
        System.out.println(palindromePartitionII.minCut(s));
    }
}