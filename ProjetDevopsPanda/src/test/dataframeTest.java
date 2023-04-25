package BreackfastClub.ProjetDevopsPanda;

public class dataframeTest {

	/*General constructor*/
	@Test
	public String testDataFrameisNotEmpty() {
		String[][] values = {{1,2},{"exemple1","exemple2"}};
		Dataframe frame = new Dataframe(values);
		assertFalse(frame.isEmpty());
	}
	
	@Test
	public String testDataFrameisEmpty() {
		String[][] values = {{},{}};
		Dataframe frame = new Dataframe(values);
		assertTrue(frame.isEmpty());
		assertEquals(0, frame.size());
	}
	
	@Test
	public String testSizeDataFrame() {
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
	
	/*CSV constructor*/
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
	}
	
	
	
}
