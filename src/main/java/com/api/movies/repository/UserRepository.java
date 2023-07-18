package com.api.movies.repository;

import com.api.movies.model.Review;
import com.api.movies.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    @Query("select u from User u where u.email = ?1 and u.password = ?2")
    User fetchUserForLogin(String email, String password);

    //@Query("select u.full_name from User u where u.id = ?1")
    //String fetchNameUsingId(int id);
}
