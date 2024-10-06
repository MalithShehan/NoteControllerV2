package lk.ihse.gdse68.NoteCollentorV2.service;


import lk.ihse.gdse68.NoteCollentorV2.customObj.UserResponse;
import lk.ihse.gdse68.NoteCollentorV2.dto.impl.UserDTO;

import java.util.List;

public interface UserService {
    void saveUser(UserDTO userDTO);
    void updateUser(UserDTO userDTO);
    void deleteUser(String userId);
    UserResponse getSelectedUser(String userId);
    List<UserDTO> getAllUsers();
}
