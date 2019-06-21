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
	
	public static void checkCircular(List<String> myList) {
		String sb = "";
		String s1 = null, s2 = null;
		outerLoop:
		for (int i = 0; i < myList.size(); i++) {
			for (int j = 0; i < myList.size(); j++) {
				if (i == myList.size() - 1 || j == myList.size() - 1 ) break;
				else  {
					s1 = myList.get(i);
					s2 = myList.get(j);
					if (checkChar(s1, s2)) {
						sb += s1 + s2;
						System.out.println(sb);
						int len = sb.length();
						char a = sb.charAt(0);
						char b = sb.charAt(len - 1);
						if(a ==b) {System.out.println("Detected Circular !!!!"); break outerLoop;}
					} else continue;
				}
			}
		}
	}
	
	public static boolean  checkChar(String s1, String s2) {
		int len = s1.length();
		char c1 = s1.charAt(len-1);
		char c2 = s2.charAt(0);
	//	System.out.println(c1 + " and " + c2);
		return c1 == c2;
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
		
		//getMyList();
		checkCircular(getMyList());
	}
}
