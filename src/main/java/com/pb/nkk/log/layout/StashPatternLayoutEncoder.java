package com.pb.nkk.log.layout;

import ch.qos.logback.classic.encoder.PatternLayoutEncoder;

/**
 * Created by anatoliy on 24.04.2015.
 */
public class StashPatternLayoutEncoder extends PatternLayoutEncoder {

    private String application;

    public void setApplication(String application) {
        this.application = application;
    }

    @Override
    public void start() {
        StashPattenLayout patternLayout = new StashPattenLayout(application);
        patternLayout.setContext(context);
        patternLayout.setPattern(getPattern());
        patternLayout.setOutputPatternAsHeader(outputPatternAsHeader);
        patternLayout.start();
        this.layout = patternLayout;
    }

}
