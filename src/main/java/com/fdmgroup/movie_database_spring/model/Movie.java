package com.fdmgroup.movie_database_spring.model;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

@Entity
public class Movie {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "movie_gen")
	@SequenceGenerator(name = "movie_gen", sequenceName = "MOVIE_SEQ", allocationSize = 1)
	private long movieId;

	@Column
	private String name;
	
	@ManyToOne
	@JoinColumn(name = "directorId")
	private Director director;
	
	@ManyToMany
	@JoinColumn(name = "actorId")
	private List<Actor> cast;
	
	@Column
	private int running_time;
	
	@Enumerated(EnumType.STRING)
	private Genre genre;
	
	@Column
	private LocalDate releaseDate;

	public Movie() {
		super();
	}

	public Movie(String name, Director director, List<Actor> cast, int running_time, Genre genre,
			LocalDate release_date) {
		super();
		this.name = name;
		this.director = director;
		this.cast = cast;
		this.running_time = running_time;
		this.genre = genre;
		this.releaseDate = release_date;
	}

	public long getMovieId() {
		return movieId;
	}

	public void setMovieId(long movieId) {
		this.movieId = movieId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Director getDirector() {
		return director;
	}

	public void setDirector(Director director) {
		this.director = director;
	}

	public List<Actor> getCast() {
		return cast;
	}

	public void setCast(List<Actor> cast) {
		this.cast = cast;
	}

	public int getRunningTime() {
		return running_time;
	}

	public void setRunningTime(int running_time) {
		this.running_time = running_time;
	}

	public Genre getGenre() {
		return genre;
	}

	public void setGenre(Genre genre) {
		this.genre = genre;
	}

	public LocalDate getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(LocalDate release_date) {
		this.releaseDate = release_date;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cast, director, genre, movieId, name, releaseDate, running_time);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Movie other = (Movie) obj;
		return Objects.equals(cast, other.cast) && Objects.equals(director, other.director) && genre == other.genre
				&& movieId == other.movieId && Objects.equals(name, other.name)
				&& Objects.equals(releaseDate, other.releaseDate) && running_time == other.running_time;
	}

	@Override
	public String toString() {
		return "Movie [movieId=" + movieId + ", name=" + name + ", director=" + director + ", cast=" + cast
				+ ", running_time=" + running_time + ", genre=" + genre + ", release_date=" + releaseDate + "]";
	}

}
