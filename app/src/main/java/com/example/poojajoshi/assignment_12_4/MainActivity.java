package com.example.poojajoshi.assignment_12_4;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.app.Dialog;
import android.widget.EditText;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;
import android.view.LayoutInflater;
import android.app.AlertDialog;
// import android.R;

public class MainActivity extends AppCompatActivity {

    String[] nameList = {"ABC"};
    String[] phoneNumberList = {"123456789"};
    String[] dateOfBirthList = {"26/05/1985"};

    CustomAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // get the list view handle and set the custom adapter to
        ListView listview = findViewById(R.id.listView);
        adapter = new CustomAdapter(this, nameList, phoneNumberList, dateOfBirthList);
        listview.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            Toast.makeText(getApplicationContext(), "Add", Toast.LENGTH_SHORT).show();

            /*
            final Dialog dialog = new Dialog(getApplicationContext());
            dialog.setContentView(R.layout.input_dialog);
            dialog.setTitle("Enter the Details");

            // set the custom dialog components - name, phone number and date of birth
            EditText text_name = (EditText) dialog.findViewById(R.id.editText_name);
            EditText text_number = (EditText) dialog.findViewById(R.id.editText_ph);
            EditText text_dob = (EditText) dialog.findViewById(R.id.editText_dob);
            */

            LayoutInflater li = LayoutInflater.from(getApplicationContext());
            final View promptsView = li.inflate(R.layout.input_dialog, null);

            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                    MainActivity.this);

            // set prompts.xml to alertdialog builder
            alertDialogBuilder.setView(promptsView);
            alertDialogBuilder.setTitle("Enter the details");

            // create alert dialog
            final AlertDialog alertDialog = alertDialogBuilder.create();

            /*
            alertDialogBuilder.setCancelable(false)
                                .setPositiveButton("Save", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i) {
                                        // get the user Input

                                    }
                                })
                            .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    dialogInterface.cancel();
                                }
                            });
             */


            Button dialogButton = (Button) promptsView.findViewById(R.id.btn_save);

            // if button is clicked, close the custom dialog
            dialogButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    // set the custom dialog components - name, phone number and date of birth
                    final EditText text_name = (EditText) alertDialog.findViewById(R.id.editText_name);
                    final EditText text_number = (EditText) alertDialog.findViewById(R.id.editText_ph);
                    final EditText text_dob = (EditText) alertDialog.findViewById(R.id.editText_dob);

                    String name = text_name.getText().toString();
                    String phNumber = text_number.getText().toString();
                    String dob = text_dob.getText().toString();

                    // set the user entered data into list
                    nameList[(nameList.length-1)] = name;
                    phoneNumberList[(phoneNumberList.length-1)] = phNumber;
                    dateOfBirthList[(dateOfBirthList.length-1)] = dob;

                    adapter.notifyDataSetChanged();
                    alertDialog.cancel();
                }
            });

            // set onclick listener for dialog cancel button
            Button button_cancel = (Button) promptsView.findViewById(R.id.btn_cancel);
            button_cancel.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    alertDialog.dismiss();
                }
            });

            // show dialog
            alertDialog.show();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
