package com.recruit.usermate.domain.user;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@NoArgsConstructor
@Entity
public class User {

    @Id
    @Column(length = 50, nullable = false)
    private String id;
    @Column(length = 50, nullable = false)
    private String password;

    @Builder
    public User(String id, String password) {
        this.id = id;
        this.password = password;
    }
}
