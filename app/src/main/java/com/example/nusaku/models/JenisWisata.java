package com.example.nusaku.models;

//Gunung, Pantai, CagarAlam, Museum, dll
public class JenisWisata {
    private String nama;
    private int image;

    public JenisWisata(String nama, int image) {
        this.nama = nama;
        this.image = image;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
