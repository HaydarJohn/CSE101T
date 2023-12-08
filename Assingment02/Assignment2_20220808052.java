/*
 *  @author Haydar Can Karabacak (HaydarJohn)
 *  since 2023 October
 *  V 1.1
 */

import java.util.Scanner;

public class Assignment2_20220808052
{
    public static void main(String[] args) {

        System.out.println("***Category Information Entry***");

        Scanner scan = new Scanner(System.in);
        String name0,name1,name2,name3,name4;
        int quantity0,quantity1,quantity2,quantity3,quantity4;
        int weight0,weight1,weight2,weight3,weight4;
        int totalWeight;

        name0 = getName(scan);
        quantity0 = getQuantity(scan,name0);
        weight0 = getWeight(scan, name0);

        name1 = getName(scan);
        quantity1 = getQuantity(scan,name1);
        weight1 = getWeight(scan, name1);

        name2 = getName(scan);
        quantity2 = getQuantity(scan,name2);
        weight2 = getWeight(scan, name2);

        name3 = getName(scan);
        quantity3 = getQuantity(scan,name3);
        weight3 = getWeight(scan, name3);

        name4 = getName(scan);
        quantity4 = getQuantity(scan,name4);
        weight4 = getWeight(scan, name4);

        totalWeight = weight0 + weight1 + weight2 + weight3 + weight4;

        System.out.println( name0 + " " + quantity0 + " " + weight0);

        if(totalWeight != 100)
        {
            System.out.println("ERROR: The values sum to "
            +totalWeight+" but should sum to 100");
            return;
        }

        //  Student stuff

        System.out.println("***Student Grade Entry***");

        double res0,res1,res2,res3,res4;


        res0 = getResult(scan, quantity0, name0);
        res1 = getResult(scan, quantity1, name1);
        res2 = getResult(scan, quantity2, name2);
        res3 = getResult(scan, quantity3, name3);
        res4 = getResult(scan, quantity4, name4);


        // Grading Stuff

        System.out.println("***Student Results***");

        System.out.println(name0 +": " +res0);
        System.out.println(name1 +": " +res1);
        System.out.println(name2 +": " +res2);
        System.out.println(name3 +": " +res3);
        System.out.println(name4 +": " +res4);

        System.out.println();

        calculateGrade(res0,res1,res2,res3,res4,weight0,weight1
        ,weight2,weight3,weight4);

    }

    public static String formatCategoryName(String name)
    {
        name = name.substring(0,1).toUpperCase() 
        + name.substring(1).toLowerCase();
        return name;
    }

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

    public static void calculateGrade(double res0,double res1
    ,double res2,double res3,double res4,int weight0
    ,int weight1,int weight2,int weight3,int weight4)
    {
        double totalGrade =  (res0 * (weight0/100.0)) +
         (res1 * (weight1/100.0)) +(res2 * (weight2/100.0)) +
          (res3 * (weight3/100.0)) + (res4 * (weight4/100.0));
        System.out.println("The studemt has " + status(totalGrade)
         + " CSE 101 with score of " + totalGrade + ", GPA points of " 
         + gpaPoints(totalGrade) + ", and grade letter of " +
          gradeLetter(totalGrade));
    }
}