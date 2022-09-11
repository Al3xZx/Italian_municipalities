package com.github.al3xzx.italian_municipalities.service;

import com.github.al3xzx.italian_municipalities.ApplicationTests;
import com.github.al3xzx.italian_municipalities.entity.Municipality;
import com.github.al3xzx.italian_municipalities.repository.MunicipalityRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

class MunicipalityServiceTest extends ApplicationTests {

  @Autowired
  MunicipalityService municipalityService;

  @Autowired
  MunicipalityRepository municipalityRepository;

  @Test
  void allMunicipalities() {
    List<String> municipalities = municipalityService.allMunicipalities();
    Integer expected = 7904 - municipalityNameDuplicates();
    Assertions.assertEquals(expected, municipalities.size());
  }

  private int municipalityNameDuplicates() {
    List<String> listMunicipalitiesString =  municipalityRepository.findAll().stream()
        .map(Municipality::getDenominazioneItaliana).collect(Collectors.toList());
    List<String> duplicates = new LinkedList<>();
    Set<String> munSet = new HashSet<>();
    for (String municipality : listMunicipalitiesString) {
      if (!munSet.add(municipality)) {
        duplicates.add(municipality);
      }
    }
    return duplicates.size();
  }

  @Test
  void allProvinces() {
  }

  @Test
  void allProvincesByRegion() {
  }

  @Test
  void provinceMunicipalitiesFromAutomobileAbbreviation() {
  }

  @Test
  void allRegions() {
  }

  @Test
  void municipalitiesByRegion() {
  }

  @Test
  void allAutomobileAbbreviation() {
  }
}