package uk.co.onthebeach;

import java.util.ArrayList;
import java.util.List;

public interface CodingExerciseService {

	//	list is in the form of 'a, bc, cf ...' without the signs
	ArrayList<String> createList(String finalInput);

	ArrayList<String> getMyList();

	//	get the first elements from the list. such as if a, bc, de... get a, b, d
	// 	orderedList() will use first elements to organize the list
	ArrayList<String> firstElements(ArrayList<String> myList);

	//	2 lists : myList and theList. myList in form of a, bc, d, ef ... 
	//	theList first elements of myList is in form of a, b, d , e ...
	//	get the second char of elements in myList and change positions in theList.
	// 	such as 'bc' is for b => c that c comes before b that we rearrange accordingly
	ArrayList<String> orderedList(ArrayList<String> unOrderedList);

	//	Check for circular dependencies
	void checkCircular(List<String> myList);

	//	check last char of an element with first char of the other
	boolean checkChar(String s1, String s2);

	//	check if string starts and ends with same letter
	boolean isCircular(String s);

	//	read the input from console and call createList method to create a list
	//	in form of ab, c ,d , ef .... single element for single input line, double for double 
	String consoleInput();

	void start();

}