package com.csv.service;

import com.csv.entity.Lead;
import com.csv.payload.LeadDto;

import java.io.ByteArrayInputStream;
import java.util.List;

public interface LeadService {

     LeadDto createLead(LeadDto leadDto);

     void deleteById(String id);

     List<LeadDto> getAllLead();
//  -----------------------used for both excel and pdf report-----------------------------------------------------------------------
    List<Lead> getLeadExcelPdfReports();

    public ByteArrayInputStream load();

}
