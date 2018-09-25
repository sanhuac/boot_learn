package com.huc.boot.web;


import com.huc.boot.result.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@Api(value = "账号设置接口", tags = {"账号设置接口"})
@RequestMapping(value = {"v1"}, method = RequestMethod.POST)
public class AccountSetUpController {



   // @Authority(value = AuthorityType.NoAuthority)
    @ApiOperation(value = "查找账号设置所需参数", notes = "查找账号设置所需参数")
    @RequestMapping(value = {"/account/setup"}, method = RequestMethod.POST)
    public String findMyAccount(@RequestHeader String token){
       // return accountSetUpService.findMemberBankCountByMemberId(token);
        return  null;
    }

   // @Authority(value = AuthorityType.NoAuthority)
    @ApiOperation(value = "设置提现密码短信验证码", notes = "设置提现密码短信验证码")
    @RequestMapping(value = {"/account/setup/send/message/put/forword"}, method = RequestMethod.POST)
    public String sendPutForword(@ApiParam(value = "发送短信所需参数")  HttpServletRequest request, @RequestHeader String token){

        return "";
    }


    //@Authority(value = AuthorityType.NoAuthority)
    @ApiOperation(value = "设置提现密码", notes = "设置提现密码")
    @RequestMapping(value = {"/account/setup/updata/cashpsw"}, method = RequestMethod.POST)
    public Result updateMemCashPsw(@ApiParam(value = "设置提现密码所需参数")BindingResult bindingResult, HttpServletRequest request, @RequestHeader String token) {
        Result result = new Result();
        if (bindingResult.hasErrors()) {
            List<FieldError> err = bindingResult.getFieldErrors();
            FieldError fe = err.get(0);
            result.setMark("1");
            result.setTip(fe.getDefaultMessage());
        } else {
           // result = accountSetUpService.updataCashPsw(accountSetUpUpdataCashPsw,request,token);
        }
        return result;
    }
}
