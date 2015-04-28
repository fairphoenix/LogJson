package com.pb.nkk.log.filler;

import ch.qos.logback.classic.spi.ILoggingEvent;
import com.google.gson.annotations.SerializedName;
import com.pb.nkk.log.data.StashLogData;

/**
 * Created by anatoliy on 28.04.2015.
 */
public class CallerDataFiller implements Filler {

    private Filler wrappedFiller;

    public CallerDataFiller(Filler wrappedFiller) {
        this.wrappedFiller = wrappedFiller;
    }

    public void fillData(StashLogData data, ILoggingEvent event) {
        wrappedFiller.fillData(data, event);
        StackTraceElement[] stackTraceElements = event.getCallerData();
        if (stackTraceElements != null && stackTraceElements.length >= 1) {
            StackTraceElement traceElement = stackTraceElements[0];
            data.getExtAttr().put("CALLER_DATA", new CallerData()
                    .setDeclaringClass(traceElement.getClassName())
                    .setFileName(traceElement.getFileName())
                    .setMethodName(traceElement.getMethodName())
                    .setLineNumber(traceElement.getLineNumber()));
        }
    }

    public class CallerData {

        @SerializedName("CLASS")
        private String declaringClass;
        @SerializedName("METHOD")
        private String methodName;
        @SerializedName("FILE")
        private String fileName;
        @SerializedName("LINE")
        private int lineNumber;

        public String getDeclaringClass() {
            return declaringClass;
        }

        public CallerData setDeclaringClass(String declaringClass) {
            this.declaringClass = declaringClass;
            return this;
        }

        public String getFileName() {
            return fileName;
        }

        public CallerData setFileName(String fileName) {
            this.fileName = fileName;
            return this;
        }

        public int getLineNumber() {
            return lineNumber;
        }

        public CallerData setLineNumber(int lineNumber) {
            this.lineNumber = lineNumber;
            return this;
        }

        public String getMethodName() {
            return methodName;
        }

        public CallerData setMethodName(String methodName) {
            this.methodName = methodName;
            return this;
        }

        @Override
        public String toString() {
            return "CallerData{" +
                    "declaringClass='" + declaringClass + '\'' +
                    ", methodName='" + methodName + '\'' +
                    ", fileName='" + fileName + '\'' +
                    ", lineNumber=" + lineNumber +
                    '}';
        }
    }
}
