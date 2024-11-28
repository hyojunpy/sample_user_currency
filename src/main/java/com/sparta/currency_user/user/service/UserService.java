package com.sparta.currency_user.user.service;

import com.sparta.currency_user.user.dto.UserRequestDto;
import com.sparta.currency_user.user.dto.UserResponseDto;
import com.sparta.currency_user.user.entity.User;
import com.sparta.currency_user.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public UserResponseDto findById(Long id) {
        return new UserResponseDto(findUserById(id));
    }

    //유저 아이디로 찾기
    public User findUserById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("사용자를 찾을 수 없습니다."));
    }

    //모든 유저 조회
    public List<UserResponseDto> findAll() {
        return userRepository.findAll().stream().map(UserResponseDto::toDto).toList();
    }

    //유저 생성
    @Transactional
    public UserResponseDto save(UserRequestDto userRequestDto) {
        User savedUser = userRepository.save(userRequestDto.toEntity());
        return new UserResponseDto(savedUser);
    }

    //유저 삭제
    @Transactional
    public void deleteUserById(Long id) {
        this.findUserById(id);
        userRepository.deleteById(id);
    }

}
