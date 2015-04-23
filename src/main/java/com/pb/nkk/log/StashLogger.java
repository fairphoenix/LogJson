package com.pb.nkk.log;

import com.pb.nkk.log.data.*;
import org.slf4j.Logger;

/**
 * Created by anatoliy on 23.04.2015.
 */
public interface StashLogger extends Logger {
    void debug2stash(DebugStashLogData data);
    void error2stash(ErrorStashLogData data);
    void info2stash(InfoStashLogData data);
    void inReq2stash(InReqStashLogData data);
    void outReq2stash(OutReqStashLogData data);
}
