package org.girish.myfirstproject.Controller;

import org.girish.myfirstproject.Model.JournalEntry;
import org.girish.myfirstproject.Service.JournalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class JournalController {

    private Map<Long, JournalEntry> journalEntries = new HashMap<>();
    @Autowired
    JournalService journalService;
    @GetMapping("/")
    public String sayHello() {
        return "Hello World";
    }

    @PostMapping("/add") // Changed from PUT to POST
    public String createJournal(@RequestBody JournalEntry journalEntry) {
       return journalService.createEntry(journalEntry);
    }
    @GetMapping("/allJournals")
    public List<JournalEntry> getAllJournals() {
        return journalService.getAllJournals();
    }
    @GetMapping("/getJournalById/{id}")
    public JournalEntry getJournalById(@PathVariable Long id) {
        return journalService.getJournalById(id);
    }
    @DeleteMapping("/deleteJournalById/{id}")
    public boolean deleteJournalById(@PathVariable Long id) {
        journalService.deleteJournalById(id);
       return true;
    }
    @PutMapping("/updateJournalById/{id}")
    public JournalEntry updateJournalById(@PathVariable Long id, @RequestBody JournalEntry journalEntry) {
        return journalService.updateJournalById(id,journalEntry);
    }
}
