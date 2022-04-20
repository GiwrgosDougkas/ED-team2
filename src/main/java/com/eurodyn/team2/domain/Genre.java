package com.eurodyn.team2.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Data
@SuperBuilder
@NoArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "GENRE" , indexes = {@Index(name="name", columnList = "name")})
@SequenceGenerator(name = "idGenerator", sequenceName = "GENRE_SEQ",  initialValue = 1, allocationSize = 1)
public class Genre extends BaseModel {
	
	private String name;
	
}
