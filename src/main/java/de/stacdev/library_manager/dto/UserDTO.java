package de.stacdev.library_manager.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Collins Souop
 */
@Getter
@Setter
@Builder
public class UserDTO {
    private String firstName;
    private String lastName;
    private String email;
}
