package com.pb.nkk.log.filler;

import ch.qos.logback.classic.spi.ILoggingEvent;
import com.pb.nkk.log.data.MdcLogAttr;
import com.pb.nkk.log.data.StashLogData;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Map;


/**
 * Created by anatoliy on 28.04.2015.
 * Заполняет данными из MDC структуру StashLogData
 */
public class DefaultFiller implements Filler {

    private final static String NODE = System.getProperty("name");
    private final static String HOST_NAME;
    private final static String HOST_IP;

    static {
        String tmpHostName;
        String tmpHostIp;
        try {
            InetAddress localHost = InetAddress.getLocalHost();
            tmpHostName = localHost.getHostName();
            tmpHostIp = localHost.getHostAddress();
        } catch (UnknownHostException e) {
            tmpHostName = "UNKNOWN";
            tmpHostIp = "0.0.0.0";
        }
        HOST_NAME = tmpHostName;
        HOST_IP = tmpHostIp;
    }

    public void fillData(StashLogData data, ILoggingEvent event) {
        data.setdDt(event.getTimeStamp());
        data.getExtAttr().put("LOGGER", event.getLoggerName());
        Map<String, String> mdc = event.getMDCPropertyMap();
        if (data.getRef() == null) {
            data.setRef(mdc.get(MdcLogAttr.REF.toString()));
        }
        if (data.getExtRef() == null) {
            data.setExtRef(mdc.get(MdcLogAttr.EXTREF.toString()));
        }
        if (data.getLogin() == null) {
            data.setLogin(mdc.get(MdcLogAttr.LOGIN.toString()));
        }
        if (data.getRemoteHost() == null) {
            data.setRemoteHost(mdc.get(MdcLogAttr.REMOTE_HOST.toString()));
        }
        if (data.getSid() == null) {
            data.setSid(mdc.get(MdcLogAttr.SID.toString()));
        }
        StashLogData.Source source = new StashLogData.Source();
        source.setApplication(event.getLoggerContextVO().getName());
        source.setHostIp(HOST_IP);
        source.setHostName(HOST_NAME);
        source.setNode(NODE);
        data.setSource(source);
    }
}
