package com.example.ui2_demo.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name="board")
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="board_id")
    private Integer boardId;

    @Column(name="board_name")
    private String boardName;

    @Column(name="board_info")
    private String boardInfo;

    @Column(name="board_date")
    @Temporal(TemporalType.DATE)
    private Date userDate;

    @ManyToOne
    @JoinColumn(name="user_id")
    private User userEntity;
}
