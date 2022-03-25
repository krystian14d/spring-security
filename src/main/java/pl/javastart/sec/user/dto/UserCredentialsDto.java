package pl.javastart.sec.user.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@AllArgsConstructor
@Getter
@Setter
public class UserCredentialsDto {

    private final String email;
    private final String password;
    private final Set<String> roles;

}
