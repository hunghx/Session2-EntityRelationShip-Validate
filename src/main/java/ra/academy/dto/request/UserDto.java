package ra.academy.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ra.academy.validator.PasswordMatching;
import ra.academy.validator.UserNameUnique;

@NoArgsConstructor
@AllArgsConstructor
@Data
@PasswordMatching(
        password = "password",
        confirmPassword = "confirmPassword"
)
public class UserDto {
    @NotBlank
    @UserNameUnique
    private String username;
    @NotBlank
    private String password;
    @NotBlank
    private String confirmPassword;
}
