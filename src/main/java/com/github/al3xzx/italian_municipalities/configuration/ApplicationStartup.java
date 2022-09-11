package com.github.al3xzx.italian_municipalities.configuration;

import com.github.al3xzx.italian_municipalities.service.MunicipalityService;
import com.github.al3xzx.italian_municipalities.util.CsvUtils;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class ApplicationStartup implements ApplicationListener<ApplicationReadyEvent> {

  private final MunicipalityService municipalityService;

  public ApplicationStartup(MunicipalityService municipalityService) {
    this.municipalityService = municipalityService;
  }


  @Override
  public void onApplicationEvent(ApplicationReadyEvent event) {
    municipalityService.bulkAddMunicipality(CsvUtils.MunicipalityCSVToPojo());
  }
}
