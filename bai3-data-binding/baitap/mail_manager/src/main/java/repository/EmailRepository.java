package repository;

import java.util.List;

public interface EmailRepository {
    List<String> getLanguage();
    List<String> getPageSize();
}
