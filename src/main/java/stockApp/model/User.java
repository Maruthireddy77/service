package stockApp.model;

import lombok.*;
import org.hibernate.validator.constraints.UniqueElements;
import org.hibernate.validator.internal.constraintvalidators.bv.EmailValidator;
import org.springframework.context.annotation.Primary;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.Collection;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Document (collection = "User")
public class User {
    @Id
    private String id;
    @NotBlank(message = "Firstname shouldn't be blank")
    @Size(min = 3, message = "Firstname Length should be atleast 3 letters")
    private String firstname;
    @NotBlank(message = "Lastname shouldn't be blank")
    @Size(min = 3, message = "Lastname Length should be atleast 3 letters")
    private String lastname;
    @Email(message = "username must be in Email format")
    private String username;
    @NotBlank(message = "Password shouldn't be blank")
    @Size(min = 5, message = "Password should be atleast 5 letters")
    private String password;

    private Collection<Role> roles = new ArrayList<>();

}
