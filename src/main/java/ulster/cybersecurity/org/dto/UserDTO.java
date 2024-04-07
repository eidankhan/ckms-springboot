package ulster.cybersecurity.org.dto;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserDTO {
    private Long id;

    private String name;

    private String username;
    private String password;
}