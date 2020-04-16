package cn.iot.study.listener;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

@WebListener
public class MyHttpSessionAttributeListener implements HttpSessionAttributeListener {

    @Override
    public void attributeAdded(HttpSessionBindingEvent se) {
        System.out.println("attribute:" + se.getName() + ", value:" + se.getValue());
    }

    @Override
    public void attributeRemoved(HttpSessionBindingEvent se) {
        System.out.println("attribute:" + se.getName() + "remove, value:" + se.getValue());
    }

    @Override
    public void attributeReplaced(HttpSessionBindingEvent se) {

    }
}
