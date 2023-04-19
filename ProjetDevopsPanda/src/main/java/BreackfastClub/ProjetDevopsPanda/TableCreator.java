package BreackfastClub.ProjetDevopsPanda;

import javax.xml.crypto.Data;

//makes a formated table out of string data.
public class TableCreator {
	
	public static String createTable(String[][] data) {

		StringBuilder builder = new StringBuilder();

		builder.append(buildFirstString(data));
		
		//we iterate line by line
		for (int i=1 ; i<getLongestColumnSize(data); i++) {
			
			builder.append(buildLineString(data, i));
		}
		
		return builder.toString();
	}

	private static String buildFirstString(String[][] data) {

		int[] columnSizes = getDataWidth(data);

		StringBuilder builder = new StringBuilder();
		//0,0 cell is fully empty, we do not name the index column
		builder.append(" ".repeat(columnSizes[0]+2));

		for (int i=1 ; i<columnSizes.length ; i++) {
			builder.append("|");//separation from last column.
			String format = "%-" + Integer.toString(columnSizes[i]) + "s";
			builder.append(" " + String.format(format, data[i][0]) + " ");
		}
		
		return builder.append('\n').toString();
	}

	private static String buildLineString(String[][] data, int index) {

		StringBuilder builder = new StringBuilder();
		int[] columnSizes = getDataWidth(data);
		
		for (int i=0 ; i<columnSizes.length ; i++) {
			if (i!=0)
				builder.append("|");//separation from last column.
			String format = "%-" + Integer.toString(columnSizes[i]) + "s";
			builder.append(" " + String.format(format, data[i][index]) + " ");
		}
		
		return builder.append('\n').toString();
	}
	
	//finds the biggest data size of each column
	private static int[] getDataWidth(String[][] data){
		int[] sizes = new int[data.length];

		for(int i=0;i<data.length;i++){
			int maxsize = 0;
			
			for(int j=0;j<data[i].length;j++){
				if(data[i][j].length()>maxsize)
					maxsize = data[i][j].length();
			}
			sizes[i] = maxsize;
		}

		return sizes;
	}
	
	//finds the size of the longest column.
	private static int getLongestColumnSize(String [][] data) {
		int max = 0;
		for (int i=0;i<data.length;i++) {
			if(data[i].length>max)
				max=data[i].length;
		}
		return max;
	}
	
}