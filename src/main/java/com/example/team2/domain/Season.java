package com.example.team2.domain;

import com.fasterxml.jackson.annotation.JsonFilter;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import javax.persistence.Entity;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Data
@SuperBuilder
@NoArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "SESSION")
@SequenceGenerator(name = "idGenerator", sequenceName = "SESSION_SEQ", initialValue = 1, allocationSize = 1)
@JsonFilter("customerFilter")
public class Season extends BaseModel {


}
