package com.pb.nkk.log.filler;

import ch.qos.logback.classic.spi.ILoggingEvent;
import com.google.common.base.Strings;
import com.pb.nkk.log.data.InReqStashLogData;
import com.pb.nkk.log.data.MdcLogAttr;
import com.pb.nkk.log.data.StashLogData;

import java.util.Map;

/**
 * Created by anatoliy on 28.04.2015.
 */
public class InReqStashLogDataFiller implements Filler {

    private Filler wrappedFiller;

    public InReqStashLogDataFiller(Filler wrappedFiller) {
        this.wrappedFiller = wrappedFiller;
    }

    public void fillData(StashLogData data, ILoggingEvent event) {
        wrappedFiller.fillData(data, event);
        InReqStashLogData inReqData = (InReqStashLogData) data;

        Map<String, String> mdc = event.getMDCPropertyMap();
        if (inReqData.getDuration() == 0) {
            String value = mdc.get(MdcLogAttr.DURATION.toString());
            if (!Strings.isNullOrEmpty(value)) {
                try {
                    long l = Long.parseLong(value);
                    inReqData.setDuration(l);
                    //Если формат времени не правильный то оставляем значение 0
                } catch (Exception e) {
                }
            }
        }
        if (inReqData.getObjId() == null) {
            inReqData.setObjId(mdc.get(MdcLogAttr.OBJ_ID.toString()));
        }
        if (inReqData.getRequestBody() == null) {
            inReqData.setRequestBody(mdc.get(MdcLogAttr.REQUEST_BODY.toString()));
        }
        if (inReqData.getRequestHeaders() == null) {
            inReqData.setRequestHeaders(mdc.get(MdcLogAttr.REQUEST_HEADERS.toString()));
        }
        if (inReqData.getRequestUri() == null) {
            inReqData.setRequestUri(mdc.get(MdcLogAttr.REQUEST_URI.toString()));
        }
        if (inReqData.getRequestType() == null) {
            inReqData.setRequestType(mdc.get(MdcLogAttr.REQUEST_TYPE.toString()));
        }
        if (inReqData.getResponseCode() == null) {
            inReqData.setResponseCode(mdc.get(MdcLogAttr.RESPONSE_CODE.toString()));
        }
        if (inReqData.getResponseHeaders() == null) {
            inReqData.setResponseHeaders(mdc.get(MdcLogAttr.RESPONSE_HEADERS.toString()));
        }
        if (inReqData.getResponseBody() == null) {
            inReqData.setResponseBody(mdc.get(MdcLogAttr.RESPONSE_BODY.toString()));
        }
    }
}
