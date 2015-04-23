package com.pb.nkk.log.data;

import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Sets;

import java.util.Set;

/**
 * Created by anatoliy on 23.04.2015.
 */
public enum MdcLogAttr {
    /**
     * Дата и время наступления события в формате "yyyyMMdd HH:mm:ss.SSS"
     */
    DT("DT"),
    /**
     * Тип записи: ERROR​­ сообщение об ошике INFO​­ информационное сообщение INREQ​­ данные поступившего запроса и
     * сформированного ответа OUTREQ​­ данные исходящего запроса к внешней системе (включая СУБД) и полученного на
     * него ответа DEBUG​­ отладочная информация
     */
    TYPE("TYPE"),
    /**
     * Идентификатор операции, к которой относится данная запись
     */
    REF("REF"),
    /**
     * Идентификатор авторизационной сессии, от имени которой выполняется операция, к которой относится запись
     */
    SID("SID"),
    /**
     * Имя пользователя, производящего операцию, к которой относится запись (при наличии заполненного атрибута
     * SID ​может не использоваться)
     */
    LOGIN("LOGIN"),
    /**
     * ​IP­адрес хоста, с которым производится обмен данными (если операция подразумевает взаимодействие с
     * внешними системами)
     */
    REMOTE_HOST("REMOTE_HOST"),
    /**
     * ​Идентификатор операции, к которой относится данная запись, в терминах удаленной системы (если таковой
     * предусмотрен и операция подразумевает взаимодействие с внешними системами)
     */
    EXTREF("EXT_REF"),
    /**
     * Код логической или системной ошибки
     */
    ERRCODE("ERRCODE"),
    /**
     * Текст ошибки
     */
    ERRTEXT("ERRTEXT"),
    /**
     * ​stacktrace точки возникновения ошибки
     */
    STACKTRACE("STACKTRACE"),
    /**
     * Время обработки запроса (мс)
     */
    DURATION("DURATION"),
    /**
     * Полный URI, запроса
     */
    REQUEST_URI("REQUEST_URI"),
    /**
     * Тело запроса
     */
    REQUEST_BODY("REQUEST_BODY"),
    /**
     * Служебная информация запроса (если используется), например, заголовок HTTP­пакета
     */
    REQUEST_HEADERS("REQUEST_HEADERS"),
    /**
     * ​Тип запроса (если используется), например, GET/POST для HTTP
     */
    REQUEST_TYPE("REQUEST_TYPE"),
    /**
     * Параметры запроса (если поместить их в поле REQUEST_BODY ​проблематично)
     */
    REQUEST_PARAMS("REQUEST_PARAMS"),
    /**
     * Код ответа (результат обработки), например, 200 или 404 для HTTP или логический код ошибки
     */
    RESPONSE_CODE("RESPONSE_CODE"),
    /**
     * Тело ответа
     */
    RESPONSE_BODY("RESPONSE_BODY"),
    /**
     * Служебная информация ответа (если используется), например, заголовок HTTP­пакета
     */
    RESPONSE_HEADERS("RESPONSE_HEADERS"),
    /**
     * ID объекта (документ, платеж, клиент), к которому выполняется обращение (если возможно)
     */
    OBJ_ID("OBJ_ID");


    private String strVal;

    MdcLogAttr(String strVal) {
        this.strVal = strVal;
    }

    @Override
    public String toString() {
        return strVal;
    }

    private static Set<String> strValues;

    static {
        Set<String> set = Sets.newHashSet();
        for(MdcLogAttr attr: values()){
            set.add(attr.toString());
        }
        strValues = ImmutableSet.copyOf(set);
    }


    public static Set<String> getStrValues(){
        return strValues;
    }

}
