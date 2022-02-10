package com.icia.project.service;


import com.icia.project.dto.MemberLoginDTO;
import com.icia.project.dto.MemberSaveDTO;
import com.icia.project.entity.MemberEntity;
import com.icia.project.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {



    private final MemberRepository mr;



    @Override
    public Long save(MemberSaveDTO memberSaveDTO) throws IOException {
        MultipartFile memberImage = memberSaveDTO.getMemberImage();
        String memberImageName = memberImage.getOriginalFilename();
        memberImageName = System.currentTimeMillis() + "-" + memberImageName;
        String savePath = "C:\\development\\source\\springboot\\MemberBoard\\src\\main\\resources\\upload\\"+memberImageName;
        if(!memberImage.isEmpty()) {
            memberImage.transferTo(new File(savePath));
        }
        memberSaveDTO.setMemberImageName(memberImageName);


        MemberEntity memberEntity = MemberEntity.saveMember(memberSaveDTO);
        mr.save(memberEntity).getId();
        Long result =  mr.save(memberEntity).getId();

        return result;
    }

    @Override
    public boolean login(MemberLoginDTO memberLoginDTO) {
        MemberEntity memberEntity = mr.findByMemberEmail(memberLoginDTO.getMemberEmail());
        if(memberEntity != null){
            if (memberEntity.getMemberPassword().equals(memberLoginDTO.getMemberPassword())){
                return true;
            }else {
                return false;
            }}
        else {
            return false;
        }
    }

    @Override
    public String idDuplicate(String memberEmail) {
        MemberEntity memberEntity = mr.findByMemberEmail(memberEmail);
        if (memberEntity==null){
            return "ok";
        }
        else{
            return "no";
        }
    }



}
