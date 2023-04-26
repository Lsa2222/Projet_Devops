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
    
/* -----------------------------------------------------------------------------------------------------------------------
	Test Constructors
   -----------------------------------------------------------------------------------------------------------------------*/

	@Test
	public void testDataFrameisNotEmpty() throws DataframeNullException {
		String[][] values = {{"1","2"},{"exemple1","exemple2"}};
		Dataframe frame = new Dataframe(values);
		assertFalse(frame.getColumns()[0].isNull());
	}
	
	@Test
	public void testDataFrameWithJustColmumNames() throws DataframeNullException {
		String[] tab_names = {"test1","test2","test3"};
		Dataframe frame = new Dataframe(tab_names);
		assertTrue(frame.getColumns()[0].isNull());
	}
	
	@Test
	public void testDataFrameWithColmumNamesGenerated() throws DataframeNullException {
		Dataframe frame = new Dataframe(5);
		assertTrue(frame.getColumns()[0].isNull());
	}
	
	//CSV Constructor
	@Test
	public void testCreateDataframeWithCSV() throws DataframeNullException {
		Dataframe frame = new Dataframe("./src/CSVFiles/testFile.csv");
		frame.toString();
	}
	
	@Test(expected = DataframeNullException.class)
	public void testDataFrameConstructorEmpty() throws DataframeNullException {
		Dataframe frame = new Dataframe();
	}
	
	@Test(expected = DataframeNullException.class)
	public void testDataFrameEmptyTab() throws DataframeNullException {
		String[][] values = new String[0][1];
		Dataframe frame = new Dataframe(values);
	}
	
	@Test(expected = DataframeNullException.class)
	public void testDataFrameisEmpty() throws DataframeNullException {
		String[][] values = {{},{}};
		Dataframe frame = new Dataframe(values);
	}
	
	//CSV Constructor
	@Test(expected = NullPointerException.class)
	public void testCreateDataframeWithCSVUnknownName() throws DataframeNullException {
		Dataframe frame = new Dataframe("./src/CSVFiles/testFil.csv");
		frame.getLigne(0);
	}
	
	@Test(expected = DataframeNullException.class)
	public void testDataFrameEmptyString() throws DataframeNullException {
		String[] values = new String[0];
		Dataframe frame = new Dataframe(values);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testDataFrameNegatif() throws DataframeNullException {
		int values = -1;
		Dataframe frame = new Dataframe(values);
	}
	
	@Test(expected = DataframeNullException.class)
	public void testDataFrameZero() throws DataframeNullException {
		int values = 0;
		Dataframe frame = new Dataframe(values);
	}
	
/* -----------------------------------------------------------------------------------------------------------------------
	Test AddLine
   -----------------------------------------------------------------------------------------------------------------------*/
	//Name Constructor
	@Test
	public void testAddNewLine() throws DataframeNullException {
		String[][] values = {{"1","2"},{"exemple1","exemple2"}};
		String[] toAdd = {"test1","test2"};
		Dataframe frame = new Dataframe(values);
		frame.addLine(toAdd);
		//frame.getLigne(1);//tf
	}
	
	@Test
	public void testAddNewLineWithColumnNameConstructor() throws DataframeNullException {
		String[] values = {"exemple1","exemple2"};
		String[] toAdd = {"test1","test2"};
		Dataframe frame = new Dataframe(values);
		frame.addLine(toAdd);
		//frame.getLigne(0);//tf
	}
	
	//Number Constructor
	@Test
	public void testAddNewLineNumberConstructor() throws DataframeNullException {
		String[] toAdd = {"test1","test2"};
		Dataframe frame = new Dataframe(2);
		frame.addLine(toAdd);
		//frame.getLigne(0);//tf
	}
	
	//CSV Constructor
	@Test
	public void testAddNewLineWithCSV() throws DataframeNullException {
		Dataframe frame = new Dataframe("./src/CSVFiles/testFile.csv");
		String[] toAdd = {"test1","test2"};
		frame.addLine(toAdd);
		//frame.getLigne(1);//tf
	}
	
	//Name Constructor
		@Test(expected = DataframeNullException.class)
		public void testAddNewLineNullArguments() throws DataframeNullException {
			String[] values = {"exemple1"};
			Dataframe frame = new Dataframe(values);
			frame.addLine(null);
		}
		
		
	
	//Name Constructor
	@Test(expected = IllegalArgumentException.class)
	public void testAddNewLineWithColumnNameTooMuchArguments() throws DataframeNullException {
		String[] values = {"exemple1"};
		String[] toAdd = {"test1","test2"};
		Dataframe frame = new Dataframe(values);
		frame.addLine(toAdd);
	}
	
	//Name Constructor
	@Test(expected = IllegalArgumentException.class)
	public void testAddNewLineWithColumnNameTooFewArguments() throws DataframeNullException {
		String[] values = {"exemple1","exemple2"};
		String[] toAdd = {"test1"};
		Dataframe frame = new Dataframe(values);
		frame.addLine(toAdd);
	}
	
	//Number Constructor
	@Test(expected = IllegalArgumentException.class)
	public void testAddNewLineNumberConstructorTooMuchArgument() throws DataframeNullException {
		String[] toAdd = {"test1","test2"};
		Dataframe frame = new Dataframe(1);
		frame.addLine(toAdd);
	}
	
	//Number Constructor
	@Test(expected = IllegalArgumentException.class)
	public void testAddNewLineTooFewArguments() throws DataframeNullException {
		String[] toAdd = {"test1","test2"};
		Dataframe frame = new Dataframe(3);
		frame.addLine(toAdd);
	}
	
/* -----------------------------------------------------------------------------------------------------------------------
	Test SetCol
   -----------------------------------------------------------------------------------------------------------------------*/
	
	@Test
	public void testSetColInt() throws DataframeNullException {
		Dataframe frame = new Dataframe(2);
		String[] toAdd = {"test1","test2"};
		frame.addLine(toAdd);
		String[] toAdd2 = {"test3"};
		frame.setCol(0,toAdd2);
	}
	
	@Test
	public void testSetColString() throws DataframeNullException { // TODO
		String[] values = {"1","2"};
		Dataframe frame = new Dataframe(values);
		String[] toAdd = {"test1","test2"};
		frame.addLine(toAdd);
		String[] toAdd2 = {"test1"};
		frame.setCol("2",toAdd2);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testSetColColumnsNull() throws DataframeNullException {
		Dataframe frame = new Dataframe(1);
		String[] toAdd = {"test1"};
		frame.setCol(0,toAdd);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testSetColTypeError() throws DataframeNullException {
		String[][] values = {{"1","2"},{"exemple1","exemple2"}};
		Dataframe frame = new Dataframe(values);
		String[] toAdd = {"test1","test2"};
		frame.setCol(3.1,toAdd);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testSetColOutBondInt() throws DataframeNullException {
		String[][] values = {{"1","2"},{"exemple1","exemple2"}};
		Dataframe frame = new Dataframe(values);
		String[] toAdd = {"test1","test2"};
		frame.setCol(4,toAdd);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testSetColNotSameLength() throws DataframeNullException {
		String[] values = {"1","2"};
		Dataframe frame = new Dataframe(values);
		String[] toAdd = {"test1","test2"};
		frame.addLine(toAdd);
		String[] toAdd2 = {"test1", "test2", "test3"};
		frame.setCol("2",toAdd2);
	}
	
	
	@Test(expected = IllegalArgumentException.class)
	public void testSetColOutBondString() throws DataframeNullException {
		String[][] values = {{"1","2"},{"exemple1","exemple2"}};
		Dataframe frame = new Dataframe(values);
		String[] toAdd = {"test1","test2"};
		frame.setCol("4",toAdd);
	}	
	
	@Test(expected = DataframeNullException.class)
	public void testSetColNull() throws DataframeNullException {
		String[][] values = {{"1","2"},{"exemple1","exemple2"}};
		Dataframe frame = new Dataframe(values);
		frame.setCol(3.1,null);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testSetColOutOfBound() throws DataframeNullException {
		String[][] values = {{"1","2"},{"exemple1","exemple2"}};
		Dataframe frame = new Dataframe(values);
		String[] toAdd = {"test1","test2"};
		frame.setCol(5,toAdd);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testSetColOutOfBoundNegative() throws DataframeNullException {
		String[][] values = {{"1","2"},{"exemple1","exemple2"}};
		Dataframe frame = new Dataframe(values);
		String[] toAdd = {"test1","test2"};
		frame.setCol(-1,toAdd);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testSetColTooFewArguments() throws DataframeNullException {
		String[][] values = {{"1","2"},{"exemple1","exemple2"}};
		Dataframe frame = new Dataframe(values);
		String[] toAdd = {"test1"};
		frame.setCol(0,toAdd);
	}
	
/* -----------------------------------------------------------------------------------------------------------------------
	Test GetColonne
   -----------------------------------------------------------------------------------------------------------------------*/	

	@Test
	public void testGetColonneInt() throws DataframeNullException {
		Dataframe frame = new Dataframe(2);
		String[] toAdd = {"test1","test2"};
		frame.addLine(toAdd);
		Dataframe frame2 = frame.getColonne(0);
	}
	
	@Test
	public void testGetColonneString() throws DataframeNullException {
		String[] values = {"1","2"};
		Dataframe frame = new Dataframe(values);
		String[] toAdd = {"test1","test2"};
		frame.addLine(toAdd);
		Dataframe frame2 = frame.getColonne("2");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testGetColonneErrorType() throws DataframeNullException {
		String[] values = {"1","2"};
		Dataframe frame = new Dataframe(values);
		String[] toAdd = {"test1","test2"};
		frame.addLine(toAdd);
		Dataframe frame2 = frame.getColonne(3.14);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testGetColonneOutOfBoundString() throws DataframeNullException {
		String[] values = {"1","2"};
		Dataframe frame = new Dataframe(values);
		String[] toAdd = {"test1","test2"};
		frame.addLine(toAdd);
		Dataframe frame2 = frame.getColonne("3");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testGetColonneNegatif() throws DataframeNullException {
		String[] values = {"1","2"};
		Dataframe frame = new Dataframe(values);
		String[] toAdd = {"test1","test2"};
		frame.addLine(toAdd);
		Dataframe frame2 = frame.getColonne(-2);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testGetColonneOutOfBoundInt() throws DataframeNullException {
		String[] values = {"1","2"};
		Dataframe frame = new Dataframe(values);
		String[] toAdd = {"test1","test2"};
		frame.addLine(toAdd);
		Dataframe frame2 = frame.getColonne(3);
	}
	
/* -----------------------------------------------------------------------------------------------------------------------
	Test GetLine
   -----------------------------------------------------------------------------------------------------------------------*/
	
	@Test
	public void testGetLine() throws DataframeNullException {
		String[] values = {"1","2"};
		Dataframe frame = new Dataframe(values);
		String[] toAdd = {"test1","test2"};
		frame.addLine(toAdd);
		Dataframe frame2 = frame.getLigne(0);
	}
	
	@Test(expected = NullPointerException.class)
	public void testGetLineWithNoContentDataframe() throws DataframeNullException {
		String[] tab_names = {"test1","test2","test3"};
		Dataframe frame = new Dataframe(tab_names);
		frame.getLigne(0);
	}
	
	@Test(expected = NullPointerException.class)
	public void testGetLineWithNoContentWithColmumNamesGenerated() throws DataframeNullException {
		Dataframe frame = new Dataframe(5);
		frame.getLigne(0);
	}
	
	@Test(expected = IndexOutOfBoundsException.class)
	public void testGetLigneOutofBound() throws DataframeNullException {
		String[][] values = {{"1","2"},{"exemple1","exemple2"}};
		Dataframe frame = new Dataframe(values);
		frame.getLigne(3);
	}
	
/* -----------------------------------------------------------------------------------------------------------------------
	Test GetColumns & SetColumns
   -----------------------------------------------------------------------------------------------------------------------*/	

	@Test
	public void testGet_SetColumn() throws DataframeNullException {
		String[][] val1 = {{"Hello"},{"World"}};
		Dataframe frame = new Dataframe(val1);
		String[][] val2 = {{"Hey"},{"Listen"}};
		Dataframe frame2 = new Dataframe(val2);

		frame.setColumns(frame2.getColumns());
	}

/* -----------------------------------------------------------------------------------------------------------------------
	Test GetSize
   -----------------------------------------------------------------------------------------------------------------------*/	

	@Test
	public void testGetSizeFull() throws DataframeNullException {
		String[][] val1 = {{"Hello"},{"World"}};
		Dataframe frame = new Dataframe(val1);
		String size = frame.getSize();
	}
	
	@Test
	public void testGetSizeEmpty() throws DataframeNullException {
		Dataframe frame = new Dataframe(2);
		String size = frame.getSize();
	}
	
/* -----------------------------------------------------------------------------------------------------------------------
	Test ToString
   -----------------------------------------------------------------------------------------------------------------------*/	
	
	@Test
	public void testToStringEmptyy() throws DataframeNullException {
		Dataframe frame = new Dataframe(2);
		String str = frame.toString();
	}
	
/* -----------------------------------------------------------------------------------------------------------------------
	Test part
   -----------------------------------------------------------------------------------------------------------------------*/	
	
	@Test
	public void testpartToString() throws DataframeNullException {
		String[] values = {"1","2","3"};
		Dataframe frame = new Dataframe(values);
		String[] toAdd = {"test1","test2","test3"};
		frame.addLine(toAdd);
		String[] toAdd2 = {"test4","test5","test6"};
		frame.addLine(toAdd2);
		String str = frame.partToString(0,1,1,2);
	}
	
	@Test
	public void testStartPart() throws DataframeNullException {
		String[] values = {"1","2","3"};
		Dataframe frame = new Dataframe(values);
		String[] toAdd = {"test1","test2","test3"};
		frame.addLine(toAdd);
		String[] toAdd2 = {"test4","test5","test6"};
		frame.addLine(toAdd2);
		String str = frame.startToString(1);
	}
	
	@Test
	public void testEndPart() throws DataframeNullException {
		String[] values = {"1","2","3"};
		Dataframe frame = new Dataframe(values);
		String[] toAdd = {"test1","test2","test3"};
		frame.addLine(toAdd);
		String[] toAdd2 = {"test4","test5","test6"};
		frame.addLine(toAdd2);
		String str = frame.endToString(1);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testGetPartDataframeError() throws DataframeNullException {
		String[] values = {"1","2","3"};
		Dataframe frame = new Dataframe(values);
		String[] toAdd = {"test1","test2","test3"};
		frame.addLine(toAdd);
		String[] toAdd2 = {"test4","test5","test6"};
		frame.addLine(toAdd2);
		Dataframe frame2 = frame.getPartDataframe(-1, 8, 5, 2);
	}
	
/* -----------------------------------------------------------------------------------------------------------------------
	Test set & get Cell
   -----------------------------------------------------------------------------------------------------------------------*/	

	@Test
	public void testGetCell() throws DataframeNullException {
		String[] values = {"1","2","3"};
		Dataframe frame = new Dataframe(values);
		String[] toAdd = {"test1","test2","test3"};
		frame.addLine(toAdd);
		String[] toAdd2 = {"test4","test5","test6"};
		frame.addLine(toAdd2);
		Object cell = frame.getCell(0,0);
	}
	
	@Test(expected = IndexOutOfBoundsException.class)
	public void testGetcellError() throws DataframeNullException {
		String[] values = {"1","2","3"};
		Dataframe frame = new Dataframe(values);
		String[] toAdd = {"test1","test2","test3"};
		frame.addLine(toAdd);
		String[] toAdd2 = {"test4","test5","test6"};
		frame.addLine(toAdd2);
		Object cell = frame.getCell(-1,8);
	}
	
	
	@Test
	public void testSetCell() throws DataframeNullException {
		String[] values = {"1","2","3"};
		Dataframe frame = new Dataframe(values);
		String[] toAdd = {"test1","test2","test3"};
		frame.addLine(toAdd);
		String[] toAdd2 = {"test4","test5","test6"};
		String cell = "hey";
		frame.setCell(0,0,cell);
	}
	
	@Test(expected = IndexOutOfBoundsException.class)
	public void testSetcellError() throws DataframeNullException {
		String[] values = {"1","2","3"};
		Dataframe frame = new Dataframe(values);
		String[] toAdd = {"test1","test2","test3"};
		frame.addLine(toAdd);
		String[] toAdd2 = {"test4","test5","test6"};
		frame.addLine(toAdd2);
		String cell = "hey";
		frame.setCell(-1,8,cell);
	}
	
/* -----------------------------------------------------------------------------------------------------------------------
	Test setLabel
   -----------------------------------------------------------------------------------------------------------------------*/	

	@Test
	public void testSetLabel() throws DataframeNullException {
		String[] values = {"1","2","3"};
		Dataframe frame = new Dataframe(values);
		String[] toAdd = {"test1","test2","test3"};
		frame.addLine(toAdd);
		String[] toAdd2 = {"test4","test5","test6"};
		frame.addLine(toAdd2);
		String cell = "hey";
		frame.setLabel(0,cell);
	}
	
	@Test(expected = IndexOutOfBoundsException.class)
	public void testSetLabelNegatif() throws DataframeNullException {
		String[] values = {"1","2","3"};
		Dataframe frame = new Dataframe(values);
		String[] toAdd = {"test1","test2","test3"};
		frame.addLine(toAdd);
		String[] toAdd2 = {"test4","test5","test6"};
		frame.addLine(toAdd2);
		String cell = "hey";
		frame.setLabel(-1,cell);
	}
	
	@Test(expected = IndexOutOfBoundsException.class)
	public void testSetLabelOutOfBound() throws DataframeNullException {
		String[] values = {"1","2","3"};
		Dataframe frame = new Dataframe(values);
		String[] toAdd = {"test1","test2","test3"};
		frame.addLine(toAdd);
		String[] toAdd2 = {"test4","test5","test6"};
		frame.addLine(toAdd2);
		String cell = "hey";
		frame.setLabel(8,cell);
	}
}
