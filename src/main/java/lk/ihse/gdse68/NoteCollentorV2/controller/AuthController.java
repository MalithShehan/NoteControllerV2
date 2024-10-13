package lk.ihse.gdse68.NoteCollentorV2.controller;

import lk.ihse.gdse68.NoteCollentorV2.dto.impl.UserDTO;
import lk.ihse.gdse68.NoteCollentorV2.exception.DataPersistFailedException;
import lk.ihse.gdse68.NoteCollentorV2.jwtModels.JWTResponse;
import lk.ihse.gdse68.NoteCollentorV2.jwtModels.SignIn;
import lk.ihse.gdse68.NoteCollentorV2.util.AppUtil;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("api/v1/auth")
public class AuthController {
    @PostMapping(value = "signUp", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<JWTResponse> signUp(
            @RequestPart("firstName") String firstName,
            @RequestPart ("lastName") String lastName,
            @RequestPart ("email") String email,
            @RequestPart ("password") String password,
            @RequestPart ("profilePic") MultipartFile profilePic)
    {
        try {
            byte [] imageByteCollection = profilePic.getBytes();
            String base64ProfilePic = AppUtil.toBase64ProfilePic(imageByteCollection);
            UserDTO buildUserDTO = new UserDTO();
            buildUserDTO.setFirstName(firstName);
            buildUserDTO.setLastName(lastName);
            buildUserDTO.setEmail(email);
            buildUserDTO.setPassword(password);
            buildUserDTO.setProfilePic(base64ProfilePic);
            userService.saveUser(buildUserDTO);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }catch (DataPersistFailedException e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PostMapping(value = "signIn")
    public ResponseEntity<JWTResponse> signIn(@RequestBody SignIn signIn){
        return null;
    }
}
