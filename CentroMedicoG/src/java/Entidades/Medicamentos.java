package Entidades;


public class Medicamentos {
    int cod_meds;
    int cod_enf;
    String nom_meds;
    double preunit_meds;
    String desc_meds;
    int stock_meds;
    
    public Medicamentos() {
    }

    public Medicamentos(int cod_meds, int cod_enf, String nom_meds, double preunit_meds, String desc_meds, int stock_meds) {
        this.cod_meds = cod_meds;
        this.cod_enf = cod_enf;
        this.nom_meds = nom_meds;
        this.preunit_meds = preunit_meds;
        this.desc_meds = desc_meds;
        this.stock_meds = stock_meds;
    }

    public int getCod_meds() {
        return cod_meds;
    }

    public void setCod_meds(int cod_meds) {
        this.cod_meds = cod_meds;
    }

    public int getCod_enf() {
        return cod_enf;
    }

    public void setCod_enf(int cod_enf) {
        this.cod_enf = cod_enf;
    }

    public String getNom_meds() {
        return nom_meds;
    }

    public void setNom_meds(String nom_meds) {
        this.nom_meds = nom_meds;
    }

    public double getPreunit_meds() {
        return preunit_meds;
    }

    public void setPreunit_meds(double preunit_meds) {
        this.preunit_meds = preunit_meds;
    }

    public String getDesc_meds() {
        return desc_meds;
    }

    public void setDesc_meds(String desc_meds) {
        this.desc_meds = desc_meds;
    }

    public int getStock_meds() {
        return stock_meds;
    }

    public void setStock_meds(int stock_meds) {
        this.stock_meds = stock_meds;
    }
    
    
}
