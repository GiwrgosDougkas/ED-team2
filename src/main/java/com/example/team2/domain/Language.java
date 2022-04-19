package com.example.team2.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@SuperBuilder
@NoArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "LANGUAGE")
@SequenceGenerator(name = "idGenerator", sequenceName = "LANGUAGE_SEQ", initialValue = 1, allocationSize = 1)
public class Language extends BaseModel {
    @NotNull
    @Column(name = "LANGE_CODE", length = 2, nullable = false)
    private String langCode;

    @NotNull
    @Column(name = "LANG_FULL", length = 50, nullable = false)
    private String langFull;

}
