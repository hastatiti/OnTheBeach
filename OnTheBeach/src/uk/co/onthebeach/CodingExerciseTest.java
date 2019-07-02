import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import org.junit.Before;
import org.junit.jupiter.api.Test;

class CodingExerciseTest {
	
	@Test
	void listShoulBeCreatedFromGivenString() {
		String s1 = "a bc d ef";
		List<String> l1 = new ArrayList<>(Arrays.asList("a", "bc", "d", "ef"));
		assertEquals(l1, new CodingExercise().createList(s1));
		
//		String s2 = "a b d";
//		List<String> l2 = new ArrayList<>(Arrays.asList("a", "b", "d"));
//		assertEquals(l2,new CodingExercise().createList(s2));
	}
	
	@Test
	void listShouldBeOrdered() {
		ArrayList<String> unOrderedList1 = new ArrayList<>(Arrays.asList("a", "bc"));
		ArrayList<String> orderedList1 = new ArrayList<>(Arrays.asList("a", "c", "b"));
		assertEquals(orderedList1, new CodingExercise().orderedList(unOrderedList1));
		
		ArrayList<String> unOrderedList2 = new ArrayList<>(Arrays.asList("a", "bc", "cf"));
		ArrayList<String> orderedList2 = new ArrayList<>(Arrays.asList("a", "f", "c", "b"));
		assertEquals(orderedList2, new CodingExercise().orderedList(unOrderedList2));
	}
}

//@Test
////	please uncomment/comment for user inputs (java does not support multiline:))
//void consoleInputShouldReturnSingleString() {
//	System.out.println("Copy paste , Comment/Uncomment for the inputs  (Press 'ctrl d' to exit) : ");
//	Scanner sc = new Scanner(System.in);
////	a => 
////	b => c
//	assertEquals("a bc ", ce.consoleInput());
//	
////	b => c
////	d
////	e
////	f => j
////	assertEquals("bc d e fj ", ce.consoleInput());
//}