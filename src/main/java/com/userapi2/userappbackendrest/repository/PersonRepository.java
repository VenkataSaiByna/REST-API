package com.userapi2.userappbackendrest.repository;

import com.userapi2.userappbackendrest.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person,Integer> {
    public Person findByusername(String userName);
    public Person findByEmail(String email);
}
