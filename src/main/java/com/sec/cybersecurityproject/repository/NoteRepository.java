
package com.sec.cybersecurityproject.repository;

import com.sec.cybersecurityproject.model.Account;
import com.sec.cybersecurityproject.model.Note;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;


public interface NoteRepository extends JpaRepository<Note, Long>{
    
    List<Note> findByAccountId(Long id);
    
}
