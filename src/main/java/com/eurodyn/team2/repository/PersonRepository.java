package com.eurodyn.team2.repository;

import com.eurodyn.team2.domain.Person;
import com.eurodyn.team2.domain.PersonRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
	
	Person findByLastname (String lastname);
	
    List<Person> findPersonByRole(PersonRole role);

    @Query("select  concat(o.firstname, ' ', o.lastname) from Person o join o.shows s where s.title = ?1")
    List<String> findActorsByShow(String show);
}
