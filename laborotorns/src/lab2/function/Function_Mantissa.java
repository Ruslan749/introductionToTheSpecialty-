package lab2.function;

public class Function_Mantissa {
    private final String str;
    public Function_Mantissa(String str) {
        this.str = str;
    }
   public  String mantisResault(double number){
        double d = number;
        String sResult;
        long numberBits = Double.doubleToLongBits(d);
        sResult = Long.toBinaryString(numberBits);
        String s = d > 0 ? "0" + sResult : sResult;

       String resault =   " '\nПредставление вещественного числа в формате чисел с плавающей точкой" + "\n"
                + "Число: " +  d + "\n"
                + "результат вычисления при помощи стондартных средств Java: " + s ;
        return resault;
    }

    public String signMantis(String str){
        if (str.charAt(0) == '-') {
           return  "Знак мантиссы: 1";
        } else {
            return "Знак мантиссы: 0";
        }

    }

    public String expMantis(String numInput){
        float strNum = Float.parseFloat(numInput);
        float num = Math.abs(strNum);
        String [] DoubleToBinary = Function_1_A10.convertDoubleToBinaryString(num).split("\\.");
        String resaultStringNumbers = "";
        String resaultMantisNumbers = "";
        for (String resaultString: DoubleToBinary){
            if (resaultString.contains("1")) {
                resaultStringNumbers += resaultString;
            }
        }
        StringBuffer mantis = new StringBuffer(resaultStringNumbers);
        StringBuffer resMantis = new StringBuffer(resaultStringNumbers);

        for (int i = 0; i < resaultStringNumbers.length(); i++ ){
            if (resaultStringNumbers.charAt(i) == '1'){
                mantis.insert(i+1,".");
                resMantis.insert(i,"");
                resaultMantisNumbers = resMantis.toString();
                resaultStringNumbers = mantis.toString();
                break;
            }
        }

        String Exp = Function_1_A10.convertDoubleToBinaryString(1023 +(DoubleToBinary[0].length() -  1)).split("\\.", 2)[0];

        String resaultMantisNam = signMantis(numInput) + Exp + resaultMantisNumbers ;

        String resaultMantis = "Мантиса числа:  " + resaultStringNumbers + "\n"
                + "Exp: " + Exp + "\n"
                + "Результат вычисления при помощи собственной реализации: " + resaultMantisNam;

        return resaultMantis;
    }

    @Override
    public String toString() {
        return "Function_Mantissa{" +
                 '\''  +  mantisResault(Double.parseDouble(str)) + "\n" +
                  signMantis(str) + "\n"
                +  expMantis(str) + "\n" +
        '}';
    }
}
