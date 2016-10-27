package com.tarea.preguntas;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.example2.tarea2.R;
import com.tarea.tarea.MainActivity;

public class Resultado extends Activity {
	
	private TextView Co, Inc, Nota, Nombre;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_resultado);
		
		Co =(TextView)findViewById(R.id.text_correctas);
		Inc =(TextView)findViewById(R.id.text_incorrectas);
		Nota =(TextView)findViewById(R.id.txt_nota);
		Nombre = (TextView)findViewById(R.id.txt_nombre);
		
		Bundle getNombre = getIntent().getExtras();
		Nombre.setText(String.valueOf("  "+getNombre.get("pasoNombre")));

		Bundle getCorrecto = getIntent().getExtras();
		Co.setText(String.valueOf(getCorrecto.get("pasoCorrecta")));
		
		Bundle getIncorrecto = getIntent().getExtras();
		Inc.setText(String.valueOf(getIncorrecto.get("pasoIncorrecta")));
		
		Bundle getCorrectas = getIntent().getExtras();
		Nota.setText(String.valueOf(getCorrectas.get("pasoCorrecta")+"/10"));
	}
	
	/*MÉTODO PARA TERMINAR EL TEST*/
	public void terminar(View v){
		Intent P1 = new Intent(this, MainActivity.class);
		startActivity(P1);
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.resultado, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
