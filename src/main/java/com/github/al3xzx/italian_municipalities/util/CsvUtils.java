package com.github.al3xzx.italian_municipalities.util;

import com.github.al3xzx.italian_municipalities.entity.Municipality;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

@Slf4j
public class CsvUtils {

  private CsvUtils() {
  }

  public static List<Municipality> MunicipalityCSVToPojo() {
    try {
      URL url = CsvUtils.class.getClassLoader().getResource("csvData/Elenco-comuni-italiani.csv");
      String pathFile;
      if (url == null) {
        throw new FileNotFoundException("Cannot find the file Elenco-comuni-italiani.csv stored in resource");
      } else {
        pathFile = url.getPath();
      }
      Iterable<CSVRecord> records = CSVParser.parse(
          new File(pathFile), StandardCharsets.UTF_8, CSVFormat.newFormat(';'));
      List<Municipality> ret = new LinkedList<>();
      for (CSVRecord record : records) {
        Municipality municipality = new Municipality();
        municipality.setCodiceRegione(record.get(0));
        municipality.setCodiceUnitaTerritorialeSovracomunale(record.get(1));
        municipality.setCodiceStoricoProvincia(record.get(2));
        municipality.setProgressivoComune(record.get(3));
        municipality.setCodiceComuneAlfanumerico(record.get(4));
        municipality.setDenominazioneItaStraniera(record.get(5));
        municipality.setDenominazioneItaliana(record.get(6));
        municipality.setDenominazioneAltraLingua(record.get(7));
        municipality.setCodiceRipartizioneGeografica(Integer.valueOf(record.get(8)));
        municipality.setRipartizioneGeografica(record.get(9));
        municipality.setDenominazioneRegione(record.get(10));
        municipality.setDenominazioneUnitaTerritorialeSovracomunale(record.get(11));
        municipality.setTipologiaUnitaTerritorialeSovracomunale(Integer.valueOf(record.get(12)));
        municipality.setCapoluogo(Integer.parseInt(record.get(13)) != 0);
        municipality.setSiglaAutomobilistica(record.get(14));
        municipality.setCodiceComuneNumerico(Integer.valueOf(record.get(15)));
        municipality.setCodiceComuneNumerico110Province(Integer.valueOf(record.get(16)));
        municipality.setCodiceComuneNumerico107Province(Integer.valueOf(record.get(17)));
        municipality.setCodiceComuneNumerico103Province(Integer.valueOf(record.get(18)));
        municipality.setCodiceCatastale(record.get(19));
        municipality.setCodiceNUTS1_2010(record.get(20));
        municipality.setCodiceNUTS2_2010(record.get(21));
        municipality.setCodiceNUTS3_2010(record.get(22));
        municipality.setCodiceNUTS1_2021(record.get(23));
        municipality.setCodiceNUTS2_2021(record.get(24));
        municipality.setCodiceNUTS3_2021(record.get(25));
        ret.add(municipality);
      }
      return ret;
    } catch (IOException e) {
      log.error("Error while reading data from Elenco-comuni-italiani", e);
    }
    return Collections.emptyList();
  }
}