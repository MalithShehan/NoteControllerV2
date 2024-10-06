package lk.ihse.gdse68.NoteCollentorV2.service;


import lk.ihse.gdse68.NoteCollentorV2.customObj.NoteResponse;
import lk.ihse.gdse68.NoteCollentorV2.dto.impl.NoteDTO;

import java.util.List;

public interface NoteService {
    void saveNote(NoteDTO noteDTO);
    void updateNote(String noteId,NoteDTO noteDTO);
    void deleteNote(String noteId);
    NoteResponse getSelectedNote(String noteId);
    List<NoteDTO> getAllNotes();
}
