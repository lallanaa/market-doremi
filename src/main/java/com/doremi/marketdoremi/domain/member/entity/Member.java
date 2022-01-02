package com.doremi.marketdoremi.domain.member.entity;

import java.io.Serializable;

import com.doremi.marketdoremi.domain.member.Role;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Member implements Serializable {

    @EmbeddedId
    private MemberId memberId;

    @Column(length = 500, nullable = false)
    private String password;

    @Column(nullable = false)
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role;
//    private Grade grade;

    public String memberIdAsString(){
        return this.memberId.getMemberId();
    }

    @Builder
    public Member(String memberId, String password, String name, Role role) { //builder의 parameter를 추리는 기준이 뭘까?
        this.memberId = new MemberId(memberId);
        this.password = password;
        this.name = name;
        this.role = role;
    }
}