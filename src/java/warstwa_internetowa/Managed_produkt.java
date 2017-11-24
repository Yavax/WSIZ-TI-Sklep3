/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package warstwa_internetowa;

import javax.annotation.ManagedBean;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import warstwa_biznesowa.Fasada_warstwy_biznesowej;

/**
 *
 * @author Paweł L. 6148
 */
@ManagedBean
@RequestScoped
public class Managed_produkt {

    @EJB
    private Fasada_warstwy_biznesowej fasada;
    private String nazwa;
    private String kategoria;
    private String cena;
    private String promocja;
    private String cena_brutto;
    private DataModel items;
    private int stan = 1;

    public Managed_produkt() {   
    }

    public Fasada_warstwy_biznesowej getFasada() {
        return fasada;
    }

    public void setFasada(Fasada_warstwy_biznesowej fasada) {
        this.fasada = fasada;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public String getKategoria() {
        return kategoria;
    }

    public void setKategoria(String kategoria) {
        this.kategoria = kategoria;
    }

    public String getCena() {
        return cena;
    }

    public void setCena(String cena) {
        this.cena = cena;
    }

    public String getPromocja() {
        return promocja;
    }

    public void setPromocja(String promocja) {
        this.promocja = promocja;
    }

    public String getCena_brutto() {
        return cena_brutto;
    }

    public void setCena_brutto(String cena_brutto) {
        this.cena_brutto = cena_brutto;
    }
    
    public DataModel utworz_DataModel(){
        return new ListDataModel(fasada.items());
    }

    public DataModel getItems() {
        if(items == null){
            items = utworz_DataModel();
        }
        return items;
    }

    public void setItems(DataModel items) {
        this.items = items;
    }

    public int getStan() {
        return stan;
    }

    public void setStan(int stan) {
        this.stan = stan;
    }
    
    public String dodaj_produkt(){
        String[] dane = {nazwa, kategoria, cena, promocja};
        fasada.utworz_produkt(dane);
        dane_produktu();
        return "rezultat2";
    }
    
    public void dane_produktu(){
        stan = 1;
        String[] dane= fasada.dane_produktu();
        if(dane == null){
            stan = 0;
        }else{
            nazwa=dane[0];
            kategoria = dane[1];
            cena=dane[2];
            promocja=dane[3];
            cena_brutto=dane[4];
        }
    }
}
