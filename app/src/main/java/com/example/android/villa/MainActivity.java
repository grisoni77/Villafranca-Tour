package com.example.android.villa;

import android.animation.ValueAnimator;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.BounceInterpolator;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class MainActivity extends ActionBarActivity {

    /**
     * Tiene traccia della pagina mostrata.
     * Ad ogni cambio pagina viene valorizzato con l'id della nuova pagina
     */
    int currentPage;

    /**
     * Array di contatti per la ListView "Indirizzi utili"
     */
    private Contatto[] contatti;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // inizializza la pagina corrente alla mainPage
        currentPage = R.id.mainPage;
        // inizializza contatti
        contatti = new Contatto[] {
                new Contatto(getString(R.string.comune), "Via Roma, 50", R.drawable.ic_city_hall,
                        "(+39)0141943071", "info@comune.villafrancadasti.at.it", "http://www.comune.villafrancadasti.at.it"),
                new Contatto(getString(R.string.villamed), "Via Roma, 62", R.drawable.ic_hospital_2, "(+39)0141941049"),
                new Contatto(getString(R.string.farmacia), "Via Roma 70", R.drawable.ic_hospital, "(+39)0141943081"),
                new Contatto(getString(R.string.carabinieri), "Regione Pieve, 3", R.drawable.ic_police_station, "(+39)0141942433"),
                new Contatto(getString(R.string.postoffice), "Piazza Marconi, 47", R.drawable.ic_post_office, "(+39)0141943069"),
                new Contatto(getString(R.string.railway), "Piazza Luigi Capriolo, 1", R.drawable.ic_city_railway_station, null),
                new Contatto(getString(R.string.comune_demo), "Via Roma, 50", R.drawable.ic_city_hall, "(+39)0141943071"),
                new Contatto(getString(R.string.comunu_sociali), "Via Roma, 50", R.drawable.ic_city_hall, "(+39)0141943071"),
                new Contatto(getString(R.string.comune_commercio), "Via Roma, 50", R.drawable.ic_city_hall, "(+39)0141943885"),
                new Contatto(getString(R.string.comune_tributi), "Via Roma, 50", R.drawable.ic_city_hall, "(+39)0141943071"),
                new Contatto(getString(R.string.comune_tecnico), "Via Roma, 50", R.drawable.ic_city_hall, "(+39)0141943885"),
        };
        // Inizializza ListView con i contatti
        final ListView contattiList = (ListView) findViewById(R.id.listView1);
        final ContattoAdapter adapter = new ContattoAdapter(this, contatti);
        contattiList.setAdapter(adapter);
    }

    /**
     * Router per il menu. Apre la sottopagina richiesta dall'utente
     * @param view
     */
    public void goToPage(View view)
    {
        int id = view.getId();

        // in base all'id della view apro una specifica sottopagina
        if (id == R.id.itemButton1) {
            goToSubPage(R.id.subpage1);
        }
        else if (id == R.id.itemButton2) {
            goToSubPage(R.id.subpage2);
        }
        else if (id == R.id.itemButton3) {
            goToSubPage(R.id.subpage3);
        }
        else if (id == R.id.itemButton4) {
            goToSubPage(R.id.subpage4);
        }
        else if (id == R.id.itemButton5) {
            goToSubPage(R.id.subpage5);
        }
    }

    /**
     * Passa dalla main page (con menu attivo) a una sottopagina
     * @param page
     */
    private void goToSubPage(int page)
    {
        hideMenuPage();
        currentPage = page;
        showSubPage(page);
    }

    /**
     * Passa da una sotto pagina al menu
     * @param view
     */
    public void goToMenuPage(View view)
    {
        hideSubPage(currentPage);
        currentPage = R.id.menuPage;
        showMenuPage();
    }

    /**
     * Passa dal menu alla main page
     * @param view
     */
    public void goToMainPage(View view)
    {
        hideMenuPage();
        currentPage = R.id.mainPage;
        showMainPage();
    }

    /**
     * Passa alla menuPage facendo muovere il menu dal basso verso l'alto
     * @param view
     */
    public void startTour(View view)
    {
        hideMainPage();
        currentPage = R.id.menuPage;
        showMenuPage();

        // Implementa una semplice animazione che fa scorrere il menu dal basso verso l'alto
        final LinearLayout menuView = (LinearLayout) findViewById(R.id.mainMenu);
        final RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) menuView.getLayoutParams();
        ValueAnimator animator = ValueAnimator.ofInt(params.bottomMargin, 0);
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                params.bottomMargin = (Integer) valueAnimator.getAnimatedValue();
                menuView.requestLayout();
            }
        });
//        animator.setInterpolator(new BounceInterpolator());
        animator.setDuration(500);
        animator.start();
    }

    /**
     * Nasconde la mainPage
     */
    private void hideMainPage()
    {
        RelativeLayout view = (RelativeLayout) findViewById(R.id.mainPage);
        view.setVisibility(View.GONE);
    }

    /**
     * Mostra la MainPage
     */
    private void showMainPage()
    {
        RelativeLayout view = (RelativeLayout) findViewById(R.id.mainPage);
        view.setVisibility(View.VISIBLE);
    }

    /**
     * Nasconde la menuPage
     */
    private void hideMenuPage()
    {
        RelativeLayout view = (RelativeLayout) findViewById(R.id.menuPage);
        view.setVisibility(View.GONE);
    }

    /**
     * Mostra la menuPage
     */
    private void showMenuPage()
    {
        RelativeLayout view = (RelativeLayout) findViewById(R.id.menuPage);
        view.setVisibility(View.VISIBLE);
    }

    /**
     * Nasconde la subPage con id page
     *
     * @param page id della subPage
     */
    private void hideSubPage(int page)
    {
        LinearLayout view = (LinearLayout) findViewById(page);
        view.setVisibility(View.GONE);
    }

    /**
     * Mostra la subPage con id page
     *
     * @param page id della subPage
     */
    private void showSubPage(int page)
    {
        LinearLayout view = (LinearLayout) findViewById(page);
        view.setVisibility(View.VISIBLE);
    }


    /**
     * Apre la mappa lanciando un intent a Google maps
     *
     * @param view
     */
    public void openMap(View view)
    {
        // Create a Uri from an intent string. Use the result to create an Intent.
        Uri gmmIntentUri = Uri.parse("geo:44.912778,8.032778?z=13");
        // Create an Intent from gmmIntentUri. Set the action to ACTION_VIEW
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
        // Make the Intent explicit by setting the Google Maps package
        mapIntent.setPackage("com.google.android.apps.maps");
        // Attempt to start an activity that can handle the Intent
        if (mapIntent.resolveActivity(getPackageManager()) != null) {
            startActivity(mapIntent);
        } else {
            Toast.makeText(MainActivity.this, R.string.noMapsAvailable, Toast.LENGTH_SHORT).show();
        }
    }

}
