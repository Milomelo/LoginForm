package site.metacoding.login.web.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import site.metacoding.login.domain.User;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class JoinReqDto {
    @Pattern(regexp = "[a-zA-Z1-9]{4,20}", message = "유저네임은 한글이 들어갈 수 없습니다.")
    @Size(min = 4, max = 20)
    @NotBlank
    private String username;

    @Pattern(regexp = "[a-zA-Z1-9]{4,20}", message = "비밀번호는 한글이 들어갈 수 없습니다.")
    @Size(min = 4, max = 20)
    @NotBlank
    private String password;
    @Size(min = 8, max = 100)
    private String address;

    public User toEntity() {
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setAddress(address);

        return user;
    }
}
