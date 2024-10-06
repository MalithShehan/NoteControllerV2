package lk.ihse.gdse68.NoteCollentorV2.dao;

import lk.ijse.gdse.aad68.notetaker.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends JpaRepository<UserEntity,String> {
    UserEntity getUserEntityByUserId(String userId);
}
