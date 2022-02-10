package com.icia.board.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
@AllArgsConstructor
@RequiredArgsConstructor
@Data
public class BoardPagingDTO {
    private  Long boardId;
    private  String boardWriter;
    private  String boardTitle;



}
