import java.io.IOException;
import java.util.Arrays;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegisterServlet extends HttpServlet {

    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html; charset=UTF-8");    //设置响应数据的类型和编码

//        使用缓存可以加快页面的加载，降低服务端的负担。但是也可能看到过时的信息，可以通过如下手段通知浏览器不要使用缓存
        response.setDateHeader("Expires", 0);  //设置响应的过期时间为0，即浏览器不缓存此数据
        response.setHeader("Cache-Control", "no-cache");  //设置响应的缓存机制为不缓存
        response.setHeader("pragma", "no-cache");  //设置响应的pragma头为no-cache


        System.out.println("获取单值参数name:" + request.getParameter("name"));

        String[] hobits = request.getParameterValues("hobits");
        System.out.println("获取具有多值的参数hobits: " + Arrays.asList(hobits));

        System.out.println("通过 getParameterMap 遍历所有的参数： ");
        Map<String, String[]> parameters = request.getParameterMap();

        Set<String> paramNames = parameters.keySet();
        for (String param : paramNames) {
            String[] value = parameters.get(param);
            System.out.println(param + ":" + Arrays.asList(value));
        }

    }

}

//获取单值参数name:admin
//获取具有多值的参数hobits: [lol]
//通过 getParameterMap 遍历所有的参数：
//name:[admin]
//hobits:[lol]