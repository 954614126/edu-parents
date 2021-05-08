package com.definesys.edu.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.definesys.edu.bean.Teacher;
import com.definesys.edu.bean.query.TeacherQuery;
import com.definesys.edu.service.TeacherService;
import com.definesys.exceptionhandler.EduException;
import com.definesys.utils.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.sql.Wrapper;
import java.util.List;

/**
 * <p>
 * 讲师 前端控制器
 * </p>
 *
 * @author shuaishuai.li
 * @since 2021-05-03
 */
@Slf4j
@RestController
@RequestMapping("/edu/teacher")
public class TeacherController {
    @Autowired
    private TeacherService teacherService;

    @GetMapping("findAllTeacher")
    public Response findAllTeacher(){
//       1. 特定异常的测试
//        int a = 1/0;

//       2. 自定义异常的测试
//        try{
//          int a = 1/0;
//        }catch (Exception e){//用大于等于抛出的异常,自定义的捕获不了
//            throw  new EduException(400,"自定义算数异常");
//        }

//        日志注解单独测试
//        log.info("测试...");
        List<Teacher> list = teacherService.list(null);
        return Response.ok().data("teachers",list);
    }

    @DeleteMapping("{id}")
    public Response deleteById(@PathVariable String id){
        boolean result = teacherService.removeById(id);
        System.out.println(result);
        if(result==true){
            return Response.ok();
        }else {
            return Response.error();
        }
    }

    @GetMapping("pageList/{current}/{limit}")
    public Response pageList(@PathVariable long current,@PathVariable long limit){
//        3. 全局异常的测试
//        int a[] = new int[1];
//        System.out.println(a[10]);
        Page<Teacher> page = new Page<>(current,limit);
        teacherService.page(page,null);
        long total = page.getTotal();
        List<Teacher> teacherList = page.getRecords();
        return Response.ok().data("total",total).data("teacherList",teacherList);
    }

    @PostMapping("pageList/{current}/{limit}")
    public Response pageList(@PathVariable long current, @PathVariable long limit, @RequestBody
                             TeacherQuery teacherQuery){
        Page<Teacher> page = new Page<>(current,limit);
        QueryWrapper<Teacher> wrapper = new QueryWrapper<>();
        String name = teacherQuery.getName();
        Integer level = teacherQuery.getLevel();
        String startTime = teacherQuery.getStartTime();
        String endTime = teacherQuery.getEndTime();

        if(!StringUtils.isEmpty(name)){
            wrapper.like("name",name);
        }
        if(level!=null){
            wrapper.eq("level",level);
        }
        if(!StringUtils.isEmpty(startTime)){
            wrapper.ge("gmt_create",startTime);
        }
        if(!StringUtils.isEmpty(endTime)){
            wrapper.le("gmt_modified",endTime);
        }

        teacherService.page(page,wrapper);
        long total = page.getTotal();
        List<Teacher> records = page.getRecords();
        return Response.ok().data("total",total).data("records",records);

    }

    @PostMapping("addTeacher")
    public Response addTeacher(@RequestBody Teacher teacher){
        if(teacher!=null){
            boolean save = teacherService.save(teacher);
            return Response.ok().message("数据插入成功");
        }else {
            return Response.error().message("数据插入失败");
        }
    }

    @GetMapping("findTeacher/{id}")
    public Response findTeacher(@PathVariable String id){
        Teacher teacher = teacherService.getById(id);
        if(teacher!=null){
            return Response.ok().data("teacher",teacher);
        }else {
            return Response.error().message("未查到当前id的讲师");
        }
    }

    @PostMapping("updateTeacher")
    public Response updateTeacher(@RequestBody Teacher teacher){
        boolean update = teacherService.updateById(teacher);
        if(update){
            return  Response.ok().message("数据更新成功");
        }else{
            return  Response.error().message("数据更新失败");
        }
    }
}

