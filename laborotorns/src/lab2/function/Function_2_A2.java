package lab2.function;

public class Function_2_A2 {
    private final String str;

    public Function_2_A2(String str) {
        this.str = str;
    }

    public static int binaryToDecimal(String str) {
        int decimal = 0;
        int power = 0;
        // Читаем двоичное число справа налево
        for (int i = str.length() - 1; i >= 0; i--) {
            // Переводим каждую цифру в десятичное число
            int digit = Character.getNumericValue(str.charAt(i));
            // Умножаем цифру на соответствующую степень двойки и добавляем к общей сумме
            decimal += digit * Math.pow(2, power);
            // Увеличиваем степень на каждом шаге
            power++;
        }
        return decimal;
    }

    @Override
    public String toString() {
        return "Function_2_A2{" + "str='" + str + ", resault: " + binaryToDecimal(str) + " }";
    }
}
