package com.volkyxjean.formulario;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Confirmar_datos extends AppCompatActivity
{
    TextView tvnombre,tvfecha,tvcorreo,tvtelefono,tvdescripcion;
    String nombre,telefono, fecha_de_nacimiento,correo,descripcion;
    Button editarbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmar_datos);

        tvnombre = (TextView) findViewById(R.id.TVNombre);
        tvfecha = (TextView) findViewById(R.id.TVFechaNacimiento);
        tvcorreo = (TextView)findViewById(R.id.TVEmail);
        tvtelefono =(TextView) findViewById(R.id.TVTelefono);
        tvdescripcion = (TextView) findViewById(R.id.TVDescripcion);
        editarbtn = findViewById(R.id.editarbtn);
        ConfirmarDatos();

        editarbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(Confirmar_datos.this,MainActivity.class);
                intent.putExtra("nombre",nombre);
                intent.putExtra("telefono",telefono);
                intent.putExtra("fecha de nacimiento",fecha_de_nacimiento);
                intent.putExtra("correo",correo);
                intent.putExtra("descripcion",descripcion);
                startActivity(intent);
            }
        });


    }
    private void ConfirmarDatos()
    {
        Bundle datos = getIntent().getExtras();
        nombre = datos.getString("nombre");
        telefono = datos.getString("telefono");
        fecha_de_nacimiento = datos.getString("fecha de nacimiento");
        correo = datos.getString("correo");
        descripcion = datos.getString("descripcion");

        tvnombre.setText(nombre);
        tvfecha.setText(fecha_de_nacimiento);
        tvtelefono.setText(telefono);
        tvcorreo.setText(correo);
        tvdescripcion.setText(descripcion);
    }
}