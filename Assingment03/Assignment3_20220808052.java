import java.util.Scanner;

public class Assignment3_20220808052 
{
    public static void main(String[] args) 
    {
        Scanner scan = new Scanner(System.in);
        String[] a = {"sea" , "ase" ,"bese"};
        menu(scan, a);
    }

    public static int menu(Scanner scan,String[] item)
    {
        for(int i = 0; i< item.length;i++)
        {
            System.out.println(i +" - " + item[i]);
        }
        System.out.println("Q - to quit");
        char temp = scan.nextLine().toLowerCase().charAt(0);
        if((int)temp == 113)
        {
            return -1;
        }
        else if((int)temp -48>=0 && (int)temp-48 <item.length-1)
        {
            
            return (int)temp-48;
        }
        else
        {
            return menu(scan, item);
        }
        
    }

    public static void calculateGrade(String[] category,int[] quantity,int[] weight)
    {
        if(category.length==quantity.length && category.length == weight.length)
        {

        }
        else
        {
            System.out.println("Error: not same length array.");
        }
    }
}