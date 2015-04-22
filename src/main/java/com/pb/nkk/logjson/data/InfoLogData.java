package com.pb.nkk.logjson.data;

/**
 * Created by anatoliy on 09.04.2015.
 * информационное сообщение
 */
public class InfoLogData extends LogData{
    public InfoLogData() {
        super("INFO");
    }

    @Override
    public String toString() {
        return "InfoLogData{} " + super.toString();
    }
}
