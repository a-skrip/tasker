package org.example.tasker.domain.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Set;

import static org.example.tasker.domain.enums.Privilege.*;

@RequiredArgsConstructor
public enum Role {
    ADMIN,
    USER
}
