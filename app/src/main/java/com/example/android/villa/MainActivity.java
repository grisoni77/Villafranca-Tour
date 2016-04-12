package com.example.android.villa;

import android.animation.ValueAnimator;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.BounceInterpolator;
import android.view.animation.Transformation;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends ActionBarActivity {

    /**
     * Tiene traccia della pagina mostrata.
     * Ad ogni cambio pagina viene valorizzato con l'id della nuova pagina
     */
    int currentPage;

    /**
     * Array di contatti per la ListView "Indirizzi utili"
     */
    private Contatto[] contatti = new Contatto[] {
            new Contatto("Comune", "Via Roma, 50", R.drawable.ic_location_city_black_24dp, "(+39)0141943071", "info@comune.villafrancadasti.at.it"),
            new Contatto("Medici", "Via Roma, 62", R.drawable.ic_add_box_black_24dp, "(+39)0141941049"),
            new Contatto("Farmacia", "Via Roma 70", R.drawable.ic_local_pharmacy_black_24dp, "(+39)0141943081"),
            new Contatto("Carabinieri", "Regione Pieve, 3", R.drawable.ic_pan_tool_black_24dp, "(+39)0141942433"),
            new Contatto("Stazione ferroviaria", "Piazza Luigi Capriolo, 1", R.drawable.ic_train_black_24dp),
    };
//    final ArrayList<Contatto> listp = new ArrayList<Contatto>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // inizializza la pagina corrente alla mainPage
        currentPage = R.id.mainPage;
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
        currentPage = page;
        hideMenuPage();
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

        // ANIMATES MENU
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
     * MOstra la subPage con id page
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
