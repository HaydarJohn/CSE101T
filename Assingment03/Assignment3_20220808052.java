import java.util.Scanner;

public class Assignment3_20220808052 
{
    public static void main(String[] args) 
    {
        Scanner scan = new Scanner(System.in);
        String[] a = {"sea" , "ase" ,"bese"};
        int[] q = {2,3,4};
        int[] w = {50,25,25};
        int menuChoice = menu(scan, a);
        if(menuChoice == 0)
        {
            calculateGrade(a, q, w);
        }
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
        else if((int)temp -48>=0 && (int)temp-48 <=item.length-1)
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
            formatCategoryName(category);

            Scanner scan = new Scanner(System.in);
            
            double result = 0;

            for(int i = 0;i<category.length;i++)
            {
                System.out.println("Please enter " + category[i] + " notes:");
                
                result += getResult(scan, quantity[i], category[i]) * (weight[i] * 0.01);

            }
            System.out.println("The studemt has " + status(result) 
                + " CSE 101 with score of " + result + ", GPA points of " 
                + gpaPoints(result) + ", and grade letter of " 
                + gradeLetter(result));
            
        }
        else
        {
            System.out.println("Error: not same length array.");
        }
    }

    public static String[] formatCategoryName(String[] name)
    {
        for(int i = 0;i<name.length;i++)
        {
            name[i] = formatCategoryName(name[i]);
        }
        return name;
    }

    public static String formatCategoryName(String name)
    {
        return name.substring(0,1).toUpperCase() 
        + name.substring(1).toLowerCase();
    }



    public static double getResult(Scanner scan,int quantity,String name)
    {
        
        double result = 0;
        for(int i = 0;i<quantity;i++)
        {
            System.out.println(name + " " + (i+1));
            result += scan.nextDouble(); 
        }
        scan.nextLine();
        return result/quantity;
    }

    // Assignmet 2 codes


    

    public static boolean isQuantityValid(int quantity)
    {
        return quantity>0;
    }

    public static boolean isWeightValid(int weight,int totalWeight)
    {
        return weight >= 0 && (totalWeight + weight) < 100;
    }
    
    public static String gradeLetter(double grade)
    {
        if(grade >= 88)
        {
            return "AA";
        }
        else if(grade >= 81)
        {
            return "BA";
        }
        else if(grade >= 74)
        {
            return "BB";
        }
        else if(grade >= 67)
        {
            return "CB";
        }
        else if(grade >= 60)
        {
            return "CC";
        }
        else if(grade >= 53)
        {
            return "DC";
        }
        else if(grade >= 46)
        {
            return "DD";
        }
        else if(grade >= 35)
        {
            return "FD";
        }
        else
        {
            return "FF";
        }
    }

    public static double gpaPoints(double grade)
    {
        if(grade >= 88)
        {
            return 4.0;
        }
        else if(grade >= 81)
        {
            return 3.5;
        }
        else if(grade >= 74)
        {
            return 3.0;
        }
        else if(grade >= 67)
        {
            return 2.5;
        }
        else if(grade >= 60)
        {
            return 2.0;
        }
        else if(grade >= 53)
        {
            return 1.5;
        }
        else if(grade >= 46)
        {
            return 1.0;
        }
        else if(grade >= 35)
        {
            return 0.5;
        }
        else
        {
            return 0.0;
        }
    }

    public static String status(double grade)
    {
        if(grade >= 60)
        {   return "passed";    }
        else if(grade >= 46)
        {   return "conditionaly passed";   }
        else
        {   return "failed";    }
    }
     
    public static String getName(Scanner scan)
    {
        System.out.println("Please enter the name of category");
        return formatCategoryName(scan.nextLine());
    }

    public static int getQuantity(Scanner scan , String name)
    {
        while (true) 
        {
            System.out.println("Please enter hom many "+
            "items of thistype of " + name + " were given");
            int result = scan.nextInt();
            if(result > 0)
            {   
                scan.nextLine();
                return result;
            }

        }
    }

    public static int getWeight(Scanner scan , String name)
    {
        while (true) 
        {
            System.out.println("Please enter the percentage"
            +" weight of "+ name);
            int result = scan.nextInt();
            if(result >= 0)
            {
                scan.nextLine();
                return result;
            }   
        }
    }

    
}