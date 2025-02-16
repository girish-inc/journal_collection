package org.girish.myfirstproject.Controller;

import org.girish.myfirstproject.Model.JournalEntry;
import org.girish.myfirstproject.Service.JournalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class MyClass {

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
}
