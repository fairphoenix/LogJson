package com.pb.nkk.log.data;

/**
 * Created by anatoliy on 09.04.2015.
 * Отладочная информация
 */
public class DebugStashLogData extends StashLogData<DebugStashLogData> {

    public DebugStashLogData() {
        super("DEBUG");
    }

    @Override
    public String toString() {
        return "DebugStashLogData{" +
                "dt='" + dt + '\'' +
                ", type='" + type + '\'' +
                ", ref='" + ref + '\'' +
                ", sid='" + sid + '\'' +
                ", login='" + login + '\'' +
                ", remoteHost='" + remoteHost + '\'' +
                ", extRef='" + extRef + '\'' +
                ", extAttr=" + extAttr +
                "}";
    }
}
