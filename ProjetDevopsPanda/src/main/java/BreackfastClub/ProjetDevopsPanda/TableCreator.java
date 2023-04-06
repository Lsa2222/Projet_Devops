package BreackfastClub.ProjetDevopsPanda;

//makes a formated table out of string data.
public class TableCreator {
	
	public static String createTable(String[][] data) {

		StringBuilder builder = new StringBuilder();

		builder.append(buildFirstString(data));
		
		//each data row
		for (int i=0 ; i<data.length ; i++) {
			//each string 
			for (int j=0; j<data[0].length ; j++) {
				
			}
		}
		
		return builder.toString();
	}

	private static String buildFirstString(String[][] data) {

		int[] columnSizes = getColumnSizes(data);

		StringBuilder builder = new StringBuilder();
		//0,0 cell is fully empty, we do not name the index column
		builder.append(" ".repeat(columnSizes[0]));

		for (int i=1 ; i<columnSizes.length ; i++) {
			builder.append(" ");//separation from last column.
			builder.append(String.format("%-" + columnSizes[i] + "s", data[0][i]));
		}
		
		return builder.toString();
	}

	//finds the biggest data size of each column
	private static int[] getColumnSizes(String[][] data){
		int[] sizes = new int[data.length];

		for(int i=0;i<data.length;i++){
			int maxsize = 0;
			
			for(int j=0;j<data[i].length;j++){
				if(data[i][j].length()>maxsize)
					maxsize = data[i][j].length();
			}
		}

		return sizes;
	}
	
}