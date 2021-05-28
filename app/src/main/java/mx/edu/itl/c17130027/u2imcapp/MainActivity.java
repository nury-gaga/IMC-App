/*------------------------------------------------------------------------------------------
:*                         TECNOLOGICO NACIONAL DE MEXICO
:*                       INSTITUTO TECNOLOGICO DE LA LAGUNA
:*                     INGENIERIA EN SISTEMAS COMPUTACIONALES
:*                             DESARROLLO EN ANDROID "A"
:*
:*                   SEMESTRE: AGO-DIC/2020    HORA: 10-11 HRS
:*
:*                       App que muestra el índice de masa corporal.
:*
:*  Archivo     : MainActivity.java
:*  Autor       : Guadalupe Nury Galván García     17130027
:*  Fecha       : 19/oct/2020
:*  Compilador  : Android Studio 4.0.1
:*  Descripci�n : Este Main Activity, contiene los botones "calcular", donde calculamos el IMC
                   con base a la altura y peso de la persona, para determinar su condición física.
                   Y el botón "acerca de" donde mandamos llamar y mostramos el"AcercaDeActivity".
:*  Ultima modif:
:*  Fecha       Modific�             Motivo
:*==========================================================================================
:*  25/oct/2020 Nury Galván       Documentar código y agregar reglas de calidad.
:*------------------------------------------------------------------------------------------*/

package mx.edu.itl.c17130027.u2imcapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.text.DecimalFormat;
//--------------------------------------------------------------------------------------------------

public class MainActivity extends AppCompatActivity {
    private EditText edtPeso;
    private EditText edtEstatura;
//--------------------------------------------------------------------------------------------------

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Obtener las referencias a los campos del peso y la estatura
        edtPeso = findViewById ( R.id.edtPeso);
        edtEstatura = findViewById ( R.id.edtEstatura);

    }
//--------------------------------------------------------------------------------------------------

    public void btnCalcularIMCClick ( View v ) {
        float peso, estatura;
        //Validamos si se pude convertir el peso a un valor numérico
        try {
            peso = Float.parseFloat(edtPeso.getText().toString());
        }catch ( NumberFormatException ex ) {
            Toast.makeText( this, "Debe capturar un valor numérico para el peso", Toast.LENGTH_SHORT)
                    .show();
            edtPeso.requestFocus ();
            return;
        }
//--------------------------------------------------------------------------------------------------

        //Validamos si se pude convertir la estatura a un valor numérico
        try {
            estatura = Float.parseFloat(edtEstatura.getText().toString());
        }catch (NumberFormatException ex){
            Toast.makeText( this, "Debe capturar un valor numérico para la estatura", Toast.LENGTH_SHORT)
                    .show();
            edtEstatura.requestFocus ();
            return;
        }
//--------------------------------------------------------------------------------------------------

        //Calculamos el indice de masa corportal y formateamos el resultado con un decimal
        float imc = (float) ( peso / Math.pow( estatura, 2 ) );
        DecimalFormat decimalFormat = new DecimalFormat ( "#####.#" );
        String strIMC = decimalFormat.format ( imc );
//--------------------------------------------------------------------------------------------------

        //Desplegar el resultado de la IMC
        AlertDialog.Builder builder = new AlertDialog.Builder ( this );
        builder.setTitle ( "Indice de masa corporal" )
                .setMessage ( "IMC = " + strIMC + "\n" + "Condición: " + determinarCondicion (imc) )
                .setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss ();
                    }
                })
                .create()
                .show();
    }
//--------------------------------------------------------------------------------------------------

    //Implementamos el método de "determinarCondicion" para determinar por medio del indice de masa
    //corporal el estado de salud de la persona.
    public String determinarCondicion ( float imc) {
        String cond = "";
        if ( imc < 15 )
            cond += "Delgadez muy severa";
        else if ( imc >= 15 && imc < 16 )
            cond += "Delgadez severa";
        else if ( imc >= 16 && imc < 18.5 )
            cond += "Delgadez";
        else if ( imc >= 18.5 && imc < 25 )
            cond += "Peso saludable";
        else if ( imc >= 25 && imc < 30 )
            cond += "Sobrepeso";
        else if ( imc >= 30 && imc < 35 )
            cond += "Obesidad moderada";
        else if ( imc >= 35 && imc < 40 )
            cond += "Obesidad severa";
        else if ( imc >= 40 )
            cond += "Obesidad muy severa";

        return cond;
   }
//--------------------------------------------------------------------------------------------------
    //Mostramos el AcercaDeActivity
   public void btnAcercaDeClick ( View v){
        Intent intent = new Intent( this, AcercaDeActivity.class);
        startActivity( intent );
   }

}
//--------------------------------------------------------------------------------------------------