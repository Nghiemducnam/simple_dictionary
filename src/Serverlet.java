import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

@WebServlet (name="Serverlet", urlPatterns = "/dictionary")
public class Serverlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Map<String, String> dictionary = new HashMap<>();
        dictionary.put("book", "quyển vở");
        dictionary.put("duck", "con vịt");
        dictionary.put("tiger", "con hổ");
        dictionary.put("lion", "sư tử");

        String search =req.getParameter("name");

        PrintWriter writer = resp.getWriter();
        String result = dictionary.get(search);
        writer.println("<html>");
        if(result!=null){
            writer.println("word:  " + search);
            writer.println("it's mean: " + result);
        } else
            writer.println("not found");

        writer.println("</html>");

    }


}
