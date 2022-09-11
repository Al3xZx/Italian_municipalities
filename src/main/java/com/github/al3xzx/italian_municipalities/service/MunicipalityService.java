package com.github.al3xzx.italian_municipalities.service;

import com.github.al3xzx.italian_municipalities.entity.Municipality;

import java.util.List;
import java.util.Set;

public interface MunicipalityService {

  List<Municipality> bulkAddMunicipality(List<Municipality> municipalities);

  List<String> allMunicipalities();

  Set<String> allProvinces();

  List<String> allProvincesByRegion(String region);

  List<String> municipalitiesFromAutoAbbreviation(String automobileAbbreviation);

  List<String> allRegions();

  List<String> municipalitiesByRegion(String region);

  List<String> allAutomobileAbbreviation();
}
