/*------------------------------------------------------------------------------------------
:*                         TECNOLOGICO NACIONAL DE MEXICO
:*                       INSTITUTO TECNOLOGICO DE LA LAGUNA
:*                     INGENIERIA EN SISTEMAS COMPUTACIONALES
:*                             DESARROLLO EN ANDROID "A"
:*
:*                   SEMESTRE: AGO-DIC/2020    HORA: 10-11 HRS
:*
:*                  Activity que muestra una pantalla de bienvenida.
:*
:*  Archivo     : SplashActivity.java
:*  Autor       : Guadalupe Nury Galván García     17130027
:*  Fecha       : 19/oct/2020
:*  Compilador  : Android Studio 4.0.1
:*  Descripci�n : Splash Activity que muestra una pantalla de bienvenida por dos segundos y luego,
                   redirecciona al MainActivity.
:*  Ultima modif:
:*  Fecha       Modific�             Motivo
:*==========================================================================================
:*  25/oct/2020 Nury Galván       Documentar código y agregar reglas de calidad.
:*------------------------------------------------------------------------------------------*/
package mx.edu.itl.c17130027.u2imcapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
//--------------------------------------------------------------------------------------------------
public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        //Despues de 2 se invocamos a MainActivity y abandonamos el splash
        new Handler ().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent( SplashActivity.this, MainActivity.class );
            startActivity ( intent );
            finish();
            }
        }, 2000 );
    }
}
//--------------------------------------------------------------------------------------------------