package org.girish.myfirstproject.Controller;

import org.girish.myfirstproject.Model.JournalEntry;
import org.girish.myfirstproject.Service.JournalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
public class JournalController {

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
    public ResponseEntity<?> getAllJournals() {
        if (journalService.getAllJournals() != null) {
            return ResponseEntity.ok(journalService.getAllJournals());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/getJournalById/{id}")
    public ResponseEntity<?> getJournalById(@PathVariable Long id) {
        if (journalService.getJournalById(id) != null) {
            return ResponseEntity.ok(journalService.getJournalById(id));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/deleteJournalById/{id}")
    public ResponseEntity<?> deleteJournalById(@PathVariable Long id) {
        if (journalService.getJournalById(id) != null) {
            journalService.deleteJournalById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/updateJournalById/{id}")
    public ResponseEntity<?> updateJournalById(@PathVariable Long id, @RequestBody JournalEntry journalEntry) {
        if (journalService.getJournalById(id) != null) {
            journalService.updateJournalById(id, journalEntry);
            return ResponseEntity.ok(journalService.getJournalById(id));
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
