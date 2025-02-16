package org.girish.myfirstproject.Model;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class JournalEntry {

    @Id
    private Long id;
    private String title;
    private String author;

}
