package com.pb.nkk.logjson.data;

import com.google.gson.annotations.SerializedName;

/**
 * Created by anatoliy on 09.04.2015.
 * сообщение об ошибке
 */
public class ErrorLogData extends LogData {

    @SerializedName("ERRCODE")
    private String errCode;
    @SerializedName("ERRTEXT")
    private String errText;
    @SerializedName("STACKTRACE")
    private String stackTrace;

    public ErrorLogData() {
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
    public void setErrCode(String errCode) {
        this.errCode = errCode;
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
    public void setErrText(String errText) {
        this.errText = errText;
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
    public void setStackTrace(String stackTrace) {
        this.stackTrace = stackTrace;
    }

    @Override
    public String toString() {
        return "ErrorLogData{" +
                "errCode='" + errCode + '\'' +
                ", errText='" + errText + '\'' +
                ", stackTrace='" + stackTrace + '\'' +
                "} " + super.toString();
    }
}
