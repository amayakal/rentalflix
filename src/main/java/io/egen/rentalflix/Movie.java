package io.egen.rentalflix;

/**
 * Entity representing a movie.
 * Fields: id, title, year, language
 */
public class Movie {
	//POJO IMPLEMENTATION GOES HERE
	private int id;
	private String title;
	private int year;
	private String language;
	
	public Movie(int id, String title, int year, String language) {
		this.id = id;
		this.title = title;
		this.year = year;
		this.language = language;
	}
	
	public int getId(){ return id;}
	public void setId(int id){ this.id = id; }
	
	public String getTitle(){ return title;}
	public void setTitle(String title){ this.title = title; }
	
	public int getYear(){ return year;}
	public void setYear(int year){ this.year = year; }
	
	public String getLanguage(){ return language;}
	public void setLanguage(String language){ this.language = language; }
	
	@Override
	public boolean equals(Object m){
	
		if(this.title.equalsIgnoreCase(((Movie) m).title)
				&& this.year == ((Movie) m).year 
				&& this.language.equalsIgnoreCase(((Movie) m).language))
			return true;
		
		return false;
	}

}
