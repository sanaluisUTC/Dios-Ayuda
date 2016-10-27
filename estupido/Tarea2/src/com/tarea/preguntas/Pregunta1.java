package com.tarea.preguntas;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Chronometer.OnChronometerTickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example2.tarea2.R;

public class Pregunta1 extends Activity {

	EditText txtValor;
	Button btnContinuar;
	ListView lvLista;
	TextView txtTiempo;
	String nombre;
	private int correcto, incorrecto;
	
	String[] valores = new String[] { "1) Cobol", "2) Linux", "3) Windows Xp" };

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_pregunta1);

		
		/*****************************
		 * MAPEO LOS DATOS
		 ****************************/
		lvLista = (ListView) findViewById(R.id.lista);
		btnContinuar = (Button) findViewById(R.id.btn_siguiente);

		
		/*************************************
		 * RECIBIENDO DATOS
		 *************************************/
		Bundle getNombre = getIntent().getExtras();
		nombre = getNombre.getString("pasoNombre");
		
		
		/****************************************************
		 * LISTA DE OPCIONES PARA LAS RESPUESTAS DEL TEST
		 ****************************************************/
		ArrayAdapter<String> adapter = new ArrayAdapter<String>
		(this,android.R.layout.simple_list_item_1, android.R.id.text1,valores);
		lvLista.setAdapter(adapter);
		
		
		/*********************************************************
		 *SELECCIONAR LA RESPUESTA AL DAR CLIK EN EL ITEM
		 *********************************************************/
		lvLista.setOnItemClickListener(new OnItemClickListener() {
			public void onItemClick(AdapterView<?> parent, View view,int posicion, long id) {
				Toast.makeText(
						getApplicationContext(),
						"Ha seleccionado " + valores[posicion],Toast.LENGTH_SHORT).show();
				if (posicion == 0) {
					correcto = correcto + 1;
				} else if (posicion == 1) {
					incorrecto = incorrecto + 1;
				} else if (posicion == 2) {
					incorrecto = incorrecto + 1;
				}
			}	
		});
	}
	
	/*************************************
	 * CONTINUAR Y PASAR LOS DATOS
	**************************************/
	public void continuar(View v) {
		String c = String.valueOf(correcto);
		String i = String.valueOf(incorrecto);
		String n = String.valueOf(nombre);	
		Intent P1 = new Intent(this, Pregunta2.class);
		P1.putExtra("pasoCorrecta", c);
		P1.putExtra("pasoIncorrecta", i);
		P1.putExtra("pasoNombre", n);
		startActivity(P1);
	}

	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.pregunta1, menu);
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
