package cn.iot.study.response;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

@WebServlet(urlPatterns = "/download.do")
public class DownloadServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String password = request.getParameter("passwd");
        if ("123456".equals(password)) {
            response.setContentType("application/pdf");

            try (InputStream in = getServletContext().getResourceAsStream("/WEB-INF/jdbc.pdf");
                 OutputStream out = response.getOutputStream()) {
                writeBytes(in, out);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void writeBytes(InputStream in, OutputStream out) throws Exception {
        byte[] bytes = new byte[1024];
        int length = -1;
        while ((length = in.read(bytes)) != -1) {
            out.write(bytes, 0, length);
        }
    }
}
