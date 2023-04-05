package BreackfastClub.ProjetDevopsPanda;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

public class Dataframe {
	
	private static AtomicInteger columnId = new AtomicInteger(0);
	private Colonne[] columns;
	
	public Dataframe() {
		String[] values = {"exemple1","exemple2"};
		Colonne<String> c = new Colonne<String>("colonne1",values);
	}
	
	/**
	 * Content-only constructor, 
	 * Column names auto-generated following format 'A', 'B'...
	 * @param content the content to be used in columns
	 */
	public Dataframe(Object[][] content) {
		
		//TODO: check for empty content and/or empty columns
		
		columns = new Colonne[content.length];
		
		for(int i=0;i<=content.length;i++) {
			String name = generateName(columnId.getAndIncrement());
			columns[i] = new Colonne(name, content[i]);
		}
	}
	
	@Override
	public String toString() {
		int[] columnSizes = new int[columns.length+1];
		columnSizes[0] = 2;
		for(int i = 1;i<columnSizes.length;i++) {
			Colonne currCol = columns[i];
			int maxsize = currCol.getLabel().length();
			for(int j=0;j<currCol.length();j++) {
				if (currCol.get(j).toString().length()>maxsize)
					maxsize = currCol.get(j).toString().length();
			}
			columnSizes[i] = maxsize;
		}
		
		StringBuilder builder = new StringBuilder();
		
		//TODO: actually build the string
		//to keep in mind: 
		//not all columns are of the same height
		//we add a column to the left to indicate line index..
		
		return "stfu";
	}
	
	
    /**
     * generates names in format A,B,C,[...],Y,Z,AA,AB,[...],ZZ,AAA...
     * @param id the id to be converted to a string name.
     * @return the string containing the name
     */
	private String generateName(int id) {
		return id < 0 ? "" : generateName((id / 26) - 1) + (char)(65 + id % 26);
	}

}