package BreackfastClub.ProjetDevopsPanda;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.FileNotFoundException;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    
    /*General constructor*/
	@Test
	public void testDataFrameisNotEmpty() {
		String[][] values = {{"1","2"},{"exemple1","exemple2"}};
		Dataframe frame = new Dataframe(values);
		assertFalse(frame.getColumns()[0].isNull());
	}
	
	@Test
	public void testDataFrameWithJustColmumNames() {
		String[] tab_names = {"test1","test2","test3"};
		Dataframe frame = new Dataframe(tab_names);
		assertTrue(frame.getColumns()[0].isNull());
	}
	
	@Test(expected = NullPointerException.class)
	public void testGetLineWithNoContentDataframe() {
		String[] tab_names = {"test1","test2","test3"};
		Dataframe frame = new Dataframe(tab_names);
		frame.getLigne(0);
	}
	
	@Test
	public void testDataFrameWithColmumNamesGenerated() {
		Dataframe frame = new Dataframe(5);
		assertTrue(frame.getColumns()[0].isNull());
	}
	
	@Test(expected = NullPointerException.class)
	public void testGetLineWithNoContentWithColmumNamesGenerated() {
		Dataframe frame = new Dataframe(5);
		frame.getLigne(0);
	}
	
	/*@Test
	public void testDataFrameisEmpty() {
		String[][] values = {{},{}};
		Dataframe frame = new Dataframe(values);
		assertTrue(frame.getColumns()[0].isNull());
	}*/
	
	@Test(expected = IndexOutOfBoundsException.class)
	public void testGetLigneOutofBound() {
		String[][] values = {{"1","2"},{"exemple1","exemple2"}};
		Dataframe frame = new Dataframe(values);
		frame.getLigne(3);
	}
	
	//Name Constructor
	@Test
	public void testAddNewLine() {
		String[][] values = {{"1","2"},{"exemple1","exemple2"}};
		String[] toAdd = {"test1","test2"};
		Dataframe frame = new Dataframe(values);
		frame.addLine(toAdd);
		frame.getLigne(1);
	}
	
	@Test
	public void testAddNewLineWithColumnNameConstructor() {
		String[] values = {"exemple1","exemple2"};
		String[] toAdd = {"test1","test2"};
		Dataframe frame = new Dataframe(values);
		frame.addLine(toAdd);
		frame.getLigne(0);
	}
	
	//Name Constructor
	@Test
	public void testAddNewLineWithColumnNameTooMuchArguments() {
		String[] values = {"exemple1"};
		String[] toAdd = {"test1","test2"};
		Dataframe frame = new Dataframe(values);
		frame.addLine(toAdd);
		frame.getLigne(0);
	}
	
	//Name Constructor
	@Test(expected = ArrayIndexOutOfBoundsException.class)
	public void testAddNewLineWithColumnNameTooFewArguments() {
		String[] values = {"exemple1","exemple2"};
		String[] toAdd = {"test1"};
		Dataframe frame = new Dataframe(values);
		frame.addLine(toAdd);
		frame.getLigne(0);
	}
	
	//Number Constructor
	@Test
	public void testAddNewLineNumberConstructor() {
		String[] toAdd = {"test1","test2"};
		Dataframe frame = new Dataframe(2);
		frame.addLine(toAdd);
		frame.getLigne(0);
	}
	
	//Number Constructor
	@Test
	public void testAddNewLineNumberConstructorTooMuchArgument() {
		String[] toAdd = {"test1","test2"};
		Dataframe frame = new Dataframe(1);
		frame.addLine(toAdd);
		frame.getLigne(0);
	}
	
	//Number Constructor
	@Test(expected = ArrayIndexOutOfBoundsException.class)
	public void testAddNewLineTooFewArguments() {
		String[] toAdd = {"test1","test2"};
		Dataframe frame = new Dataframe(3);
		frame.addLine(toAdd);
		frame.getLigne(0);
	}
	
	//CSV Constructor
	@Test
	public void testCreateDataframeWithCSV() {
		Dataframe frame = new Dataframe("./src/CSVFiles/testFile.csv");
		frame.getLigne(0);
	}
	
	//CSV Constructor
	@Test(expected = NullPointerException.class)
	public void testCreateDataframeWithCSVUnknownName() {
		Dataframe frame = new Dataframe("./src/CSVFiles/testFil.csv");
		frame.getLigne(0);
	}
	
	//CSV Constructor
	@Test
	public void testAddNewLineWithCSV() {
		Dataframe frame = new Dataframe("./src/CSVFiles/testFile.csv");
		String[] toAdd = {"test1","test2"};
		frame.addLine(toAdd);
		frame.getLigne(1);
	}
	
	@Test
	public void testSetCol() {
		String[][] values = {{"1","2"},{"exemple1","exemple2"}};
		Dataframe frame = new Dataframe(values);
		String[] toAdd = {"test1","test2"};
		frame.setCol(1,toAdd);
		frame.getLigne(1);
	}
	
	@Test(expected = ArrayIndexOutOfBoundsException.class)
	public void testSetColOutOfBound() {
		String[][] values = {{"1","2"},{"exemple1","exemple2"}};
		Dataframe frame = new Dataframe(values);
		String[] toAdd = {"test1","test2"};
		frame.setCol(5,toAdd);
	}
	
	@Test(expected = ArrayIndexOutOfBoundsException.class)
	public void testSetColOutOfBoundNegative() {
		String[][] values = {{"1","2"},{"exemple1","exemple2"}};
		Dataframe frame = new Dataframe(values);
		String[] toAdd = {"test1","test2"};
		frame.setCol(-1,toAdd);
	}
	
	@Test(expected = ArrayIndexOutOfBoundsException.class)
	public void testSetColTooFewArguments() {
		String[][] values = {{"1","2"},{"exemple1","exemple2"}};
		Dataframe frame = new Dataframe(values);
		String[] toAdd = {"test1"};
		frame.setCol(0,toAdd);
		frame.toString();
	}
		
	
	/*
	@Test
	public int[] testSizeDataFrame() {
		String[][] values = {{1,2},{"exemple1","exemple2"}};
		Dataframe frame = new Dataframe(values);
		int[] frameSizeToTest = {2,2};
		assertEquals(frameSizeToTest, frame.size());
	}
	
	@Test
	public String testSizeDataFrame() {
		String[][] values = {{1,2},{"exemple1","exemple2"}};
		Dataframe frame = new Dataframe(values);
		int[] frameSizeToTest = {2,2};
		assertEquals(frameSizeToTest, frame.size());
	}
	
	@Test
	public String testDataframeGetColumn() {
		String[][] values = {{1,2},{"exemple1","exemple2"}};
		Dataframe frame = new Dataframe(values);
		String[] testColumn = {"A","1","2"};
		assertEquals(testColumn, frame.getColumn(1));
	}
	
	//CSV constructor
	@Test
	public String testSizeCSV() {
		File fileTest = new File("/src/CSVFiles/testFile.csv");
		Dataframe frame = new Dataframe(fileTest);
		int[] frameSizeToTest = {2,2};
		assertEquals(frameSizeToTest, frame.size());
	}
	
	@Test
	public String testDataframeCSVisEmpty() {
		File fileTest = new File("/src/CSVFiles/testFileEmpty.csv");
		Dataframe frame = new Dataframe(fileTest);
		assertTrue(frame.isEmpty());
		assertEquals(0, frame.size());
	}
	
	@Test
	public String testDataframeCSVgetColumn() {
		File fileTest = new File("/src/CSVFiles/testFileEmpty.csv");
		Dataframe frame = new Dataframe(fileTest);
		String[] testColumn1 = {"Chiffre","1","2"};
		String[] testColumn2 = {"Lettre","un","deux"};
		assertEquals(testColumn1, frame.getColumn(1));
		assertEquals(testColumn2, frame.getColumn(2));
	}*/
}
