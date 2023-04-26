package BreackfastClub.ProjetDevopsPanda;

public class Colonne <T>{
	
	private String label;
	private T[] content;
	
	public Colonne(String s, T[]tableau) {
		label = s;
		content = tableau;
	}
	
	//TODO: check for out of bounds
	public T get(int index) {
		return content[index];
	}
	
	public int length() {
		return content.length;
	}
	
	public String getLabel() {
		return label;
	}
	
	public void setLabel(String value) {
		this.label = value;
	}
	
	public void setValue(int pos,T value) {
		this.content[pos] = value;
	}
	
	public Boolean isNull(){
		return content == null;
	}
	
	public T[] getContent() {
		return content;
	}
}
