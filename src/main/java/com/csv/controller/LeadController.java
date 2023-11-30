package com.csv.controller;

import com.csv.payload.LeadDto;
import com.csv.service.LeadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/leads")
public class LeadController {
    @Autowired
    private LeadService leadService;

    //  http://localhost:8080/api/leads
    @PostMapping
    public ResponseEntity<LeadDto> createLead(@RequestBody LeadDto leadDto){
        System.out.println(leadDto);
        LeadDto dto = leadService.createLead(leadDto);
        return new ResponseEntity<>(dto, HttpStatus.CREATED);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteById(@PathVariable String id){
        leadService.deleteById(id);
        return new ResponseEntity<>("Lead is deleted with id: "+id, HttpStatus.OK);
    }

    @GetMapping
    public List<LeadDto> getAllLead(){
        List<LeadDto> lead = leadService.getAllLead();
        return lead;
    }

//----------------------- ------CSV File Report--------------------------------------------------------------------------

    //  http://localhost:8080/api/leads/csvDownload
    @GetMapping("/csvDownload")
    public ResponseEntity<Resource> getFile() {
        String filename = "Leads.csv";
        InputStreamResource file = new InputStreamResource(leadService.load());

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + filename)
                .contentType(MediaType.parseMediaType("application/csv"))
                .body(file);
    }

}
