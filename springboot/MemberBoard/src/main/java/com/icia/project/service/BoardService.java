package com.icia.project.service;

import com.icia.project.dto.MemberLoginDTO;
import com.icia.project.dto.MemberSaveDTO;

import java.io.IOException;

public interface MemberService {
    Long save(MemberSaveDTO memberSaveDTO) throws IOException;

    boolean login(MemberLoginDTO memberLoginDTO);

    String idDuplicate(String memberEmail);
}
