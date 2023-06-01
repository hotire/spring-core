package com.github.hotire.springcore.tomcat;

import org.apache.tomcat.util.IntrospectionUtils;

/**
 * @see IntrospectionUtils
 */
public class IntrospectionUtilsCore {


    /**
     * @see IntrospectionUtils#setProperty(Object, String, String, boolean, StringBuilder) 
     */
    public static boolean setProperty(Object o, String name, String value,
        boolean invokeSetProperty, StringBuilder actualMethod) {
        return true;
    }
}
