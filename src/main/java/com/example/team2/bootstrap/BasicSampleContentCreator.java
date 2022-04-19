package com.example.team2.bootstrap;

import com.example.team2.base.BaseComponent;
import com.example.team2.domain.*;
import com.example.team2.service.LanguageService;
import com.example.team2.service.MovieService;
import com.example.team2.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.time.LocalDate;


@Component
@Profile("generate-basic-content")
@RequiredArgsConstructor
public class BasicSampleContentCreator extends BaseComponent implements CommandLineRunner {

    private final PersonService personService;
    private final MovieService movieService;
    private final LanguageService languageService;
    @Override
    public void run(String... args) throws Exception {
        //add language
        languageService.create(Language.builder().langCode("GR").langFull("GREECE").build());
        languageService.create(Language.builder().langCode("EN").langFull("ENGLISH").build());

        //add person
        personService.create(Person.builder().firstname("Angelina").lastname("Jolie").dateOfBirth(LocalDate.of(1982,10,10)).gender(Gender.FEMALE).role(PersonRole.ACTOR).build());
        personService.create(Person.builder().firstname("Brand").lastname("Pitt").dateOfBirth(LocalDate.of(1987,2,19)).gender(Gender.MALE).role(PersonRole.ACTOR).build());
        personService.create(Person.builder().firstname("George").lastname("Clooney").dateOfBirth(LocalDate.of(1957,3,5)).gender(Gender.MALE).role(PersonRole.ACTOR).build());
        personService.create(Person.builder().firstname("Tom").lastname("Cruise").dateOfBirth(LocalDate.of(1962,8,8)).gender(Gender.MALE).role(PersonRole.ACTOR).build());
        personService.create(Person.builder().firstname("Will").lastname("Smith").dateOfBirth(LocalDate.of(1968,1,9)).gender(Gender.MALE).role(PersonRole.ACTOR).build());
        personService.create(Person.builder().firstname("Kevin").lastname("Feige").dateOfBirth(LocalDate.of(1970,11,21)).gender(Gender.MALE).role(PersonRole.PRODUCER).build());
        personService.create(Person.builder().firstname("Kevin").lastname("Feige").dateOfBirth(LocalDate.of(1970,3,6)).gender(Gender.MALE).role(PersonRole.PRODUCER).build());
        personService.create(Person.builder().firstname("kathleen").lastname("kennedy").dateOfBirth(LocalDate.of(1953,6,25)).gender(Gender.FEMALE).role(PersonRole.PRODUCER).build());
        personService.create(Person.builder().firstname("David").lastname("Heyman").dateOfBirth(LocalDate.of(1973,9,16)).gender(Gender.MALE).role(PersonRole.PRODUCER).build());
        personService.create(Person.builder().firstname("Charles").lastname("Roven").dateOfBirth(LocalDate.of(1958,5,3)).gender(Gender.MALE).role(PersonRole.PRODUCER).build());
        personService.create(Person.builder().firstname("Peter").lastname("Brown").dateOfBirth(LocalDate.of(1958,5,18)).gender(Gender.MALE).role(PersonRole.STAFF).build());
        personService.create(Person.builder().firstname("Michael").lastname("Ronne").dateOfBirth(LocalDate.of(1988,8,28)).gender(Gender.MALE).role(PersonRole.STAFF).build());

        //add movie
        movieService.create(Movie.builder().originCountry("USA").rating(3).releaseDate(LocalDate.of(2021,1,1)).title("Spy").summary("comedy").build());
        movieService.create(Movie.builder().originCountry("USA").rating(5).releaseDate(LocalDate.of(2009,12,1)).title("The Hangover I").summary("comedy").build());
        movieService.create(Movie.builder().originCountry("USA").rating(5).releaseDate(LocalDate.of(2011,11,15)).title("The Hangover II").summary("comedy").build());
        movieService.create(Movie.builder().originCountry("USA").rating(4).releaseDate(LocalDate.of(2013,7,12)).title("The Hangover III").summary("comedy").build());
        movieService.create(Movie.builder().originCountry("USA").rating(4).releaseDate(LocalDate.of(2001,3,19)).title("The Lord of the rings I").summary("adventure").build());
        movieService.create(Movie.builder().originCountry("USA").rating(5).releaseDate(LocalDate.of(2002,9,1)).title("The Lord of the rings II").summary("adventure").build());
        movieService.create(Movie.builder().originCountry("USA").rating(3).releaseDate(LocalDate.of(2003,1,8)).title("The Lord of the rings III").summary("adventure").build());
        movieService.create(Movie.builder().originCountry("USA").rating(5).releaseDate(LocalDate.of(2001,11,7)).title("Fast 2 and Furious").summary("action").build());
        movieService.create(Movie.builder().originCountry("USA").rating(5).releaseDate(LocalDate.of(2003,1,1)).title("2 Fast 2 Furious").summary("action").build());
        movieService.create(Movie.builder().originCountry("USA").rating(3).releaseDate(LocalDate.of(2003,11,11)).title("Fast and Furious Tokyo Drift").summary("action").build());
        movieService.create(Movie.builder().originCountry("USA").rating(4).releaseDate(LocalDate.of(2009,2,11)).title("Fast and Furious 4").summary("action").build());

        //add series
        movieService.create(Series.builder().originCountry("GREECE").rating(4).releaseDate(LocalDate.of(2000,3,11)).title("10 lepta kurhgma").summary("comedy").build());
        movieService.create(Series.builder().originCountry("GREECE").rating(5).releaseDate(LocalDate.of(2001,4 ,10)).title("Eisai to tairi mou").summary("romance").build());
        movieService.create(Series.builder().originCountry("GREECE").rating(5).releaseDate(LocalDate.of(1998,7,1)).title("Konstantinou & Elenhs").summary("comedy").build());
        movieService.create(Series.builder().originCountry("GREECE").rating(3).releaseDate(LocalDate.of(2000,1,1)).title("Duo ksenoi").summary("comedy").build());
        movieService.create(Series.builder().originCountry("GREECE").rating(5).releaseDate(LocalDate.of(1998,1,1)).title("Egglhmata").summary("comedy").build());
        movieService.create(Series.builder().originCountry("GREECE").rating(2).releaseDate(LocalDate.of(1998,1,1)).title("Sto para pente").summary("comedy").build());
        movieService.create(Series.builder().originCountry("GREECE").rating(2).releaseDate(LocalDate.of(2005,1,1)).title("Singles").summary("comedy").build());


        //TODO resolve error
       //movieService.create(Season.builder().series((Series)movieService.findByTitle("Singles").get(0)).build());
    }
}
