package Lab1;

import java.util.Date;

public class MoviesStart {
	
	public static void main(String[] args) {
		String moviename = "scoobydoo";
		
		Date release = new Date(5,5,2015);
		Movies movie = new Movies(555556, moviename, release, 10/10);
		movie.print();
	}

}
