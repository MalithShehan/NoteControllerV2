package lk.ihse.gdse68.NoteCollentorV2.dto.impl;


import lk.ihse.gdse68.NoteCollentorV2.customObj.UserResponse;
import lk.ihse.gdse68.NoteCollentorV2.dto.SuperDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserDTO implements SuperDTO, UserResponse {
    private String userId;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String profilePic;
    private List<NoteDTO> notes = new ArrayList<>();
}
