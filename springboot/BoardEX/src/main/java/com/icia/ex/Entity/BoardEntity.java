package com.icia.ex.Entity;


import com.icia.ex.dto.BoardSaveDTO;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity // 필수적임
@Getter
@Setter
@Table(name = "boards_table")
@RequiredArgsConstructor
public class BoardEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "board_Id") //컬럼명
    private Long id;

    @Column
    private String boardWriter;

    @Column
    private String boardTitle;

    @Column
    private String boardContents;

    @Column
    private LocalDateTime boardDate;


    public static BoardEntity toSaveEntity(BoardSaveDTO boardSaveDTO){

        BoardEntity boardEntity = new BoardEntity();
        boardEntity.setBoardWriter(boardSaveDTO.getBoardWriter());
        boardEntity.setBoardTitle(boardSaveDTO.getBoardTitle());
        boardEntity.setBoardContents(boardSaveDTO.getBoardContents());
        boardEntity.setBoardDate(LocalDateTime.now());
        return boardEntity;
    }






}
