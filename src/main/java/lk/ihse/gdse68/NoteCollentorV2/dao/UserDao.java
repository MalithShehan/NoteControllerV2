package lk.ihse.gdse68.NoteCollentorV2.dao;


import lk.ihse.gdse68.NoteCollentorV2.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserDao extends JpaRepository<UserEntity,String> {
    UserEntity getUserEntityByUserId(String userId);
    Optional<UserEntity> findByEmail(String email);
}
