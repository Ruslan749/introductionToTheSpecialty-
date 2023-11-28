package lab2.function;

public class Function_1_A10 {
    private final float decimal;

    public Function_1_A10(float decimal) {
        this.decimal = decimal;
    }

    public static String convertDoubleToBinaryString(float decimal) {
        int left = (int) decimal;
        boolean divideOneMoreTime = true;

        StringBuilder binBuilder = new StringBuilder();
        while (divideOneMoreTime) {
            binBuilder.insert(0, left % 2);
            left /= 2;
            if (left < 1) {
                divideOneMoreTime = false;
            }
        }
        String bin = binBuilder.toString();
        bin += ".";

        float right = (float) decimal - (int) decimal;
        for (int i = 0; i < 20; i++) {
            right = right * 2 - (int) right * 2;
            bin = bin + (int) right;
            if (right == 1.0) {
                break;
            }
        }
        return bin;

    }



    @Override
    public String toString() {
        return "Function_1_A10{" + "str='" + decimal + ", resault: " + convertDoubleToBinaryString(decimal) + " }";
    }
}
