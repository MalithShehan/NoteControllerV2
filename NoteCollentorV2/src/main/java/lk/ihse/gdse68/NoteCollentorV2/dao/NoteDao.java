package lk.ihse.gdse68.NoteCollentorV2.dao;

import lk.ihse.gdse68.NoteCollentorV2.entity.NoteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NoteDao extends JpaRepository<NoteEntity, String> {

}
