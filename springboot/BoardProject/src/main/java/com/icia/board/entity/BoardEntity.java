package com.icia.board.entity;

import com.icia.board.dto.BoardSaveDTO;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity // JPA를 사용하려면 Entity Class가 필수적이다.
@Getter
@Setter
@Table(name="board_table")
public class BoardEntity {

    @Id // PK
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto_increment
    @Column(name = "board_id") // 컬럼 이름 지정
    private Long id;

    @Column(length = 50, unique = true)
    private String boardWriter;
    // Entity에서는 _(언더바) 절대 금물. 차후에 오류 발생 가능성 높음.

    @Column(length = 20)
    private String boardPassword;

    @Column()
    private String boardTitle;

    @Column()
    private String boardContents;

    // MemberSaveDTO -> MemberEntity 객체로 변환하기 위한 메서드
    public static BoardEntity saveBoard(BoardSaveDTO boardSaveDTO) {
        BoardEntity boardEntity = new BoardEntity();

//        // memberEntity 객체에 memberSaveDTO 객체 안에 담긴 각 요소를 담아줌.
//        boardEntity
          boardEntity.setBoardWriter(boardSaveDTO.getBoardWriter());
          boardEntity.setBoardPassword(boardSaveDTO.getBoardPassword());
          boardEntity.setBoardTitle(boardSaveDTO.getBoardTitle());
          boardEntity.setBoardContents(boardSaveDTO.getBoardContents());

        return boardEntity;
    }



}