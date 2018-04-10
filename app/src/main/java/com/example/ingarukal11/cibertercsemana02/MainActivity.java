package com.example.ingarukal11.cibertercsemana02;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {

    EditText txtCodigo;
    RadioGroup rgCursos;
    CheckBox chkDescuento1, chkDescuento2;
    Button btnCalcular;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtCodigo = (EditText)findViewById(R.id.txtCodigo);
        rgCursos = (RadioGroup)findViewById(R.id.rgCursos);
        chkDescuento1 = (CheckBox)findViewById(R.id.chkDescuento1);
        chkDescuento2 = (CheckBox)findViewById(R.id.chkDescuento2);
        btnCalcular = (Button)findViewById(R.id.btnCalcular);

        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double precio;
                String curso;

                if (rgCursos.getCheckedRadioButtonId() == R.id.rbJava){
                    precio = 600;
                    curso = "Java";
                }else if (rgCursos.getCheckedRadioButtonId() == R.id.rbNet){
                    precio = 700;
                    curso = "C# .NET";
                }else{
                    precio = 500;
                    curso = "Node JS";
                }

                double descuento1, descuento2, descuentoFinal;

                if(chkDescuento1.isChecked()){
                    descuento1 = precio * 0.05;
                }else{
                    descuento1 = 0;
                }

                if(chkDescuento2.isChecked()){
                    descuento2 = precio * 0.1;
                }else{
                    descuento2 = 0;
                }

                descuentoFinal = descuento1 + descuento2;

                double total = precio - descuentoFinal;
                String codigo = txtCodigo.getText().toString();

                //Enviar a otra pantalla
                Intent i = new Intent(getApplicationContext(), ClaseDetalle.class);

                i.putExtra("codigo", codigo);
                i.putExtra("curso", curso);
                i.putExtra("precio", precio);
                i.putExtra("descuento", descuentoFinal);
                i.putExtra("total", total);

                startActivity(i);

            }
        });

    }
}
