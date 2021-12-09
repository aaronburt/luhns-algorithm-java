# Luhn's Algorithm

Java implementation of Luhn's Algorithm used for checking the validity of a Credit/Debit card 16 digit number.

## How does it work

Luhn's algorithm uses the pattern of 2 1 2 1 to multiply corresponding numbers by the pattern numbers they are assigned too.
```
Card Number:  4 9 2 9 2 0 7 3 1 3 5 0 0 1 6 8 
Pattern used: 2 1 2 1 2 1 2 1 2 1 2 1 2 1 2 1
Answer:       8 9 4 9 4 0 5 3 2 3 1 0 0 1 3 8
```

If an answer goes into double digits, the answer will be split into two single digits and they will be added together; for example, 6 * 2 = 12 so we split 12 into 1 + 2 = 3. If a card number is valid it must end in a zero.

The Sum of adding up 8 9 4 9 4 0 5 3 2 3 1 0 0 1 3 8 is 60, therefore the card is a valid card. This doesn't mean the card is active or was ever active but merely means it fits the algorithm.


## Disclaimer

This doesn't poll or check any external service and only uses the algorithm to check its validity, it's very possible that a number could be used that passes this test but still isn't a valid card number.