package BreackfastClub.ProjetDevopsPanda;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
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
		
		for(int i=0;i<content.length;i++) {
			String name = generateName(columnId.getAndIncrement());
			columns[i] = new Colonne(name, content[i]);
		}
	}
	
	public Dataframe(String[] tab_names) {
		columns = new Colonne[tab_names.length];
		
		for (int i = 0;i<tab_names.length;i++) {
			columns[i] = new Colonne(tab_names[i],null);
		}
	}
	
	public Dataframe(int nbcols) {
		
		//TODO: check for empty content and/or empty columns
		
		columns = new Colonne[nbcols];
		
		for(int i=0;i<nbcols;i++) {
			String name = generateName(columnId.getAndIncrement());
			columns[i] = new Colonne(name, null);
		}
	}
	
	public Dataframe(String file_name) {
	    try
	    {
	      File file = new File(file_name);    
	      // Creating the object filereader
	      FileReader fr = new FileReader(file);  
	      // Creating the object buffereader       
	      BufferedReader br = new BufferedReader(fr);   
	      String[] HeadLine = br.readLine().split(";");
	      Dataframe data = new Dataframe(HeadLine);
	      String line;
	      while((line = br.readLine()) != null)
	      {
	    	  data.addLine(line.split(";"));
	      }
	      fr.close(); 
	      
	      columns = data.columns;
	    }
	    catch(IOException e)
	    {
	      e.printStackTrace();
	    }
	}
	
	
	public void addLine(Object[] line) {
		Integer index;
		if (columns[0].isNull())
			index = 0;
		else 
			index = columns[0].length();
		
		for (int i = 0;i<columns.length;i++) {
			Object content[] = new Object[index+1];
			for (int j = 0;j<index;j++) {
				content[j] = columns[i].get(j);
			}
			content[index] = line[i];
			columns[i] = new Colonne(columns[i].getLabel(), content);
		}
	}
	
	public void setCol(Object indice, Object[] col) {
		int position = -1;
		String label = "";
		if ((indice.getClass().getSimpleName()).equals("String")) {
			for(int i = 0;i<columns.length;i++) {
				if (columns[i].getLabel() == indice) {
					position = i;
				}
			}
			label = indice.toString();
		}
		else if ((indice.getClass().getSimpleName()).equals("Integer")){
			position = (Integer)indice;
			label = columns[position].getLabel();
		}
		else {
			return;
		}
		Colonne colonne = new Colonne(label,col);
		columns[position] = colonne;
	}
	
	public Dataframe getColonne(Object indice) {
		int position = -1;
		String[] label = new String[columns.length];
		if ((indice.getClass().getSimpleName()).equals("String")) {
			for(int i = 0;i<columns.length;i++) {
				if (columns[i].getLabel() == indice) {
					position = i;
				}
			}
			label[0] = indice.toString();
		}
		else if ((indice.getClass().getSimpleName()).equals("Integer")){
			position = (Integer)indice;
			label[0] = columns[position].getLabel();
		}
		else {
			return null;
		}
		Dataframe dat = new Dataframe(label);
		dat.setCol(0, columns[position].getContent());
		return dat;
	}
	
	public Dataframe getLigne(int indice){
		String[] labels = new String[columns.length];
		for(int i =0;i<columns.length;i++) {
			labels[i] = columns[i].getLabel();
		}
		Dataframe data = new Dataframe(labels);
		for (int i =0;i<columns.length;i++) {
			Object[] val = {columns[i].get(indice)};
			data.setCol(i,val);
		}
		return data;
	}
	
	
	@Override
	public String toString() {
		//TODO check for empty things, maybe?
		String[][] rawdata;
		rawdata = new String[columns.length+1][];

		for(int i = 0;i<rawdata.length-1;i++) {

			Colonne currCol = columns[i];
			String[] currColData = new String[currCol.length()+1];

			currColData[0] = currCol.getLabel();

			for(int j=0;j<currCol.length();j++) {
				currColData[j+1] = currCol.get(j).toString();
			}
			rawdata[i+1] = currColData;
		}
		int size = 0;
		for(int i = 1;i<rawdata.length;i++) {
			if (rawdata[i].length>size)
				size = rawdata[i].length;
		}
		String[] c = new String[size];
		for(int i = 0;i<size;i++) {
			c[i] = Integer.toString(i);
		}
		rawdata[0]=c;
		//we delegate the creation of the table to a specialized class to limit the code here (bad?)
		
		return TableCreator.createTable(rawdata);
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