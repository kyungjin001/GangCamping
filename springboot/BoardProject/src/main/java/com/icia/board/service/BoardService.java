package com.icia.board.service;



import com.icia.board.dto.BoardSaveDTO;

import java.util.List;

public interface BoardService {
    Long save(BoardSaveDTO boardSaveDTO);
//    Long save(MemberSaveDTO memberSaveDTO);
//
//    boolean login(MemberLoginDTO memberLoginDTO);
//
//    List<MemberDetailDTO> findAll();
//
//    MemberDetailDTO findById(Long memberId);
//
//    void deleteById(Long memberId);
//
//    MemberDetailDTO findByEmail(String memberEmail);
//
//    Long update(MemberDetailDTO memberDetailDTO);
}
