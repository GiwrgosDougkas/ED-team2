package com.eurodyn.team2.domain;

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
@Table(name = "LANGUAGE", indexes = {@Index(name="language_full", columnList = "LANG_FULL"),@Index(name="language_code", columnList = "LANGE_CODE")})
@SequenceGenerator(name = "idGenerator", sequenceName = "LANGUAGE_SEQ", initialValue = 1, allocationSize = 1)
public class Language extends BaseModel {
	@NotNull
	@Column(name = "LANGE_CODE", length = 2, nullable = false)
	private String langCode;
	
	@NotNull
	@Column(name = "LANG_FULL", length = 50, nullable = false)
	private String langFull;
	
}
