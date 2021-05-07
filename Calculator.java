import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Calculator {
    private String inputString;
    private String operation;
    private String[] inputOperands;
    private int[] operands;
    private int result;
    Map<Integer, String> roman = new HashMap<>();

    {
        roman.put(0, "0");
        roman.put(1, "I");
        roman.put(2, "II");
        roman.put(3, "III");
        roman.put(4, "IV");
        roman.put(5, "V");
        roman.put(6, "VI");
        roman.put(7, "VII");
        roman.put(8, "VIII");
        roman.put(9, "IX");
        roman.put(10, "X");
        roman.put(11, "XI");
        roman.put(12, "XII");
        roman.put(13, "XIII");
        roman.put(14, "XIV");
        roman.put(15, "XV");
        roman.put(16, "XVI");
        roman.put(17, "XVII");
        roman.put(18, "XVIII");
        roman.put(19, "XIX");
        roman.put(20, "XX");
        roman.put(21, "XXI");
        roman.put(24, "XXIV");
        roman.put(25, "XXV");
        roman.put(27, "XXVII");
        roman.put(28, "XXVIII");
        roman.put(30, "XXX");
        roman.put(32, "XXXII");
        roman.put(35, "XXXV");
        roman.put(36, "XXXVI");
        roman.put(40, "XL");
        roman.put(42, "XLII");
        roman.put(45, "XLV");
        roman.put(48, "XLVIII");
        roman.put(49, "XLIX");
        roman.put(50, "L");
        roman.put(54, "LIV");
        roman.put(56, "LVI");
        roman.put(60, "LX");
        roman.put(63, "LXIII");
        roman.put(64, "LXIV");
        roman.put(70, "LXX");
        roman.put(72, "LXXII");
        roman.put(80, "LXXX");
        roman.put(81, "LXXXI");
        roman.put(90, "XC");
        roman.put(100, "C");
    }

    public void showResult() {
        if (inputString.matches("^[0-9]+.+$") || result == 0) System.out.println(result);
        else {
            if (result >= 0) System.out.println(roman.get(result));
            else try {
                throw new Exception();
            } catch (Exception e) {
                System.out.println("Отрицательных римских чисел не бывает.\n" +
                        "Это как деление на ноль");
                e.printStackTrace();
            }
        }
    }

    public String getInputString() {
        return inputString;
    }

    public void setInputString() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        inputString = reader.readLine();
        inputOperands = inputString.split("[+/\\-*]");
        operands = new int[inputOperands.length];
        operation = (inputString.substring(0, inputOperands[0].length() + 1)).substring(inputOperands[0].length());
        reader.close();
    }

    public void parseArab() throws NumberFormatException {
        for (int i = 0; i < inputOperands.length; i++) {
            operands[i] = Integer.parseInt(inputOperands[i].strip());
        }
    }

    public void parseRoman() throws Exception {
        for (int i = 0; i < inputOperands.length; i++) {
            switch (inputOperands[i]) {
                case "I":
                    operands[i] = 1;
                    break;
                case "II":
                    operands[i] = 2;
                    break;
                case "III":
                    operands[i] = 3;
                    break;
                case "IV":
                    operands[i] = 4;
                    break;
                case "V":
                    operands[i] = 5;
                    break;
                case "VI":
                    operands[i] = 6;
                    break;
                case "VII":
                    operands[i] = 7;
                    break;
                case "VIII":
                    operands[i] = 8;
                    break;
                case "IX":
                    operands[i] = 9;
                    break;
                case "X":
                    operands[i] = 10;
                    break;
                default:
                    throw new Exception();
            }
        }
    }

    public void calculate() throws Exception {
        switch (operation) {
            case "+":
                result = operands[0] + operands[1];
                break;
            case "-":
                result = operands[0] - operands[1];
                break;
            case "*":
                result = operands[0] * operands[1];
                break;
            case "/":
                result = operands[0] / operands[1];
                break;
            default:
                throw new Exception();
        }
    }
}
