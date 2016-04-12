package com.example.android.villa;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by cris on 12/04/2016.
 */
public class ContattoAdapter extends ArrayAdapter<Contatto> {

    private final Context context;
    private final Contatto[] values;

    public ContattoAdapter(Context context, Contatto[] values) {
        super(context, -1, values);
        this.context = context;
        this.values = values;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        LinearLayout rowView = (LinearLayout) inflater.inflate(R.layout.list_item, parent, false);
        ImageView imageView = (ImageView) rowView.findViewById(R.id.icon);
        TextView nomeView = (TextView) rowView.findViewById(R.id.nome);
        TextView addressView = (TextView) rowView.findViewById(R.id.address);
        Contatto value = values[position];
        imageView.setImageResource(value.icon);
        nomeView.setText(value.nome);
        addressView.setText(value.address);
        if (value.telefono != null) {
            TextView phoneView = (TextView) rowView.findViewById(R.id.telefono);
            phoneView.setText("Telefono: "+value.telefono);
            phoneView.setVisibility(View.VISIBLE);
            ImageView phoneIcon = (ImageView) rowView.findViewById(R.id.icon_phone);
            phoneIcon.setVisibility(View.VISIBLE);
        }
        if (value.email != null) {
            TextView emailView = (TextView) rowView.findViewById(R.id.email);
            emailView.setText("E-mail: "+value.email);
            emailView.setVisibility(View.VISIBLE);
            ImageView emailIcon = (ImageView) rowView.findViewById(R.id.icon_email);
            emailIcon.setVisibility(View.VISIBLE);
        }
        ViewGroup.LayoutParams params = rowView.getLayoutParams();
        params.height = 200;
        rowView.setLayoutParams(params);
        return rowView;
    }
}
