package com.volkyxjean.formulario;


import android.app.Dialog;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity
{   Button boton;
    EditText ET,nombre,telefono,correo,descripcion;
    private int mYearIni,mMonthIni,mDayIni,sYearIni,sMonthIni,sDayIni;
    String nnombre,ntelefono,ncorreo,ndescripcion,nfecha_de_nacimiento;
    static final int DATE_ID = 0;
    Calendar C = Calendar.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState)
        {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
            sMonthIni = C.get(Calendar.MONTH);
            sDayIni = C.get(Calendar.DAY_OF_MONTH);
            sYearIni = C.get(Calendar.YEAR);
            ET =findViewById(R.id.etFecha_nacimiento);

            ET.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    showDialog(DATE_ID);
                }
            });

            nombre = findViewById(R.id.TINombre_Completo);
            telefono = findViewById(R.id.TITelefono);
            correo = findViewById(R.id.TIEmail);
            descripcion = findViewById(R.id.TIDescripcion_Contacto);
            boton = findViewById(R.id.button);

            Bundle parametros = getIntent().getExtras();
            nnombre = parametros.getString("nombre");
            ntelefono = parametros.getString("telefono");
            nfecha_de_nacimiento = parametros.getString("fecha de nacimiento");
            ncorreo = parametros.getString("correo");
            ndescripcion = parametros.getString("descripcion");
            nombre.setText(nnombre);
            telefono.setText(ntelefono);
            ET.setText(nfecha_de_nacimiento);
            correo.setText(ncorreo);
            descripcion.setText(ndescripcion);
            boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                String name = nombre.getText().toString();
                String telef = telefono.getText().toString();
                String corr = correo.getText().toString();
                String desc = descripcion.getText().toString();
                String nac = ET.getText().toString();

                Intent i = new Intent(MainActivity.this,Confirmar_datos.class);
                i.putExtra("nombre",name);
                i.putExtra("telefono",telef);
                i.putExtra("fecha de nacimiento",nac);
                i.putExtra("correo",corr);
                i.putExtra("descripcion",desc);
                startActivity(i);

            }
        });

        }


    private void colocar_fecha() {
        ET.setText((mMonthIni + 1) + "-" + mDayIni + "-" + mYearIni+" ");
    }



    private DatePickerDialog.OnDateSetListener mDateSetListener =
            new DatePickerDialog.OnDateSetListener() {
                public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                    mYearIni = year;
                    mMonthIni = monthOfYear;
                    mDayIni = dayOfMonth;
                    colocar_fecha();

                }

            };


    @Override
    protected Dialog onCreateDialog(int id) {
        switch (id) {
            case DATE_ID:
                return new DatePickerDialog(this, mDateSetListener, sYearIni, sMonthIni, sDayIni);


        }


        return null;
    }
}



