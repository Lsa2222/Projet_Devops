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
	
	
	public Colonne[] getColumns() {
		return columns;
	}

	public void setColumns(Colonne[] columns) {
		this.columns = columns;
	}
	
	public String getSize() {
	    int nb_rows = 0;
	    int nb_cols = columns.length;
	    if(columns.length > 0) {
	    	if (columns[0].isNull()) {
	    		nb_rows = 0;
	    	}
	    	else {
	    		nb_rows = columns[0].length();
	    	}
	    }
	    String taille = "lines : " + Integer.toString(nb_rows) + " cols : " + Integer.toString(nb_cols);
	    return taille;
	}

	@Override
	public String toString() {
		//TODO check for empty things, maybe?
		String[][] rawdata;
		rawdata = new String[columns.length+1][];

		for(int i = 0;i<rawdata.length-1;i++) {
			Colonne currCol = columns[i];
			String[] currColData;
			if (!(columns[i].isNull())) {
				currColData = new String[currCol.length()+1];

				currColData[0] = currCol.getLabel();
				for(int j=0;j<currCol.length();j++) {
					currColData[j+1] = currCol.get(j).toString();
				}
			}
			else {
				currColData = new String[1];
				currColData[0] = currCol.getLabel();
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
	
	public String partToString(int start, int end) {
	    if (start < 0 || end >= columns[0].length() || start > end) {
	        throw new IllegalArgumentException("Invalid indices");
	    }
	    StringBuilder sb = new StringBuilder();
	    for (int i = start; i <= end; i++) {
	        for (int j = 0; j < columns.length; j++) {
	            sb.append(columns[j].get(i)).append("\t");
	        }
	        sb.append("\n");
	    }
	    return sb.toString();
	}
	
	//ou en utilisant la méthode toString existante
	/*public String partToString(int debut, int fin) {
    String fullString = this.toString();
    String[] lines = fullString.split("\n");
    StringBuilder sb = new StringBuilder();
    for (int i = debut; i < fin && i < lines.length; i++) {
        sb.append(lines[i]).append("\n");
    }
    return sb.toString();
	}*/
	
	public String startToString(int nb) {
		return partToString(0,nb-1);
	}
	
	public String endToString(int nb) {
		return partToString(columns[0].length() - nb,columns[0].length()-1);
	}
	
	public Object getCell(int row, int col) {
		if (row < 0 || row >= columns[0].length() || col < 0 || col >= columns.length) {
	        throw new IndexOutOfBoundsException("Invalid row or column index");
	    }
	    return columns[col].get(row);
	}
	
	public void setCell(int row, int col, Object value) {
		if (row < 0 || row >= columns[0].length() || col < 0 || col >= columns.length) {
	        throw new IndexOutOfBoundsException("Invalid row or column index");
	    }
		columns[col].setValue(row, value);
	}
	
	public void setLabel(int col, String value) {
		if (col < 0 || col >= columns.length) {
	        throw new IndexOutOfBoundsException("Invalid row or column index");
	    }
			columns[col].setLabel(value);
	}
	
	public Dataframe getPartDataframe(int startrow, int endrow,int startcol, int endcol) {
		if (startrow < 0 || startrow > endrow || endrow >= columns[0].length() || startcol < 0 || startcol > endcol || endcol >= columns.length) {
	        throw new IllegalArgumentException("Indices invalides");
	    }
		int decal = endcol - startcol + 1;
		String[] labels = new String[decal];
		for(int i =startcol;i<endcol+1;i++) {
			labels[i-startcol] = columns[i].getLabel();
		}
		Colonne[] newcolumns = new Colonne[decal];
	    for (int i = startcol; i < endcol+1; i++) {
	        Object[] newData = new Object[decal];
	        for(int j = startrow; j < endrow+1;j++) {
	        	newData[j - startrow] = columns[i].getContent()[j];
	        }
	        newcolumns[i - startcol] = new Colonne(columns[i].getLabel(), newData);
	    }
	    Dataframe data = new Dataframe(labels);
	    data.setColumns(newcolumns);
	    return data;
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