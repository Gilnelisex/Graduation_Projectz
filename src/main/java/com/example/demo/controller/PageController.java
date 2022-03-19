package com.example.demo.controller;

import com.example.demo.domain.*;
import com.example.demo.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class PageController {

    @Autowired
    UsersService usersService;
    @Autowired
    RotationService rotationService;
    @Autowired
    ActivityService activityService;
    @Autowired
    BaseService baseService;
    @Autowired
    ReviewService reviewService;
    @Autowired
    JoininfoService joininfoService;

    @GetMapping("/")
    public String getHomePage(Model model, HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("tokens")) {
                    String tokens = cookie.getValue();
                    Users users = this.usersService.selectByPrimaryKey(Integer.parseInt(tokens));
                    if (users != null) {
                        if (users.getUserstatus() == 1) {
                            request.getSession().setAttribute("users", users);
                        }
                    }
                }
            }
        }
        List<Rotation> rotationList = this.rotationService.selectAllRotation();
        List<Activity> activityList = this.activityService.selectNewAct();
        List<Base> baseList = this.baseService.selectNewBase();
        Integer baseCount = this.baseService.selectBaseCount();
        List<Review> reviewList = this.reviewService.selectNewReview();
        model.addAttribute("rotationList", rotationList);
        model.addAttribute("activityList", activityList);
        model.addAttribute("baseList", baseList);
        model.addAttribute("baseCount", baseCount);
        model.addAttribute("reviewList", reviewList);
        return "homePage/homePage";
    }

    @GetMapping("/login")
    public String Login() {
        return "login";
    }

    @PostMapping("/doLogin")
    public String doLogin(Users user, String verify, Model model, HttpServletRequest request, HttpServletResponse response) {
        String code = (String) request.getSession().getAttribute("VerifyCode");
        verify = verify.toUpperCase();
        code = code.toUpperCase();
        if (verify.equals(code)) {
            Users users = this.usersService.selectUser(user);
            if (users != null) {
                if (users.getUserstatus() == 1) {
                    request.getSession().setAttribute("users", users);
                    Cookie cookie = new Cookie("tokens", (users.getId()).toString());
                    cookie.setMaxAge(86400);
                    response.addCookie(cookie);
                    return "redirect:/";
                } else {
                    model.addAttribute("fail", "账号被限制，请联系管理员!");
                    return "login";
                }
            } else {
                model.addAttribute("fail", "账号或密码错误!");
                return "login";
            }
        } else {
            model.addAttribute("fail", "验证码错误!");
            return "login";
        }
    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest request, HttpServletResponse response) {
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("tokens")) {
                    HttpSession session = request.getSession();
                    session.invalidate();
                    cookie.setMaxAge(0);
                    response.addCookie(cookie);
                }
            }
        }
        return "redirect:/";
    }

    @GetMapping("/register")
    public String Register() {
        return "register";
    }

    @PostMapping("/doRegister")
    public String doRegister(Users user, String verify, Model model, HttpServletRequest request) {
        String code = (String) request.getSession().getAttribute("VerifyCode");
        verify = verify.toUpperCase();
        code = code.toUpperCase();
        if (verify.equals(code)) {
//            if (this.usersService.selectByNickname(user) != null) {
//                model.addAttribute("fail", "昵称重复，请重新填写!");
//                return "register";
//            } else
            if (this.usersService.selectByAccount(user) != null) {
                model.addAttribute("fail", "账号重复，请重新填写!");
                return "register";
            } else {
                if (this.usersService.insertSelective(user) != 1) {
                    model.addAttribute("fail", "注册失败!");
                    return "register";
                } else {
                    model.addAttribute("success", "注册成功!");
                    return "register";
                }
            }
        } else {
            model.addAttribute("fail", "验证码错误!");
            return "register";
        }
    }

    @GetMapping("/activityPage")
    public String getActivityPage(Activity activity, Integer pageNum, Model model, HttpSession session) {
        if (pageNum == null) {
            pageNum = 1;
            //保留查询条件
            session.setAttribute("selectiveActivity", activity);
        } else {
            activity = (Activity) session.getAttribute("selectiveActivity");
        }
        List<Activity> activityList = this.activityService.selectAllAct(activity, pageNum, 6);
        List<Activity> typeList = this.activityService.selectAllType();
        List<Activity> harvestList = this.activityService.selectAllHarvest();
        model.addAttribute("activityList", activityList);
        model.addAttribute("typeList", typeList);
        model.addAttribute("harvestList", harvestList);
        return "activityPage/activityPage";
    }

    @GetMapping("/getActivityDetail")
    public String getActivityDetail(Integer id, Model model) {
        Activity activity = this.activityService.selectByPrimaryKey(id);
        Base base = this.baseService.selectByPrimaryKey(activity.getField());
        model.addAttribute("activity", activity);
        model.addAttribute("base", base);
        return "activityPage/activityDetail";
    }

    @GetMapping("/basePage")
    public String getBasePage(Base base, Integer pageNum, Model model, HttpSession session) {
        if (pageNum == null) {
            pageNum = 1;
            //保留查询条件
            session.setAttribute("selectiveBase", base);
        } else {
            base = (Base) session.getAttribute("selectiveBase");
        }
        List<Base> baseList = this.baseService.selectAllBase(base, pageNum, 6);
        List<Base> typeList = this.baseService.selectAllType();
        List<Base> provList = this.baseService.selectAllProv();
        if (base.getProvince() != null && base.getProvince().trim().length() > 0) {
            List<Base> cityList = this.baseService.selectAllCity(base);
            model.addAttribute("cityList", cityList);
        }
        model.addAttribute("baseList", baseList);
        model.addAttribute("typeList", typeList);
        model.addAttribute("provList", provList);
        return "basePage/basePage";
    }

    @GetMapping("/getBaseDetail")
    public String getBaseDetail(Integer id, Model model) {
        Base base = this.baseService.selectByPrimaryKey(id);
        List<Activity> activityList = this.activityService.selectByBase(id);
        model.addAttribute("base", base);
        if(activityList.size() != 0) {
            model.addAttribute("activityList", activityList);
        }
        return "basePage/baseDetail";
    }

    @GetMapping("/reviewPage")
    public String getReviewPage(Review review, Integer pageNum, Model model, HttpSession session) {
        if (pageNum == null) {
            pageNum = 1;
            //保留查询条件
            session.setAttribute("selectiveReview", review);
        } else {
            review = (Review) session.getAttribute("selectiveReview");
        }
        List<Review> reviewList = this.reviewService.selectAllReviews(review, pageNum, 6);
        model.addAttribute("reviewList", reviewList);
        return "reviewPage/reviewPage";
    }

    @GetMapping("/getReviewDetail")
    public String getReviewDetail(Integer id, Model model) {
        this.reviewService.updateVisit(id);
        Review review = this.reviewService.selectByPrimaryKey(id);
        Activity activity = this.activityService.selectByPrimaryKey(review.getRelationact());
        Base base = this.baseService.selectByPrimaryKey(activity.getField());
        model.addAttribute("review", review);
        model.addAttribute("activity", activity);
        model.addAttribute("base", base);
        return "reviewPage/reviewDetail";
    }

    @GetMapping("/personalCenter")
    public String personalCenter() {
        return "personalCenter/personalCenter";
    }

    @PutMapping("/changeUsers")
    public String changeUsers(Users users) {
        if (this.usersService.updateByPrimaryKeySelective(users) == 1) {
            return "redirect:/personalCenter";
        } else {
            return "redirect:/personalCenter";
        }
    }

    @GetMapping("/getChangePic/{id}")
    public String getChangePic(@PathVariable("id") Integer id, Model model) {
        Users users = this.usersService.selectByPrimaryKey(id);
        model.addAttribute("users", users);
        return "personalCenter/changePic";
    }

    @GetMapping("/getChangePassword/{id}")
    public String getChangePassword(@PathVariable("id") Integer id, Model model) {
        Users users = this.usersService.selectByPrimaryKey(id);
        model.addAttribute("users", users);
        return "personalCenter/changePassword";
    }

    @PostMapping("/changePassword")
    @ResponseBody
    public String changePassword(Users users) {
        if (this.usersService.updateByPrimaryKeySelective(users) == 1) {
            return "success";
        } else {
            return "fail";
        }
    }

    @GetMapping("/getEnroll/{id}")
    public String getEnroll(@PathVariable("id") Integer id, Model model) {
        Activity activity = this.activityService.selectByPrimaryKey(id);
        model.addAttribute("activity", activity);
        return "activityPage/enroll";
    }

    @PostMapping("/confirmDate")
    @ResponseBody
    public String confirmDate(Joininfo joininfo) {
        Activity activity = this.activityService.selectByPrimaryKey(joininfo.getActid());
        joininfo.setBaseid(activity.getField());
        if(this.joininfoService.selectByDate(joininfo).size() == 0) {
            return "success";
        } else {
            return "fail";
        }
    }

    @PostMapping("/enroll")
    @ResponseBody
    public String enroll(Joininfo joininfo) {
        Activity activity = this.activityService.selectByPrimaryKey(joininfo.getActid());
        joininfo.setUserprices(joininfo.getUsernums()*activity.getPrice());
        if(this.joininfoService.insertSelective(joininfo) == 1) {
            return "success";
        } else {
            return "fail";
        }
    }

    @GetMapping("/getOrderManage")
    public String getOrderManage(HttpServletRequest request, Model model) {
        Users users = (Users) request.getSession().getAttribute("users");
        List<Joininfo> joininfoList =this.joininfoService.selectByUserID(users.getId());
        if(joininfoList.size() != 0) {
            model.addAttribute("joininfoList", joininfoList);
        }
        return "personalCenter/orderManage";
    }

    @GetMapping("/getOrder/{id}")
    public String getOrder(@PathVariable("id") Integer id, Model model) {
        Joininfo joininfo = this.joininfoService.selectByJoinInfoID(id);
        model.addAttribute("joininfo", joininfo);
        return "personalCenter/orderDetail";
    }

    @GetMapping("/getCancel/{id}")
    public String getCancel(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("idz", id);
        return "personalCenter/cancelOrder";
    }

    @PutMapping("/cancelOrder")
    public String cancelOrder(Joininfo joininfo) {
        if(this.joininfoService.updateByPrimaryKeySelective(joininfo) == 1) {
            return "redirect:/getOrderManage";
        }else {
            return "redirect:/getOrderManage";
        }
    }

    @GetMapping("/getDelete/{id}")
    public String getDelete(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("idz", id);
        return "personalCenter/deleteOrder";
    }

    @PutMapping("/deleteOrder")
    public String deleteOrder(Joininfo joininfo) {
        if(this.joininfoService.updateByPrimaryKeySelective(joininfo) == 1) {
            return "redirect:/getOrderManage";
        }else {
            return "redirect:/getOrderManage";
        }
    }
}
