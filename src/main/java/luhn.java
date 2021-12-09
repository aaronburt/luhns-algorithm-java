import java.util.LinkedList;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class luhn {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.println("16 Digit card");
        String sixteenDigit = input.nextLine();

        LinkedList<Integer> CardNum = new LinkedList<Integer>();
        LinkedList<Integer> List = new LinkedList<Integer>();
        LinkedList<Integer> Pattern = new LinkedList<Integer>();

        int sixteenLength = sixteenDigit.length();
        if(sixteenLength == 16) {
            for (var i = 0; i < sixteenLength; i++) {
                int currentChar = Integer.parseInt(String.valueOf(sixteenDigit.charAt(i)));
                CardNum.add(currentChar);

                int updated;
                int module = i % 2;

                if (module == 0) {
                    updated = Integer.parseInt(String.valueOf(currentChar)) * 2;
                    Pattern.add(2);
                } else {
                    updated = Integer.parseInt(String.valueOf(currentChar));
                    Pattern.add(1);
                }

                if (updated >= 10) {
                    String updatedString = String.valueOf(updated);
                    int first = Integer.parseInt(String.valueOf(updatedString.charAt(0)));
                    int second = Integer.parseInt(String.valueOf(updatedString.charAt(1)));
                    int third = first + second;
                    List.add(third);
                } else {
                    List.add(updated);
                }
            }

            int result = List.stream().mapToInt(Integer::intValue).sum();

            System.out.println(Pattern);
            System.out.println(List);

            if (result % 10 == 0) {
                System.out.println("Result: " + result  + " Valid token");
            } else {
                System.out.println("Result: " + result  + " Invalid token");
            }
        }
    }
}
