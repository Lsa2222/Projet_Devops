package BreackfastClub.ProjetDevopsPanda;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] a = {"one", "seven", "twelve"};
		Integer[] b = {1, 7, 12};
		Object[][] c = {a, b};
		int d = 4;
		
		/*Dataframe da = new Dataframe(a);
		System.out.println(da.toString());*/
		
		// CSV
		
		Dataframe db = new Dataframe("D:\\Documents\\M1\\SEMESTRE2\\devops\\projet\\testcsv.csv");
		System.out.println(db.toString());
		
		/*Dataframe dc = new Dataframe(c);
		System.out.println(dc.toString());*/
		
		
	}

}
