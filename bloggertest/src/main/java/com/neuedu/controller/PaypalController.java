//package com.neuedu.controller;
//
//import com.paypal.api.payments.Links;
//import com.paypal.api.payments.Payment;
//import com.paypal.base.rest.PayPalRESTException;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
//import com.neuedu.config.PaypalPaymentIntent;
//import com.neuedu.config.PaypalPaymentMethod;
//import com.neuedu.entity.User;
//import com.neuedu.service.PaypalService;
//import com.neuedu.service.UserService;
//import com.neuedu.Utils.URLUtils;
//
//import javax.annotation.Resource;
//import javax.servlet.http.HttpServletRequest;
//
//@Controller
//@RequestMapping(value = "paypal")
//public class PaypalController {
//	
//	@Autowired
//	UserService userservice;
//	
//    @Resource
//    private PaypalService paypalService;
//    public static final String PAYPAL_SUCCESS_URL = "paypal/pay/success";
//    public static final String PAYPAL_CANCEL_URL = "palpal/pay/cancel";
//
//    private Logger log = LoggerFactory.getLogger(PaypalController.class);
//
////    @RequestMapping(method = RequestMethod.GET)
////    public String index(){
////        return "pay";
////    }
////    method = RequestMethod.POST, 
//    @RequestMapping("/pay")
//    public String pay(@RequestParam("userid") int userid,
//    		          @RequestParam("type") int type,
//    		          HttpServletRequest request){
//        
//        String cancelUrl = URLUtils.getBaseURl(request) + "/" + PAYPAL_CANCEL_URL;
//        String successUrl = URLUtils.getBaseURl(request) + "/" + PAYPAL_SUCCESS_URL+"?userid="+userid+"&type="+type;
//        double price = 0;
//        if(type==1)price=10.00;
//        if(type==2)price=19.80;
//        if(type==3)price=49.00;
//        if(type==4)price=98.00;
//        try {
//            Payment payment = paypalService.createPayment(
//                    price, 
//                    "USD",
//                    PaypalPaymentMethod.paypal,
//                    PaypalPaymentIntent.sale,
//                    "payment description",
//                    cancelUrl,
//                    successUrl);
//            for(Links links : payment.getLinks()){
//                if(links.getRel().equals("approval_url")){
//                    return "redirect:" + links.getHref();
//                }
//            }
//        } catch (PayPalRESTException e) {
//            log.error(e.getMessage());
//        }
//        return "redirect:/";
//    }
//
//    @RequestMapping( "/pay/cancel")
//    public String cancelPay(){
//        log.info("cancle");
//        return "cancel";
//    }
//
//    @RequestMapping("/pay/success")
//    public String successPay(@RequestParam("userid") int payerId,@RequestParam("type") int type,Model model){
//    	//@RequestParam("paymentId") String paymentId,
//        int integral=0;
//        if(type==1)integral=100;
//        if(type==2)integral=200;
//        if(type==3)integral=500;
//        if(type==4)integral=1000;
//        User user=new User();
//        user.setUserid(payerId);
//        User reuser =userservice.selectUserByPrimaryKey(user);
//        reuser.setIntegral(reuser.getIntegral()+integral);
//        int retu = userservice.updateUserSelective(reuser);
////        try {
////            Payment payment = paypalService.executePayment(paymentId, payerId);
////            if(payment.getState().equals("approved")){
////                return "success";
////            }
////        } catch (PayPalRESTException e) {
////            log.error(e.getMessage());
////        }
//        model.addAttribute("currentuser", reuser); 
//        return "shopmarket/publishbankrecord";
//    }
//    
//    
//
//    @RequestMapping(value = "topay")
//    public String topay(){
//    
//        return "pay";
//    }
//
//
//
//}
