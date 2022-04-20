package com.eurodyn.team2.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.sun.istack.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

@Data
@SuperBuilder
@NoArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "EPISODE", indexes = {@Index(name="episode", columnList = "EPISODE_NUMBER")})
@SequenceGenerator(name = "idGenerator", sequenceName = "EPISODE_SEQ", initialValue = 1, allocationSize = 1)
public class Episode extends BaseModel {


	@Column(name = "EPISODE_NUMBER")
	private int episodeNumber;
	
	@Column(name = "EPISODE_TITLE")
	private String episodeTitle;

	@NotNull
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JsonBackReference("episodes")
	private Season season;



}
