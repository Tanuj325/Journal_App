package com.tanuj.Spring.Boot.service;

import com.tanuj.Spring.Boot.entity.JournalEntry;
import com.tanuj.Spring.Boot.entity.User;
import com.tanuj.Spring.Boot.repository.JournalEntryRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class JournalEntryService {


    @Autowired
    private JournalEntryRepository journalEntryRepository;
    @Autowired
    private UserService userService;

    @Transactional
    public void saveEntry(JournalEntry journalEntry, String userName) {
        try {
            User user = userService.findByUserName(userName);
            journalEntry.setDate(LocalDateTime.now());
            JournalEntry saved = journalEntryRepository.save(journalEntry);
            user.getJournalEntries().add(saved);
            userService.saveEntry(user);
        } catch (Exception e) {
            throw new RuntimeException("An error occured while saving the entry. ", e);
        }
    }

    public void saveEntry(JournalEntry journalEntry) {
        journalEntryRepository.save(journalEntry);
    }

    public List<JournalEntry> getAll() {
        return journalEntryRepository.findAll();
    }

    public Optional<JournalEntry> findById(ObjectId id) {
        return journalEntryRepository.findById(id);
    }

    @Transactional
    public void deleteById(ObjectId id, String userName) {
        try {
            User user = userService.findByUserName(userName);
            boolean removed = user.getJournalEntries().removeIf(entry -> entry.getId().equals(id));
            if (removed) {
                userService.saveEntry(user);
                journalEntryRepository.deleteById(id);
            } else {
                throw new RuntimeException("JOURNAL ENTRY NOT FOUND");
            }
        } catch (Exception e) {
            throw new RuntimeException("An error occured while deleting the entry. ", e);
        }
    }
//
//    public List<JournalEntry> findByUserName(String userName){
//        userService.findByUserName(userName);
//    }
}
