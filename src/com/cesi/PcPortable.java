package com.cesi;

import java.math.BigDecimal;

public class PcPortable {
    private int id;
    private BigDecimal prix;
    private String couleur;
    private String marque;
    private int stock;
    private int ram;
    private String cpu;

    public PcPortable() {
    }

    public PcPortable(int id, BigDecimal prix, String couleur, String marque, int stock, int ram, String cpu) {
        this.id = id;
        this.prix = prix;
        this.couleur = couleur;
        this.marque = marque;
        this.stock = stock;
        this.ram = ram;
        this.cpu = cpu;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public BigDecimal getPrix() {
        return prix;
    }

    public void setPrix(BigDecimal prix) {
        this.prix = prix;
    }

    public String getCouleur() {
        return couleur;
    }

    public void setCouleur(String couleur) {
        this.couleur = couleur;
    }

    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public String getCpu() {
        return cpu;
    }

    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    public  void increaseStock() {
        this.setStock(this.getStock()+1);
    }

    public  void decreaseStock() {
        this.setStock(this.getStock() - 1);
    }

    protected void finalize() throws Throwable {

    }
}
