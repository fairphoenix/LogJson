package com.pb.nkk.log.filler;

import ch.qos.logback.classic.spi.ILoggingEvent;
import com.google.common.base.Strings;
import com.pb.nkk.log.data.MdcLogAttr;
import com.pb.nkk.log.data.OutReqStashLogData;
import com.pb.nkk.log.data.StashLogData;

import java.util.Map;

/**
 * Created by anatoliy on 28.04.2015.
 */
public class OutReqStashLogDataFiller implements Filler {

    private Filler wrappedFiller;

    public OutReqStashLogDataFiller(Filler wrappedFiller) {
        this.wrappedFiller = wrappedFiller;
    }

    public void fillData(StashLogData data, ILoggingEvent event) {
        wrappedFiller.fillData(data, event);
        OutReqStashLogData outReqData = (OutReqStashLogData) data;
        Map<String, String> mdc = event.getMDCPropertyMap();
        if (outReqData.getDuration() == 0) {
            String value = mdc.get(MdcLogAttr.DURATION.toString());
            if (!Strings.isNullOrEmpty(value)) {
                try {
                    long l = Long.parseLong(value);
                    outReqData.setDuration(l);
                    //Если формат времени не правильный то оставляем значение 0
                } catch (Exception e) {
                }
            }
        }
        if (outReqData.getRequestParams() == null) {
            outReqData.setRequestParams(mdc.get(MdcLogAttr.REQUEST_PARAMS.toString()));
        }
        if (outReqData.getRequestBody() == null) {
            outReqData.setRequestBody(mdc.get(MdcLogAttr.REQUEST_BODY.toString()));
        }
        if (outReqData.getRequestHeaders() == null) {
            outReqData.setRequestHeaders(mdc.get(MdcLogAttr.REQUEST_HEADERS.toString()));
        }
        if (outReqData.getRequestUri() == null) {
            outReqData.setRequestUri(mdc.get(MdcLogAttr.REQUEST_URI.toString()));
        }
        if (outReqData.getRequestType() == null) {
            outReqData.setRequestType(mdc.get(MdcLogAttr.REQUEST_TYPE.toString()));
        }
        if (outReqData.getResponseCode() == null) {
            outReqData.setResponseCode(mdc.get(MdcLogAttr.RESPONSE_CODE.toString()));
        }
        if (outReqData.getResponseHeaders() == null) {
            outReqData.setResponseHeaders(mdc.get(MdcLogAttr.RESPONSE_HEADERS.toString()));
        }
        if (outReqData.getResponseBody() == null) {
            outReqData.setResponseBody(mdc.get(MdcLogAttr.RESPONSE_BODY.toString()));
        }
    }

}
