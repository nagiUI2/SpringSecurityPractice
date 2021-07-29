package com.example.ui2_demo.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name="comment")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="comment_id")
    private Integer commentId;

    @Column(name="comment_name")
    private String commentName;

    @Column(name="comment_info")
    private String commentInfo;

    @Column(name="comment_date")
    @Temporal(TemporalType.DATE)
    private Date commentDate;

    @ManyToOne
    @JoinColumn(name="board_id")
    private Board board;

    @ManyToOne
    @JoinColumn(name="user_id")
    private User userEntity;
}
