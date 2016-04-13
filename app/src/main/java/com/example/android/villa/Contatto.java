package com.example.android.villa;

/**
 * Questa classe descrive un oggetto di tipo Contatto.
 * Ogni oggetto di tipo Contatto è mappato su una singola
 * riga della ListView utilizzata nella sottopagina "Indirizzi utili"
 */
public class Contatto {

    // proprietà obbligatorie
    String nome;
    String address;
    int icon;

    // queste proprietà sono opzionali
    String telefono;
    String email;

    /**
     * Primo costruttore (no tel, no mail)
     *
     * @param nome
     * @param address
     * @param icon
     */
    public Contatto(String nome, String address, int icon) {
        this.nome = nome;
        this.address = address;
        this.icon = icon;
    }

    /**
     * Secondo costruttore (si tel, no mail)
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
     * Terzo costruttore (si tel, si mail)
     *
     * @param nome
     * @param address
     * @param icon
     * @param telefono
     * @param email
     */
    public Contatto(String nome, String address, int icon, String telefono, String email) {
        this.nome = nome;
        this.address = address;
        this.icon = icon;
        this.telefono = telefono;
        this.email = email;
    }

}

