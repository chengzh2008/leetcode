package src.main.java;

import java.util.ArrayList;
import java.util.List;

/**
 * return a list of primer numbers smaller than n.
 */
public class PrimerNumberBeforeN {
    public static List<Integer> primersN(int n) {
        List<Integer> result = new ArrayList<>();
        result.add(2);
        boolean isPrimer = true;
        for (int i = 3; i < n; i+=2) {
            for(int r : result) {
                if (i < 2 * r) {
                    break;
                }
                if (i % r == 0) {
                    isPrimer = false;
                    break;
                }
            }
            if(isPrimer) {
                result.add(i);
            }
            isPrimer = true;

        }
        return result;
    }

    public static List<Integer> firstNthPrimer(int n) {
        List<Integer> result = new ArrayList<>();
        result.add(2);
        int start = 3;
        boolean isPrimer = true;
        while(result.size() < n) {
            for(int r : result) {
                if (start < 2 * r) {
                    break;
                }
                if (start % r == 0) {
                    isPrimer = false;
                    break;
                }
            }
            if (isPrimer) {
                result.add(start);
            } else {
                isPrimer = true;
            }
            start +=2;
        }
        return result;
    }

    public static int sumOfFirstNthPrimer(int n) {
        List<Integer> result = new ArrayList<>();
        result.add(2);
        int sum = 2;
        if (n <= 0) return 0;
        if (n == 1) return sum;
        int start = 3;
        boolean isPrimer = true;
        while(result.size() < n) {
            for(int r : result) {
                if (start < 2 * r) {
                    break;
                }
                if (start % r == 0) {
                    isPrimer = false;
                    break;
                }
            }
            if (isPrimer) {
                result.add(start);
                sum+=start;
            } else {
                isPrimer = true;
            }
            start +=2;
        }
        return sum;
    }

    public static void main(String[] args) {
//        System.out.println(p.primersN(150));
        System.out.println(sumOfFirstNthPrimer(1000));
    }
}
