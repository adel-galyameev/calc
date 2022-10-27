import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("input: ");
        String str = scanner.nextLine();
        calc(str);
        System.out.println("output: "+calc(str));
    }

    public static String calc(String input) throws IOException {

        String[] a = input.split(" ");
        if(a.length != 3){
            throw new IOException("формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
        }
        String[] arabic = { "0","1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
        String[] roman = {" ","I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX",
                "XX", "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII",
                "XXXVIII", "XXXIX", "XL", "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L", "LI", "LII", "LIII", "LIV", "LV",
                "LVI", "LVII", "LVIII", "LIX", "LX", "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX", "LXXI", "LXXII",
                "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX", "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI",
                "LXXXVII", "LXXXVIII", "LXXXIX", "XC", "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C"};

        if (Arrays.asList(arabic).contains(a[0]) && Arrays.asList(arabic).contains(a[2])) {
            int num1 = Integer.parseInt(a[0]);
            int num2 = Integer.parseInt(a[2]);
            String op = a[1];

                int result;
                switch (op) {
                    case "-":
                        result = (num1 - num2);
                        break;
                    case "+":
                        result = (num1 + num2);
                        break;
                    case "/":
                        result = (num1 / num2);
                        break;
                    case "*":
                        result = (num1 * num2);
                        break;
                    default:
                        throw new IOException("вы указали не верный оператор!");
                }
                 String res = Integer.toString(result);
                return res;

        } else if (Arrays.asList(roman).contains(a[0]) && Arrays.asList(roman).contains(a[2])){

            int num1 = Arrays.asList(roman).indexOf(a[0]);
            int num2 = Arrays.asList(roman).indexOf(a[2]);
            String op = a[1];
            int result = 0;

            if (num1 > 10 || num2 > 10){
                throw new IOException("вводите число от I до Х !");
            } else {

                switch (op) {
                    case "+":
                        result = (num1 + num2);
                        break;
                    case "-":
                        result = (num1 - num2);
                        break;
                    case "*":
                        result = (num1 * num2);
                        break;
                    case "/":
                        result = (num1 / num2);
                        break;
                    default:
                        throw new IOException("вы указали не верный оператор!");
                }
                if(result <= 0){
                    throw new IOException("результат вычесления не может быть отрицительныи или равнятся нулю!");
                } else {
                    String res = roman[result];
                    return res;
                }
            }
        } else if (Arrays.asList(arabic).contains(a[0]) && Arrays.asList(roman).contains(a[2]) || Arrays.asList(roman).contains(a[0]) && Arrays.asList(arabic).contains(a[2])){
            throw new IOException("невозможно использование римских и арабских чисел в одном решение!");
        }  else if ((Integer.parseInt(a[0]) <= 0 || Integer.parseInt(a[0]) > 10) ||(Integer.parseInt(a[2]) <= 0 || Integer.parseInt(a[2]) > 10)) {
            throw new IOException("число должно быть от 1 до 10!");
        } else {
            throw new IOException();
        }
    }
}