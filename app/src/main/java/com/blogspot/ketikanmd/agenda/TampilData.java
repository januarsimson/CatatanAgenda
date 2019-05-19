package com.blogspot.ketikanmd.agenda;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.blogspot.ketikanmd.appcatatanagenda.R;

import java.util.List;

public class TampilData extends AppCompatActivity {
    ListView grdData;
    private static final class Holder{
        public TextView nama_homestay;
        public TextView alamat;
        public TextView area, jumlah_kamar, harga;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tampil_data);

        grdData = (ListView) findViewById(R.id.listagenda);

        AgendaController data = new AgendaController(this);
        data.open();
        data.getData();

        AgendaAdapter adapter= new AgendaAdapter(this, android.R.layout.simple_list_item_1, data.getData());
        grdData.setAdapter(adapter);
        data.close();
    }
    private class AgendaAdapter extends ArrayAdapter<AgendaModel> {
        private LayoutInflater minflater;
        public AgendaAdapter(@NonNull Context context, @LayoutRes int resource, @NonNull List<AgendaModel> objects) {
            super(context, resource, objects);
            minflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }
        public View getView(int position, View convertVIew, ViewGroup parent){
            View view = convertVIew;
            Holder holder;

            if(view == null){
                view = minflater.inflate(R.layout.custom_home,parent, false);
                holder = new Holder();
                holder.nama_homestay = (TextView) view.findViewById(R.id.tvTim1);
                holder.alamat = (TextView) view.findViewById(R.id.tvSkor);
                holder.area = (TextView) view.findViewById(R.id.tvTim2);
                holder.jumlah_kamar = (TextView) view.findViewById(R.id.jumlah_kamar);
                holder.harga = (TextView) view.findViewById(R.id.harga);

                view.setTag(holder);
            }else{
                holder = (Holder) view.getTag();
            }
            AgendaModel stream = getItem(position);
            holder.nama_homestay.setText(stream.getAgenda());
            holder.alamat.setText(stream.getTanggal());
            holder.area.setText(stream.getTempat());
            holder.jumlah_kamar.setText(stream.getKeterangan());
            holder.harga.setText(stream.getStatus());
            Log.e("Data : ", stream.toString());
            return view;
        }
    }
}
