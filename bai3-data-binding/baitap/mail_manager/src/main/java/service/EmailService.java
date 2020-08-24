package service;

import model.Email;

import java.util.List;

public interface EmailService {
    List<String> getLanguage();
    List<String> getPageSize();

    List<Email> findAll();
    void save(Email email);
    void delete(int id);
    Email findById(int id);
}
