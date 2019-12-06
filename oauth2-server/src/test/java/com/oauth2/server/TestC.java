package com.oauth2.server;

import org.junit.Test;
import org.springframework.security.crypto.codec.Base64;

import java.io.UnsupportedEncodingException;
import java.util.HashSet;
import java.util.Set;

/**
 * @author zhicheng.zhang
 * @date 2019-11-29
 * @description
 */
public class TestC {

    @Test
    public void test() throws UnsupportedEncodingException {
        Set<String> a = new HashSet<>();
        a.add("a");
        a.add("b");

        Set<String> b = new HashSet<>();
        b.add("a");
        b.add("c");
        System.err.println(a.containsAll(b));
    }
}
