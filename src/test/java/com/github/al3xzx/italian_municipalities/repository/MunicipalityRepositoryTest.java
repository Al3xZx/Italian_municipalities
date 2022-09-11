package com.github.al3xzx.italian_municipalities.repository;

import com.github.al3xzx.italian_municipalities.ApplicationTests;
import com.github.al3xzx.italian_municipalities.entity.Municipality;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Slf4j
class MunicipalityRepositoryTest extends ApplicationTests {

  @Autowired
  MunicipalityRepository municipalityRepository;

  @Test
  void findAll() {
    List<Municipality> municipalities = municipalityRepository.findAll();
    Set<Municipality> setMunicipalities = new HashSet<>(municipalities);
    Set<Integer> setMunicipalitiesNumber = municipalities.stream()
        .map(Municipality::getCodiceComuneNumerico).collect(Collectors.toSet());
    List<String> listMunicipalitiesString = municipalities.stream()
        .map(Municipality::getDenominazioneItaliana).collect(Collectors.toList());
    Assertions.assertEquals(7904, municipalities.size());
    Assertions.assertEquals(7904, setMunicipalities.size());
    Assertions.assertEquals(7904, setMunicipalitiesNumber.size());
    Assertions.assertEquals(7904, listMunicipalitiesString.size());
    List<String> duplicates = new LinkedList<>();
    Set<String> munSet = new HashSet<>();
    for (String municipality : listMunicipalitiesString) {
      if (!munSet.add(municipality)) {
        duplicates.add(municipality);
      }
    }
    log.info("Duplicates are {}", duplicates);
  }

  @Test
  void findRegions() {
  }

  @Test
  void findMunicipalities() {
  }

  @Test
  void findProvinces() {
  }
}