//package com.pb.nkk.log.logger;
//
//import ch.qos.logback.classic.pattern.ThrowableProxyConverter;
//import ch.qos.logback.classic.spi.ILoggingEvent;
//import com.google.common.base.Strings;
//import com.google.common.collect.Sets;
//import com.google.gson.annotations.SerializedName;
//import com.pb.nkk.log.data.*;
//
//import java.net.InetAddress;
//import java.net.UnknownHostException;
//import java.util.Map;
//
///**
// * Created by anatoliy on 24.04.2015.
// */
//public class LogDataWriterImpl implements LogDataWriter {
//
//    private final static String NODE = System.getProperty("name");
//    private final static String HOST;
//
//    static {
//        String tmpHost;
//        try {
//            tmpHost = InetAddress.getLocalHost().toString();
//        } catch (UnknownHostException e) {
//            tmpHost = "UNKNOWN";
//        }
//        HOST = tmpHost;
//    }
//
//    private ThrowableProxyConverter throwableProxyConverter = new ThrowableProxyConverter();
//
//    public void writeFromEvent(ILoggingEvent event, StashLogData data) {
//        writeSource(event, data);
//        writeDefaultInfo(event, data);
//        if (data instanceof ErrorStashLogData) {
//            writeErrorInfo(event, (ErrorStashLogData) data);
//        }
//        if (data instanceof InReqStashLogData) {
//            writeInReqInfo(event, (InReqStashLogData) data);
//        }
//        if (data instanceof OutReqStashLogData) {
//            writeOutReqInfo(event, (OutReqStashLogData) data);
//        }
//    }
//
//    private void writeSource(ILoggingEvent event, StashLogData data) {
//        StashLogData.Source source = new StashLogData.Source();
//        source.setApplication(event.getLoggerContextVO().getName());
//        source.setHost(HOST);
//        source.setNode(NODE);
//        data.setSource(source);
//    }
//
//    private void writeDefaultInfo(ILoggingEvent event, StashLogData data) {
//        data.setdDt(event.getTimeStamp());
//        data.getExtAttr().put("LOGGER", event.getLoggerName());
//        if (event.getCallerData() != null) {
//            writeCallerData(event.getCallerData(), data.getExtAttr());
//        }
//        if (event.getThrowableProxy() != null) {
//            writeThrowableInfo(event, data.getExtAttr());
//        }
//        if (event.getMDCPropertyMap() != null) {
//            writeInfoFromMdc(event.getMDCPropertyMap(), data);
//        }
//    }
//
//    private void writeCallerData(StackTraceElement[] stackTraceElements, Map<String, Object> data) {
//        if (stackTraceElements != null && stackTraceElements.length >= 1) {
//            StackTraceElement traceElement = stackTraceElements[0];
//            data.put("CALLER_DATA", new CallerData()
//                    .setDeclaringClass(traceElement.getClassName())
//                    .setFileName(traceElement.getFileName())
//                    .setMethodName(traceElement.getMethodName())
//                    .setLineNumber(traceElement.getLineNumber()));
//        }
//    }
//
//    private void writeThrowableInfo(ILoggingEvent event, Map<String, Object> extAttr) {
//        ThrowableInfo info = new ThrowableInfo();
//        info.setMsg(event.getThrowableProxy().getMessage());
//        info.setStackTrace(obtainStackTrace(event));
//        extAttr.put("THROWABLE", info);
//    }
//
//    private void writeInfoFromMdc(Map<String, String> mdc, StashLogData data) {
//        if (data.getRef() == null) {
//            data.setRef(mdc.get(MdcLogAttr.REF.toString()));
//        }
//        if (data.getExtRef() == null) {
//            data.setExtRef(mdc.get(MdcLogAttr.EXTREF.toString()));
//        }
//        if (data.getLogin() == null) {
//            data.setLogin(mdc.get(MdcLogAttr.LOGIN.toString()));
//        }
//        if (data.getRemoteHost() == null) {
//            data.setRemoteHost(mdc.get(MdcLogAttr.REMOTE_HOST.toString()));
//        }
//        if (data.getSid() == null) {
//            data.setSid(mdc.get(MdcLogAttr.SID.toString()));
//        }
//        Map<String, Object> extAttr = data.getExtAttr();
//        Sets.SetView<String> difference = Sets.difference(mdc.keySet(), MdcLogAttr.getStrValues());
//        for (String key : difference) {
//            extAttr.put(key, mdc.get(key));
//        }
//    }
//
//    private void writeErrorInfo(ILoggingEvent event, ErrorStashLogData data) {
//        if (data.getErrCode() == null) {
//            data.setErrCode(event.getMDCPropertyMap().get(MdcLogAttr.ERRCODE.toString()));
//        }
//        if (data.getErrText() == null) {
//            if (event.getThrowableProxy() != null) {
//                data.setErrText(event.getThrowableProxy().getMessage());
//            } else {
//                data.setErrText(event.getMDCPropertyMap().get(MdcLogAttr.ERRTEXT.toString()));
//            }
//        }
//        data.setStackTrace(obtainStackTrace(event));
//    }
//
//    private String obtainStackTrace(ILoggingEvent event) {
//        String stackTrace = throwableProxyConverter.convert(event);
//        return stackTrace.isEmpty() ? null : stackTrace;
//    }
//
//    private void writeInReqInfo(ILoggingEvent event, InReqStashLogData data) {
//        Map<String, String> mdc = event.getMDCPropertyMap();
//        if (data.getDuration() == 0) {
//            String value = mdc.get(MdcLogAttr.DURATION.toString());
//            if (!Strings.isNullOrEmpty(value)) {
//                try {
//                    long l = Long.parseLong(value);
//                    data.setDuration(l);
//                    //Если формат времени не правильный то оставляем значение 0
//                } catch (Exception e) {
//                }
//            }
//        }
//        if (data.getObjId() == null) {
//            data.setObjId(mdc.get(MdcLogAttr.OBJ_ID.toString()));
//        }
//        if (data.getRequestBody() == null) {
//            data.setRequestBody(mdc.get(MdcLogAttr.REQUEST_BODY.toString()));
//        }
//        if (data.getRequestHeaders() == null) {
//            data.setRequestHeaders(mdc.get(MdcLogAttr.REQUEST_HEADERS.toString()));
//        }
//        if (data.getRequestUri() == null) {
//            data.setRequestUri(mdc.get(MdcLogAttr.REQUEST_URI.toString()));
//        }
//        if (data.getRequestType() == null) {
//            data.setRequestType(mdc.get(MdcLogAttr.REQUEST_TYPE.toString()));
//        }
//        if (data.getResponseCode() == null) {
//            data.setResponseCode(mdc.get(MdcLogAttr.RESPONSE_CODE.toString()));
//        }
//        if (data.getResponseHeaders() == null) {
//            data.setResponseHeaders(mdc.get(MdcLogAttr.RESPONSE_HEADERS.toString()));
//        }
//        if (data.getResponseBody() == null) {
//            data.setResponseBody(mdc.get(MdcLogAttr.RESPONSE_BODY.toString()));
//        }
//    }
//
//    private void writeOutReqInfo(ILoggingEvent event, OutReqStashLogData data) {
//        Map<String, String> mdc = event.getMDCPropertyMap();
//        if (data.getDuration() == 0) {
//            String value = mdc.get(MdcLogAttr.DURATION.toString());
//            if (!Strings.isNullOrEmpty(value)) {
//                try {
//                    long l = Long.parseLong(value);
//                    data.setDuration(l);
//                    //Если формат времени не правильный то оставляем значение 0
//                } catch (Exception e) {
//                }
//            }
//        }
//        if (data.getRequestParams() == null) {
//            data.setRequestParams(mdc.get(MdcLogAttr.REQUEST_PARAMS.toString()));
//        }
//        if (data.getRequestBody() == null) {
//            data.setRequestBody(mdc.get(MdcLogAttr.REQUEST_BODY.toString()));
//        }
//        if (data.getRequestHeaders() == null) {
//            data.setRequestHeaders(mdc.get(MdcLogAttr.REQUEST_HEADERS.toString()));
//        }
//        if (data.getRequestUri() == null) {
//            data.setRequestUri(mdc.get(MdcLogAttr.REQUEST_URI.toString()));
//        }
//        if (data.getRequestType() == null) {
//            data.setRequestType(mdc.get(MdcLogAttr.REQUEST_TYPE.toString()));
//        }
//        if (data.getResponseCode() == null) {
//            data.setResponseCode(mdc.get(MdcLogAttr.RESPONSE_CODE.toString()));
//        }
//        if (data.getResponseHeaders() == null) {
//            data.setResponseHeaders(mdc.get(MdcLogAttr.RESPONSE_HEADERS.toString()));
//        }
//        if (data.getResponseBody() == null) {
//            data.setResponseBody(mdc.get(MdcLogAttr.RESPONSE_BODY.toString()));
//        }
//    }
//
//    public class ThrowableInfo {
//
//        @SerializedName("MSG")
//        private String msg;
//        @SerializedName("STACKTRACE")
//        private String stackTrace;
//
//        public String getMsg() {
//            return msg;
//        }
//
//        public ThrowableInfo setMsg(String msg) {
//            this.msg = msg;
//            return this;
//        }
//
//        public String getStackTrace() {
//            return stackTrace;
//        }
//
//        public ThrowableInfo setStackTrace(String stackTrace) {
//            this.stackTrace = stackTrace;
//            return this;
//        }
//
//        @Override
//        public String toString() {
//            return "ThrowableInfo{" +
//                    "msg='" + msg + '\'' +
//                    ", stackTrace='" + stackTrace + '\'' +
//                    '}';
//        }
//    }
//
//    public class CallerData {
//
//        @SerializedName("CLASS")
//        private String declaringClass;
//        @SerializedName("METHOD")
//        private String methodName;
//        @SerializedName("FILE")
//        private String fileName;
//        @SerializedName("LINE")
//        private int lineNumber;
//
//        public String getDeclaringClass() {
//            return declaringClass;
//        }
//
//        public CallerData setDeclaringClass(String declaringClass) {
//            this.declaringClass = declaringClass;
//            return this;
//        }
//
//        public String getFileName() {
//            return fileName;
//        }
//
//        public CallerData setFileName(String fileName) {
//            this.fileName = fileName;
//            return this;
//        }
//
//        public int getLineNumber() {
//            return lineNumber;
//        }
//
//        public CallerData setLineNumber(int lineNumber) {
//            this.lineNumber = lineNumber;
//            return this;
//        }
//
//        public String getMethodName() {
//            return methodName;
//        }
//
//        public CallerData setMethodName(String methodName) {
//            this.methodName = methodName;
//            return this;
//        }
//
//        @Override
//        public boolean equals(Object o) {
//            if (this == o) return true;
//            if (o == null || getClass() != o.getClass()) return false;
//
//            CallerData that = (CallerData) o;
//
//            if (lineNumber != that.lineNumber) return false;
//            if (declaringClass != null ? !declaringClass.equals(that.declaringClass) : that.declaringClass != null)
//                return false;
//            if (methodName != null ? !methodName.equals(that.methodName) : that.methodName != null) return false;
//            return !(fileName != null ? !fileName.equals(that.fileName) : that.fileName != null);
//
//        }
//
//        @Override
//        public int hashCode() {
//            int result = declaringClass != null ? declaringClass.hashCode() : 0;
//            result = 31 * result + (methodName != null ? methodName.hashCode() : 0);
//            result = 31 * result + (fileName != null ? fileName.hashCode() : 0);
//            result = 31 * result + lineNumber;
//            return result;
//        }
//
//        @Override
//        public String toString() {
//            return "CallerData{" +
//                    "declaringClass='" + declaringClass + '\'' +
//                    ", methodName='" + methodName + '\'' +
//                    ", fileName='" + fileName + '\'' +
//                    ", lineNumber=" + lineNumber +
//                    '}';
//        }
//    }
//
//
//}
