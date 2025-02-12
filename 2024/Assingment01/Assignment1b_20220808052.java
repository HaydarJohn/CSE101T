/*
 *  @author Haydar Can Karabacak (HaydarJohn)
 *  since 2023 October
 */

import java.util.Scanner;

public class Assignment1b_20220808052 {
    public static void main(String[] args) 
    {
        Scanner scan = new Scanner(System.in);
        System.out.println("Please enter the grading weight (percentage) for"+
        " the following categories:");
        System.out.print("Quizzes: ");


        int quizPercent = scan.nextInt() ;
        if(quizPercent >= 0 && quizPercent <= 100)
        {
            System.out.print("Homework: ");
            int homeworkPercent = scan.nextInt();
            if(homeworkPercent  >= 0 && homeworkPercent <= 100)
            {
                System.out.print("Midterm Exam: ");
                int midtermPercent = scan.nextInt();
                if( midtermPercent  >= 0 && midtermPercent <= 100)
                {
                    System.out.print("Final Exam: ");
                    int finalPercent = scan.nextInt();
                    if( finalPercent >= 0 && finalPercent <= 100)
                    {
                        if((quizPercent + homeworkPercent +
                         midtermPercent + finalPercent) == 100)
                        {
                            System.out.println("Please enter what Haydar C"+
                            "an earned"
                            +" for each category");
                            System.out.print("Quizzez: ");
                            double quiz = scan.nextDouble();
                            System.out.print("Homework: ");
                            double homework = scan.nextDouble();
                            System.out.print("Midterm Exams: ");
                            double midtermExam = scan.nextDouble();
                            System.out.print("Final Exams: ");
                            double finalExam = scan.nextDouble();
                            double totalGrade = 0.01*((quizPercent * quiz) +
                            (homeworkPercent * homework) +
                             (midtermPercent * midtermExam)
                            + (finalExam * finalPercent));
                            if(totalGrade > 88)
                            {
                                System.out.println("Haydar Can Karabacak - "+
                                totalGrade+
                                ",GPA 4.0, Grade"+
                                " Letter AA, Passed.");
                            }
                            else if(totalGrade > 81)
                            {
                                System.out.println("Haydar Can Karabacak - "+
                                totalGrade
                                    +", GPA 3.5, Grade"+
                                " Letter BA, Passed.");
                            }
                            else if(totalGrade > 74)
                            {
                                System.out.println("Haydar Can Karabacak - "+
                                totalGrade+
                                ", GPA 3.0, Grade"+
                                " Letter BB, Passed.");
                            }
                            else if(totalGrade > 67)
                            {
                                System.out.println("Haydar Can Karabacak - "+
                                totalGrade+
                                ", GPA 2.5, Grade"+
                                " Letter CB, Passed.");
                            }
                            else if(totalGrade > 60)
                            {
                                System.out.println("Haydar Can Karabacak - "+
                                totalGrade+
                                ", GPA 2.0, Grade"+
                                " Letter CC, Passed.");
                            }
                            else if(totalGrade > 53)
                            {
                                System.out.println("Haydar Can Karabacak - "+
                                totalGrade+
                                ", GPA 1.5, Grade"+
                                " Letter DC, Conditionaly Passed.");
                            }
                            else if(totalGrade > 46)
                            {
                                System.out.println("Haydar Can Karabacak - "+
                                totalGrade+
                                ", GPA 1.0, Grade"+
                                " Letter DD, Conditionaly Passed.");
                            }
                            else if(totalGrade > 35)
                            {
                                System.out.println("Haydar Can Karabacak - "+
                                totalGrade+
                                ", GPA 0.5, Grade"+
                                " Letter FD, Failed.");
                            }
                            else
                            {
                                System.out.println("Haydar Can Karabacak - "+
                                totalGrade+
                                ", GPA 0.0, Grade"+
                                " Letter FF, Failed.");
                            }
                        }
                        else
                        {
                            System.out.println("Error: Total does "+
                            "not add to 100 !");
                        }
                    }
                    else
                    {
                        System.out.println("Error: Grade can not"+
                        " be less than 0 or more than 100!");   
                    }
                }
                else
                {
                    System.out.println("Error: Grade can not be"+
                    " less than 0 or more than 100!");
                }
            }
            else
            {
                System.out.println("Error: Grade can not be "+
                "less than 0 or more than 100!");
            }
        }
        else
        {
            System.out.println("Error: Grade can not be less"+
            " than 0 or more than 100!");

        }

        //////////////////////////////////////////////////////////////////////////

        // if(quizPercent < 0 )
        // {
        //     System.out.println("Error: Grade can not be less than 0!");

        //     return;
        // }
        // System.out.print("Homework: ");
        // int homeworkPercent = scan.nextInt();
        // if(homeworkPercent < 0 )
        // {
        //     System.out.println("Error: Grade can not be less than 0!");

        //     return;
        // }
        
        // System.out.print("Midterm Exam: ");
        // int midtermPercent = scan.nextInt();

        // if(midtermPercent < 0 )
        // {
        //     System.out.println("Error: Grade can not be less than 0!");

        //     return;
        // }
        

        // System.out.print("Final Exam: ");
        // int finalPercent = scan.nextInt();
        // if(finalPercent < 0 )
        // {
        //     System.out.println("Error: Grade can not be less than 0!");

        //     return;
        // }

        // if(quizPercent+homeworkPercent+midtermPercent+finalPercent != 100)
        // {
        //     System.out.println("Error: it should add up to 100");

        //     return;
        // }

        // System.out.println("Please enter what HaydarJohn earned"
        // +" for each category");
        // System.out.print("Quizzez: ");
        // double quiz = scan.nextDouble();
        // System.out.print("Homework: ");
        // double homework = scan.nextDouble();
        // System.out.print("Midterm Exams: ");
        // double midtermExam = scan.nextDouble();
        // System.out.print("Final Exams: ");
        // double finalExam = scan.nextDouble();

        // double totalGrade = 0.01*((quizPercent * quiz) +
        //  (homeworkPercent * homework) + (midtermPercent * midtermExam)
        //   + (finalExam * finalPercent));
        // System.out.println(totalGrade);
        

    }
}
