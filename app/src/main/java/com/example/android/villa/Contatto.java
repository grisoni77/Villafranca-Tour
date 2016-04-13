package com.example.android.villa;

/**
 * Questa classe descrive un oggetto di tipo Contatto.
 * Ogni oggetto di tipo Contatto è mappato su una singola
 * riga della ListView utilizzata nella sottopagina "Indirizzi utili"
 */
public class Contatto {

    // proprietà del contatto
    String nome;
    String address;
    int icon;
    String telefono;
    String email;
    String website;


    /**
     * Primo costruttore (si tel, no mail)
     *
     * @param nome
     * @param address
     * @param icon
     * @param telefono
     */
    public Contatto(String nome, String address, int icon, String telefono) {
        this.nome = nome;
        this.address = address;
        this.icon = icon;
        this.telefono = telefono;
    }

    /**
     * Secondo costruttore (include anche email e website)
     *
     * @param nome
     * @param address
     * @param icon
     * @param telefono
     * @param email
     */
    public Contatto(String nome, String address, int icon, String telefono, String email, String website) {
        this.nome = nome;
        this.address = address;
        this.icon = icon;
        this.telefono = telefono;
        this.email = email;
        this.website = website;
    }
}

