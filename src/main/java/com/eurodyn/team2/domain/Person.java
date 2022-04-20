package com.eurodyn.team2.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.NotNull;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.springframework.format.annotation.DateTimeFormat;
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "shows"})
@Data
@SuperBuilder
@NoArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "PERSON", indexes = {@Index(name="first_last_name",columnList = "FIRST_NAME,LAST_NAME"),@Index(name="first_name",columnList = "FIRST_NAME"),@Index(name="last_name", columnList="LAST_NAME")})
@SequenceGenerator(name = "idGenerator", sequenceName = "PERSON_SEQ",  initialValue = 1, allocationSize = 1)
public class Person extends BaseModel {
	
	@NotNull
	@Column(name = "FIRST_NAME", length = 20, nullable = false)
	private String firstname;
	
	@NotNull
	@Column(name = "LAST_NAME", length = 50, nullable = false)
	private String lastname;
	
	@Column(name = "DATE_OF_BIRTH", nullable = false)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate dateOfBirth;
	
	@Enumerated(EnumType.STRING)
	@Column(length = 10, nullable = false)
	private Gender gender;

	@Enumerated(EnumType.STRING)
	@Column(length = 10, nullable = false)
	private PersonRole role;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "SHOW_CAST", joinColumns = {
			@JoinColumn(name = "FK_CAST_PERSON_ID")}, inverseJoinColumns = {
			@JoinColumn(name = "FK_SHOW_CAST_ID")})
	@Cascade({CascadeType.MERGE})
	private Set<Show> shows = new HashSet<>();


}
