package com.example.team2.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Entity
@Data
@SuperBuilder
@NoArgsConstructor
@DiscriminatorValue("2")
public class Series extends Show {



}
