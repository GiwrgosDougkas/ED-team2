package com.example.team2.domain;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.sun.istack.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Data
@SuperBuilder
@NoArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "SEASON")
@SequenceGenerator(name = "idGenerator", sequenceName = "SEASON_SEQ", initialValue = 1, allocationSize = 1)
public class Season extends BaseModel {

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private Series series;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @OneToMany(mappedBy = "session", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private final Set<Episode> episodes = new HashSet<>();

}
