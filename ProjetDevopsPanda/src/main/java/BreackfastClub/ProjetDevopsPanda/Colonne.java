package BreackfastClub.ProjetDevopsPanda;

public class Colonne <T>{
	
	private String label;
	private T[] tab;
	
	public Colonne(String s, T[]tableau) {
		label = s;
		tab = tableau;
	}

}
