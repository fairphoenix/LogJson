package com.pb.nkk.log.filler;

import ch.qos.logback.classic.spi.ILoggingEvent;
import com.google.common.collect.Sets;
import com.pb.nkk.log.data.MdcLogAttr;
import com.pb.nkk.log.data.StashLogData;

import java.util.Map;

/**
 * Created by anatoliy on 28.04.2015.
 * Заполняет ExtAttr map из MDC. Любые значения найденные в MDC, которых нет в MdcLogAttr будут помещены в map ExtAttr.
 */
public class ExtAttrFromMdcFiller implements Filler {

    private Filler wrappedFiller;

    public ExtAttrFromMdcFiller(Filler wrappedFiller) {
        this.wrappedFiller = wrappedFiller;
    }

    public void fillData(StashLogData data, ILoggingEvent event) {
        wrappedFiller.fillData(data, event);
        Map<String, String> mdc = event.getMDCPropertyMap();
        Map<String, Object> extAttr = data.getExtAttr();
        Sets.SetView<String> difference = Sets.difference(mdc.keySet(), MdcLogAttr.getStrValues());
        for (String key : difference) {
            extAttr.put(key, mdc.get(key));
        }
    }
}
