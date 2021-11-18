package br.com.jhegnerlabs.log;

public final class Log {

    private Severity severity;

    private String mensagem;

    private Object payload;



    public enum Severity {INFO, DEBUG, WARN, ERROR, TRACE}



}
