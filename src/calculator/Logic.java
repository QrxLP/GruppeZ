package calculator;

public class Logic {

    Logic()
    {

    }

    /**
     * Entscheidet welche Rechenart (Methode) verwendet werden soll über die erste Stelle im Arry
     * 0 -- Addition
     * 1 -- Subtraktion
     * 2 -- Multiplikation
     * 3 -- Division
     * 4 -- Mitternachtsformel
     * 5 -- Skalarprodukt
     * 6 -- Vektorprodukt
     * 7 -- Satz des Pythagoras
     * 8 -- Vektorlänge
     *
     * @param input Eingabewerte
     * @return Ergenbnis der Berechnung
     */
    public static double[] calc(double[] input)
    {
        //Erstes Element im input array Entscheidet mathematische Operation
        int op = (int)input[0];
        //Entfernt erstes Element aus dem array und schiebt alle Elemente nach
        int tempLength=input.length-1;
        double[] temp = new double [tempLength];
        for(int i=0;i<temp.length;i++)
        {
            temp[i]=input[i+1];
        }
        double[] res;
        //Entscheidung über mathematische Operation
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
            case 7: res= phytagoras_theorem(temp);
                break;
            case 8: res=vector_lenght(temp);

            default:
                res = new double[10];
        }
        return res;

    }

    /**
     * Addiert zwei Zahlen
     * @param input Zahlen die addiert werden
     * @return Ergebnis
     */
    public static double[] add(double[] input)
    {
        double[] res=new double[1];
        res[0]=input[0]+input[1];
        return res;
    }

    /**
     *  Subtrahiert zweite Zahl von der ersten
     * @param input Zahlen die subtahiert werden
     * @return Ergebnis
     */
    public static double[] subtract(double[] input)
    {
        double[] res=new double[1];
        res[0]=input[0]-input[1];
        return res;
    }

    /**
     * Multipliziert zwei Zahlen
     * @param input Zahlen die multipliziert werden
     * @return Ergebnis
     */
    public static double[] multiply(double[] input)
    {
        double[] res=new double[1];
        res[0]=input[0]*input[1];
        return res;
    }

    /**
     *  Dividiert eine Zahl durch eine andere
     * @param input Zahlen die dividiert werden
     * @return Ergebnis
     */
    public static double[] divide(double[] input)
    {
        double[] res=new double[1];
        res[0]=input[0]/input[1];
        return res;
    }

    /**
     * Methode für die Mitternachtsformel.
     */
    public static double [] midnight_formula(double [] input) {

        double a;
        double b;
        double c;
        double value_under_sqrt;
        double x1;
        double x2;
        double [] result;

        a = input[0];
        b = input [1];
        c = input [2];
        result  = new double[3];

        //Logic: Teilt den Prozess
        value_under_sqrt = Math.pow(b, 2) - 4 * a * c;
        if(value_under_sqrt < 0) {
            result[2] = 1;
        }
        x1 = (-1 * b + Math.sqrt(value_under_sqrt)) / (2 * a);
        x2 = (-1 * b - Math.sqrt(value_under_sqrt)) / (2 * a);

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

        //Variablen deklarieren
        double a1;
        double a2;
        double a3;
        double b1;
        double b2;
        double b3;

        double[] result;



        //die Variablen aus dem input array in die Varablen
        a1 = input[0];
        a2 = input[1];
        a3 = input[2];
        b1 = input[3];
        b2 = input[4];
        b3 = input[5];
        result = new double[3];

        double zähler;
        double nenner;

        //zwei array für die Berechnung der Vektor länge erstellen und füllen
        double[] a;
        a = new double[]{a1, a2, a3};

        double[] b;
        b = new double[]{b1, b2, b3};

        //zähler und nenner berechnen
        zähler = a1 * b1 + a2 * b2 + a3 * b3;
        nenner = vector_lenght(a)[0] * vector_lenght(b)[0];
        double bruch = zähler / nenner;


        //result array füllen
        result[0] = zähler;
        result[1] = Math.toDegrees(Math.acos(bruch));
        result[2] = nenner;



        return result;
    }
    /**
     * Methode für die Länge eines Vektors
     *
     * Reihenfolge im input array: a1, a2, a3.
     * @param input array
     * @return result double
     */
    public static double[] vector_lenght(double[] input){
        double[] result;
        result = new double[3];

        //quadreiern addieren und wurzel ziehen
        result[0] = Math.sqrt(Math.pow(input[0],2) + Math.pow(input[1],2) + Math.pow(input[2],2));

        return result;
    }

    /**
     * Methode für das Vektorprodukt.
     */
    public static double [] vector_product(double [] input) {

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
    public static double [] phytagoras_theorem(double [] input) {

        double cathete_a;
        double cathete_b;
        double hypothenuse_c;
        double result_variable;
        double [] result;
        double variable_under_sqrt;


        hypothenuse_c = input [0];
        cathete_a = input [1];
        cathete_b = input [2];




        //Wenn eine Variable 0 ist, wird diese als leer bezeichnet und ist somit die Variable die berechnet werden muss
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

        result = new double [1];
        result [0] = result_variable;
        return result;

    }

}