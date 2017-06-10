package com.scalawilliam.dot;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public interface DotToSvg {
    String renderDot(String dot);

    String SAMPLE_GRAPH = "graph g { a -- b }";

    static void loadIntoEngine(ScriptEngine scriptEngine) throws ScriptException {
        scriptEngine.eval(
                "load('classpath:META-INF/resources/webjars/viz.js/1.7.0/viz.js');");
    }

    static DotToSvg fromScriptEngine(ScriptEngine scriptEngine) throws ScriptException {
        scriptEngine.eval("load('classpath:com/scalawilliam/dot/get-viz.js');");
        Object funCall = scriptEngine.eval("getRenderer()");
        return ((Invocable) scriptEngine).getInterface(funCall, DotToSvg.class);
    }

    static DotToSvg fromNewScriptEngine() throws ScriptException {
        ScriptEngine scriptEngine = new ScriptEngineManager(null).getEngineByName("javascript");
        DotToSvg.loadIntoEngine(scriptEngine);
        return DotToSvg.fromScriptEngine(scriptEngine);
    }

}
