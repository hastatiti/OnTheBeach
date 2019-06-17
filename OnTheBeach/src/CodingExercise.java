import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CodingExercise {
	String s = "a => b => c =>";
	String s2 = "a => b => c c =>";
	public static ArrayList sequence(String job) {
		List<String> myList = new ArrayList<>();

		return null;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Entries : ");
		while(sc.hasNextLine()) {
			String rawLine = sc.nextLine();
			String[] line = rawLine.split(" => ");
			String firstInput = line[0];
			String secondInput = line[1];
		}
	}
}
