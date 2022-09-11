package com.github.al3xzx.italian_municipalities.service.impl;

import com.github.al3xzx.italian_municipalities.entity.Municipality;
import com.github.al3xzx.italian_municipalities.repository.MunicipalityRepository;
import com.github.al3xzx.italian_municipalities.service.MunicipalityService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Slf4j
@Service
public class MunicipalityServiceImpl implements MunicipalityService {

  private final MunicipalityRepository municipalityRepository;


  public MunicipalityServiceImpl(@Lazy MunicipalityRepository municipalityRepository) {
    this.municipalityRepository = municipalityRepository;
  }

  @Override
  public List<Municipality> bulkAddMunicipality(List<Municipality> municipalities) {
    return municipalityRepository.saveAll(municipalities);
  }

  @Override
  public List<String> allMunicipalities() {
    log.info("Finding all municipalities");
    List<String> municipalities = municipalityRepository.findMunicipalities();
    log.info("Number of municipalities: {}", municipalities.size());
    return municipalities;
  }

  @Override
  public Set<String> allProvinces() {
    log.info("Finding all provinces");
    Set<String> provinces = municipalityRepository.findProvinces();
    log.info("Number of all provinces: {}", provinces.size());
    return provinces;
  }

  @Override
  public List<String> allProvincesByRegion(String region) {
    log.info("Finding all provinces by region {}", region);
    List<String> provinces = municipalityRepository.findProvincesByRegion(region);
    log.info("Number of provinces in {} : {}", region, provinces.size());
    return provinces;
  }

  @Override
  public List<String> municipalitiesFromAutoAbbreviation(String automobileAbbreviation) {
    return municipalityRepository.findAllBySiglaAutomobilistica(automobileAbbreviation.toUpperCase())
        .stream()
        .map(Municipality::getDenominazioneItaliana)
        .collect(Collectors.toList());
  }

  @Override
  public List<String> allRegions() {
    log.info("Finding all regions");
    List<String> regions = municipalityRepository.findRegions()
        .stream()
        .map(r -> {
          if (r.contains("/")) {
            return r.split("/")[0];
          } else {
            return r;
          }
        }).collect(Collectors.toList());
    log.info("Number of regions: " + regions.size());
    return regions;
  }

  @Override
  public List<String> municipalitiesByRegion(String region) {
    return municipalityRepository.findAllMunicipalitiesByRegion(region);
  }

  @Override
  public List<String> allAutomobileAbbreviation() {
    return municipalityRepository.findAllAutoAbbreviation();
  }

}
