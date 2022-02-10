package com.icia.project.entity;


import com.icia.project.dto.BoardSaveDTO;
import com.icia.project.dto.MemberSaveDTO;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Table(name = "board_table")
public class BoardEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "board_id")
    private Long id;

    @Column
    private String boardTitle;

    @Column
    private  String boardWriter;

    @Column
    private String boardContents;

    @Column
    private String boardImageName;

    @Column
    private LocalDateTime boardDate;


    // 회원 엔티티와의 연관관계(N : 1)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id") // 부모테이블(참조하고자하는 테이블)의 pk 컬럼이름
    private MemberEntity memberEntity; // 참조하고자 하는 테이블을 관리하는 엔티티


    public static BoardEntity saveBoard(BoardSaveDTO boardSaveDTO){
    BoardEntity boardEntity = new BoardEntity();
    boardEntity.setBoardTitle(boardSaveDTO.getBoardTitle());
    boardEntity.setBoardWriter(boardSaveDTO.getBoardWriter());
    boardEntity.setBoardContents(boardSaveDTO.getBoardContents());
    boardEntity.setBoardImageName(boardSaveDTO.getBoardImageName());
    return boardEntity;
    }







}
