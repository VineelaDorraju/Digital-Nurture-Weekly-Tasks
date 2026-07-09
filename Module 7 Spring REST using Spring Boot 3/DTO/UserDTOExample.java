package com.vineela.concepts.dto;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/dto/users")
public class UserDTOExample {

    static class User {
        public Long id; public String name; public String email; public String password;
    }

    static class UserDTO {
        public Long id; public String name; public String email;
    }

    private UserDTO toDTO(User u) {
        UserDTO d = new UserDTO();
        d.id = u.id; d.name = u.name; d.email = u.email;
        return d;
    }

    @GetMapping
    public List<UserDTO> getUsers() {
        User u1 = new User(); u1.id=1L; u1.name="A"; u1.email="a@mail.com"; u1.password="secret";
        User u2 = new User(); u2.id=2L; u2.name="B"; u2.email="b@mail.com"; u2.password="secret";
        return List.of(toDTO(u1), toDTO(u2));
    }
}
