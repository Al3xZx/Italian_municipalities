package com.github.al3xzx.italian_municipalities.util;

import com.github.al3xzx.italian_municipalities.entity.Municipality;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CsvUtilsTest {

  @Test
  void municipalityCSVToPojo() {
    List<Municipality> municipalities = CsvUtils.MunicipalityCSVToPojo();
    // number expected https://www.tuttitalia.it/variazioni-amministrative/nuovi-comuni-2021/
    Assertions.assertEquals(7904,municipalities.size());
  }
}