package com.icia.board.entity;

import com.icia.board.dto.BoardSaveDTO;

import com.icia.board.dto.BoardUpdateDTO;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity // JPA를 사용하려면 Entity Class가 필수적이다.
@Getter
@Setter
@Table(name="board_table")
public class BoardEntity extends BaseEntity{

    @Id // PK
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto_increment
    @Column(name = "board_id") // 컬럼 이름 지정 /DB에 생성될 컬럼이름
    private Long id;

    @Column(length = 50, unique = true)
    private String boardWriter;
    // Entity에서는 _(언더바) 절대 금물. 차후에 오류 발생 가능성 높음.

    @Column
    private String boardPassword; //무조건 카멜케이스!
    @Column
    private String boardTitle;

    @Column
    private String boardContents;

    // 댓글 연관관계
    @OneToMany(mappedBy = "boardEntity",cascade = CascadeType.ALL,orphanRemoval = true,fetch = FetchType.LAZY) //일대다
    private List<CommentEntity> commentEntityList = new ArrayList<>();




//    @Column
//    private LocalDateTime boardDate;

    public static BoardEntity toSaveEntity(BoardSaveDTO boardSaveDTO) {
        BoardEntity boardEntity = new BoardEntity();

          boardEntity.setBoardWriter(boardSaveDTO.getBoardWriter());
          boardEntity.setBoardPassword(boardSaveDTO.getBoardPassword());
          boardEntity.setBoardTitle(boardSaveDTO.getBoardTitle());
          boardEntity.setBoardContents(boardSaveDTO.getBoardContents());
//          boardEntity.setBoardDate(LocalDateTime.now());

        return boardEntity;
    }


    public static BoardEntity toUpdateBoard(BoardUpdateDTO boardDetailDTO) {
        BoardEntity boardEntity = new BoardEntity();

        boardEntity.setId(boardDetailDTO.getBoardId());
        boardEntity.setBoardWriter(boardDetailDTO.getBoardWriter());
        boardEntity.setBoardPassword(boardDetailDTO.getBoardPassword());
        boardEntity.setBoardTitle(boardDetailDTO.getBoardTitle());
        boardEntity.setBoardContents(boardDetailDTO.getBoardContents());
//        boardEntity.setBoardDate(LocalDateTime.now());

        return boardEntity;
    }



}