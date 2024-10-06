package lk.ihse.gdse68.NoteCollentorV2.dao;

import lk.ijse.gdse.aad68.notetaker.entity.NoteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NoteDao extends JpaRepository<NoteEntity, String> {

}
