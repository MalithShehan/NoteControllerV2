package lk.ihse.gdse68.NoteCollentorV2.service;

import jakarta.transaction.Transactional;
import lk.ihse.gdse68.NoteCollentorV2.customObj.UserErrorResponse;
import lk.ihse.gdse68.NoteCollentorV2.customObj.UserResponse;
import lk.ihse.gdse68.NoteCollentorV2.dao.UserDao;
import lk.ihse.gdse68.NoteCollentorV2.dto.impl.UserDTO;
import lk.ihse.gdse68.NoteCollentorV2.entity.UserEntity;
import lk.ihse.gdse68.NoteCollentorV2.exception.DataPersistFailedException;
import lk.ihse.gdse68.NoteCollentorV2.exception.UserNotFoundException;
import lk.ihse.gdse68.NoteCollentorV2.util.AppUtil;
import lk.ihse.gdse68.NoteCollentorV2.util.Mapping;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class UserServiceIMPL implements UserService{
    @Autowired
    private final UserDao userDao;
    @Autowired
    private final Mapping mapping;
    @Override
    public void saveUser(UserDTO userDTO) {
        userDTO.setUserId(AppUtil.createUserId());
        UserEntity savedUser =
                userDao.save(mapping.convertToUserEntity(userDTO));
        if(savedUser == null ) {
            throw new DataPersistFailedException("Cannot data saved");
        }
    }
    @Override
    public void updateUser(UserDTO userDTO) {
        Optional<UserEntity> tmpUser = userDao.findById(userDTO.getUserId());
        if(!tmpUser.isPresent()){
           throw new UserNotFoundException("User not found");
        }else {
            tmpUser.get().setFirstName(userDTO.getFirstName());
            tmpUser.get().setLastName(userDTO.getLastName());
            tmpUser.get().setEmail(userDTO.getEmail());
            tmpUser.get().setPassword(userDTO.getPassword());
            tmpUser.get().setProfilePic(userDTO.getProfilePic());
        }
    }

    @Override
    public void deleteUser(String userId) {
        Optional<UserEntity> selectedUserId = userDao.findById(userId);
        if(!selectedUserId.isPresent()){
            throw new UserNotFoundException("User not found");
        }else {
            userDao.deleteById(userId);
        }
    }

    @Override
    public UserResponse getSelectedUser(String userId) {
        if(userDao.existsById(userId)){
            UserEntity userEntityByUserId = userDao.getUserEntityByUserId(userId);
            return mapping.convertToUserDTO(userEntityByUserId);
        }else {
            return new UserErrorResponse(0, "User not found");
        }
    }

    @Override
    public List<UserDTO> getAllUsers() {
        List<UserEntity> getAllUsers = userDao.findAll();
        return mapping.convertUserToDTOList(getAllUsers);
    }
}
