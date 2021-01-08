import java.util.*;


class ValueException extends Exception {

    public ValueException(String message) {

        super(message);
    }
}

public class Main {

    private static String getKey(HashMap<String, String> hm, String value) {

        for (String key : (Set<String>)hm.keySet())
            if (hm.get(key).equals(value.indexOf(0)))
                return key;

        return "";
    }

    public static void main(String[] args) {
        List<String> rom_values = Arrays.asList("I II III IV V VI VII VIII IX X XI XII XIII XIV XV XVI XVII XVIII XIX XX XXI XXII XXIII XXIV XXV XXVI XXVII XXVIII XXIX XXX XXXI XXXII XXXIII XXXIV XXXV XXXVI XXXVII XXXVIII XXXIX XL XLI XLII XLIII XLIV XLV XLVI XLVII XLVIII XLIX L LI LII LIII LIV LV LVI LVII LVIII LIX LX LXI LXII LXIII LXIV LXV LXVI LXVII LXVIII LXIX LXX LXXI LXXII LXXIII LXXIV LXXV LXXVI LXXVII LXXVIII LXXIX LXXX LXXXI LXXXII LXXXIII LXXXIV  LXXXV LXXXVI LXXXVII LXXXVIII LXXXIX  XC XCI XCII XCIII XCIV XCV XCVI XCVII XCVIII XCIX C".toString().split(" ").clone());

        HashMap rom_value = new HashMap<String, String>() {{ put("I", "1");
                                                              put("II", "2");
                                                              put("III", "3");
                                                              put("IV", "4");
                                                              put("V", "5");
                                                              put("VI", "6");
                                                              put("VII", "7");
                                                              put("VIII", "8");
                                                              put("IX", "9");
                                                              put("X", "10");
                                                              put("L", "50");
                                                              put("C", "100"); }};

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

            // if rom value
            Boolean is_rom_value = Boolean.FALSE;
            if (line.split("[0-9-*/+]+").length > 0) {
                ch = line.split("[a-zA-Z]+");

                value1 = (String) rom_value.get(items[0]);
                value2 = (String) rom_value.get(items[1]);

                is_rom_value = Boolean.TRUE;
            }

            int size_value1 = 0, size_value2 = 0, result = 0;

            // check for digit format:
            try {
                size_value1 = ((String) value.get(value1)).length();
                size_value2 = ((String) value.get(value2)).length();
                result = 0;
            } catch (NullPointerException e) {
                ValueException mye = new ValueException("ExceptionValue: You can use only roman or only arabic numbers(0 to 10 inclusive)!");
                mye.printStackTrace();
            }


            if (ch[1].equals("+"))
                result = size_value1 + size_value2;
            if (ch[1].equals("-"))
                result = size_value1 - size_value2;
            if (ch[1].equals("*"))
                result = size_value1 * size_value2;
            if (ch[1].equals("/"))
                result = size_value1 / size_value2;

            if (!is_rom_value)
                System.out.println(result);
            else {
                String rv = (String)rom_values.get(result-1);

                System.out.println(rv);
            }
        }
    }
}