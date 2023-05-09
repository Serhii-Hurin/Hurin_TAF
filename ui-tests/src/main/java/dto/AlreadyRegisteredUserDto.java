package dto;


import lombok.Data;

@Data
public class AlreadyRegisteredUserDto {

    private final String loginName;
    private final String password;

}
