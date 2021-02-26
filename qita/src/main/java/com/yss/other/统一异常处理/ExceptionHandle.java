package com.yss.other.统一异常处理;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**异常统一处理类，方便用户可以更加友好的看到错误信息
 * @author: duhao
 * @date: 2021/1/30 10:47
 */
@ControllerAdvice
public class ExceptionHandle {
    //增加异常日志打印
    private final static Logger logger = LoggerFactory.getLogger(ExceptionHandle.class);
    //设置异常错误的页面
    public static final String DEFAULT_ERROR_VIEW = "error";
    /**
     * 以json的格式进行返回内容(开发环境一般个人是用这个比较好)
     * @param e
     * @return
     */
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Object handle(HttpServletRequest req, Exception e){
        //如果是自定义的异常
        if(e instanceof MyException){
            MyException myException = (MyException)e;
            return ResultUtil.getError(myException.getCode(),myException.getMessage());
        }else{
            //如果是系统的异常，比如空指针这些异常
            logger.error("【系统异常】={}",e);
            return ResultUtil.getError(ResultEnum.SystemException.getCode(),ResultEnum.SystemException.getMsg());
        }
    }

    /**
     * 判断是否是Ajax的请求
     * @param request
     * @return
     */
    public boolean isAjax(HttpServletRequest request){
        return (request.getHeader("X-Requested-With") != null
                &&
                "XMLHttpRequest".equals(request.getHeader("X-Requested-With").toString()));
    }
    /*
    //备注:
    //这个是正式项目完成之后的错误统一处理(开发情况先用上面的的)
    //我们在开发过程中还是用json格式的会好一些，要不然看错误麻烦
    @ExceptionHandler(value = Exception.class)
    public ModelAndView defaultErrorHandler(HttpServletRequest req, Exception e) throws Exception {
        e.printStackTrace();
        //判断是否是Ajax的异常请求（如果是Ajax的那么就是返回json格式）
        if(isAjax(req)){
            //如果是自定义的异常
            if(e instanceof MyException){
                MyException myException = (MyException)e;
                return ResultUtil.getError(myException.getCode(),myException.getMessage());
            }else{
                //如果是系统的异常，比如空指针这些异常
                logger.error("【系统异常】={}",e);
                return ResultUtil.getError(ResultEnum.SystemException.getCode(),ResultEnum.SystemException.getMsg());
            }
        }else{
            //如果是系统内部发生异常，那么就返回到错误页面进行友好的提示
            ModelAndView mav = new ModelAndView();
            //这些就是要返回到页面的内容（其实不用都行，反正用户也不懂，没必要在页面显示都可以，先写着吧）
            mav.addObject("exception", e);
            mav.addObject("url", req.getRequestURL());
            mav.setViewName(DEFAULT_ERROR_VIEW);
            return mav;
        }
    }
    */

}
