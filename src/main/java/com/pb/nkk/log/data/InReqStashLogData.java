package com.pb.nkk.log.data;

import com.google.gson.annotations.SerializedName;

import java.util.Map;

/**
 * Created by anatoliy on 09.04.2015.
 * данные поступившего запроса и сформированного ответа
 */
public class InReqStashLogData extends StashLogData {

    @SerializedName("DURATION")
    private long duration;
    @SerializedName("REQUEST_URI")
    private String requestUri;
    @SerializedName("REQUEST_BODY")
    private String requestBody;
    @SerializedName("REQUEST_HEADERS")
    private Map<String, String> requestHeaders;
    @SerializedName("REQUEST_TYPE")
    private String requestType;
    @SerializedName("RESPONSE_CODE")
    private String responseCode;
    @SerializedName("RESPONSE_BODY")
    private String responseBody;
    @SerializedName("RESPONSE_HEADERS")
    private Map<String, String> responseHeaders;
    @SerializedName("OBJ_ID")
    private String objId;


    public InReqStashLogData() {
        super("INREQ");
    }

    /**
     * время обработки запроса (мс)
     */
    public long getDuration() {
        return duration;
    }

    /**
     * время обработки запроса (мс)
     */
    public void setDuration(long duration) {
        this.duration = duration;
    }

    /**
     * полный URI запроса
     */
    public String getRequestUri() {
        return requestUri;
    }

    /**
     * полный URI запроса
     */
    public void setRequestUri(String requestUri) {
        this.requestUri = requestUri;
    }

    /**
     * тело запроса
     */
    public String getRequestBody() {
        return requestBody;
    }

    /**
     * тело запроса
     */
    public void setRequestBody(String requestBody) {
        this.requestBody = requestBody;
    }

    /**
     * служебная информация запроса (если используется), например, заголовок HTTP­пакета
     */
    public Map<String, String> getRequestHeaders() {
        return requestHeaders;
    }

    /**
     * служебная информация запроса (если используется), например, заголовок HTTP­пакета
     */
    public void setRequestHeaders(Map<String, String> requestHeaders) {
        this.requestHeaders = requestHeaders;
    }

    /**
     * тип запроса (если используется), например, GET/POST для HTTP
     */
    public String getRequestType() {
        return requestType;
    }

    /**
     * тип запроса (если используется), например, GET/POST для HTTP
     */
    public void setRequestType(String requestType) {
        this.requestType = requestType;
    }

    /**
     * код ответа (результат обработки), например, 200 или 404 для HTTP или логический код ошибки
     */
    public String getResponseCode() {
        return responseCode;
    }

    /**
     * код ответа (результат обработки), например, 200 или 404 для HTTP или логический код ошибки
     */
    public void setResponseCode(String responseCode) {
        this.responseCode = responseCode;
    }

    /**
     * тело ответа
     */
    public String getResponseBody() {
        return responseBody;
    }

    /**
     * тело ответа
     */
    public void setResponseBody(String responseBody) {
        this.responseBody = responseBody;
    }

    /**
     * служебная информация ответа (если используется), например, заголовок HTTP­пакета
     */
    public Map<String, String> getResponseHeaders() {
        return responseHeaders;
    }

    /**
     * служебная информация ответа (если используется), например, заголовок HTTP­пакета
     */
    public void setResponseHeaders(Map<String, String> responseHeaders) {
        this.responseHeaders = responseHeaders;
    }

    /**
     * ID объекта (документ, платеж, клиент), к которому выполняется обращение (если возможно)
     */
    public String getObjId() {
        return objId;
    }

    /**
     * ID объекта (документ, платеж, клиент), к которому выполняется обращение (если возможно)
     */
    public void setObjId(String objId) {
        this.objId = objId;
    }

    @Override
    public String toString() {
        return "InReqLogData{" +
                "dt='" + dt + '\'' +
                ", type='" + type + '\'' +
                ", ref='" + ref + '\'' +
                ", sid='" + sid + '\'' +
                ", login='" + login + '\'' +
                ", remoteHost='" + remoteHost + '\'' +
                ", extRef='" + extRef + '\'' +
                ", extAttr=" + extAttr +
                ", duration=" + duration +
                ", requestUri='" + requestUri + '\'' +
                ", requestBody='" + requestBody + '\'' +
                ", requestHeaders=" + requestHeaders +
                ", requestType='" + requestType + '\'' +
                ", responseCode='" + responseCode + '\'' +
                ", responseBody='" + responseBody + '\'' +
                ", responseHeaders=" + responseHeaders +
                ", objId='" + objId + '\'' +
                "} ";
    }
}
