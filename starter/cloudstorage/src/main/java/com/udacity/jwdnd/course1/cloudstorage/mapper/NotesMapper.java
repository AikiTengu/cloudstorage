package com.udacity.jwdnd.course1.cloudstorage.mapper;

import com.udacity.jwdnd.course1.cloudstorage.model.Note;
import com.udacity.jwdnd.course1.cloudstorage.model.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface NotesMapper {

    @Select("SELECT * FROM Notes WHERE userId = #{userId})")
    List<Note> getNotes(int userId);

    @Insert("INSERT INTO Notes (notetitle, notedescription, userid) VALUES(#{notetitle}, #{notedescription}, #{userId})")
    @Options(useGeneratedKeys = true, keyProperty = "noteId")
    int insert(Note note);

    @Delete("DELETE * FROM Notes WHERE noteId = #{noteid}")
    void deletebyNoteId(Integer noteId);
}
