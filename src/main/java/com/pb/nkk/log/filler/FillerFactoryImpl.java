package com.pb.nkk.log.filler;

import com.pb.nkk.log.data.ErrorStashLogData;
import com.pb.nkk.log.data.InReqStashLogData;
import com.pb.nkk.log.data.OutReqStashLogData;
import com.pb.nkk.log.data.StashLogData;

/**
 * Created by anatoliy on 28.04.2015.
 */
public class FillerFactoryImpl implements FillerFactory {
    public Filler createFillerByData(StashLogData data) {
        if (data instanceof ErrorStashLogData) {
            return new ErrorFiller(new CallerDataFiller(new ExtAttrFromMdcFiller(new DefaultFiller())));
        }
        if (data instanceof InReqStashLogData) {
            return new InReqStashLogDataFiller(new CallerDataFiller(new ExtAttrFromMdcFiller(
                    new ThrowableFiller(new DefaultFiller()))));
        }
        if(data instanceof OutReqStashLogData){
            return new OutReqStashLogDataFiller(new CallerDataFiller(new ExtAttrFromMdcFiller(
                    new ThrowableFiller(new DefaultFiller()))));
        }
        return new CallerDataFiller(new ExtAttrFromMdcFiller(new ThrowableFiller(new DefaultFiller())));
    }
}
