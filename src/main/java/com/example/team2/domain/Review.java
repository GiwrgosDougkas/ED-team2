package com.example.team2.domain;

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
@Table(name = "REVIEW")
@SequenceGenerator(name = "idGenerator", sequenceName = "REVIEW_SEQ", initialValue = 1, allocationSize = 1)
public class Review extends BaseModel {
	
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "SUBMIT_DATE", nullable = false)
	private Date submitDate;
	
	
}
