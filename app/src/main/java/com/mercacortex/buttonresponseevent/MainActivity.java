package com.mercacortex.buttonresponseevent;

import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button btnEvent;
    private View.OnLongClickListener lstLongClick;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Se implementan los listener
        lstLongClick = new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                final Snackbar snb = Snackbar.make(view, "Mensaje con Action", Snackbar.LENGTH_INDEFINITE);
                snb.setAction("Ok", new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        // final hace accesible snb
                        // Si no usamos un objeto snb, podemos usar métodos de la actividad
                        // para cerrar la actividad
                        snb.dismiss();
                    }
                });
                snb.show();
                // Si cambio de true a false, se cierra cuando dejo de pulsar
                // A veces tenemos que acudir con super al objeto superior
                return true;
            }
        };

        // Se instancian los Widget y se registran los eventos
        btnEvent = (Button) findViewById(R.id.btnEvent);
        btnEvent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Es una barra que aparece abajo con opciones
                Snackbar.make(view, "Se ha pulsado sobre el botón", Snackbar.LENGTH_SHORT).show();
            }
        });

        // De este modo nos garantizamos que no nos hayamos olvidado en el examen
        btnEvent.setOnLongClickListener(lstLongClick);
    }
}
