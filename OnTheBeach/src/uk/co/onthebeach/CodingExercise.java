package uk.co.onthebeach;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class CodingExercise implements CodingExerciseService {
	ArrayList<String> myList = new ArrayList<>();
	ArrayList<String> theList = new ArrayList();
	String finalInput;

	//	list is in the form of 'a, bc, cf ...' without the signs
	@Override
	public ArrayList<String> createList(String finalInput) {
		String [] s = finalInput.split(" ");
		for(String st : s) {
			myList.add(st);
		}
		return myList;
	}

	@Override
	public ArrayList<String> getMyList() {
		return myList;
	}
	
	//	get the first elements from the list. such as if a, bc, de... get a, b, d
	// 	orderedList() will use first elements to organize the list
	@Override
	public ArrayList<String> firstElements(ArrayList<String> myList){
		for (int i = 0; i < myList.size(); i++) {
			String a = myList.get(i);
			char c = a.charAt(0);
			String b = Character.toString(c);
			theList.add(b);
		}
		return theList;
	}
	
	//	2 lists : myList and theList. myList in form of a, bc, d, ef ... 
	//	theList first elements of myList is in form of a, b, d , e ...
	//	get the second char of elements in myList and change positions in theList.
	// 	such as 'bc' is for b => c that c comes before b that we rearrange accordingly
	@Override
	public ArrayList<String> orderedList(ArrayList<String> unOrderedList){
		myList = unOrderedList;
		theList = firstElements(getMyList());
		for (int i = 0; i < myList.size(); i++) {
			String st = myList.get(i);
			if(st.length() > 1) {
				char c1 = st.charAt(0);
				char c2 = st.charAt(1);
				String a = Character.toString(c1);
				String b = Character.toString(c2);
				int k = theList.indexOf(a);
				theList.add(k, b);
			}
		}
		//remove duplicate elements
		Set<String> mySet = new LinkedHashSet<>(theList);
		theList = new ArrayList<>(mySet);
		System.out.println(theList);
		return theList;
	}
	
	//	Check for circular dependencies
	@Override
	public void checkCircular(List<String> myList) {
		String sb = "";
		String s1 = null, s2 = null;
		
		//	compare each element with others in the list such as
		//	a, bc, cf ... 1) a with bc then cf 2) bc with a and cf ...
		for (int i = 0; i < myList.size(); i++) {
			for (int j = 0; i < myList.size(); j++) {
				//	stop at last element
				if (i == myList.size() - 1 || j == myList.size() - 1 ) break;
				else  {
					s1 = myList.get(i);
					s2 = myList.get(j);
					//	if elements in the list are not single letter call checkChar() method
					//	compare 2 letters , last char with first char, if equal create a new string such as
					//	ab, bc ,de  b==b new string is abbc now compare abbc with de c != e so stop
					if (s1.length() > 1 && s2.length() > 1 && checkChar(s1, s2)) {
						sb += s1 + s2;
					//	System.out.println(sb);
						//	with the newly created string above call findCircular()
						// check if the newly created string starts and ends with same char
						if (isCircular(sb)) {
							System.err.println("Circular Dependecy Detected !!!");
							System.exit(0);
						}
					} else continue;
				}
			}
		}
	}
	
	//check last char of an element with first char of the other
	@Override
	public boolean checkChar(String s1, String s2) {
		int len = s1.length();
		char c1 = s1.charAt(len-1);
		char c2 = s2.charAt(0);
		return c1 == c2;
	}
	
	//check if string starts and ends with same letter
	@Override
	public boolean isCircular(String s) {
		int len = s.length();
		char a = s.charAt(0);
		char b = s.charAt(len - 1);
		return a == b;
	}
	
	//	read the input from console and call createList method to create a list
	//	in form of ab, c ,d , ef .... single element for single input line, double for double 
	@Override
	public String consoleInput() {
		// if a => b firstInput is a, secondInput is b
		String firstInput,secondInput;
		// a + b
		//String finalInput = null;
		StringBuilder sb = new StringBuilder();
		
		Scanner sc = new Scanner(System.in);
		while (sc.hasNextLine()) {
			String rawLine = sc.nextLine();
			
			String[] line = rawLine.split(" => ");
			//get 2 letters 
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
			sb =  sb.append(finalInput).append(" ");
		}
		finalInput = sb.toString();
		return finalInput;
	}
	
	@Override
	public void start() {
		createList(consoleInput());		//get user input, create list
		checkCircular(getMyList());		//Error message on circular
		orderedList(getMyList());		//final product, ordered list
	}
	
	public static void main(String[] args) {
		System.out.println("Entries (Press 'ctrl d' to exit) : ");
		Scanner sc = new Scanner(System.in);
			
		new CodingExercise().start();
	}
}
