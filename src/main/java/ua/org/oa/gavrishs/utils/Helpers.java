package ua.org.oa.gavrishs.utils;

import javax.servlet.http.HttpServletRequest;

import static java.util.Objects.nonNull;

public class Helpers {

    public static boolean isAjaxCall(HttpServletRequest request){
        String reqWith = request.getHeader("X-Requested-With");
        return  nonNull(reqWith) && reqWith.equalsIgnoreCase("XMLHttpRequest");
    }

    public static void badRequest(HttpServletRequest request){


    }
}
