package com.example.ingarukal11.cibertercsemana02;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ClaseDetalle extends AppCompatActivity {

    TextView txtCodigo, txtCurso, txtPrecio, txtDescuento, txtTotal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.vista_detalle);

        txtCodigo = (TextView)findViewById(R.id.txtCodigo);
        txtCurso = (TextView)findViewById(R.id.txtCurso);
        txtPrecio = (TextView)findViewById(R.id.txtPrecio);
        txtDescuento = (TextView)findViewById(R.id.txtDescuento);
        txtTotal = (TextView)findViewById(R.id.txtTotal);

        Bundle recupera = getIntent().getExtras();

        if (recupera != null){
            txtCodigo.setText(recupera.getString("codigo"));
            txtCurso.setText(recupera.getString("curso"));
            txtPrecio.setText("S/ " + recupera.getDouble("precio"));
            txtDescuento.setText("S/ " + recupera.getDouble("descuento"));
            txtTotal.setText("S/ " + recupera.getDouble("total"));
        }
    }
}
