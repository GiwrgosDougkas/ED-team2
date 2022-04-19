package com.example.team2.domain;

import com.sun.istack.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.DiscriminatorOptions;

import javax.persistence.*;
import java.util.Date;

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
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "RELEASE_DATE", nullable = false)
	private Date releaseDate;
	
	@Column(nullable = true)
	private int rating;
	
	@Column(name = "ORIGIN_COUNTRY")
	private String originCountry;
}
