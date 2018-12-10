package com.tsystems.javaschool.tasks.calculator;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

public class Calculator {

    /**
     * Evaluate statement represented as string.
     *
     * @param statement mathematical statement containing digits, '.' (dot) as decimal mark,
     *                  parentheses, operations signs '+', '-', '*', '/'<br>
     *                  Example: <code>(1 + 38) * 4.5 - 1 / 2.</code>
     * @return string value containing result of evaluation or null if statement is invalid
     *
     */

    public String evaluate(String statement) {

        if (statement == null) return null;
        if (statement.contains(",") || statement.contains("//"))return null;

        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("JavaScript");

        try {
            Object result = engine.eval(statement);
            if (result.equals(Double.POSITIVE_INFINITY) || result.equals(Double.NEGATIVE_INFINITY) || result.equals(Double.NaN)) return null;
            return result.toString();
        } catch (Exception e) {
            return null;
        }
    }
}
