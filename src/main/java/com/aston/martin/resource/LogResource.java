package com.aston.martin.resource;

import com.aston.martin.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/students/{id}/logs")
public class LogResource {

    private final LogService logService;

    @Autowired
    public LogResource(LogService logService) {
        this.logService = logService;
    }

    @PostMapping
    public void createNewLog(@PathVariable(name = "id") int id, @RequestParam(name = "message") String message) {

        logService.createNewLog(id, message);
    }

    @PostMapping("/{logId}")
    public void updateLog(@PathVariable(name = "logId") int logId, @RequestParam(name = "message") String message) {

        logService.updateLog(logId, message);
    }
}