import static org.junit.jupiter.api.Assertions.*;

import java.util.Scanner;

import org.junit.jupiter.api.Test;

class CodingExerciseTest {

	@Test
	void consoleKeyBoardTest() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Entries (Press 'ctrl d' to exit) : ");
		while (sc.hasNextLine()) {
			String rawLine = sc.nextLine();
			// get the letters line by line
			String firstInput,secondInput;
			// and concatenation in form of xy
			String finalInput = null;
			
			String[] line = rawLine.split(" => ");
			//get the 2 letters 
			if (line.length > 1) {
				firstInput = line[0];
				secondInput = line[1];
				finalInput = firstInput + secondInput;
			}
			//get the single letter
			if (line.length == 1) {
				firstInput = line[0];
				finalInput = firstInput;
			}
			//sequence(finalInput);
		}
	}

}
