package com.example.poojajoshi.assignment_12_4;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.Toast;

public class CustomAdapter extends BaseAdapter{
    String [] names;
    String [] phoneNumbers;
    String [] birthDates;

    Context context;
    private static LayoutInflater inflater=null;

    // Create Custom Adapter
    public CustomAdapter(MainActivity mainActivity, String[] prgmNameList, String[] prgmPhoneNumbers, String[] prgmBdates) {
        // TODO Auto-generated constructor stub

        context = mainActivity;
        names = prgmNameList;
        context = mainActivity;
        phoneNumbers = prgmPhoneNumbers;
        birthDates = prgmBdates;
        inflater = ( LayoutInflater )context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return names.length;
    }

    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    public class Holder
    {
        TextView textView_name;
        TextView textView_phoneNo;
        TextView textView_birthDate;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        // Create the each Row Item and fill with the name and number list

        Holder holder=new Holder();
        View rowView;
        rowView = inflater.inflate(R.layout.list_item, null);
        rowView.setMinimumHeight(200);
        rowView.setPadding(20, 5, 20, 5);

        holder.textView_name=(TextView) rowView.findViewById(R.id.textView);
        holder.textView_phoneNo=(TextView) rowView.findViewById(R.id.textView2);
        holder.textView_birthDate= (TextView) rowView.findViewById(R.id.textView3);

        holder.textView_name.setText(names[position]);
        holder.textView_phoneNo.setText(phoneNumbers[position]);
        holder.textView_birthDate.setText(birthDates[position]);

        return rowView;
    }
}
