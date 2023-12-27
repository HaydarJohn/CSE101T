import java.io.File;
import java.util.Scanner;

public class Assignment4_20220808052 
{


    public static int countCategory(String filename)
    {
        int count = 0;
        File file = new File(filename);
        try
        {
            Scanner scan = new Scanner(file);
            while (scan.hasNextLine()) 
            {
                count++;
                scan.nextLine();   
            }
            
        }
        catch(Exception e)
        {
            //TODO:Error Handling
        }
        return count;
    }
    public static void getCategory(String[] category,int[] quantity,int[] weight,String fileName)
    {
        File file = new File(fileName);
        try
        {
            Scanner scan = new Scanner(file);
            for(int i = 0; i< category.length;i++)
            {
                category[i] = formatCategoryName(scan.next());
                quantity[i] = Integer.parseInt(scan.next());
                weight[i] = Integer.parseInt(scan.next());
            }

        }
        catch(Exception e)
        {
            // TODO:Error Handling
        }

    }

    //Before Assignment04

    public static void formatCategoryName(String[] name)
    {
        for(int i = 0;i<name.length;i++)
        {
            name[i] = formatCategoryName(name[i]);
        }
    }

    public static String formatCategoryName(String name)
    {
        return name.substring(0,1).toUpperCase() 
        + name.substring(1).toLowerCase();
    }

}