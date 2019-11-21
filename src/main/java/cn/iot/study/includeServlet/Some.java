package cn.iot.study.includeServlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/some.view")
public class Some extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter printWriter = resp.getWriter();
        printWriter.println("Some do one...");

        RequestDispatcher dispatcher = req.getRequestDispatcher("/other.view");
        dispatcher.include(req, resp);

        printWriter.println("Some do two...");
        printWriter.flush();
        printWriter.close();
    }
}
