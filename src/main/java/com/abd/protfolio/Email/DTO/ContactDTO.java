package com.abd.protfolio.Email.DTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ContactDTO {

    @NotEmpty(message = "name can not be empty")
    private String name;

    @NotEmpty(message = "email can not be empty")
    @Email(message = "invalid email")
    private String email;

    @Size(min = 1 , max = 50 , message = "size must be between 1 and 50 chars")
    private String message;

}
