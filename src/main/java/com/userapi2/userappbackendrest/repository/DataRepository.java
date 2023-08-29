package com.userapi2.userappbackendrest.repository;

import com.userapi2.userappbackendrest.model.DataClass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DataRepository extends JpaRepository<DataClass,Integer> {
}
