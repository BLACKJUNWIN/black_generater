package ${package.Controller};

import org.springframework.web.bind.annotation.RequestMapping;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
<#if restControllerStyle>
import org.springframework.web.bind.annotation.RestController;
<#else>
import org.springframework.stereotype.Controller;
</#if>
<#if superControllerClassPackage??>
import ${superControllerClassPackage};
</#if>
<#assign path = package.Parent?split(".")>
import ${path[0]}.${path[1]}.common.entity.ApiCode;
import ${path[0]}.${path[1]}.common.entity.ApiRes;
import ${path[0]}.${path[1]}.common.entity.BlPageInfo;
import ${package.Service}.${table.serviceName};
import ${package.Entity}.${entity};
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
/**
 * <p>
 * ${table.comment!} 前端控制器
 * </p>
 *
 * @author ${author}
 * @since ${date}
 */
@CrossOrigin
<#if restControllerStyle>
@RestController
<#else>
@Controller
</#if>
@RequestMapping("<#if package.ModuleName?? && package.ModuleName != "">/${package.ModuleName}</#if>/<#if controllerMappingHyphenStyle>${controllerMappingHyphen}<#else>${table.entityPath?replace("([a-z])([A-Z]+)","$1_$2","r")?lower_case}</#if>")
<#if kotlin>
class ${table.controllerName}<#if superControllerClass??> : ${superControllerClass}()</#if>
<#else>
<#if superControllerClass??>
public class ${table.controllerName} extends ${superControllerClass} {
<#else>
public class ${table.controllerName} {
</#if>
    @Autowired
    private ${table.serviceName} ${table.serviceName? uncap_first};

    /**
    * 添加数据
    *
    */
    @PostMapping("/")
    public ApiRes<?> save(@RequestBody ${entity} ${entity? uncap_first}){
        if (${table.serviceName? uncap_first}.save(${entity? uncap_first})){
            return ApiRes.SuccessApi();
        }
        return ApiRes.FailApi();
    }

    /**
    * 删除数据
    *
    */
    @DeleteMapping("/{id}")
    public ApiRes<?> remove(@PathVariable("id") Long id){
        if(${table.serviceName? uncap_first}.removeById(id)){
            return ApiRes.SuccessApi();
        }
        return ApiRes.FailApi();
    }

    /**
    * 修改数据
    *
    */
    @PutMapping("/")
    public ApiRes<?> modify(@RequestBody ${entity} ${entity? uncap_first}){
        if(${table.serviceName? uncap_first}.modifyAll(${entity? uncap_first})!=0){
            return ApiRes.SuccessApi();
        }
        return ApiRes.FailApi();
    }
    /**
    * 查询全部
    *
    */
    @GetMapping("/")
    public ApiRes<?> findAll(){
        PageHelper.startPage(0,10);
        return new ApiRes<>(new BlPageInfo<>(${table.serviceName? uncap_first}.list()));
    }
    /**
    * 任意查询
    *
    */
    @PatchMapping("/")
    public ApiRes<?> findBy(@RequestBody ${entity} ${entity? uncap_first}){
        PageHelper.startPage(${entity? uncap_first}.getPageNum(),${entity? uncap_first}.getPageSize());
        return new ApiRes<>(new BlPageInfo<>(${table.serviceName? uncap_first}.findAll(${entity? uncap_first})));
    }
}
</#if>
