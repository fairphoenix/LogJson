package com.pb.nkk.log.filler;

import ch.qos.logback.classic.pattern.ExtendedThrowableProxyConverter;
import ch.qos.logback.classic.pattern.ThrowableProxyConverter;
import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.classic.spi.IThrowableProxy;
import ch.qos.logback.classic.spi.ThrowableProxy;
import com.google.common.base.Throwables;
import com.google.gson.annotations.SerializedName;
import com.pb.nkk.log.data.StashLogData;

/**
 * Created by anatoliy on 28.04.2015.
 * Заполняет информацию о Throwable, если такое было сгенерировано. Помещает в map ExtAttr.
 */
public class ThrowableFiller implements Filler {

    private Filler wrappedFiller;

    public ThrowableFiller(Filler wrappedFiller) {
        this.wrappedFiller = wrappedFiller;
    }

    private ExtendedThrowableProxyConverter throwableProxyConverter = new ExtendedThrowableProxyConverter();

    public ThrowableFiller() {
    }

    public void fillData(StashLogData data, ILoggingEvent event) {
        wrappedFiller.fillData(data, event);
        if(event.getThrowableProxy() == null){
            return;
        }
        ThrowableInfo info = new ThrowableInfo();
        info.setMsg(event.getThrowableProxy().getMessage());
        info.setStackTrace(obtainStackTrace(event));
        data.getExtAttr().put("THROWABLE", info);
    }

    private String obtainStackTrace(ILoggingEvent event) {
//        IThrowableProxy throwableProxy = event.getThrowableProxy();
//        if(throwableProxy != null && throwableProxy instanceof ThrowableProxy){
//            ThrowableProxy proxy = (ThrowableProxy) throwableProxy;
//            return Throwables.getStackTraceAsString(proxy.getThrowable());
//        }
//        return null;
        throwableProxyConverter.start();
        String stackTrace = throwableProxyConverter.convert(event);
        throwableProxyConverter.stop();
        return stackTrace.isEmpty() ? null : stackTrace;
    }

    public class ThrowableInfo {

        @SerializedName("MSG")
        private String msg;
        @SerializedName("STACKTRACE")
        private String stackTrace;

        public String getMsg() {
            return msg;
        }

        public ThrowableInfo setMsg(String msg) {
            this.msg = msg;
            return this;
        }

        public String getStackTrace() {
            return stackTrace;
        }

        public ThrowableInfo setStackTrace(String stackTrace) {
            this.stackTrace = stackTrace;
            return this;
        }

        @Override
        public String toString() {
            return "ThrowableInfo{" +
                    "msg='" + msg + '\'' +
                    ", stackTrace='" + stackTrace + '\'' +
                    '}';
        }
    }
}
