package com.example.team2.domain;

import com.sun.istack.NotNull;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.DiscriminatorOptions;
import org.springframework.format.annotation.DateTimeFormat;

@Data
@SuperBuilder
@NoArgsConstructor
@Entity
@Table(name = "SHOW")
@DiscriminatorColumn(name = "SHOW_TYPE", discriminatorType = DiscriminatorType.INTEGER)
@DiscriminatorOptions(force = true)
public class Show extends BaseModel {

  @NotNull
  @Column(length = 50, nullable = false)
  private String title;

  @NotNull
  @Column(length = 2000, nullable = false)
  private String summary;

  @Column(name = "RELEASE_DATE", nullable = false)
  @DateTimeFormat(pattern = "yyyy-MM-dd")
  private LocalDate releaseDate;

  @Column()
  private int rating;

  @Column(name = "ORIGIN_COUNTRY")
  private String originCountry;

  @OneToMany
  @JoinTable(name = "SHOW_GENRE", joinColumns = {
      @JoinColumn(name = "FK_SHOW_ID")}, inverseJoinColumns = {
      @JoinColumn(name = "FK_GENRE_ID")})
  @Cascade({CascadeType.MERGE, CascadeType.PERSIST})
  private Set<Genre> genre = new HashSet<>();

  @ManyToMany
  @JoinTable(name = "SHOW_CAST", joinColumns = {
      @JoinColumn(name = "FK_SHOW_CAST_ID")}, inverseJoinColumns = {
      @JoinColumn(name = "FK_CAST_PERSON_ID")})
  @Cascade({CascadeType.MERGE, CascadeType.PERSIST})
  private Set<Person> cast = new HashSet<>();

  @OneToMany
  @JoinTable(name = "SHOW_LANGUAGE", joinColumns = {
      @JoinColumn(name = "FK_SHOW_ID", referencedColumnName = "ID")}, inverseJoinColumns = {
      @JoinColumn(name = "LANG_ID", referencedColumnName = "ID")})
  private Set<Language> languages = new HashSet<>();

  @OneToMany(mappedBy = "show")
  private Set<Review> reviews = new HashSet<>();

/*
  @ManyToMany
  @JoinTable(name = "SHOW_PRODUCER", joinColumns = {
      @JoinColumn(name = "FK_SHOW_PRODUCER_ID")}, inverseJoinColumns = {
      @JoinColumn(name = "FK_PRODUCER_PERSON_ID")})
  @Cascade({org.hibernate.annotations.CascadeType.MERGE,
      org.hibernate.annotations.CascadeType.PERSIST})
  private Set<Person> producers = new HashSet<>();*/


}
