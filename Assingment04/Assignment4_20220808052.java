import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;

public class Assignment4_20220808052 
{
    public static void main(String[] args)
    {
        //hocalara soruyorlar ne yapacaklarini
        //tum dunyadan yayinlar bakip gelismeleri arastiriyorlar
        int count = countCategory("a.txt");
        String[] a = new String[count];
        int[] b = new int[count];
        int[] c = new int[count];
        
        getCategory(a, b, c,"a.txt");
    }


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
                System.out.println(category[i]);
                System.out.println(quantity[i]);
                System.out.println(weight[i]);
            }

        }
        catch(Exception e)
        {
            // TODO:Error Handling
        }

    }

    public static void writeGrades(String[] student,double[] grade,String studentGrades,String errorLog)
    {
        File strudentFile = new File(studentGrades);
        File errorFile = new File(errorLog);
        try
        {
            PrintWriter errorWriter = new PrintWriter(errorFile);
            PrintWriter studentWriter = new PrintWriter(strudentFile);
            


            //temporary
            for(int i=0;i<student.length;i++)
            {
                studentWriter.print(student[i]);
                studentWriter.print(grade[i]);
            }
        }
        catch (Exception e)
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