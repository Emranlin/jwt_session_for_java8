package peaksoft.dto.requests;

import lombok.Builder;



@Builder
public record UserRegisterRequest(
        String email,
        String password
) {

}



