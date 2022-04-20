package com.eurodyn.team2.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;


@Data
@SuperBuilder
@NoArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "REVIEW")
@SequenceGenerator(name = "idGenerator", sequenceName = "REVIEW_SEQ", allocationSize = 1)
public class Review extends BaseModel {
	
	
	@Column(name = "SUBMIT_DATE", nullable = false)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate submitDate;

	@ManyToOne
	private Show show;
}