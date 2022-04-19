package com.example.team2.domain;

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
@Table(name = "EPISODE")
@SequenceGenerator(name = "idGenerator", sequenceName = "EPISODE_SEQ", initialValue = 1, allocationSize = 1)
public class Episode extends BaseModel {


	@Column(name = "EPISODE_NUMBER")
	private int episodeNumber;

	@NotNull
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	private Season season;



}
