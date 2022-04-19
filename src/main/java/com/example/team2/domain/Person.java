package com.example.team2.domain;

import com.sun.istack.NotNull;

import java.time.LocalDate;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.springframework.format.annotation.DateTimeFormat;

@Data
@SuperBuilder
@NoArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "PERSON")
@SequenceGenerator(name = "idGenerator", sequenceName = "PERSON_SEQ", allocationSize = 1)
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

	@ManyToMany
	@JoinTable(name = "SHOW_CAST", joinColumns = {
			@JoinColumn(name = "FK_CAST_PERSON_ID")}, inverseJoinColumns = {
			@JoinColumn(name = "FK_SHOW_CAST_ID")})
	@Cascade({CascadeType.MERGE, CascadeType.PERSIST})
	private Set<Show> shows = new HashSet<>();


}
