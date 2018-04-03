package fr.wildcodeschool.roomreservation;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class PersonCreateActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_person_create);

        Button btCreate = findViewById(R.id.button_create_person);
        btCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                EditText etFirstname = findViewById(R.id.edit_firstname);
                EditText etLastname = findViewById(R.id.edit_lastname);

                String firstname = etFirstname.getText().toString();
                String lastname = etLastname.getText().toString();

                addPersonToDB(firstname, lastname);

                Intent intent = new Intent(PersonCreateActivity.this, MainActivity.class);
                PersonCreateActivity.this.startActivity(intent);
            }
        });
    }

    private void addPersonToDB(String firstname, String lastname) {
        // TODO : add person into database
        DbHelper mDbHelper = new DbHelper(PersonCreateActivity.this);
        SQLiteDatabase db = mDbHelper.getWritableDatabase();

        ContentValues person = new ContentValues();
        person.put(DbContract.PersonEntry.COLUMN_NAME_FIRSTNAME, firstname);
        person.put(DbContract.PersonEntry.COLUMN_NAME_LASTNAME, lastname);
        long newPersonId = db.insert(DbContract.PersonEntry.TABLE_NAME, null, person);

        Toast.makeText(this, String.valueOf(newPersonId), Toast.LENGTH_SHORT).show();
    }
}
