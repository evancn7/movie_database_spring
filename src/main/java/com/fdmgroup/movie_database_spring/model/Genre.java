package com.fdmgroup.movie_database_spring.model;

public enum Genre {
	COMEDY("Comedy"), ACTION("Action");

	private String genre;

	Genre(String genre) {
		this.genre = genre;
	}
	
	public static String getGenre(int index) {
		return Genre.values()[index].toString();
	}

	public String getGenre() {
		return genre;
	}

}
