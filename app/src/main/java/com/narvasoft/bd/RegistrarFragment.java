package com.narvasoft.bd;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.JsonRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

//import com.android.volley.Response;

public class RegistrarFragment extends Fragment implements Response.Listener<JSONObject>, Response.ErrorListener {
    RequestQueue rq;
    JsonRequest jrq;
    EditText txtUser, txtPwd, txtNames;
    Button btnConsultar, btnRegistrar;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_sesion, container, false);
        View vista = inflater.inflate(R.layout.fragment_registrar, container, false);
        txtUser = (EditText) vista.findViewById(R.id.txtuser);
        txtPwd = (EditText) vista.findViewById(R.id.txtpwd);
        txtNames = (EditText) vista.findViewById(R.id.txtNombre);

        btnConsultar = (Button) vista.findViewById(R.id.btnsesion);
        btnRegistrar = (Button) vista.findViewById(R.id.btn_irRegistrar);
        rq = Volley.newRequestQueue(getContext());
        btnConsultar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                iniciarSesion();
            }
        });
        btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                registrarUsuario();
            }
        });
        return vista;
    }


    @Override
    public void onErrorResponse(VolleyError error) {
        Toast.makeText(getContext(),"No se Registró el usuario "+ error.toString() +txtUser.toString(),Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onResponse(JSONObject response) {
        Toast.makeText(getContext(),"Se Registró el usuario "+ txtUser.toString(),Toast.LENGTH_SHORT).show();
        limpiarcajas();

    }
    void limpiarcajas(){
        txtPwd.setText("");
        txtUser.setText("");
        txtNames.setText("");
    }
    void iniciarSesion(){
        SesionFragment fr=new SesionFragment();
        getActivity().getSupportFragmentManager().beginTransaction()
                .replace(R.id.escenario,fr)
                .addToBackStack(null)
                .commit();
    }

    void registrarUsuario(){
        String url ="http://192.168.1.12/login/registrar.php?names=" +txtNames.getText().toString()+"&user="+ txtUser.getText().toString() +
                "&pwd=" + txtPwd.getText().toString();
        jrq = new JsonObjectRequest(Request.Method.GET,url, (String) null,this, this);
        rq.add(jrq);
    }

}