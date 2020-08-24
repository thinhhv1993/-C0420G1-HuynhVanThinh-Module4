package service;

import repository.EmailRepository;
import repository.EmailRepositoryImpl;

import java.util.List;

public class EmailServiceImpl implements EmailService {

    EmailRepository emailRepository = new EmailRepositoryImpl();
    @Override
    public List<String> getLanguage() {
        return this.emailRepository.getLanguage();
    }

    @Override
    public List<String> getPageSize() {
        return this.emailRepository.getPageSize();
    }
}
