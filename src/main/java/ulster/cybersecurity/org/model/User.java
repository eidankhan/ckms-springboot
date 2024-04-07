package ulster.cybersecurity.org.model;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.HashSet;
import java.util.Set;

@Document(collection = "users")
@NoArgsConstructor
@Getter
@Setter
public class User {
    @Id
    private String id;
    private String name;

    @Indexed(unique = true)
    private String username;
    private String password;
    @DBRef
    private Set<Role> roles = new HashSet<>();

}