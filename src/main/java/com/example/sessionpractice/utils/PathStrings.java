package com.example.sessionpractice.utils;

import java.util.Arrays;
import java.util.List;

public class PathStrings {
    public static final List<String> NO_AUTHORITIES_PATHS = Arrays.asList("/", "/home", "/login", "/logout", "/no-auth");
    public static final List<String> USER_AUTHORITIES_PATHS = Arrays.asList("/users/**", "/", "/posts/**", "/session-info/**");
}
