package com.example.jpa.repository;

import com.example.jpa.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface AuthorRepository extends JpaRepository<Author, Integer>, JpaSpecificationExecutor<Author> {

    List<Author> findAllByLastName(String lastName);

    List<Author> findAllByFirstName(String firstName);

    List<Author> findAllByFirstNameIgnoreCase(String firstName);

    List<Author> findAllByFirstNameContainingIgnoreCase(String firstName);

    List<Author> findAllByFirstNameStartsWithIgnoreCase(String firstName);

    List<Author> findAllByFirstNameEndsWithIgnoreCase(String firstName);

    List<Author> findAllByFirstNameInIgnoreCase(List<String> firstNames);

    List<Author> findAllByFirstNameAndLastName(String firstName, String lastName);

    List<Author> findAllByFirstNameOrLastName(String firstName, String lastName);

    Optional<Author> findByEmail(String email);

    int countAllByAge(int age);

    int deleteAllByAge(int age);

    @Transactional
    @Modifying
    @Query("update Author a set a.age = :age where a.id = :id")
    int updateAuthor(int age, int id);

    @Transactional
    @Modifying
    @Query("update Author a set a.age = :age")
    int updateAllAuthorsAges(int age);

    List<Author> findByNamedQuery(@Param("age") int age);

    @Modifying
    @Transactional
    void updateByNamedQuery(@Param("age") int age);
}
