package com.academy.kirik.online_pastry_shop.enums;

import lombok.Getter;

@Getter
public enum OrderStatus {
    NEW("НОВЫЙ"),
    ACCEPTED("ПРИНЯТ"),
    FORMED("ГОТОВ"),
    SENT("ОТПРАВЛЕН"),
    DELIVERED("ДОСТАВЛЕН"),
    CLOSED("ЗАКРЫТ");

    private final String title;

    OrderStatus(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return title;
    }
}
