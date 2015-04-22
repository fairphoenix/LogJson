package com.pb.nkk.logjson.data;


import com.google.gson.annotations.SerializedName;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

/**
 * Created by anatoliy on 09.04.2015.
 * Объект содержащий атребуты записываемые в лог. Будет сериализоваться в JSON.
 */
public abstract class LogData {

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
    protected Object extAttr;

    protected LogData(String type) {
        this.type = type;
    }

    /**
     * дата и время наступления события
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
    public void setdDt(long timeStamp) {
        this.dt = DT_FORMAT.print(new DateTime(timeStamp));
    }

    /**
     * дата и время наступления события
     */
    public void setdDt(DateTime dateTime) {
        this.dt = DT_FORMAT.print(dateTime);
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
    public void setRef(String ref) {
        this.ref = ref;
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
    public void setSid(String sid) {
        this.sid = sid;
    }

    /**
     * ​имя пользователя, производящего операцию, к которой относится запись (при
     * наличии заполненного атрибута {@link LogData#sid} ​может не использоваться)
     */
    public String getLogin() {
        return login;
    }

    /**
     * ​имя пользователя, производящего операцию, к которой относится запись (при
     * наличии заполненного атрибута {@link LogData#sid} ​может не использоваться)
     */
    public void setLogin(String login) {
        this.login = login;
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
    public void setRemoteHost(String remoteHost) {
        this.remoteHost = remoteHost;
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
    public void setExtRef(String extRef) {
        this.extRef = extRef;
    }

    /**
     * дополнительные атрибуты
     */
    public Object getExtAttr() {
        return extAttr;
    }

    /**
     * дополнительные атрибуты
     */
    public void setExtAttr(Object extAttr) {
        this.extAttr = extAttr;
    }

    @Override
    public String toString() {
        return "LogData{" +
                "dt='" + dt + '\'' +
                ", type='" + type + '\'' +
                ", ref='" + ref + '\'' +
                ", sid='" + sid + '\'' +
                ", login='" + login + '\'' +
                ", remoteHost='" + remoteHost + '\'' +
                ", extRef='" + extRef + '\'' +
                ", extAttr=" + extAttr +
                '}';
    }
}
