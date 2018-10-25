/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

/**
 *
 * @author ANDRES
 */
public class Paciente {
    String dni_pac;
    String nom_pac;
    String ape_pac;
    String dir_pac;
    String sex_pac;
    String tel_pac;
    String estci_pac;
    String Nhistmed_pac;
    String fechanac_pac;
    String seg_pac;

    public Paciente() {
    }

    public Paciente(String dni_pac, String nom_pac, String ape_pac, String dir_pac, String sex_pac, String tel_pac, String estci_pac, String Nhistmed_pac, String fechanac_pac, String seg_pac) {
        this.dni_pac = dni_pac;
        this.nom_pac = nom_pac;
        this.ape_pac = ape_pac;
        this.dir_pac = dir_pac;
        this.sex_pac = sex_pac;
        this.tel_pac = tel_pac;
        this.estci_pac = estci_pac;
        this.Nhistmed_pac = Nhistmed_pac;
        this.fechanac_pac = fechanac_pac;
        this.seg_pac = seg_pac;
    }

    public String getDni_pac() {
        return dni_pac;
    }

    public void setDni_pac(String dni_pac) {
        this.dni_pac = dni_pac;
    }

    public String getNom_pac() {
        return nom_pac;
    }

    public void setNom_pac(String nom_pac) {
        this.nom_pac = nom_pac;
    }

    public String getApe_pac() {
        return ape_pac;
    }

    public void setApe_pac(String ape_pac) {
        this.ape_pac = ape_pac;
    }

    public String getDir_pac() {
        return dir_pac;
    }

    public void setDir_pac(String dir_pac) {
        this.dir_pac = dir_pac;
    }

    public String getSex_pac() {
        return sex_pac;
    }

    public void setSex_pac(String sex_pac) {
        this.sex_pac = sex_pac;
    }

    public String getTel_pac() {
        return tel_pac;
    }

    public void setTel_pac(String tel_pac) {
        this.tel_pac = tel_pac;
    }

    public String getEstci_pac() {
        return estci_pac;
    }

    public void setEstci_pac(String estci_pac) {
        this.estci_pac = estci_pac;
    }

    public String getNhistmed_pac() {
        return Nhistmed_pac;
    }

    public void setNhistmed_pac(String Nhistmed_pac) {
        this.Nhistmed_pac = Nhistmed_pac;
    }

    public String getFechanac_pac() {
        return fechanac_pac;
    }

    public void setFechanac_pac(String fechanac_pac) {
        this.fechanac_pac = fechanac_pac;
    }

    public String getSeg_pac() {
        return seg_pac;
    }

    public void setSeg_pac(String seg_pac) {
        this.seg_pac = seg_pac;
    }
    
}
