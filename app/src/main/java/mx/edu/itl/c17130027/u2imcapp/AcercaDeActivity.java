/*------------------------------------------------------------------------------------------
:*                         TECNOLOGICO NACIONAL DE MEXICO
:*                       INSTITUTO TECNOLOGICO DE LA LAGUNA
:*                     INGENIERIA EN SISTEMAS COMPUTACIONALES
:*                             DESARROLLO EN ANDROID "A"
:*
:*                   SEMESTRE: AGO-DIC/2020    HORA: 10-11 HRS
:*
:*                     Activity que contiene la portada de la aplicación.
:*
:*  Archivo     : AcercaDeActivity.java
:*  Autor       : Guadalupe Nury Galván García     17130027
:*  Fecha       : 19/oct/2020
:*  Compilador  : Android Studio 4.0.1
:*  Descripci�n : Este Main Activity, manda llamar el layout "activity_acercade", que  contiene
                   la portada de la práctica con los datos de la institución, del alumno y el
                   nombre de la aplicación.
:*  Ultima modif:
:*  Fecha       Modific�             Motivo
:*==========================================================================================
:*  25/oct/2020 Nury Galván       Documentar código y agregar reglas de calidad.
:*------------------------------------------------------------------------------------------*/
package mx.edu.itl.c17130027.u2imcapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
//--------------------------------------------------------------------------------------------------
public class AcercaDeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acercade);
    }
}
//--------------------------------------------------------------------------------------------------