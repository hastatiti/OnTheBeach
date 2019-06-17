import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CodingExercise {
	static ArrayList<String> myList = new ArrayList<>();

	public static ArrayList<String> sequence(String job) {
		myList.add(job);
		return myList;
	}


	public static ArrayList<String> getMyList() {
		System.out.println(myList);
		return myList;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Entries (Press 'ctrl d' to exit) : ");
		while (sc.hasNextLine()) {
			String rawLine = sc.nextLine();
			// get the letters line by line
			String firstInput,secondInput;
			// and concatenation in form of xy
			String finalInput = null;
			
			String[] line = rawLine.split(" => ");
			if (line.length > 1) {
				firstInput = line[0];
				secondInput = line[1];
				finalInput = firstInput + secondInput;
			}
			if (line.length == 1) {
				firstInput = line[0];
				finalInput = firstInput;
			}
			sequence(finalInput);
		}
		
		getMyList();
	}
}
