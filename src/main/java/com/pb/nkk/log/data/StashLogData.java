package com.pb.nkk.log.data;


import com.google.gson.annotations.SerializedName;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.util.Map;

/**
 * Created by anatoliy on 09.04.2015.
 * Объект содержащий атребуты записываемые в лог. Будет сериализоваться в JSON.
 */
public abstract class StashLogData<T extends StashLogData> {

    private final static DateTimeFormatter DT_FORMAT = DateTimeFormat.forPattern("yyyyMMdd HH:mm:ss.SSS");

    @SerializedName("DT")
    protected String dt;
    @SerializedName("TYPE")
    protected String type;
    @SerializedName("REF")
    protected String ref;
    @SerializedName("SID")
    protected String sid;
    @SerializedName("LOGIN")
    protected String login;
    @SerializedName("REMOTE_HOST")
    protected String remoteHost;
    @SerializedName("EXTREF")
    protected String extRef;
    @SerializedName("EXTATTR")
    protected Map<String, Object> extAttr;

    protected StashLogData(String type) {
        this.type = type;
        fillDefaultByMdc();
    }

    private void fillDefaultByMdc(){

    };

    /**
     * дата и время наступления события
     *
     * @return строка в формате "yyyyMMdd HH:mm:ss.SSS"
     */
    public String getDt() {
        return dt;
    }

    /**
     * дата и время наступления события
     */
    public DateTime getDtAsDataTime() {
        return DT_FORMAT.parseDateTime(dt);
    }

    /**
     * дата и время наступления события
     */
    public T setdDt(long timeStamp) {
        this.dt = DT_FORMAT.print(new DateTime(timeStamp));
        return (T) this;
    }

    /**
     * дата и время наступления события
     */
    public T setdDt(DateTime dateTime) {
        this.dt = DT_FORMAT.print(dateTime);
        return (T) this;
    }

    /**
     * идентификатор операции, к которой относится данная запись
     */
    public String getRef() {
        return ref;
    }

    /**
     * идентификатор операции, к которой относится данная запись
     */
    public T setRef(String ref) {
        this.ref = ref;
        return (T) this;
    }

    /**
     * идентификатор авторизационной сессии, от имени которой выполняется операция, к
     * которой относится запись
     */
    public String getSid() {
        return sid;
    }

    /**
     * идентификатор авторизационной сессии, от имени которой выполняется операция, к
     * которой относится запись
     */
    public T setSid(String sid) {
        this.sid = sid;
        return (T) this;
    }

    /**
     * ​имя пользователя, производящего операцию, к которой относится запись (при
     * наличии заполненного атрибута {@link StashLogData#sid} ​может не использоваться)
     */
    public String getLogin() {
        return login;
    }

    /**
     * ​имя пользователя, производящего операцию, к которой относится запись (при
     * наличии заполненного атрибута {@link StashLogData#sid} ​может не использоваться)
     */
    public T setLogin(String login) {
        this.login = login;
        return (T) this;
    }

    /**
     * ​​IP­адрес хоста, с которым производится обмен данными (еслиоперация подразумевает
     * взаимодействие с внешними системами)
     */
    public String getRemoteHost() {
        return remoteHost;
    }

    /**
     * ​​IP­адрес хоста, с которым производится обмен данными (еслиоперация подразумевает
     * взаимодействие с внешними системами)
     */
    public T setRemoteHost(String remoteHost) {
        this.remoteHost = remoteHost;
        return (T) this;
    }

    /**
     * идентификатор операции, к которой относится данная запись, в терминах удаленной
     * системы (если таковой предусмотрен и операция подразумевает взаимодействие с внешними системами)
     */
    public String getExtRef() {
        return extRef;
    }

    /**
     * идентификатор операции, к которой относится данная запись, в терминах удаленной
     * системы (если таковой предусмотрен и операция подразумевает взаимодействие с внешними системами)
     */
    public T setExtRef(String extRef) {
        this.extRef = extRef;
        return (T) this;
    }

    /**
     * дополнительные атрибуты
     */
    public Map<String, Object> getExtAttr() {
        return extAttr;
    }

    /**
     * дополнительные атрибуты
     */
    public T setExtAttr(Map<String, Object> extAttr) {
        this.extAttr = extAttr;
        return (T) this;
    }

    @Override
    public abstract String toString();
}
