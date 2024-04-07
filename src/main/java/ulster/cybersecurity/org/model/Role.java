package ulster.cybersecurity.org.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.index.Indexed;


@Document(collection = "roles")
@NoArgsConstructor
@Getter
@Setter
public class Role {
    @Id
    private String id;

    @Indexed(unique = true)
    private String name;

}
