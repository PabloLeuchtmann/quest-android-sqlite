package fr.wildcodeschool.roomreservation;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;

public class RoomListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room_list);

        ArrayList<RoomModel> roomModels = loadRoomsFromDB();

        RoomAdapter adapter = new RoomAdapter(this, 0, roomModels);
        ListView lvListRoom = findViewById(R.id.list_room);
        lvListRoom.setAdapter(adapter);
    }

    private ArrayList<RoomModel> loadRoomsFromDB() {
        ArrayList<RoomModel> roomModels = new ArrayList<>();

        // TODO : load rooms from database

        DbHelper mDbHelper = new DbHelper(RoomListActivity.this);
        SQLiteDatabase db = mDbHelper.getReadableDatabase();

        String[] projection = {
                DbContract.RoomEntry._ID,
                DbContract.RoomEntry.COLUMN_NAME_ROOM,
        };

        Cursor cursor = db.query(
                DbContract.RoomEntry.TABLE_NAME,
                projection,
                null, null, null, null, null
        );

        while (cursor.moveToNext()) {
            long id = cursor.getLong(cursor.getColumnIndexOrThrow(DbContract.RoomEntry._ID));
            String name = cursor.getString(cursor.getColumnIndexOrThrow(DbContract.RoomEntry.COLUMN_NAME_ROOM));


            RoomModel roomModel = new RoomModel(id,name);
            roomModels.add(roomModel);
        }
        cursor.close();

        return roomModels;
    }
}
