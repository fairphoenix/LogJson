package com.pb.nkk.logjson.data;

/**
 * Created by anatoliy on 09.04.2015.
 * Отладочная информация
 */
public class DebugLogData extends LogData {
    public DebugLogData() {
        super("DEBUG");
    }

    @Override
    public String toString() {
        return "DebugLogData{} " + super.toString();
    }
}
