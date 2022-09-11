package com.github.al3xzx.italian_municipalities.repository;

import com.github.al3xzx.italian_municipalities.entity.Municipality;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface MunicipalityRepository extends JpaRepository<Municipality, Integer> {

  @Query("SELECT DISTINCT m.denominazioneRegione FROM Municipality m")
  List<String> findRegions();

  @Query("SELECT DISTINCT m.denominazioneItaliana FROM Municipality m")
  List<String> findMunicipalities();

  @Query("SELECT DISTINCT m.denominazioneUnitaTerritorialeSovracomunale " +
      "FROM Municipality m " +
      "GROUP BY m.denominazioneUnitaTerritorialeSovracomunale")
  Set<String> findProvinces();

  @Query("SELECT DISTINCT m.denominazioneUnitaTerritorialeSovracomunale " +
      "FROM Municipality m " +
      "WHERE lower(m.denominazioneRegione) like lower(concat('%', ?1,'%'))" +
      "GROUP BY m.denominazioneUnitaTerritorialeSovracomunale")
  List<String> findProvincesByRegion(String region);

  List<Municipality> findAllBySiglaAutomobilistica(String sigla);

  @Query("SELECT DISTINCT m.denominazioneItaliana " +
      "FROM Municipality m " +
      "WHERE lower(m.denominazioneRegione) like lower(concat('%', ?1,'%'))")
  List<String> findAllMunicipalitiesByRegion(String region);

  @Query("SELECT DISTINCT m.siglaAutomobilistica FROM Municipality m")
  List<String> findAllAutoAbbreviation();
}
