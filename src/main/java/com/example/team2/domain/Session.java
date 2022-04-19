package com.example.team2.domain;

import com.fasterxml.jackson.annotation.JsonFilter;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;



@Data
@SuperBuilder
@NoArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "SESSION")
@SequenceGenerator(name = "idGenerator", sequenceName = "SESSION_SEQ", initialValue = 1, allocationSize = 1)
@JsonFilter("customerFilter")
public class Session extends BaseModel {




}
