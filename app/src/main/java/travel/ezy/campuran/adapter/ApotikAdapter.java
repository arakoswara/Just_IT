package travel.ezy.campuran.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import travel.ezy.campuran.ApotikResponse;
import travel.ezy.campuran.Main2Activity;
import travel.ezy.campuran.R;

public class ApotikAdapter extends BaseAdapter {

    private LayoutInflater inflater;
    private List<ApotikResponse.Message> data;

    public ApotikAdapter(List<ApotikResponse.Message> data, Main2Activity context)
    {
        this.inflater = LayoutInflater.from(context);
        this.data = data;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position){
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        ListItemHolder holder;
        if (view == null)
        {
            holder = new ListItemHolder();
            view = inflater.inflate(R.layout.test, null);
            holder.nama = (TextView) view.findViewById(R.id.nama);
            holder.angka = (TextView) view.findViewById(R.id.angka);

            view.setTag(holder);
        }
        else
        {
            holder = (ListItemHolder) view.getTag();
        }

        holder.angka.setText(data.get(position).address);
        holder.nama.setText(data.get(position).name);

        return view;
    }

    class ListItemHolder
    {
        TextView nama, angka;
    }

    public void sortApotik()
    {
        Comparator<ApotikResponse.Message> comparator = new Comparator<ApotikResponse.Message>() {
            @Override
            public int compare(ApotikResponse.Message message, ApotikResponse.Message t1) {
                return message.name.compareTo(t1.name);
            }
        };
        Collections.sort(data, comparator);
    }
}
