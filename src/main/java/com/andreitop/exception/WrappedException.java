package com.andreitop.exception;


import java.sql.SQLException;

public class WrappedException {

    @SuppressWarnings("unchecked")
    private static <E extends Exception> void rethrow(Exception e) throws E {
        throw (E) e;
    }

    private static void rethrowBasic (Exception e) {
        try{
            throw e;
        } catch(Exception exp){
            throw new RuntimeException(exp);
        }
    }

    public static void doThrow(Exception e) {
        WrappedException.rethrowBasic(e);
    }


    public static void main(String[] args) {
        WrappedException.doThrow(new SQLException("i'll be runtime exception"));
    }

}
