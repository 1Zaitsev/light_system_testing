package qdo_ln.light_system_testing.utils;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum EventType{
    EVENT("event"),
    WARNING("warning"),
    ERROR("error");

    private final String title;
}
