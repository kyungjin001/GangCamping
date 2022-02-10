package com.icia.board.dto;


import com.icia.board.entity.BoardEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class BoardUpdateDTO {

    private Long boardId;
    private String boardWriter;
    private String boardPassword;
    private String boardTitle;
    private String boardContents;
    private LocalDateTime boardDate;


    public  BoardUpdateDTO(Long boardId, String boardWriter, String boardPassword,String boardTitle,String boardContents){
        this.boardId = boardId;
        this.boardWriter = boardWriter;
        this.boardPassword = boardPassword;
        this.boardTitle = boardTitle;
        this.boardContents = boardContents;
    }




}
