package fr.wildcodeschool.roomreservation;

import android.provider.BaseColumns;

/**
 * Created by wilder on 03/04/18.
 */

public class DbContract {

    public static class PersonEntry implements BaseColumns {
        public static final String TABLE_NAME = "Person";
        public static final String COLUMN_NAME_LASTNAME = "lastname";
        public static final String COLUMN_NAME_FIRSTNAME = "firstname";
    }

    public static class RoomEntry implements BaseColumns {
        public static final String TABLE_NAME = "Room";
        public static final String COLUMN_NAME_ROOM = "name";

    }

}
