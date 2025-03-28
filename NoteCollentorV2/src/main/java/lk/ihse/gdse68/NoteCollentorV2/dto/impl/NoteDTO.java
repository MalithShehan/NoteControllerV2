package lk.ihse.gdse68.NoteCollentorV2.dto.impl;


import lk.ihse.gdse68.NoteCollentorV2.customObj.NoteResponse;
import lk.ihse.gdse68.NoteCollentorV2.dto.SuperDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class NoteDTO implements SuperDTO, NoteResponse {
    private String noteId;
    private String noteTitle;
    private String noteDesc;
    private String priorityLevel;
    private String createDate;
    private String userId;
}
