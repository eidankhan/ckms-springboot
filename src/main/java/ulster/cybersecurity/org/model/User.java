package ulster.cybersecurity.org.model;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "user")
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


    // Constructors, getters, setters as needed
}