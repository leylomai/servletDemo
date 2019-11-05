package cn.iot.study;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/hello.view")
public class FirstServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String name = request.getParameter("name");

        out.println("<html>");
        out.println("<head>");
        out.println("<title>Hello Servlet</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1> Hello! " + name + " !</h1>");
        out.println(request.getRequestURL() + "<br>");
        out.println(request.getRequestURI() + "<br>");
        out.println(request.getContextPath() + "<br>");
        out.println(request.getServletPath() + "<br>");
        out.println("</body>");
        out.println("</html>");

        out.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String body = readBody(req);
        PrintWriter out = resp.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Hello Servlet</title>");
        out.println("</head>");
        out.println("<body>");
        out.println(body);
        out.println("</body>");
        out.println("</html>");
    }

    private String readBody(HttpServletRequest req) throws IOException {
        BufferedReader reader = req.getReader();
        String content = null;
        StringBuilder strBuilder = new StringBuilder();
        while (null != (content = reader.readLine())) {
            strBuilder.append(content);
        }
        return strBuilder.toString();
    }

    private byte[] readBody_1(HttpServletRequest req) throws IOException {
        int formDataLength = req.getContentLength();

        ServletInputStream sis = req.getInputStream();
        DataInputStream dataInputStream = new DataInputStream(sis);

        byte[] bodys = new byte[formDataLength];

        int indexBytes = 0;
        while (indexBytes < formDataLength) {
            int byteCount = dataInputStream.read(bodys, indexBytes, formDataLength);
            indexBytes += byteCount;
        }
        // 75页
        return bodys;
    }
}
