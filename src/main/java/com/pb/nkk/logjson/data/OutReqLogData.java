package com.pb.nkk.logjson.data;

import com.google.gson.annotations.SerializedName;

import java.util.Map;

/**
 * Created by anatoliy on 09.04.2015.
 * данные исходящего запроса к внешней системе (включая СУБД) и полученного на него ответа
 */
public class OutReqLogData extends LogData {

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
    @SerializedName("REQUEST_PARAMS")
    private Map<String, String> requestParams;
    @SerializedName("RESPONSE_CODE")
    private String responseCode;
    @SerializedName("RESPONSE_BODY")
    private String responseBody;
    @SerializedName("RESPONSE_HEADERS")
    private String responseHeaders;

    public OutReqLogData() {
        super("OUTREQ");
    }

    /**
     * время выполнения запроса (мс)
     */
    public long getDuration() {
        return duration;
    }

    /**
     * время выполнения запроса (мс)
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
     * тело запроса (в случае отправки больших блоков данных возможно указание только ключевых полей)
     */
    public String getRequestBody() {
        return requestBody;
    }

    /**
     * тело запроса (в случае отправки больших блоков данных возможно указание только ключевых полей)
     */
    public void setRequestBody(String requestBody) {
        this.requestBody = requestBody;
    }

    /**
     * ​служебная информация запроса (если используется), например, заголовок HTTP­пакета
     */
    public Map<String, String> getRequestHeaders() {
        return requestHeaders;
    }

    /**
     * ​служебная информация запроса (если используется), например, заголовок HTTP­пакета
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
     * параметры запроса (если поместить их в поле {@link OutReqLogData#requestBody} ​проблематично)
     */
    public Map<String, String> getRequestParams() {
        return requestParams;
    }

    /**
     * параметры запроса (если поместить их в поле {@link OutReqLogData#requestBody} ​проблематично)
     */
    public void setRequestParams(Map<String, String> requestParams) {
        this.requestParams = requestParams;
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
     * тело ответа (в случае получения больших блоков данных возможно указание только ключевых полей)
     */
    public String getResponseBody() {
        return responseBody;
    }

    /**
     * тело ответа (в случае получения больших блоков данных возможно указание только ключевых полей)
     */
    public void setResponseBody(String responseBody) {
        this.responseBody = responseBody;
    }

    /**
     * служебная информация ответа (если используется), например, заголовок HTTP­пакета
     */
    public String getResponseHeaders() {
        return responseHeaders;
    }

    /**
     * служебная информация ответа (если используется), например, заголовок HTTP­пакета
     */
    public void setResponseHeaders(String responseHeaders) {
        this.responseHeaders = responseHeaders;
    }

    @Override
    public String toString() {
        return "OutReqLogData{" +
                "duration=" + duration +
                ", requestUri='" + requestUri + '\'' +
                ", requestBody='" + requestBody + '\'' +
                ", requestHeaders=" + requestHeaders +
                ", requestType='" + requestType + '\'' +
                ", requestParams=" + requestParams +
                ", responseCode='" + responseCode + '\'' +
                ", responseBody='" + responseBody + '\'' +
                ", responseHeaders='" + responseHeaders + '\'' +
                "} " + super.toString();
    }
}
