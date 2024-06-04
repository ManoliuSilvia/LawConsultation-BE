package com.example.LawConsultation.repository;

import com.example.LawConsultation.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User,Long> {
    public Optional<User> findByEmail(String username);
    public Optional<User> findByUserId(Long userId);

}
