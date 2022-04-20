package com.eurodyn.team2.bootstrap;

import com.eurodyn.team2.base.BaseComponent;
import com.eurodyn.team2.domain.*;
import com.eurodyn.team2.service.*;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;


@Component
@Profile("generate-basic-content")
@RequiredArgsConstructor
public class BasicSampleContentCreator extends BaseComponent implements CommandLineRunner {
	
	private final PersonService personService;
	private final ShowService showService;
	private final LanguageService languageService;
	private final GenreService genreService;
	private final SeasonService seasonService;
	private final EpisodeService episodeService;
	
	@Override
	public void run(String... args) throws Exception {
		// Create Geres
		List<Genre> genreList = List.of(Genre.builder().name("Action").build(),
				Genre.builder().name("Drama").build(),
				Genre.builder().name("Comedy").build(),
				Genre.builder().name("Sci-fi").build(),
				Genre.builder().name("Adventure").build(),
				Genre.builder().name("Documentary").build());
		genreService.createAll(genreList);
		
		
		// Create Laguages
		List<Language> languageList = List.of(Language.builder().langCode("EN").langFull("English").build(),
				Language.builder().langCode("DE").langFull("German").build());
		languageService.createAll(languageList);
		
		
		//add person
		personService.create(Person.builder().firstname("Angelina").lastname("Jolie").dateOfBirth(LocalDate.of(1982, 10, 10)).gender(Gender.FEMALE).role(PersonRole.ACTOR).build());
		personService.create(Person.builder().firstname("Brand").lastname("Pitt").dateOfBirth(LocalDate.of(1987, 2, 19)).gender(Gender.MALE).role(PersonRole.ACTOR).build());
		personService.create(Person.builder().firstname("George").lastname("Clooney").dateOfBirth(LocalDate.of(1957, 3, 5)).gender(Gender.MALE).role(PersonRole.ACTOR).build());
		personService.create(Person.builder().firstname("Tom").lastname("Cruise").dateOfBirth(LocalDate.of(1962, 8, 8)).gender(Gender.MALE).role(PersonRole.ACTOR).build());
		personService.create(Person.builder().firstname("Will").lastname("Smith").dateOfBirth(LocalDate.of(1968, 1, 9)).gender(Gender.MALE).role(PersonRole.ACTOR).build());
		personService.create(Person.builder().firstname("Kevin").lastname("Feige").dateOfBirth(LocalDate.of(1970, 11, 21)).gender(Gender.MALE).role(PersonRole.PRODUCER).build());
		personService.create(Person.builder().firstname("Natali").lastname("Portman").dateOfBirth(LocalDate.of(1970, 3, 6)).gender(Gender.MALE).role(PersonRole.PRODUCER).build());
		personService.create(Person.builder().firstname("kathleen").lastname("kennedy").dateOfBirth(LocalDate.of(1953, 6, 25)).gender(Gender.FEMALE).role(PersonRole.PRODUCER).build());
		personService.create(Person.builder().firstname("David").lastname("Heyman").dateOfBirth(LocalDate.of(1973, 9, 16)).gender(Gender.MALE).role(PersonRole.PRODUCER).build());
		personService.create(Person.builder().firstname("Charles").lastname("Roven").dateOfBirth(LocalDate.of(1958, 5, 3)).gender(Gender.MALE).role(PersonRole.PRODUCER).build());
		personService.create(Person.builder().firstname("Peter").lastname("Brown").dateOfBirth(LocalDate.of(1958, 5, 18)).gender(Gender.MALE).role(PersonRole.STAFF).build());
		personService.create(Person.builder().firstname("Michael").lastname("Ronne").dateOfBirth(LocalDate.of(1988, 8, 28)).gender(Gender.MALE).role(PersonRole.STAFF).build());
		
		
		//add movie
		List<Movie> movieList = List.of(Movie.builder().originCountry("USA").rating(3).releaseDate(LocalDate.of(2021, 1, 1)).title("Spy").summary("comedy").languages(Set.of(languageList.get(0), languageList.get(1))).build(),
				Movie.builder().originCountry("USA").rating(5).releaseDate(LocalDate.of(2009, 12, 1)).title("The Hangover I").summary("comedy").build(),
				Movie.builder().originCountry("USA").rating(5).releaseDate(LocalDate.of(2011, 11, 15)).title("The Hangover II").summary("comedy").build(),
				Movie.builder().originCountry("USA").rating(4).releaseDate(LocalDate.of(2013, 7, 12)).title("The Hangover III").summary("comedy").build(),
				Movie.builder().originCountry("USA").rating(4).releaseDate(LocalDate.of(2001, 3, 19)).title("The Lord of the rings I").summary("adventure").build(),
				Movie.builder().originCountry("USA").rating(5).releaseDate(LocalDate.of(2002, 9, 1)).title("The Lord of the rings II").summary("adventure").build(),
				Movie.builder().originCountry("USA").rating(3).releaseDate(LocalDate.of(2003, 1, 8)).title("The Lord of the rings III").summary("adventure").build(),
				Movie.builder().originCountry("USA").rating(5).releaseDate(LocalDate.of(2001, 11, 7)).title("Fast 2 and Furious").summary("action").build(),
				Movie.builder().originCountry("USA").rating(5).releaseDate(LocalDate.of(2003, 1, 1)).title("2 Fast 2 Furious").summary("action").build(),
				Movie.builder().originCountry("USA").rating(3).releaseDate(LocalDate.of(2003, 11, 11)).title("Fast and Furious Tokyo Drift").summary("action").build(),
				Movie.builder().originCountry("USA").rating(4).releaseDate(LocalDate.of(2009, 2, 11)).title("Fast and Furious 4").summary("action").build());
		
		
		for (Movie movie : movieList) {
			movie.setReviews(generateRandomReviewSet(movie));
			showService.create(movie);
		}
		
		//add series
		showService.create(Series.builder().originCountry("GREECE").rating(4).releaseDate(LocalDate.of(2000, 3, 11)).title("10 lepta kurhgma").summary("comedy").cast(Set.of(personService.findByFirstAndLastName("Angelina","Jolie"), personService.findByFirstAndLastName("kathleen","kennedy"))).genre(Set.of(genreService.findByName("Documentary"), genreService.findByName("Drama"))).languages(Set.of(languageList.get(0), languageList.get(1))).build());
		showService.create(Series.builder().originCountry("GREECE").rating(5).releaseDate(LocalDate.of(2001, 4, 10)).title("Eisai to tairi mou").summary("romance").cast(Set.of(personService.findByFirstAndLastName("kathleen","kennedy"), personService.findByFirstAndLastName("Peter","Brown"))).genre(Set.of(genreService.findByName("Adventure"))).languages(Set.of(languageList.get(0))).build());
		showService.create(Series.builder().originCountry("GREECE").rating(5).releaseDate(LocalDate.of(1998, 7, 1)).title("Konstantinou & Elenhs").summary("comedy").cast(Set.of(personService.findByFirstAndLastName("David","Heyman"), personService.findByFirstAndLastName("Tom","Cruise"))).genre(Set.of(genreService.findByName("Comedy"), genreService.findByName("Adventure"))).languages(Set.of(languageList.get(0), languageList.get(1))).build());
		showService.create(Series.builder().originCountry("GREECE").rating(3).releaseDate(LocalDate.of(2000, 1, 1)).title("Duo ksenoi").summary("comedy").cast(Set.of(personService.findByFirstAndLastName("Natali","Portman"), personService.findByFirstAndLastName("George","Clooney"))).genre(Set.of(genreService.findByName("Comedy"))).languages(Set.of(languageList.get(0), languageList.get(1))).build());
		showService.create(Series.builder().originCountry("GREECE").rating(5).releaseDate(LocalDate.of(1998, 1, 1)).title("Egglhmata").summary("comedy").cast(Set.of(personService.findByFirstAndLastName("Natali","Portman"), personService.findByFirstAndLastName("Kevin","Feige"))).genre(Set.of(genreService.findByName("Adventure"))).languages(Set.of(languageList.get(1))).build());
		showService.create(Series.builder().originCountry("GREECE").rating(2).releaseDate(LocalDate.of(1998, 1, 1)).title("Sto para pente").summary("comedy").cast(Set.of(personService.findByFirstAndLastName("George","Clooney"), personService.findByFirstAndLastName("Tom","Cruise"))).genre(Set.of(genreService.findByName("Comedy"))).languages(Set.of(languageList.get(0), languageList.get(1))).build());
		showService.create(Series.builder().originCountry("GREECE").rating(2).releaseDate(LocalDate.of(2005, 1, 1)).title("Singles").summary("comedy").cast(Set.of(personService.findByFirstAndLastName("Angelina","Jolie"), personService.findByFirstAndLastName("Brand","Pitt"))).genre(Set.of(genreService.findByName("Action"), genreService.findByName("Drama"))).languages(Set.of(languageList.get(0), languageList.get(1))).build());
		
		//season
		seasonService.create(Season.builder().series((Series) showService.findSeriesByTitle("Singles").get(0)).seasonNumber(1).build());
		seasonService.create(Season.builder().series((Series) showService.findSeriesByTitle("Singles").get(0)).seasonNumber(2).build());
		seasonService.create(Season.builder().series((Series) showService.findSeriesByTitle("Egglhmata").get(0)).seasonNumber(1).build());
		
		episodeService.create(Episode.builder().episodeNumber(1).episodeTitle("Tete").season(seasonService.findBySeasonNumberAndSeriesTitle(1, "Singles")).build());
		episodeService.create(Episode.builder().episodeNumber(2).episodeTitle("Tata").season(seasonService.findBySeasonNumberAndSeriesTitle(1, "Singles")).build());
		episodeService.create(Episode.builder().episodeNumber(1).episodeTitle("bobob").season(seasonService.findBySeasonNumberAndSeriesTitle(2, "Singles")).build());
		episodeService.create(Episode.builder().episodeNumber(2).episodeTitle("fafafafa").season(seasonService.findBySeasonNumberAndSeriesTitle(2, "Singles")).build());
		episodeService.create(Episode.builder().episodeNumber(1).episodeTitle("toto").season(seasonService.findBySeasonNumberAndSeriesTitle(1, "Egglhmata")).build());
		episodeService.create(Episode.builder().episodeNumber(2).episodeTitle("tete").season(seasonService.findBySeasonNumberAndSeriesTitle(1, "Egglhmata")).build());
		
	
	}
	
	private Set<Review> generateRandomReviewSet(Show show) {
		Set<Review> reviewSet = new HashSet<>();
		Random rand = new Random();
		int randomNum = rand.nextInt((5 - 1) + 1) + 1;
		// length is bounded by 7
		for (int i = 0; i < randomNum; i++) {
			String generatedRandomString = Long.toHexString(Double.doubleToLongBits(Math.random()));
			reviewSet.add(Review.builder().submitDate(LocalDate.of(2001, 4, 10)).reviewText(generatedRandomString).show(show).build());
		}
		return reviewSet;
	}
}
