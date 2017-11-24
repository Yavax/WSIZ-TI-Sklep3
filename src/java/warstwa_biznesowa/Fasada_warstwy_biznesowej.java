/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package warstwa_biznesowa;

import javax.ejb.Stateless;
import warstwa_biznesowa.entity.Produkt1;
/**
 *
 * @author Paweł L. 6148
 */
@Stateless
public class Fasada_warstwy_biznesowej {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    private Produkt1 produkt;

    public Produkt1 getProdukt() {
        return produkt;
    }

    public void setProdukt(Produkt1 produkt) {
        this.produkt = produkt;
    }
    
    // Tworzenie produktu
    public void utworz_produkt(String[] dane){
        produkt = new Produkt1();
        produkt.setNazwa(dane[0]);
        produkt.setKategoria(dane[1]);
        produkt.setCena(Float.parseFloat(dane[2]));
        produkt.setPromocja(Integer.parseInt(dane[3]));
    }
    
    public String[] dane_produktu() {
        String nazwa = "brak produktu";
        String kategoria = "brak produktu";
        String cena = "brak produktu";
        String promocja = "brak produktu";
        String cena_brutto = "brak produktu";
        if(produkt != null) {
            nazwa = produkt.getNazwa();
            kategoria = produkt.getKategoria();
            cena = "" + produkt.getCena();
            promocja = "" + produkt.getPromocja();
            cena_brutto = "" + produkt.cena_brutto();
        }
        String[] dane = {nazwa, kategoria, cena, promocja, cena_brutto};
        return dane;
    }
}
