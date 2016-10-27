package com.tarea.tarea;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import com.example2.tarea2.R;
import com.tarea.preguntas.Pregunta1;

public class MainActivity extends Activity {

	EditText txtNombre;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		txtNombre = (EditText) findViewById(R.id.txt_nombre);
	}

	/******************
	 * METODO EMPEZAR
	******************/
	public void empezar(View v) {
		String n = txtNombre.getText().toString();
		Intent I = new Intent(this, Pregunta1.class);	
		I.putExtra("pasoNombre", n);
		startActivity(I);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
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
