package com.pb.nkk.log.filler;

import com.pb.nkk.log.data.StashLogData;

/**
 * Created by anatoliy on 28.04.2015.
 */
public interface FillerFactory {
    Filler createFillerByData(StashLogData clazz);
}
