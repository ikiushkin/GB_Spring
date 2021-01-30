package ru.entities;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "scores")
public class Score {

    @Id
    @Column(name = "user_id")
    private Long user_id;

    @Column(name = "score")
    private Long score;

//    @OneToOne(mappedBy = "score")
//    private User user;
}
