package com.github.al3xzx.italian_municipalities.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class Municipality {
  // Codice Regione
  private String codiceRegione;

  // Codice dell'Unità territoriale sovracomunale (valida a fini statistici)
  private String codiceUnitaTerritorialeSovracomunale;

  /**
   * Codice Provincia (Storico)(1)
   * Con l'istituzione delle Città Metropolitane il codice di provincia delle CM istituite permane al solo scopo di
   * costituire il Codice del comune.
   * Allo stesso scopo permangono i codici delle soppresse province del Friuli-Venezia Giulia (Gorizia, Trieste e Pordenone),
   * cessate secondo le modalità espresse con Legge regionale 20 dicembre 2016, n. 20 (Suppl. ord. n. 55 al B.U.R n. 50
   * del 14 dicembre 2016).
   */
  private String codiceStoricoProvincia;

  /**
   * Progressivo del Comune  E' un progressivo alfanumerico di tre caratteri assegnato ai comuni nell'ambito della
   * provincia di appartenenza. Concatenato con il codice di provincia costituisce il Codice comune
   */
  private String progressivoComune;

  // Codice Comune formato alfanumerico
  private String codiceComuneAlfanumerico;

  // Denominazione del Comune in lingua italiana e straniera
  private String denominazioneItaStraniera;

  // Denominazione del comune in italiano
  private String denominazioneItaliana;

  // Denominazione altra lingua
  private String denominazioneAltraLingua;

  // Codice Ripartizione Geografica
  private Integer codiceRipartizioneGeografica;

  // Ripartizione geografica
  private String ripartizioneGeografica;

  // Denominazione Regione
  private String denominazioneRegione;

  // Denominazione dell'Unità territoriale sovracomunale (valida a fini statistici)
  private String denominazioneUnitaTerritorialeSovracomunale;

  // Tipologia di Unità territoriale sovracomunale
  /*1=Provincia; 2=Provincia autonoma; 3=Città metropolitana; 4=Libero consorzio di comuni;
  5=Unità non amministrativa (ex- province del Friuli-Venezia Giulia)*/
  private Integer tipologiaUnitaTerritorialeSovracomunale;

  // Flag Comune capoluogo di provincia/città metropolitana/libero consorzio
  //true=Comune capoluogo; false=Comune non è capoluogo.
  private Boolean capoluogo;

  // Sigla automobilistica
  private String siglaAutomobilistica;

  // Codice Comune formato numerico
  @Id
  private Integer codiceComuneNumerico;

  // Codice Comune numerico con 110 province (dal 2010 al 2016)
  private Integer codiceComuneNumerico110Province;

  // Codice Comune numerico con 107 province (dal 2006 al 2009)
  private Integer codiceComuneNumerico107Province;

  // Codice Comune numerico con 103 province (dal 1995 al 2005)
  private Integer codiceComuneNumerico103Province;

  // Codice Catastale del comune
  private String codiceCatastale;

  // Codice NUTS1 2010
  private String codiceNUTS1_2010;

  // Codice NUTS2 2010 (3)
  private String codiceNUTS2_2010;

  // Codice NUTS3 2010
  private String codiceNUTS3_2010;

  // Codice NUTS1 2021
  private String codiceNUTS1_2021;

  // Codice NUTS2 2021 (3)
  private String codiceNUTS2_2021;

  // Codice NUTS3 2021
  private String codiceNUTS3_2021;

}
