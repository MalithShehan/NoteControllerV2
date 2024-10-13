package lk.ihse.gdse68.NoteCollentorV2.controller;

import lk.ihse.gdse68.NoteCollentorV2.jwtModels.JWTResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/auth")
public class AuthController {
    @PostMapping(value = "signUp")
    public ResponseEntity<JWTResponse> signUp() {
        return null;
    }
    @PostMapping(value = "signIn")
    public ResponseEntity<JWTResponse> signIn(){
        return null;
    }

}
