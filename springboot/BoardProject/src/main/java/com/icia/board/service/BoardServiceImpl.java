package com.icia.board.service;


import com.icia.board.dto.BoardSaveDTO;
import com.icia.board.entity.BoardEntity;
import com.icia.board.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {
    private final BoardRepository br;



    @Override
    public Long save(BoardSaveDTO boardSaveDTO) {
        BoardEntity.saveBoard(boardSaveDTO);
       Long boardId= br.save(boardEntity).getId();
//       return memberId;
        return br.save(BoardEntity).getId();
    }

//
//    @Override
//    public boolean login(MemberLoginDTO memberLoginDTO) {
//        MemberEntity memberEntity = mr.findByMemberEmail(memberLoginDTO.getMemberEmail());
//        if(memberEntity != null){
//            if (memberEntity.getMemberPassword().equals(memberLoginDTO.getMemberPassword())){
//                return true;
//            }else {
//                return false;
//            }}
//            else {
//        return false;
//            }
//    }
//
//    @Override
//    public List<MemberDetailDTO> findAll() {
//        List<MemberEntity> memberEntityList = mr.findAll();
//        List<MemberDetailDTO> memberList = new ArrayList<>();
//        for(MemberEntity m : memberEntityList){
//            memberList.add(MemberDetailDTO.toMemberDetailDTO(m));
//        }
//        return memberList;
//    }
//
//    @Override
//    public MemberDetailDTO findById(Long memberId) {
//        Optional<MemberEntity> memberEntityOptional = mr.findById(memberId);
//        MemberEntity memberEntity = memberEntityOptional.get();
//        MemberDetailDTO memberDetailDTO = MemberDetailDTO.toMemberDetailDTO(memberEntity); //변환 모습
////        return MemberDetailDTO.toMemberDetailDTO(mr.findById(memberId).get());
//        return memberDetailDTO;
//    }
//
//    @Override
//    public void deleteById(Long memberId) {
//        mr.deleteById(memberId);
//    }
//
//    @Override
//    public MemberDetailDTO findByEmail(String memberEmail) {
//        MemberEntity memberEntity = mr.findByMemberEmail(memberEmail);
//        MemberDetailDTO memberDetailDTO =MemberDetailDTO.toMemberDetailDTO(memberEntity);
//        return memberDetailDTO;
//    }
//
//    @Override
//    public Long update(MemberDetailDTO memberDetailDTO) { //mr에서는 무조건 MemberEntity를 넘겨줘야함
//        // update 처리시 save 메서드 호출
//        // MemberDetailDTO -> MemberEntity
//        MemberEntity memberEntity = MemberEntity.toupdateMember(memberDetailDTO);
//        Long memberId = mr.save(memberEntity).getId();
//        return memberId;
//    }


}

