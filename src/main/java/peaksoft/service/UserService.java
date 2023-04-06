package peaksoft.service;

import peaksoft.dto.requests.UserRegisterRequest;
import peaksoft.dto.responses.UserRegisterResponse;

public interface UserService {
    UserRegisterResponse authenticate(UserRegisterRequest authRequest);

}
