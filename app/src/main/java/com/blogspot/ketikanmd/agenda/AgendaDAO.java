package com.blogspot.ketikanmd.agenda;

import android.database.Cursor;

public interface AgendaDAO {
    Cursor read();

    Cursor readpenting();

    boolean create(Agenda agenda);

    boolean update(Agenda agenda);

    boolean delete(int id);

}
