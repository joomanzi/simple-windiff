package Controller;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class LCSalgorithmsTest {

	@Test
	public void testLCSalgorithms() {
		ArrayList<String> X = new ArrayList<String>();
		ArrayList<String> Y = new ArrayList<String>(); 	
		X.add("a");
		X.add("c");
		X.add("a");
		X.add("y");
		X.add("k");
		X.add("p");
		Y.add("c");
		Y.add("a");
		Y.add("p");
		Y.add("c");
		Y.add("a");
		Y.add("k");
		//  A CAYKP
		// CAPCA K
		LCSalgorithms test =new LCSalgorithms(X, Y);
		
	}

	@Test
	public void testGetLCSlength() {
		ArrayList<String> X = new ArrayList<String>();
		ArrayList<String> Y = new ArrayList<String>(); 	
		X.add("a");
		X.add("c");
		X.add("a");
		X.add("y");
		X.add("k");
		X.add("p");
		Y.add("c");
		Y.add("a");
		Y.add("p");
		Y.add("c");
		Y.add("a");
		Y.add("k");
		//  A CAYKP
		// CAPCA K
		LCSalgorithms test =new LCSalgorithms(X, Y);
		test.print();
	}

}
