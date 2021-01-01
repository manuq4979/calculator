import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.HashMap;


class ValueException extends Exception{

    public ValueException(String message) {

        super(message);
    }
}


public class Main {

    public static void main(String[] args) {

        HashMap rom_value = new HashMap<String, String>() {{ put("I", "1");
                                                              put("II", "2");
                                                              put("III", "3");
                                                              put("IV", "4");
                                                              put("V", "5");
                                                              put("VI", "6");
                                                              put("VII", "7");
                                                              put("VIII", "8");
                                                              put("IX", "9");
                                                              put("X", "10"); }};

        HashMap value = new HashMap<String, String>() {{     put("1", "1");
                                                              put("2", "11");
                                                              put("3", "111");
                                                              put("4", "1111");
                                                              put("5", "11111");
                                                              put("6", "111111");
                                                              put("7", "1111111");
                                                              put("8", "11111111");
                                                              put("9", "111111111");
                                                              put("10", "1111111111"); }};

        String line = new String();
        while (!line.equals("exit")) {
            Scanner input = new Scanner(System.in);
            System.out.println("Enter: ");
            line = input.nextLine();
            line = line.replaceAll(" ", "");

            String[] ch = line.split("[0-9]+");
            String[] items = line.split("[-*+/]+");

            String value1 = items[0], value2 = items[1];

            // if rom value:
            if (line.split("[0-9-*/+]+").length > 0) {
                ch = line.split("[a-zA-Z]+");

                value1 = (String) rom_value.get(items[0]);
                value2 = (String) rom_value.get(items[1]);
            }

            int size_value1 = 0, size_value2 = 0, result = 0;

            // check for digit format:
            try {
                size_value1 = ((String) value.get(value1)).length();
                size_value2 = ((String) value.get(value2)).length();
                result = 0;
            } catch (NullPointerException e) {
                ValueException mye = new ValueException("ExceptionValue: You can use only roman or only arabic numbers!");
                mye.printStackTrace();
            }


            if (ch[1].equals("+"))
                result = size_value1 + size_value2;
            System.out.println(result);
            if (ch[1].equals("-"))
                result = size_value1 - size_value2;
            System.out.println(result);
            if (ch[1].equals("*"))
                result = size_value1 * size_value2;
            System.out.println(result);
            if (ch[1].equals("/"))
                result = size_value1 / size_value2;
            System.out.println(result);
        }
    }
}