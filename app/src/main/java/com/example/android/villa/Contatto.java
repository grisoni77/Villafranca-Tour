package com.example.android.villa;

/**
 * Created by cris on 12/04/2016.
 */
public class Contatto {
    String nome;
    String address;
    int icon;

    String telefono;
    String email;


    public Contatto(String nome, String address, int icon) {
        this.nome = nome;
        this.address = address;
        this.icon = icon;
    }

    public Contatto(String nome, String address, int icon, String telefono) {
        this.nome = nome;
        this.address = address;
        this.icon = icon;
        this.telefono = telefono;
    }

    public Contatto(String nome, String address, int icon, String telefono, String email) {
        this.nome = nome;
        this.address = address;
        this.icon = icon;
        this.telefono = telefono;
        this.email = email;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

