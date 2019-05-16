package com.es.cloudapi.util;

import org.apache.tomcat.util.codec.binary.Base64;

import java.io.UnsupportedEncodingException;

public class CodecUtil {

    public static String decodeBase64(String value) throws UnsupportedEncodingException {
        return decodeBase64(value, "utf-8");
    }

    public static String decodeBase64(String value, String encoding) throws UnsupportedEncodingException {
        return new String(Base64.decodeBase64(value.getBytes()), encoding);
    }

}
