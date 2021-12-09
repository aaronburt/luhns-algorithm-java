import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Luhn {
    public static void main(String[] args){
        /* Get data from userInput */
        Scanner userInput = new Scanner(System.in);
        System.out.println("16 Digit card number");
        String sixteenDigit = userInput.nextLine();

        List<Integer> cardNumbers = new LinkedList<>();
        List<Integer> accumulatedNumbers = new LinkedList<>();
        List<Integer> patternNumbers = new LinkedList<>();

        /* Final ensuring it isn't updated by mistake */
        final int sixteenLength = sixteenDigit.length();
        final int cardLength = 16;

        if(sixteenLength == cardLength) {
            for (var i = 0; i < sixteenLength; i++) {
                int currentChar = Integer.parseInt(String.valueOf(sixteenDigit.charAt(i)));
                cardNumbers.add(currentChar);

                int updated;
                int module = i % 2;

                if (module == 0) {
                    updated = Integer.parseInt(String.valueOf(currentChar)) * 2;
                    patternNumbers.add(2);
                } else {
                    updated = Integer.parseInt(String.valueOf(currentChar));
                    patternNumbers.add(1);
                }

                if (updated >= 10) {
                    String updatedString = String.valueOf(updated);
                    int first = Integer.parseInt(String.valueOf(updatedString.charAt(0)));
                    int second = Integer.parseInt(String.valueOf(updatedString.charAt(1)));
                    int third = first + second;
                    accumulatedNumbers.add(third);
                } else {
                    accumulatedNumbers.add(updated);
                }
            }

            int result = accumulatedNumbers.stream().mapToInt(Integer::intValue).sum();

            System.out.println(cardNumbers);
            System.out.println(patternNumbers);
            System.out.println(accumulatedNumbers);

            /* */
            if (result % 10 == 0) {
                System.out.println("Result: '" + result  + "' valid card number");
            } else {
                System.out.println("Result: '" + result  + "' invalid card number");
            }
        }
    }
}
