package com.grx10.solar.controller;

import com.grx10.solar.exception.CustomException;
import com.grx10.solar.model.LeadCapture;
import com.grx10.solar.model.LeadCaptureResponse;
import com.grx10.solar.model.Solar;
import com.grx10.solar.model.SolarValues;
import com.grx10.solar.repository.LeadCaptureRepository;
import com.grx10.solar.service.SolarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class SolarController {

    @Autowired
    private LeadCaptureRepository leadCaptureRepository;
    @Autowired
    private SolarService solarService;

    @PostMapping("/captureLead")
    public LeadCaptureResponse captureLead(@RequestBody LeadCapture leadCapture){
        LeadCaptureResponse leadCaptureResponse = new LeadCaptureResponse();
        try {
            leadCaptureRepository.save(leadCapture);
            leadCaptureResponse.setMessage("SUCCESS");
            return leadCaptureResponse;
        }
        catch(DataIntegrityViolationException e){
            throw new CustomException("Phone Number Already Exists");
        }
    }

    @PostMapping("/calculate")
    public SolarValues calculateSolar(@RequestBody Solar solar){
        HashMap response = solarService.calculateSolar(solar);
        return new SolarValues(Integer.valueOf(response.get("Number of Panels Needed").toString()),
                Integer.valueOf(response.get("Required Area of rooftop").toString()),
                Double.valueOf(response.get("Capital Needed").toString()),
                Integer.valueOf(response.get("Breakeven years").toString()),
                Double.valueOf(response.get("Next 25 years earnings").toString()));
    }
}
