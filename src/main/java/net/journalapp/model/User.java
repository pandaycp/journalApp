package net.journalapp.model;

import lombok.Data;
import net.journalapp.entity.JournalEntry;
import org.bson.types.ObjectId;
import java.util.List;

@Data
public class User {
    private ObjectId id;
    private String userName;
    private  String password;
    private List<String> roles;
    private List<JournalEntry> journalEntries;
}
