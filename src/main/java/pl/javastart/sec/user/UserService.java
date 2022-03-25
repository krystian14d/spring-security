package pl.javastart.sec.user;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.javastart.sec.user.dto.UserCredentialsDto;

import java.util.Optional;

@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public Optional<UserCredentialsDto> findCredentialsByEmail(String email) {
        return userRepository.findByEmail(email)
                .map(UserCredentialsDtoMapper::map);
    }
}
