package com.app.rdc.marketcanvas.Feed.FIX;

import quickfix.*;

public class FixApplication implements Application {
    @Override
    public void onCreate(SessionID sessionID) {
        System.out.println("Connected with " + sessionID.toString());
    }

    @Override
    public void onLogon(SessionID sessionID) {
        System.out.println("Logged in with " + sessionID.toString());
    }

    @Override
    public void onLogout(SessionID sessionID) {
        System.out.println("Goodbye with " + sessionID.toString());
    }

    @Override
    public void toAdmin(Message message, SessionID sessionID) {

    }

    @Override
    public void fromAdmin(Message message, SessionID sessionID) throws FieldNotFound, IncorrectDataFormat, IncorrectTagValue, RejectLogon {

    }

    @Override
    public void toApp(Message message, SessionID sessionID) throws DoNotSend {

    }

    @Override
    public void fromApp(Message message, SessionID sessionID) throws FieldNotFound, IncorrectDataFormat, IncorrectTagValue, UnsupportedMessageType {

    }
}
