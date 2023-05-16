package com.adolfoponce.spinning.presentation.ui.calendar;

import org.joda.time.LocalDate;

public class MessageEvent {

    public LocalDate mMessage;

    public MessageEvent(LocalDate message) {
        mMessage = message;
    }

    public LocalDate getMessage() {
        return mMessage;
    }
}