package com.sparta.currency_user.user.dto;

import com.sparta.currency_user.user.entity.User;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import jakarta.validation.Valid;

@Getter
public class UserRequestDto {

    @Valid
    @NotBlank(message = "이름은 필수사항입니다.")
    private String name;

    @Valid
    @NotBlank(message = "이메일은 필수사항입니다.")
    private String email;

    public User toEntity() {
        return new User(
                this.name,
                this.email
        );
    }
}
