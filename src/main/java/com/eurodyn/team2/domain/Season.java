package com.eurodyn.team2.domain;

import com.sun.istack.NotNull;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;


@Data
@SuperBuilder
@NoArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "SEASON")
@SequenceGenerator(name = "idGenerator", sequenceName = "SEASON_SEQ",  initialValue = 1, allocationSize = 1)
public class Season extends BaseModel {
    
    
    @Column(name = "SEASON_NUMBER")
    private int seasonNumber;
    
    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private Series series;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @OneToMany(mappedBy = "season", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private final Set<Episode> episodes = new HashSet<>();

}
