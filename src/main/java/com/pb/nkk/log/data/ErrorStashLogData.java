package com.pb.nkk.log.data;

import com.google.gson.annotations.SerializedName;

/**
 * Created by anatoliy on 09.04.2015.
 * сообщение об ошибке
 */
public class ErrorStashLogData extends StashLogData<ErrorStashLogData> {

    @SerializedName("ERRCODE")
    private String errCode;
    @SerializedName("ERRTEXT")
    private String errText;
    @SerializedName("STACKTRACE")
    private String stackTrace;

    public ErrorStashLogData() {
        super("ERROR");
    }

    /**
     * код логической или системной ошибки
     */
    public String getErrCode() {
        return errCode;
    }

    /**
     * код логической или системной ошибки
     */
    public ErrorStashLogData setErrCode(String errCode) {
        this.errCode = errCode;
        return this;
    }

    /**
     * текст ошибки
     */
    public String getErrText() {
        return errText;
    }

    /**
     * текст ошибки
     */
    public ErrorStashLogData setErrText(String errText) {
        this.errText = errText;
        return this;
    }

    /**
     * stacktrace точки возникновения ошибки
     */
    public String getStackTrace() {
        return stackTrace;
    }

    /**
     * stacktrace точки возникновения ошибки
     */
    public ErrorStashLogData setStackTrace(String stackTrace) {
        this.stackTrace = stackTrace;
        return this;
    }

    @Override
    public String toString() {
        return "ErrorLogData{" +
                "dt='" + dt + '\'' +
                ", type='" + type + '\'' +
                ", ref='" + ref + '\'' +
                ", sid='" + sid + '\'' +
                ", login='" + login + '\'' +
                ", remoteHost='" + remoteHost + '\'' +
                ", extRef='" + extRef + '\'' +
                ", extAttr=" + extAttr +
                ", errCode='" + errCode + '\'' +
                ", errText='" + errText + '\'' +
                ", stackTrace='" + stackTrace + '\'' +
                "} ";
    }
}
