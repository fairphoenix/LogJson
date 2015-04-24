package com.pb.nkk.log.logger;

import com.pb.nkk.log.data.*;
import org.slf4j.Logger;

/**
 * Created by anatoliy on 23.04.2015.
 */
public interface StashLogger extends Logger {

    void debug2stash(DebugStashLogData data);

    void debug2stash(DebugStashLogData data, Throwable t);

    void error2stash(ErrorStashLogData data);

    void error2stash(ErrorStashLogData data, Throwable t);

    void info2stash(InfoStashLogData data);

    void info2stash(InfoStashLogData data, Throwable t);

    void inReq2stash(InReqStashLogData data);

    void inReq2stash(InReqStashLogData data, Throwable t);

    void outReq2stash(OutReqStashLogData data);

    void outReq2stash(OutReqStashLogData data, Throwable t);
}
