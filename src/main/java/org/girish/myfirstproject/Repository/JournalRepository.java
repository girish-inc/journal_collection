package org.girish.myfirstproject.Repository;

import org.girish.myfirstproject.Model.JournalEntry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JournalRepository extends JpaRepository<JournalEntry, Integer> {
    JournalEntry findById(long id);
    List<JournalEntry> findAll();

    void deleteById(Long id);
}
