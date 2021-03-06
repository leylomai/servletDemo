package cn.iot.study.listener;

import javax.servlet.http.HttpSessionActivationListener;
import javax.servlet.http.HttpSessionEvent;
import java.io.Serializable;

public class MyHttpSessionActivationListener implements HttpSessionActivationListener, Serializable {

    private static final long serialVersionUID = 8872878604808928765L;

    private String name;

    public MyHttpSessionActivationListener(String name) {
        this.name = name;
    }

    @Override
    public void sessionWillPassivate(HttpSessionEvent se) {
        System.out.println("sessionWillPassivate, name:" + this.name + ",sessionId:" + se.getSession().getId());
    }

    @Override
    public void sessionDidActivate(HttpSessionEvent se) {
        System.out.println("sessionDidActivate, name:" + this.name + ",sessionId:" + se.getSession().getId());
    }
}
