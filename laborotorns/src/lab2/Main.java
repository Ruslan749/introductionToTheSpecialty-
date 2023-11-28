package lab2;

import lab2.Date.Numbers;
import lab2.function.Function_1_A10;
import lab2.function.Function_2_A2;
import lab2.function.Function_Mantissa;

public class Main {
    public static void main(String[] args) {
        Function_1_A10 f_1 = new Function_1_A10(Numbers.getNUMBERS_A10());
        Function_2_A2 f_2 = new Function_2_A2(Numbers.getNUMBERS_A2());
        Function_Mantissa f_3 = new Function_Mantissa(Numbers.getNumbersMetisa());


        System.out.println(f_1);
        System.out.println(f_2);
        System.out.println(f_3);

    }
}