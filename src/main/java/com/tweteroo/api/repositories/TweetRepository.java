package com.tweteroo.api.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.tweteroo.api.models.TweetModel;



@Repository
public interface TweetRepository extends JpaRepository<TweetModel, Long> {
   

    @Query(value="SELECT t.id, t.text, t.userId FROM tweets r\n" + //
    "JOIN users ON users.id = t.userId\n" + //
    "WHERE t.userId = :userId", nativeQuery = true)
    List<TweetModel> findByUserId(@Param("userId") Long categoryId);
}
