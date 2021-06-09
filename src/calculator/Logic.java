package calculator;

import javax.swing.*;

public class Logic {

    Logic()
    {

    }

    /**
     * Decides which mathematical operation is supposed to be used by the first value in the input array
     * 0 for Addition
     * 1 for Subtraction
     * 2 for Multiplication
     * 3 for Division
     * 4 for Midnight_formula
     * 5 for scalar_product
     * 6 for vector_product
     * 7 for Phytagoras_theorem
     *
     * @param input Array of numbers to be calculated
     * @return Result of the calculation
     */
    public double[] calc(double[] input)
    {
        //First number in array for decision of operation
        int op = (int)input[0];
        //Deletes the first value of the array
        int tempLength=input.length-1;
        double[] temp = new double [tempLength];
        for(int i=0;i<temp.length;i++)
        {
            temp[i]=input[i+1];
        }
        double[] res =new double[10];
        //Decision for operation ; add new operations when finished
        switch (op)
        {
            case 0: res= add(temp);
                break;
            case 1: res=subtract(temp);
                break;
            case 2: res=multiply(temp);
                break;
            case 3: res=divide(temp);
                break;
            case 4: res=midnight_formula(temp);
                break;
            case 5: res=scalar_product(temp);
                break;
            case 6: res=vector_product(temp);
                break;
            case 7: res=Phytagoras_theorem(temp);
                break;
        }
        return res;

    }

    /**
     * Adds two numbers
     * @param input Numbers to be added
     * @return Result
     */
    public double[] add(double[] input)
    {
        double[] res=new double[1];
        res[0]=input[0]+input[1];
        return res;
    }

    /**
     *  Subtracts one number from another
     * @param input Numbers to be subtracted
     * @return Result
     */
    public double[] subtract(double[] input)
    {
        double[] res=new double[1];
        res[0]=input[0]-input[1];
        return res;
    }

    /**
     * Multiplies two numbers
     * @param input Numbers to be multiplied
     * @return Result
     */
    public double[] multiply(double[] input)
    {
        double[] res=new double[1];
        res[0]=input[0]*input[1];
        return res;
    }

    /**
     *  Divides one number by another
     * @param input Numbers to be divided
     * @return Result
     */
    public double[] divide(double[] input)
    {
        double[] res=new double[1];
        res[0]=input[0]/input[1];
        return res;
    }

    /**
     * Methode für die Mitternachtsformel.
     */
    public static double [] midnight_formula(double [] input) {


        //Declaring variables.
        double a;
        double b;
        double c;
        double value_under_sqrt;
        double x1;
        double x2;
        double [] result;


        //Initializing the array which returns the result and the variables which save the input received from the input array.
        a = input[0];
        b = input [1];
        c = input [2];
        result  = new double[2];


        //Logic: Splits the process into 2 parts.
        value_under_sqrt = Math.pow(b, 2) - 4 * a * c;
        x1 = (-1 * b + Math.sqrt(value_under_sqrt)) / (2 * a);
        x2 = (-1 * b - Math.sqrt(value_under_sqrt)) / (2 * a);


        //Filling the result array with the result values, returning it.
        result [0] = x1;
        result [1] = x2;
        return result;

    }

    /**
     * Methode für das Skalarprodukt.
     *
     * Reihenfolge im input array: a1, a2, a3, b1, b2, b3.
     */
    public static double [] scalar_product(double [] input) {

        //Declaring variables.
        double a1;
        double a2;
        double a3;
        double b1;
        double b2;
        double b3;
        double scalar_product; // result variable
        double [] result;


        //Initializing the array which returns the result and the variables which save the values from the input array.
        a1 = input[0];
        a2 = input [1];
        a3 = input [2];
        b1 = input [3];
        b2 = input [4];
        b3 = input [5];
        result = new double [1];


        //Logic
        scalar_product = a1 * b1 + a2 * b2 + a3 * b3;


        //Filling result array and returning it.
        result [0] = scalar_product;


        //winkel
        double zähler;
        double nenner;

        zähler = result[0];
        double [] a;
        a = new double[]{input[0], input[1], input[3]};

        double [] b;
        b = new double[]{input[0], input[1], input[3]};
        nenner = vector_lenght(a)[0] + vector_lenght(b)[0];


        result[1] = Math.acos(zähler / nenner);
        return result;

    }

    public static double[] vector_lenght(double[] input){
        double[] result;
        result = new double[3];

        result[0] = Math.sqrt(Math.pow(input[0],2) + Math.pow(input[1],2) + Math.pow(input[2],2));

        return result;
    }

    /**
     * Methode für das Vektorprodukt.
     */
    public static double [] vector_product(double [] input) {

        //Declaring variables.
        double a1;
        double a2;
        double a3;
        double b1;
        double b2;
        double b3;
        double result_c1;
        double result_c2;
        double result_c3;
        double [] result;


        //Initializing the result array and the variables which save the values from the input array.
        a1 = input[0];
        a2 = input [1];
        a3 = input [2];
        b1 = input [3];
        b2 = input [4];
        b3 = input [5];
        result = new double [3];


        //Logic
        result_c1 = a2 * b3 - a3 * b2;
        result_c2 = a3 * b1 - a1 * b3;
        result_c3 = a1 * b2 - a2 * b1;


        //Filling the result array and returning it.
        result [0] = result_c1;
        result [1] = result_c2;
        result [2] = result_c3;
        return result;

    }

    /**
     * Methode für berechnen des SdP.
     * input [0] = Hypothenuse
     * input [1] = Kathete A
     * input [2] = Kathete B
     */
    public static double [] Phytagoras_theorem(double [] input) {

        //Declaring variables.
        double cathete_a;
        double cathete_b;
        double hypothenuse_c;
        double result_variable; // saved in result  array
        double [] result;
        double variable_under_sqrt;


        //Initializing the variables which save the values received from the input array.
        cathete_a = input [0];
        cathete_b = input [1];
        hypothenuse_c = input [2];


        /*
         * Logic: If ANY of the three variables equals 0, the program regards it as empty and therefore
         * it is the one which needs to be calculated.
         * If no variable equals 0, zero is returned to show that something was wrong :).
         */
        if(hypothenuse_c == 0) {
            variable_under_sqrt = Math.pow(cathete_a, 2) + Math.pow(cathete_b, 2);
            result_variable = Math.sqrt(variable_under_sqrt);
        }
        else if(cathete_a == 0) {
            variable_under_sqrt = Math.pow(hypothenuse_c, 2) - Math.pow(cathete_b, 2);
            result_variable = Math.sqrt(variable_under_sqrt);
        }
        else if(cathete_b == 0) {
            variable_under_sqrt = Math.pow(hypothenuse_c, 2) - Math.pow(cathete_a,  2);
            result_variable = Math.sqrt(variable_under_sqrt);
        } else {
            result_variable = 0;
        }


        //Filling the result array and returning it.
        result = new double [1];
        result [0] = result_variable;
        return result;

    }

}
