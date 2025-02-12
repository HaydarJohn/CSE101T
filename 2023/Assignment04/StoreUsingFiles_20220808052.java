import java.io.*;
import java.util.Scanner;

import javax.lang.model.util.ElementScanner14;

/*
 * @author HaydarJohn (Haydar Can Karabacak)
 * @since 11.11.2022
 * version 3.0
 */

public class StoreUsingFiles_20220808052
{
    public static void main(String[] args) throws IOException
    {
        //This part of code counts the lines and makes arrays for 

        String filename = args[0];
        int itemCount = countProducts(filename+"_ProductInfo.txt");
        String[] itemID = new String[itemCount];
        String[] itemName = new String[itemCount];
        int[] quantity = new int[itemCount];
        double[] price = new double[itemCount];

        //These lines calls the methods for input and output stuff.

        getProductInfo(itemID, itemName, quantity, price, filename);

        writeProductInfo(itemID, itemName, quantity, price, filename);

    }
    
    public static int countProducts(String filename) throws IOException
    {
        //This code's sole purpose is count how many lines in text formed file and return the results.
        int count = 0;
        File countfile = new File(filename);
        Scanner scan = new Scanner(countfile);
        while(scan.hasNextLine()) { count++;   scan.nextLine(); }
        return count;
    }
    public static void getProductInfo(String[] itemID,String[] itemName,int[] quantity,double[] price,String filename) throws IOException
    {
        //This part of code will take inventory info from file.

        filename += "_ProductInfo.txt";
        File readFile = new File(filename);
        Scanner scan = new Scanner(readFile);

        //this for loop helps to store data in arrays.

        for(int i = 0;scan.hasNextLine();i++)
        {
            itemID[i] = scan.next();
            itemName[i] = scan.next();
            quantity[i] = scan.nextInt();
            price[i] = scan.nextDouble();
        }

        scan.close();

    }
    public static void writeProductInfo(String[] itemID,String[] itemName,int[] quantity,double[] price,String filename) throws IOException
    {
        //This part of the code instanciate files , scanner and printwriter objects that is necessary.
        File orderFile = new File(filename+"_Order.txt");
        File recieptFile = new File(filename+"_Reciept.txt");
        File logFile = new File(filename+".log");
        File infoAfterFile = new File(filename+"_ProductInfoAfterOrder.txt");
        Scanner scan = new Scanner(orderFile);
        PrintWriter recieptWriter = new PrintWriter(recieptFile);
        PrintWriter logWriter = new PrintWriter(logFile);
        PrintWriter infoAfterFileWriter = new PrintWriter(infoAfterFile);

        //This part of the code reads order and logs any oreder errors. First we will take all order id and oreder quantities.First we check if there is id for product.
        // If not we will log that and skip the quantity. if id match we will proceed to look previous and current order amount is more than stored amount or not.if not
        //add the total requested amount of specific product bu if it is the log an error and continue.

        String readCustomerItemID[] = new String[countProducts(filename+"_Order.txt")];
        int readCustomerQuantity[] = new int[countProducts(filename+"_Order.txt")];
        int writeCustomerQuantity[] = new int[itemID.length];
        
        //This for loop make us copy order info.

        for(int i = 0;scan.hasNextLine();i++)
        {
            readCustomerItemID[i] = scan.next();
            readCustomerQuantity[i] = scan.nextInt();
        }

        //This for loop in a for loop cheks if requested amounts are above zero and store has enough product to give. If not log an error message.

        for(int i = 0; i<readCustomerItemID.length;i++)
        {
            for(int j = 0; j< itemID.length;j++)
            {
                if(itemID[j].equals(readCustomerItemID[i]))
                {
                    if(readCustomerQuantity[i]<0)
                    {
                        logWriter.println("Error: Invalid amount requested (" + readCustomerQuantity[i] + ")");
                        //System.out.println(itemName[j]);
                        break;
                    }
                    else if(quantity[j] < writeCustomerQuantity[j] + readCustomerQuantity[i])
                    {
                        logWriter.println("Error: " + itemName[j] + " " + readCustomerQuantity[i] + " requested but only " + (quantity[j]-writeCustomerQuantity[j]) + " remaning.");
                        //System.out.println(itemName[j]);
                        break;
                    }
                    else
                    {
                        writeCustomerQuantity[j] += readCustomerQuantity[i];
                        //System.out.println(itemName[j]);
                        //System.out.println(writeCustomerQuantity[j]);
                        break;
                    }
                }
                else
                {
                    logWriter.println("Error: Product " + readCustomerItemID[j] + " not found.");
                }

            }
        }

        logWriter.close();

        //This part of code will print reciept first then info after order

        recieptWriter.println("******Customer Reciept*****");
        for(int i = 0;i<writeCustomerQuantity.length-1;i++)
        {
            if(writeCustomerQuantity[i]!= 0)
            {
                recieptWriter.println(itemName[i]+" ("+itemID[i] + ") " + writeCustomerQuantity[i] + " X " +price[i] + " = " + price[i]*writeCustomerQuantity[i]);
            }
        }
        recieptWriter.println("-------------------------------------------------");
        double total = 0;
        for(int i = 0;i < writeCustomerQuantity.length-1;i++)
        {
            if(writeCustomerQuantity[i]!= 0)
                total += writeCustomerQuantity[i] * price[i];
        }
        recieptWriter.println("Total due - " + total);
        
        
        recieptWriter.close();


        //This part of code will print info after order
        
        for(int i = 0; i < itemID.length;i++)
        {
            infoAfterFileWriter.println(itemID[i] + " " + itemName[i] + " " + (quantity[i]-writeCustomerQuantity[i]) + " " + price[i]);
        }

        infoAfterFileWriter.close();
    }
}

// I know this is incorrect buggy mess but my friends could not even do this please give me point.