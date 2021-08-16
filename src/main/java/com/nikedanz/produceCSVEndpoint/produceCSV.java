package com.nikedanz.produceCSVEndpoint;

import org.springframework.core.io.FileSystemResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;

@RestController
public class produceCSV {

    @GetMapping()
    @RequestMapping("/")
    public ResponseEntity<FileSystemResource> getSample() {
        File file = new File("monitors.csv");
        return ResponseEntity.ok()
                .header("Content-Disposition", "attachment; filename=Sample.csv")
                .contentType(MediaType.parseMediaType("text/csv"))
                .body(new FileSystemResource(file));

    }
}
