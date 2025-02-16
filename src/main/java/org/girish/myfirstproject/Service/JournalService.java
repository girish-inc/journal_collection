package org.girish.myfirstproject.Service;

import jakarta.transaction.Transactional;
import org.girish.myfirstproject.Model.JournalEntry;
import org.girish.myfirstproject.Repository.JournalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class JournalService {
    @Autowired
    JournalRepository journalRepository;

    public String createEntry(JournalEntry journalEntry) {
        journalEntry.setDate(LocalDateTime.now());
        journalRepository.save(journalEntry);
        return journalEntry.toString();
    }

    public List<JournalEntry> getAllJournals() {
        return journalRepository.findAll();
    }

    public JournalEntry getJournalById(Long id) {
        return journalRepository.findById(id);
    }

    @Transactional
    public void deleteJournalById(Long id) {
        journalRepository.deleteById(id);
    }

    public JournalEntry updateJournalById(Long id, JournalEntry journalEntry) {
        JournalEntry oldJournal = journalRepository.findById(id);
        journalEntry.setId(oldJournal.getId());
        journalEntry.setDate(oldJournal.getDate());
        return journalRepository.save(journalEntry);
    }
}
