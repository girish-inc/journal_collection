package org.girish.myfirstproject.Service;

import org.girish.myfirstproject.Model.JournalEntry;
import org.girish.myfirstproject.Repository.JournalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JournalService {
    @Autowired JournalRepository journalRepository;
    public String createEntry(JournalEntry journalEntry) {
        journalRepository.save(journalEntry);
        return journalEntry.toString();
    }

    public List<JournalEntry> getAllJournals() {
        return journalRepository.findAll();
    }

    public JournalEntry getJournalById(Long id) {
        return journalRepository.findById(id);
    }
}
