package com.example.team2.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import javax.persistence.Entity;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Data
@SuperBuilder
@NoArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "GENRE")
@SequenceGenerator(name = "idGenerator", sequenceName = "GENRE_SEQ", allocationSize = 1)
public class Genre extends BaseModel {
	
	private String name;
	
}
