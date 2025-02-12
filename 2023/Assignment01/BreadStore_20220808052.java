import java.util.Scanner;
public class BreadStore_20220808052 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("How much bread do owner has?");
        int bread = input.nextInt();
        if (bread < 0) {
            System.out.println("Error: There is no such thing as negative bread.\nExiting...");
            return ;
        }
        System.out.println("What price does owner want\'s to sell?");
        double cost = input.nextDouble();
        if (cost < 0) {
            System.out.println("Error: There is no such a thing as negative price.\nExiting...");
            return ;
        }
        System.out.println("How much bread does customer wants?");
        int customerBread = input.nextInt();
        if (customerBread > bread) {
            System.out.println("Error: There is not enough bread.");
            customerBread = 0;
        } else if (customerBread < 1) {
            System.out.println("");
            customerBread = 0;
        }
        System.out.println("cost " + customerBread * cost);
        System.out.println("left " + (bread - customerBread));
    }



}
