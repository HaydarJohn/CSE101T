import java.util.Scanner;

/*
 * @author HaydarJohn (Haydar Can Karabacak)
 * @since 11.11.2022
 * version 1.0
 */

 public class TwoItemStore_20220808052{
	public static void main(String[] args){
		Scanner inp = new Scanner(System.in);

		/*First Item And Start Of Store Menu*/

		System.out.println("*****Store Inventory*****");

		System.out.print("Please enter first products name :");

		String stringProduct1 = inp.nextLine();

		System.out.print("What amount of " + stringProduct1 + " we have :");

		int  quantityProduct1 = inp.nextInt();

		if(quantityProduct1 < 0)
		{
			System.out.println("Error: Quantity can not be negative! \nExitting ...");
			return;
		}

		System.out.print("What it costs :");

		double priceProduct1 = inp.nextDouble();

		if(priceProduct1 < 0)
		{
			System.out.println("Error: Price can not be negative! \nExitting ...");
			return;
		}


		/*End Of First Item And Start Of Second Item*/

		System.out.println();

		System.out.print("Please enter second products name :");

		// This random inp.nextLine is for stupid compiler.it acts like "Well this line dont start as blank because you put
		//  integer in my system so i will take nothing and commit suicide.But for other instance of me i will clear
		// the line so it can take values." So it fixes ghost forces brought upon us by complilers big great evil plan. 

		inp.nextLine();

		String stringProduct2 = inp.nextLine();

		System.out.print("What amount of " + stringProduct2 + " we have :");

		int  quantityProduct2 = inp.nextInt();

		if(quantityProduct2 < 0)
		{
			System.out.println("Error: Quantity can not be negative! \nExitting ...");
			return;
		}
		
		System.out.print("What it costs :");
		
		double priceProduct2 = inp.nextDouble();
		
		if(priceProduct2 < 0)
		{
			System.out.println("Error: Price can not be negative! \nExitting ...");
			return;
		}

		/*End Of Second Item And Start Of The Customer Menu*/

		int quantityPurchased1 = 0;
		int quantityPurchased2 = 0;
		int temp = 0;

		System.out.println("*****Customer Menu*****");

		while (true) 
		{
			System.out.println("Welcome to store! Please input what you want to buy!");

			System.out.println("1 - " + stringProduct1);

			System.out.println("2 - " + stringProduct2);

			System.out.println("0 - to checkout");

			int customerChoice = inp.nextInt();

			if(customerChoice == 1)
			{
				System.out.println("How many do you want to purchase ?");
				
				temp = inp.nextInt();

				if(temp > quantityProduct1)
				{
					System.out.println("Error: Store dont have enough product for you");

					temp = 0;
				}
				else if(temp <= 0)
				{
					System.out.println("Error: Quantity cannot be zero or negative");

					temp = 0;
				}
				quantityPurchased1 += temp;

				quantityProduct1 -= temp;

			}
			
			else if(customerChoice == 2)
			{
				System.out.println("How many do you want to purchase ?");
				
				temp = inp.nextInt();

				if(temp > quantityProduct2)
				{
					System.out.println("Error: Store dont have enough product for you");

					temp = 0;
				}

				else if(temp <= 0)
				{
					System.out.println("Error: Quantity cannot be zero or negative");

					temp = 0;
				}
				quantityPurchased2 += temp;

				quantityProduct2 -= temp;

			}
			else if(customerChoice == 0)
			{
				break;
			}
			else
			{
				System.out.println("Error: Invalid option input.");
			}
		}

		/*End of customer menu and start of customer total and final report*/

		System.out.println("*****Customer Total*****");

		System.out.println(stringProduct1 + " " + quantityPurchased1 + " X " + priceProduct1 + " = " + (quantityPurchased1 * priceProduct1));

		System.out.println(stringProduct2 + " " + quantityPurchased2 + " X " + priceProduct2 + " = " + (quantityPurchased2 * priceProduct2));

		System.out.println("Total: " + ((quantityPurchased1*priceProduct1)+(quantityPurchased2*priceProduct2)));

		System.out.println("*****Final Report*****");

		System.out.println("Now we have remaining products :");

		System.out.println( stringProduct1 +" - "+ quantityProduct1);

		System.out.println( stringProduct2 +" - "+ quantityProduct2);

		

	}


}
