package com.pb.nkk.log.filler;

import ch.qos.logback.classic.pattern.ExtendedThrowableProxyConverter;
import ch.qos.logback.classic.pattern.RootCauseFirstThrowableProxyConverter;
import ch.qos.logback.classic.pattern.ThrowableProxyConverter;
import ch.qos.logback.classic.spi.ILoggingEvent;
import com.pb.nkk.log.data.ErrorStashLogData;
import com.pb.nkk.log.data.MdcLogAttr;
import com.pb.nkk.log.data.StashLogData;

/**
 * Created by anatoliy on 28.04.2015.
 */
public class ErrorFiller implements Filler {

    private Filler wrappedFiller;

    private RootCauseFirstThrowableProxyConverter throwableProxyConverter = new RootCauseFirstThrowableProxyConverter();

    public ErrorFiller(Filler wrappedFiller) {
        this.wrappedFiller = wrappedFiller;
    }

    public void fillData(StashLogData data, ILoggingEvent event) {
        wrappedFiller.fillData(data, event);
        ErrorStashLogData errorData = (ErrorStashLogData) data;
        if (errorData.getErrCode() == null) {
            errorData.setErrCode(event.getMDCPropertyMap().get(MdcLogAttr.ERRCODE.toString()));
        }
        if (errorData.getErrText() == null) {
            if (event.getThrowableProxy() != null) {
                errorData.setErrText(event.getThrowableProxy().getMessage());
            } else {
                errorData.setErrText(event.getMDCPropertyMap().get(MdcLogAttr.ERRTEXT.toString()));
            }
        }
        errorData.setStackTrace(obtainStackTrace(event));
    }

    private String obtainStackTrace(ILoggingEvent event) {
        throwableProxyConverter.start();
        String stackTrace = throwableProxyConverter.convert(event);
        throwableProxyConverter.stop();
        return stackTrace.isEmpty() ? null : stackTrace;
    }
}
