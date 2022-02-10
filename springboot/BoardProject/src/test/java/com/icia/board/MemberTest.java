package com.icia.member;


import com.icia.member.dto.MemberDetailDTO;
import com.icia.member.dto.MemberLoginDTO;
import com.icia.member.dto.MemberSaveDTO;
import com.icia.member.service.MemberService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import javax.transaction.Transactional;

import java.util.List;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
public class MemberTest {
    /*

        MemberServiceImpl.save() 메서드가 잘 동작하는지를 테스트

        회원가입테스트
        save.html에서 회원정보 입력 후 가입클릭
        DB 확인
     */
    @Autowired
    private MemberService ms;

    @Test
    @DisplayName("회원가입 테스트")
    public void memberSaveTest() {
        MemberSaveDTO memberSaveDTO = new MemberSaveDTO();
        memberSaveDTO.setMemberEmail("테스트회원이메일1");
        memberSaveDTO.setMemberPassword("테스트비번1");
        memberSaveDTO.setMemberName("테스트회원이름1");

        ms.save(memberSaveDTO);
    }

        @Test
        @Transactional // 테스트 시작할 때 새로운 트랜잭션 시작
        @Rollback // 테스트 종료 후 롤백 수행
        @DisplayName("회원조회 테스트")
        public void memberDetailTest(){

        // given: 테스트조건 설정
            // 1. 새로운 회원을 등록하고 해당회원의 번호(member_id)를 가져옴.
            // 1.1 테스트용 데이터 객체 생성
         MemberSaveDTO memberSaveDTO = new MemberSaveDTO("조회용회원이메일1", "조회용회원비번1","조회용회원이름1");
        // 1.2 테스트용 데이터를 DB에 저장하고 member_id를 가져옴.
        Long memberId = ms.save(memberSaveDTO);
        // when: 테스트 수행
             // 2. 위에서 가져온 회원번호를 가지고 조회 기능 수행
        MemberDetailDTO findMember = ms.findById(memberId);
        // then: 테스트 결과 검증
            // 3. 1번에서 가입한 회원의 정보와 2번에서 조회한 회원의 정보가 일치하면 테스트 통과 일치하지 않으면 테스트 실패
       // memberSaveDTO의 이메일값과 findMember의 이메일 값이 일치하는지 확인.
        assertThat(memberSaveDTO.getMemberEmail()).isEqualTo(findMember.getMemberEmail());

    }

    @Test
    @Transactional
    @Rollback
    @DisplayName("로그인 테스트")
    public void loginTest() {
        /*
            1. 테스트용 회원가입(MemberSaveDTO)
            2. 로그인용 객체 생성(MembrtLoginDTO)
            1.2 수행할 때 동일한 이메일,패스워드 사용하도록함
            3.로그인 실행
            4. 로그인 결과 수행
            8.로그인결과가 true인지 확인
         */

        // given
        final String testMemberEmail = "로그인테스트이메일";
        final String testMemberPassword = "로그인테스트비밀번호";
        final String testMemberName = "로그인테스트이름";
        final String wrongMemberEmail = "로그인실패";
        MemberSaveDTO memberSaveDTO = new MemberSaveDTO("로그인아이디", "로그인비밀번호","로그인이름");
        // 1.2 테스트용 데이터를 DB에 저장하고 member_id를 가져옴.
        Long memberId = ms.save(memberSaveDTO);
        MemberLoginDTO memberLoginDTO = new MemberLoginDTO("로그인아이디", "로그인비밀번호");
        // when: 테스트 수행
        boolean loginResult= ms.login(memberLoginDTO);
        // then: 테스트 결과 검증
        assertThat(loginResult).isEqualTo(true);

    }

    @Test
    @Transactional
    @Rollback
    @DisplayName("회원목록 테스트")
    public void memberListTest() {
        /*

            member_table에 아무 데이터가 없는 상태에서
            3명의 회원을 가입시킨 후 memberList 사이즈를 조회하여 3이면 테스트 통과
         */




//        MemberSaveDTO memberSaveDTO1 = new MemberSaveDTO("로그인아이디1", "로그인비밀번호1","로그인이름1");
//        MemberSaveDTO memberSaveDTO2 = new MemberSaveDTO("로그인아이디2", "로그인비밀번호2","로그인이름2");
//        MemberSaveDTO memberSaveDTO3 = new MemberSaveDTO("로그인아이디3", "로그인비밀번호3","로그인이름3");

//        for(int i = 1; i<=3; i++){
////            MemberSaveDTO memberSaveDTO = new MemberSaveDTO("로그인아이디1"+i, "로그인비밀번호1"+i,"로그인이름1"+i);
////            ms.save(memberSaveDTO);
//            ms.save(new MemberSaveDTO("로그인아이디1"+i, "로그인비밀번호1"+i,"로그인이름1"+i));
//        }


//        ms.save(memberSaveDTO2);
//        ms.save(memberSaveDTO3);

        //IntStream 방식, Arrow Function(화살표함수)
        IntStream.rangeClosed(1,3).forEach(i -> {
            ms.save(new MemberSaveDTO("로그인아이디1"+i, "로그인비밀번호1"+i,"로그인이름1"+i));
        });


        List<MemberDetailDTO> memberDetailDTOList = ms.findAll();


        assertThat(memberDetailDTOList.size()).isEqualTo(3); //DB안에 아무것도 없어야함


    }




}
