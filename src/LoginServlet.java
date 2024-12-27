
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//继承HttpServlet类，并重写init()方法，该方法用于初始化Servlet，在Servlet被创建的时候调用。
//在init()方法中，可以做一些Servlet的初始化工作，比如读取配置文件，创建数据库连接等。
//在HttpServlet类中，提供了两个方法用于处理请求，分别是doGet()和doPost()。
//doGet()方法用于处理get请求，doPost()方法用于处理post请求。但更多的时候，我们只需要重写service方法，
//在HttpServlet类中，提供了四个方法用于配置Servlet，分别是init(), service(), destroy(), getServletInfo()。
//init()方法用于初始化Servlet，service()方法用于处理请求，destroy()方法用于销毁Servlet，getServletInfo()方法用于获取Servlet的描述信息。
//在HttpServlet类中，提供了两个方法用于获取请求参数，分别是getParameter()和getParameterValues()。
//getParameter()方法用于获取单个请求参数，getParameterValues()方法用于获取多个请求参数。
//在HttpServlet类中，提供了两个方法用于设置响应信息，分别是setContentType()和getWriter()。
//setContentType()方法用于设置响应的Content-Type，getWriter()方法用于获取PrintWriter对象，用于输出响应信息。
//在HttpServlet类中，提供了两个方法用于获取请求和响应对象，分别是HttpServletRequest和HttpServletResponse。
//HttpServletRequest用于获取请求信息，HttpServletResponse用于设置响应信息。
//在HttpServlet类中，提供了两个方法用于获取ServletContext和HttpServletRequest，分别是getServletContext()和getRequest()。
//getServletContext()方法用于获取ServletContext对象，HttpServletRequest用于获取HttpServletRequest对象。
public class LoginServlet extends HttpServlet {
    public LoginServlet() {      //构造方法
        System.out.println("LoginServlet 构造方法 被调用");
    }

    public void init(ServletConfig config) {  //ServletConfig接口用于配置Servlet的初始化参数
        System.out.println("init(ServletConfig)");
    }

    //重写service方法，用于处理请求，并获取请求参数
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");  //设置请求编码为UTF-8
        String name = request.getParameter("name");
        String password = request.getParameter("password");

        String html = null;

        if ("admin".equals(name) && "123".equals(password))  //断账号密码是否为 admin 123，如果是就打印 success，否则就打印 fail
//            html = "<div style='color:green'>success</div>"; //如果账号密码正确，则输出 success
            request.getRequestDispatcher("success.html").forward(request, response); //如果账号密码正确，则转发到 success.html页面(服务端跳转，可以观察到，浏览器地址没有发生变化，http://127.0.0.1/login)
        else
//            html = "<div style='color:red'>fail</div>";  //如果账号密码错误，则输出 fail
            response.sendRedirect("fail.html");   //如果账号密码错误，则重定向到 fail.html页面(. 客户端跳转，可以观察到，浏览器地址发生了变化，http://127.0.0.1/fail.html)


//        response.setContentType("text/html; charset=UTF-8");    //设置响应编码为UTF-8
//        PrintWriter pw = response.getWriter();  //获取PrintWriter对象，用于输出响应信息
//        pw.println(html);  //输出响应信息到浏览器
    }
}


