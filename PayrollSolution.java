import java.util.Scanner;
import java.io.*;
/**
 * In one sentence, give the overall purpose of this class here.
 * 
 * @assumptions Put any assumptions you have made here (e.g. error checking not required)
 * @errors  If you know of any errors, give them here (or put "None")
 * 
 * @author  your name
 * @instructor  Instructor name here
 * @date    date assignment due
 */

public class PayrollSolution 
{
    /*
     *  Give a brief description of how main works
     * 
     */
    public static void main(String[] args) throws IOException
    {
        Scanner infile = new Scanner (new FileReader ("payroll.txt"));
        int row;
        int col;
        int numEmployees;
        // Answer to Question A)
        int [] employeeNum = new int [100];
        double [][] payroll = new double [100] [5];

        // Answer to Question B)
        numEmployees = infile.nextInt();
        for (row = 0; row < numEmployees; row++)
        {
            employeeNum [row] = infile.nextInt();
            payroll [row][0] = infile.nextDouble();
            payroll [row][1] = infile.nextDouble();
        }

        // Answer to question C).  Note that although this is done in 3 separate for
        // loops to answer the specific question, in practice, this will be done in 
        // one loop

        for (row = 0; row < numEmployees; row ++)
        {
            if (payroll[row][1] > 40.0)
                payroll[row][2] = 40.0 * payroll[row][0];
            else
                payroll[row][2] = payroll[row][1] * payroll[row][0];
        }

        for (row = 0; row < numEmployees; row ++)
        {
            if (payroll[row][1] > 40.0)
                payroll[row][3] = (payroll[row][1] - 40.0) * payroll[row][0] * 1.5;
            else
                payroll[row][3] = 0;
        }

        for (row = 0; row < numEmployees; row ++)
        {
            payroll[row][4] = payroll[row][2] + payroll[row][3];
        }

        // Prints the arrays
        for (row = 0; row < numEmployees; row++)
        {
            System.out.print (employeeNum [row] + "\t");
            for (col = 0; col < 5; col++)
            {
                System.out.print (payroll [row] [col] + "\t");
            }
            System.out.println ("");
        }

        // Answer to D)
        // largest OT pay
        int empNo = 0;
        double largest = 0.0;
        for (row = 0; row < numEmployees; row ++)
        {
            if (payroll[row][3] > largest)
            {
                largest = payroll[row][3];
                empNo = employeeNum[row];
            }
        }
        System.out.println ("\n" + empNo + "\t" + largest);

        // total Payroll
        double totalPayroll = 0.0;
        for (row = 0; row < numEmployees; row ++)
        {
            totalPayroll = totalPayroll + payroll[row][4];
        }
        System.out.println ("\n" + totalPayroll);

        infile.close();
        System.exit(0);
    }

    // **************************  end of main  *********************************************

}