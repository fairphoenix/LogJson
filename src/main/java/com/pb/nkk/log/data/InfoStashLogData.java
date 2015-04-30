package com.pb.nkk.log.data;

/**
 * Created by anatoliy on 09.04.2015.
 * информационное сообщение
 */
public class InfoStashLogData extends StashLogData<InfoStashLogData> {
    public InfoStashLogData() {
        super("INFO");
    }

    @Override
    public String toString() {
        return "InfoLogData{" +
                "dt='" + dt + '\'' +
                ", type='" + type + '\'' +
                ", ref='" + ref + '\'' +
                ", sid='" + sid + '\'' +
                ", login='" + login + '\'' +
                ", remoteHost='" + remoteHost + '\'' +
                ", extRef='" + extRef + '\'' +
                ", extAttr=" + extAttr +
                "} ";
    }
}
