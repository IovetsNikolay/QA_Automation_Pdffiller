package lesson7;

public class toStringAndBack {

    public static void main(String[] args) {

        int i = 5;
        double d = 0.15;
        long l = 2342;
        boolean b = true;

        String iStr;
        String dStr;
        String lStr;
        String bStr;
        iStr = String.valueOf(i);
        dStr = String.valueOf(d);
        lStr = String.valueOf(l);
       // bStr = String.copyValueOf(b);

        System.out.println(iStr);
        System.out.println(dStr);
        System.out.println(lStr);

        int iConv = Integer.valueOf(iStr);
        double dConv = Double.valueOf(dStr);
        long lConv = Long.valueOf(lStr);
        //long bConv = Boolean.valueOf(lStr);



    }



}
