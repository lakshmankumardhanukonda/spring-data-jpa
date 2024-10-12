package com.example.jpa.model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Data
@Entity
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class Course extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String title;

    private String description;

    @ManyToMany
    @JoinTable(name = "authors_courses", joinColumns = {
            @JoinColumn(name = "course_id")
    }, inverseJoinColumns = {
            @JoinColumn(name = "author_id")
    })
    private List<Author> authors;

    @OneToMany(mappedBy = "course")
    private List<Section> sections;
}
