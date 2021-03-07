package Lambda;

import java.io.IOException;
import java.util.Scanner;

interface performOperation
{
    int check(int q);
}
class Kukafunction{
    public static int checker(performOperation s ,int num){
        return s.check(num);
    }

    performOperation TakZhup()
    {
        performOperation s =  (q) -> {return q%2;};

        return s;
    }

    performOperation checkPrime ()
    {
        performOperation s =  (q) -> {
            if (q == 1) 
                return 1;
            for(int i = 2;i<q;i++){
                if((q%i)==0)
                    return 1;
            }
            return 0;
        };
        return s;
    }

    performOperation checkPalindrome()
    {
        performOperation s =  (q) -> {
            String slovo = ""+q;
            boolean isPalindrome = true;
            for(int i = 0;i<(int)slovo.length()/2;i++)
            {
                if(slovo.charAt(i) != slovo.charAt(slovo.length()-1-i)){
                    isPalindrome = false;
                    break;

                }
            }
            if(isPalindrome==true){
                return 0;
            }
            else {
                return 1;
            }
        };
        return s;
    }
}

public class Function {

    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        Kukafunction kf = new Kukafunction();
        performOperation po;
        int all;
        int size = scan.nextInt();
        for (int i = 0; i < size; i++) {
            int com = scan.nextInt();
            int num = scan.nextInt();
            switch (com) {
                case 1 -> {
                    po = kf.TakZhup();
                    all = Kukafunction.checker(po, num);
                    if (all == 1)
                        System.out.println("Odd");
                    else
                        System.out.println("Even");
                }
                case 2 -> {
                    po = kf.checkPrime();
                    all = Kukafunction.checker(po, num);
                    if (all == 0)
                        System.out.println("Prime");
                    else
                        System.out.println("Composit");
                }
                case 3 -> {
                    po = kf.checkPalindrome();
                    all = Kukafunction.checker(po, num);
                    if (all == 0)
                        System.out.println("Polindrome");
                    else
                        System.out.println("Not Polindrom");
                }
            }
        }
    }
}