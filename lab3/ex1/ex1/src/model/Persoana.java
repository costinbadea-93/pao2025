package model;

import java.util.ArrayList;
import java.util.List;

//final pe clasa ca ea sa nu poata fi mostenita
public final class Persoana {
    private final String nume;
    private final int varsta;
    //facem copie -> deep copy
    private final List<CaracteristiciPersoana> caracteristici;
    //pentru obiecte folosim interfata cloanable pentu a putea clona obiectele ca si copii
    private final DetaliiLocuinta detaliiLocuinta;

    public Persoana(String nume, int varsta, List<CaracteristiciPersoana> caracteristici, DetaliiLocuinta detaliiLocuinta) {
        this.nume = nume;
        this.varsta = varsta;
        this.caracteristici = caracteristici;
        this.detaliiLocuinta = detaliiLocuinta;
    }

    public String getNume() {
        return nume;
    }

    public int getVarsta() {
        return varsta;
    }
}

class CaracteristiciPersoana {
   private List<String> caracteristici;

    public CaracteristiciPersoana(List<String> caracteristici) {
        this.caracteristici = caracteristici;
    }

    public List<String> getCaracteristici() {
        return caracteristici;
    }

    public void setCaracteristici(List<String> caracteristici) {
        this.caracteristici = caracteristici;
    }

    @Override
    public String toString() {
        return "CaracteristiciPersoana{" +
                "caracteristici=" + caracteristici +
                '}';
    }
}

class DetaliiLocuinta implements Cloneable{
    private String adresaLocuinta;


    public DetaliiLocuinta(String adresaLocuinta) {
        this.adresaLocuinta = adresaLocuinta;
    }

    public String getAdresaLocuinta() {
        return adresaLocuinta;
    }

    public void setAdresaLocuinta(String adresaLocuinta) {
        this.adresaLocuinta = adresaLocuinta;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        return "DetaliiLocuinta{" +
                "adresaLocuinta='" + adresaLocuinta + '\'' +
                '}';
    }
}
