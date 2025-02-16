package org.girish.myfirstproject.Repository;

import org.girish.myfirstproject.Model.JournalEntry;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JournalRepository extends CrudRepository<JournalEntry, Integer> {
    JournalEntry findById(long id);
    List<JournalEntry> findAll();
}
