package at.simon.b64.gethealthybackend.web.model;

import java.util.UUID;

public record UserDto(
    UUID id,
    String ssoId,
    String email,
    String firstName,
    String lastName
) {
}
