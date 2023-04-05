package BreackfastClub.ProjetDevopsPanda;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Dataframe {
	
	private Colonne[] dataframe;
	
	public Dataframe() {
		String[] values = {"exemple1","exemple2"};
		Colonne<String> c = new Colonne<String>("colonne1",values);
	}

}