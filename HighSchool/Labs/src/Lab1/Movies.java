package Lab1;

import java.util.Date;

public class Movies {
	
	private int movieID;
	private String movieName;
	private Date releaseDate;
	private float movieRating;
	
	
	public Movies(int id, String name, Date date, float rating) {
		movieID = id;
		movieName = name;
		releaseDate = date;
		movieRating = rating;
	}
	
	
	public void print() {
		System.out.printf("MovieID: %d, Movie: %s, release: %tF, rating: %.2f",movieID, movieName, releaseDate,movieRating);
	}
	
	
	public int getMovieID() {
		return movieID;
	}

	public void setMovieID(int movieID) {
		this.movieID = movieID;
	}

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public Date getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}

	public double getMovieRating() {
		return movieRating;
	}

	public void setMovieRating(float movieRating) {
		this.movieRating = movieRating;
	}

	
	
	
}
