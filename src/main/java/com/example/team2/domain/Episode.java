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
@Table(name = "EPISODE")
@SequenceGenerator(name = "idGenerator", sequenceName = "EPISODE_SEQ", initialValue = 1, allocationSize = 1)
public class Episode extends BaseModel {

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private Session session;

    @Column(name="EPISODE_NUMBER")
    private int episodeNumber;
}
