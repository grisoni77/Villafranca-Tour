package com.example.android.villa;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Questa classe è l'adapter che permette di mappare
 * le proprietà della classe Contatto sul layout list_item
 * utilizzaot per ogni riga della ListView della sottopagina
 * Indirizzi utili
 */
public class ContattoAdapter extends ArrayAdapter<Contatto> {

    private final Context context;
    private final Contatto[] values;

    /**
     * Costruttore
     *
     * @param context il contesto (nel nostro caso la MainActivity)
     * @param values l'array contenente gli oggeti Contatto che popolano la ListView
     */
    public ContattoAdapter(Context context, Contatto[] values) {
        super(context, -1, values);
        this.context = context;
        this.values = values;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        // Inflate il layout list_item nell'oggetto rowView
        LinearLayout rowView = (LinearLayout) inflater.inflate(R.layout.list_item, parent, false);
        // Cerca le viste da valorizzare nel layout list_item
        ImageView imageView = (ImageView) rowView.findViewById(R.id.icon);
        TextView nomeView = (TextView) rowView.findViewById(R.id.nome);
        TextView addressView = (TextView) rowView.findViewById(R.id.address);
        // crea una variabile locale per comodità
        final Contatto value = values[position];
        // altezza della riga (varia a seconda dei campi valorizzati in contatto)
        int rowHeight = 0;
        // Popola i campi testo e src delle TextView e ImageView di list_item
        // con i valori contenuti nell'oggetto Contatto
        imageView.setImageResource(value.icon);
        nomeView.setText(value.nome);
        addressView.setText(value.address);
        // aggiorno altezza
        rowHeight += imageView.getMeasuredHeight() + nomeView.getMeasuredHeight() + addressView.getMeasuredHeight();
        // Alcuni campi sono opzionali per cui popolo e mostro le rispettive view solo se sono valorizzati
        if (value.telefono != null) {
            TextView phoneView = (TextView) rowView.findViewById(R.id.telefono);
            phoneView.setText("Telefono: " + value.telefono);
            phoneView.setVisibility(View.VISIBLE);
            ImageView phoneIcon = (ImageView) rowView.findViewById(R.id.icon_phone);
            phoneIcon.setVisibility(View.VISIBLE);
            rowHeight += phoneView.getMeasuredHeight();
            // Set click Listener sull'icona in modo che faccia una chiamata telefonica al numero del contatto
            phoneIcon.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(Intent.ACTION_DIAL);
                    intent.setData(Uri.parse("tel:" + value.telefono));
                    if (intent.resolveActivity(context.getPackageManager()) != null) {
                        context.startActivity(intent);
                    }
                }
            });
        }
        // Alcuni campi sono opzionali per cui popolo e mostro le rispettive view solo se sono valorizzati
        if (value.email != null) {
            TextView emailView = (TextView) rowView.findViewById(R.id.email);
            emailView.setText("E-mail: "+value.email);
            emailView.setVisibility(View.VISIBLE);
            ImageView emailIcon = (ImageView) rowView.findViewById(R.id.icon_email);
            emailIcon.setVisibility(View.VISIBLE);
            rowHeight += emailView.getMeasuredHeight();
            // Set click Listener sull'icona in modo che mandi un Intent per mandare un email
            emailIcon.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(Intent.ACTION_SENDTO);
                    intent.setData(Uri.parse("mailto:" + value.email));
                    if (intent.resolveActivity(context.getPackageManager()) != null) {
                        context.startActivity(intent);
                    }
                }
            });
        }
        //
        ViewGroup.LayoutParams params = rowView.getLayoutParams();
        params.height = rowHeight;
        rowView.setLayoutParams(params);
        return rowView;
    }
}
