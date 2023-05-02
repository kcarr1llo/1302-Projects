package lab11;


import java.util.*;

public class Num2WordsRecur {

	static String unitsArray[] = { "zero", "one", "two", "three", "four", "five", "six", 
			"seven", "eight", "nine", "ten", "eleven", "twelve",
			"thirteen", "fourteen", "fifteen", "sixteen", "seventeen", 
			"eighteen", "nineteen" };
	static String tensArray[] = { "zero", "ten", "twenty", "thirty", "forty", "fifty",
			"sixty", "seventy", "eighty", "ninety" };

	public static void main(String[] args) {
		int number = 0;
		Scanner SCinput = new Scanner(System.in);
		System.out.println("Please type an integer number(max upto 9 digits): ");
		try {
			// read the number
			number = SCinput.nextInt();
			System.out.print("Number in words: " + numToWord(number));
		} 
		catch (Exception e) {
			System.out.println("Please enter a valid number");
		}
		// close the reader
		SCinput.close();

	}

	private static String numToWord(int num) {
		// variable to hold string representation of number 
		String words = "";
		if (num == 0) {
			return "zero";
		}

		// add minus before conversion if the number is less than 0
		if (num < 0) { 
			// 1) convert the number to a string 
			// 2) remove minus before the number
			// 3) add "minus" spelled word before the number and convert the rest with 
			//     recursion like a positive
			String n ="" + num;
			n = n.substring(1);
			return "minus" + numToWord(Integer.parseInt(n));
			
			
		} 
		
		// First: check if number is divisible by 1 million (use modulo %)
		//          hint: if(num/1000000 > 0) ...
		if(num/1000000 >0 ) {
			words += numToWord(num/1000000) + " million ";
			num %= 1000000;
		}
		
		
		// Secondly: check if number is divisible by 1 thousand 
		//          hint: if(num/1000 > 0) ...
		if((num/1000) >0) {
			words += numToWord(num/1000) + " thousand ";
			num %= 1000;
			
		}
		
		
		// Thirdly: check if number is divisible by 1 hundred
		//          hint: if(num/100 > 0) ...
		if(num/100>0) {
			words += numToWord(num/100) + " hundred ";
			num %= 100;
			
		}

		if (num > 0) {
			// check if number is within teens
			if (num < 20) { 
				// fetch the appropriate value from unit array
				words += unitsArray[num];
			} else { 
				// fetch the appropriate value from tens array
				words += tensArray[num/10]; 
				if ((num % 10) > 0) {
					words += "-" + unitsArray[num%10];
				}  
			}
		}
		return words;
	}
}

