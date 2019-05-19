package com.blogspot.ketikanmd.agenda;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.util.SortedList;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.blogspot.ketikanmd.appcatatanagenda.R;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Splashscreen extends AppCompatActivity {
    Context myContext;
    ProgressDialog progress;
    API apiHomestay;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashscreen);
//      requestWindowFeature(Window.FEATURE_NO_TITLE);
//      getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);



        myContext = getApplicationContext();
        progress = ProgressDialog.show(Splashscreen.this, "Inisialisasi Data", "Sedang Mengunduh Data Untuk Aplikasi", true);

        Callback<ResponseAgeda> hasilHomestay = new Callback<ResponseAgeda>() {
            @Override
            public void onResponse(Call<ResponseAgeda> call, Response<ResponseAgeda> response) {
                if(response.isSuccessful()){
                    List<AgendaModel> home = response.body().getList();
                    int jumlah_data = response.body().getList().size();

                    if(jumlah_data>0){
                        AgendaController agendaController = new AgendaController(myContext);
                        agendaController.open();
                        agendaController.deleteData();
                        for(int y = 0; y<jumlah_data;y++){
                            AgendaModel tmpHasil = home.get(y);
                            agendaController.insertData(tmpHasil.getId(), tmpHasil.getAgenda(), tmpHasil.getTanggal(), tmpHasil.getTempat(), tmpHasil.getKeterangan(), tmpHasil.getStatus());
//                            Toast.makeText(myContext, "Data : "+tmpHasil, Toast.LENGTH_LONG).show();
                        }
                        agendaController.close();

                        Intent intent = new Intent(myContext, TampilData.class);
                        startActivity(intent);
                        finish();
                    }else{
                        Toast.makeText(getApplicationContext(), "Data Sedang Tidak Tersedia", Toast.LENGTH_LONG).show();

                    }
                    progress.dismiss();
                }else{
                    Log.e("onResponse failure","Code : "+response.code()+", Messege : "+response.message());
                }

            }

            @Override
            public void onFailure(Call<ResponseAgeda> call, Throwable t) {
                progress.dismiss();
                Toast.makeText(getApplicationContext(), "Akses Ke server Gagal"+t.getMessage(), Toast.LENGTH_SHORT).show();
                Log.e("Kesalahan: ",t.getMessage());
            }
        };

        apiHomestay = RestClient.get();
        Call<ResponseAgeda> callHasil = apiHomestay.getHasilAgenda();
        callHasil.enqueue(hasilHomestay);
    }
}
