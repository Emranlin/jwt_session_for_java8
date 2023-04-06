package peaksoft.dto.responses;

import lombok.Builder;

@Builder
public record UserRegisterResponse(
        String email,
        String token
) {
}
