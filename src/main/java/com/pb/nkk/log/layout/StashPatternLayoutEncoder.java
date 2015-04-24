package com.pb.nkk.log.layout;

import ch.qos.logback.classic.encoder.PatternLayoutEncoder;

/**
 * Created by anatoliy on 24.04.2015.
 */
public class StashPatternLayoutEncoder extends PatternLayoutEncoder {

    @Override
    public void start() {
        StashPattenLayout patternLayout = new StashPattenLayout();
        patternLayout.setContext(context);
        patternLayout.setPattern(getPattern());
        patternLayout.setOutputPatternAsHeader(outputPatternAsHeader);
        patternLayout.start();
        this.layout = patternLayout;
    }

}
