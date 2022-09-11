package com.github.al3xzx.italian_municipalities.controller;

import com.github.al3xzx.italian_municipalities.service.MunicipalityService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/v1")
@RestController
public class MunicipalityController {

  private final MunicipalityService municipalityService;

  public MunicipalityController(MunicipalityService municipalityService) {
    this.municipalityService = municipalityService;
  }

  @GetMapping("/municipalities")
  public ResponseEntity allMunicipalities() {
    return new ResponseEntity(municipalityService.allMunicipalities(), HttpStatus.OK);
  }

  @GetMapping("/provincies")
  public ResponseEntity allProvinces() {
    return new ResponseEntity(municipalityService.allProvinces(), HttpStatus.OK);
  }

  @GetMapping("/provincie/{region}")
  public ResponseEntity allProvincesByRegion(@PathVariable String region) {
    return new ResponseEntity(municipalityService.allProvincesByRegion(region), HttpStatus.OK);
  }

  @GetMapping("/municipalities/{automobileAbbreviation}")
  public ResponseEntity municipalitiesByAutoAbbreviation(@PathVariable String automobileAbbreviation) {
    return new ResponseEntity(municipalityService.municipalitiesFromAutoAbbreviation(automobileAbbreviation), HttpStatus.OK);
  }

  @GetMapping("/regions")
  public ResponseEntity allRegions() {
    return new ResponseEntity(municipalityService.allRegions(), HttpStatus.OK);
  }

  @GetMapping("/municipalities-region")
  public ResponseEntity municipalitiesByRegion(@RequestParam("region") String region) {
    return new ResponseEntity(municipalityService.municipalitiesByRegion(region), HttpStatus.OK);
  }

  @GetMapping("/automobileAbbreviation")
  public ResponseEntity allAutomobileAbbreviation() {
    return new ResponseEntity(municipalityService.allAutomobileAbbreviation(), HttpStatus.OK);
  }

}
