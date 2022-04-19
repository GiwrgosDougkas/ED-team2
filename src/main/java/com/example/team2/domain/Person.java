package com.example.team2.domain;

import com.sun.istack.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.util.Date;

@Data
@SuperBuilder
@NoArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "PERSON")
@SequenceGenerator(name = "idGenerator", sequenceName = "PERSON_SEQ", initialValue = 1, allocationSize = 1)
public class Person extends BaseModel {
	
	@NotNull
	@Column(name = "FIRST_NAME", length = 20, nullable = false)
	private String firstname;
	
	@NotNull
	@Column(name = "LAST_NAME", length = 50, nullable = false)
	private String lastname;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "DATE_OF_BIRTH", nullable = false)
	private Date dateOfBirth;
	
	@Enumerated(EnumType.STRING)
	@Column(length = 10, nullable = false)
	private Genre genre;

	@Enumerated(EnumType.STRING)
	@Column(length = 10, nullable = false)
	private PersonRole role;
}
