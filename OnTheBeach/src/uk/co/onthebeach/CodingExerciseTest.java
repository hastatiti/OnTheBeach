package uk.co.onthebeach;
import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.Test;

class CodingExerciseTest {
	
	@Test
	void listShoulBeCreatedFromGivenString() {
		String s1 = "a bc d ef";
		List<String> l1 = new ArrayList<>(Arrays.asList("a", "bc", "d", "ef"));
		assertEquals(l1, new CodingExercise().createList(s1));
		
		String s2 = "a b d";
		List<String> l2 = new ArrayList<>(Arrays.asList("a", "b", "d"));
		assertEquals(l2,new CodingExercise().createList(s2));
	}
	
	@Test
	void listShouldBeOrdered() {
		ArrayList<String> unOrderedList1 = new ArrayList<>(Arrays.asList("a", "bc"));
		ArrayList<String> orderedList1 = new ArrayList<>(Arrays.asList("a", "c", "b"));
		System.out.print("Expected : " +  orderedList1 + " Result  : ");
		assertEquals(orderedList1, new CodingExercise().orderedList(unOrderedList1));
		
		ArrayList<String> unOrderedList2 = new ArrayList<>(Arrays.asList("a", "bc", "cf"));
		ArrayList<String> orderedList2 = new ArrayList<>(Arrays.asList("a", "f", "c", "b"));
		System.out.print("Expected : " +  orderedList2 + " Result  : ");
		assertEquals(orderedList2, new CodingExercise().orderedList(unOrderedList2));
		
		ArrayList<String> unOrderedList3 = new ArrayList<>(Arrays.asList("a", "bc", "cf"));
		ArrayList<String> orderedList3 = new ArrayList<>(Arrays.asList("a", "b", "c", "f"));
		System.out.print("FAILED!!! Result : " +  orderedList3 + " Expected  : ");
		assertNotEquals(orderedList3, new CodingExercise().orderedList(unOrderedList3));
	}
	
	@Test
	void testIsCircular() {
		assertTrue(new CodingExercise().isCircular("abcda"));
		assertFalse(new CodingExercise().isCircular("abcd"));
	}
	
	@Test
	void testCheckChar() {
		assertTrue(new CodingExercise().checkChar("ab", "bc"));
		assertFalse(new CodingExercise().checkChar("ab", "cd"));

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