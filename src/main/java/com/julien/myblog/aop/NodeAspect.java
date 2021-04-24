//package com.julien.myblog.aop;
//
//import com.julien.myblog.bean.Node;
//import com.julien.myblog.service.NodeService;
//import com.julien.myblog.utils.IpUtil;
//import com.julien.myblog.utils.iputil.IPSeeker;
//import org.aspectj.lang.ProceedingJoinPoint;
//import org.aspectj.lang.annotation.After;
//import org.aspectj.lang.annotation.Around;
//import org.aspectj.lang.annotation.Aspect;
//import org.slf4j.Logger;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//import org.springframework.web.context.request.RequestAttributes;
//import org.springframework.web.context.request.RequestContextHolder;
//import org.springframework.web.context.request.ServletRequestAttributes;
//
//import javax.servlet.http.HttpServletRequest;
//
///**
// * @function: AOP
// * @author: 863978160@qq.com
// * @create: 2021-01-20 23:26
// **/
//
//@Component
//@Aspect
//public class NodeAspect {
//
//    private final NodeService nodeService;
//    private final IPSeeker ipSeeker;
//    private final Logger logger;
//
//    @Autowired
//    public NodeAspect(NodeService nodeService, IPSeeker ipSeeker, Logger logger) {
//        this.nodeService = nodeService;
//        this.ipSeeker = ipSeeker;
//        this.logger = logger;
//    }
//
//    @After("execution(* com.julien.myblog.controller.NodeController.getNodeList())")
//    public void getAfter(){
//        logger.info("正在查询节点");
//    }
//
//
//    @Around("execution(* com.julien.myblog.controller.NodeController.getNodeText(..))")
//    public Object getBefore(ProceedingJoinPoint pjp) throws Throwable {
//
//        RequestAttributes ra = RequestContextHolder.getRequestAttributes();
//        ServletRequestAttributes sra = (ServletRequestAttributes) ra;
//        assert sra != null;
//        HttpServletRequest request = sra.getRequest();
//        String ip = IpUtil.getIpAddr(request);
//        String agent = request.getHeader("user-agent");
//        String address =  ipSeeker.getCountry(ip)+ipSeeker.getArea(ip);
//        String token = request.getParameter("token");
//        Node  node = new Node(ip,agent,token,address);
//        System.out.println(node);
//        if (nodeService.UpdateNode(node)>0){
//            logger.info(ip+agent+address+"正在查询节点信息");
//        }else {
//            logger.info("修改失败");
//        }
//        return pjp.proceed();
//    }
//}
