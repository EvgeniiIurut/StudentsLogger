package com.aston.martin.service;

import com.aston.martin.repository.LogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LogService {

    private final LogRepository logRepository;

    @Autowired
    public LogService(LogRepository logRepository) {
        this.logRepository = logRepository;
    }

    public void createNewLog(int id, String message) {
        logRepository.add(id, message);
    }

    public void updateLog(int logId, String message) {
        logRepository.update(logId, message);
    }
}
