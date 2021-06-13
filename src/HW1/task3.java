package HW1;

import java.util.Scanner;

public class task3 {//O(n)
    public static int prime(int n,int m){
        if(n<2){
            return 0;
        }
        if(n==2){
            return 1;
        }
        if(n%m==0) {
            return 0;
        }
        if(m*m>n){
            return 1;
        }
        return prime(n,m+1);
    }

    public static void main(String[] args) {
        Scanner scan =new Scanner(System.in);
        int n=scan.nextInt();
        if(prime(n,2)==1){
            System.out.println("Prime");
        }
        else{
            System.out.println("Composite");
        }
    }
}
