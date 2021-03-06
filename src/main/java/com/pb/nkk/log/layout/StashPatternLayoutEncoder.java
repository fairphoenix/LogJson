package com.pb.nkk.log.layout;

import ch.qos.logback.classic.encoder.PatternLayoutEncoder;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.pb.nkk.log.filler.FillerFactoryImpl;

/**
 * Created by anatoliy on 18.06.2015.
 */
public class StashPatternLayoutEncoder extends PatternLayoutEncoder {

    private boolean prettyPrinting = false;

    public void setPrettyPrinting(boolean prettyPrinting) {
        this.prettyPrinting = prettyPrinting;
    }

    @Override
    public void start() {
        StashPattenLayout patternLayout = new StashPattenLayout();
        patternLayout.setFillerFactory(new FillerFactoryImpl());
        patternLayout.setContext(context);
        Gson gson = prettyPrinting ? new GsonBuilder().setPrettyPrinting().create() : new Gson();
        patternLayout.setGson(gson);
        patternLayout.setPattern(getPattern());
        patternLayout.setOutputPatternAsHeader(outputPatternAsHeader);
        patternLayout.start();
        this.layout = patternLayout;
    }

}
