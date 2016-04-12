package com.example.android.villa;

/**
 * Questa classe descrive un oggetto di tipo Contatto.
 * Ogni oggetto di tipo Contatto è mappato su una singola
 * riga della ListView utilizzata nella sottopagina "Indirizzi utili"
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

