package com.icia.member;


import com.icia.member.dto.MemberDetailDTO;
import com.icia.member.dto.MemberMapperDTO;
import com.icia.member.dto.MemberSaveDTO;
import com.icia.member.repository.MemberMapperRepository;
import com.icia.member.repository.MemberRepository;
import com.icia.member.service.MemberService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import javax.transaction.Transactional;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
public class MemberTest {
    @Autowired
    private MemberService ms;

    @Autowired
    private MemberMapperRepository mmr;
// unit test
    @Test
    @DisplayName("회원 데이터 생성")
    public void newMembers() {
        IntStream.rangeClosed(1, 15).forEach(i -> {
            ms.save(new MemberSaveDTO("email" + i, "pw" + i, "name" + i));
        });
    }


    /*
        회원삭제 테스트코드를 만들어봅시다.
        회원삭제 시나리오를 작성해보고 코드도 작성
     */


    @Test
    @Transactional
    @Rollback
    @DisplayName("회원삭제 테스트")
    public void memberDeleteTest() {


        MemberSaveDTO memberSaveDTO = new MemberSaveDTO("삭제용회원이메일1", "삭제용회원비번1", "삭제용회원이름1");
        Long memberId = ms.save(memberSaveDTO);
        ms.deleteById(memberId);
        // 삭제한 회원의 id로 조회를 시도했을 때 null 이어야 테스트 통과
        assertThrows(NoSuchElementException.class, () -> {
                    assertThat(ms.findById(memberId)).isNull(); // 삭제회원 id 조회결과가 null 이면 테스트 통과
                }
        );
    }

    @Test
    @Transactional
    @Rollback
    @DisplayName("회원수정 테스트하기")
    public void memberupdateTest() {


        MemberSaveDTO memberSaveDTO = new MemberSaveDTO("수정용이메일1", "수정용비번1", "수정용이름1");
        Long memberId = ms.save(memberSaveDTO);
        //변경하기전
        MemberDetailDTO memberDetailDTO = ms.findById(memberId);
        //변경한 후(값을 바꾸고 보내줌)
        MemberDetailDTO memberUpdateDetailDTO = ms.findById(memberId);
        // DetailDTO 가져오기 및 값 변경
        memberUpdateDetailDTO.setMemberName("수정후이름");
        // 수정
        memberId = ms.update(memberUpdateDetailDTO);
        memberUpdateDetailDTO = ms.findById(memberId);

        // 수정 후 비교
        System.out.println("수정 전 : " + memberDetailDTO.getMemberName());
        System.out.println("수정 후 : " + memberUpdateDetailDTO.getMemberName());
        assertThat(memberDetailDTO.getMemberName()).isNotEqualTo(memberUpdateDetailDTO.getMemberName());

    }


        // 선생님의 테스트 코드
    @Test
    @Transactional // 커밋 자동적으로 가능
    @Rollback // 이거는 선택임
    @DisplayName("회원수정 테스트")
    public void memberUpdateTest(){

        /*
            1. 신규회원등록
            2. 신규등록한 회원에 대한 이름 수정
            3. 신규등록시 사용한 이름과 DB에 저장된 이름이 일치하는지 판단
            4. 일치하지 않아야 테스트 통과
         */
        // 1.
        String memberEmail = "수정회원1";
        String memberPassword = "수정비번1";
        String memberName = "수정이름1";
        MemberSaveDTO memberSaveDTO = new MemberSaveDTO(memberEmail, memberPassword, memberName);
        Long saveMemberId = ms.save(memberSaveDTO);

        // 가입 후 DB에서 이름 조회
        String saveMemberName = ms.findById(saveMemberId).getMemberName();

        // 2.
        String updateName = "수정용이름";
        MemberDetailDTO updateMember = new MemberDetailDTO(saveMemberId, memberEmail, memberPassword, updateName);
        ms.update(updateMember);

        // 수정 후 DB에서 이름 조회
        String updateMemmberName = ms.findById(saveMemberId).getMemberName();



        // 3.4.
        assertThat(saveMemberName).isNotEqualTo(updateMemmberName);
        System.out.println("수정전 :"+ saveMemberName);
        System.out.println("수정후 :"+ updateMemmberName);


    }

    @Test
    @Transactional
    @DisplayName("mybatis 목록 출력 테스트")
    public void memberListTest(){
        List<MemberMapperDTO> memberList = mmr.memberList();
        for (MemberMapperDTO m : memberList){
            System.out.println("m.toString = " + m);

        }

        List<MemberMapperDTO> memberList2 = mmr.memberList2();
        for (MemberMapperDTO m : memberList2){
            System.out.println("m.toString = " + m);

        }
    }
    @Test
    @DisplayName("mybatis 회원가입 테스트")
    public void memberSaveTest(){
        MemberMapperDTO memberMapperDTO = new MemberMapperDTO("회원이메일11","회원비번11","회원이름11");
        mmr.save(memberMapperDTO);
        MemberMapperDTO memberMapperDTO2 = new MemberMapperDTO("회원이메일2","회원비번2","회원이름2");
        mmr.save2(memberMapperDTO2);
    }





}



