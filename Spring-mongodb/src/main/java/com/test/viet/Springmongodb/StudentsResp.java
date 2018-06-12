package com.test.viet.Springmongodb;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentsResp extends MongoRepository<Student,String> {
    Optional<Student> findById(String id);
    List<Student> findByluckyNumberLessThan(int lucky);
    //To access one level deeper than just the student collection, say
    //small components of it, we need to use the query tag
    //remember to add quoute around the first key

    @Query(value = "{'address.city':?0}")
    List<Student> findByCity(String city);

}
