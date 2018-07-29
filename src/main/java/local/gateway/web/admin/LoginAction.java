package local.gateway.web.admin;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author: eleven
 * @since: 2018/7/13 21:19
 * @description:
 */
@Slf4j
@RestController
@RequestMapping("login")
public class LoginAction{


    @GetMapping("login")
    public boolean login(HttpServletRequest request, HttpServletResponse response,String account, String password){

        HttpSession session = request.getSession();
        String sessionId =  session.getId();
        log.info("sessionId:{}",sessionId);
//        String server = "server";
//        boolean hasSetCook =  false;
//        for (Cookie cookie : cookies) {
//            if (cookie.getName().equals(server)){
//                hasSetCook = true;
//                break;
//            }
//        }
//        if (!hasSetCook){
//            response.addCookie(new Cookie(server,sessionId));
//        }

        session.setAttribute("account",account);
        session.setAttribute("password",password);
        return true;

    }
    @GetMapping("doLoginOut")
    public boolean doLoginOut(HttpServletRequest request, HttpServletResponse response){

        HttpSession session = request.getSession();
        session.removeAttribute("account");
        session.removeAttribute("password");
        session.invalidate();
        return false;
    }

    @GetMapping("checkLogin")
    public boolean checkLogin(HttpServletRequest request){

        HttpSession session = request.getSession();
        String account = (String) session.getAttribute("account");
        return StringUtils.isNotBlank(account);
    }

}
