package Java_ITS;

public class Practice2 {
    public static void main(String[] args) {
        double a1 = 0.58;
        double b1 = 0.34;
        double c1 = 1.25;
        double d1 = -1.89;
        double a2 = -1.49;
        double b2 = 23.4;
        double c2 = 1.23;
        double d2 = 2.254;
        double a3 = 2.34;
        double b3 = 0.756;
        double c3 = 2.23;
        double d3 = -1.653;

        double y1 = ((2 * Math.sin(a1)) / Math.acos(-2*b1)) - (Math.sqrt(Math.log(c1 * Math.abs(2 * d1)))) ;
        double y2 = (2 * (Math.sqrt(Math.tan(Math.abs(a2+c2))))) + (Math.log(b2) / Math.pow(c2, d2)) ;
        double y3 = ((Math.exp(c3) + 2 * Math.log10(a3)) / (Math.sqrt(Math.pow(c3, b3)))) * (Math.abs(Math.asin(d3))) ;

        System.out.println("Result y1 = " + y1);
        System.out.println("Result y2 = " + y2);
        System.out.println("Result y3 = " + y3);


    }

}
