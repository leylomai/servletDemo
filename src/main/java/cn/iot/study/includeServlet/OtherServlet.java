package cn.iot.study.includeServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/other.view")
public class OtherServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        PrintWriter printWriter = resp.getWriter();
        printWriter.println("Other do one, " + String.valueOf(name) + "...");
        //printWriter.flush();
        //printWriter.close();    //被include，这里不能close stream;
    }
}
