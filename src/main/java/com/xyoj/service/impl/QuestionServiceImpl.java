package com.xyoj.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xyoj.model.entity.Question;
import com.xyoj.service.QuestionService;
import com.xyoj.model.QuestionMapper;
import org.springframework.stereotype.Service;

/**
* @author xuyuan
* @description 针对表【question(创建题目)】的数据库操作Service实现
* @createDate 2024-06-27 23:32:31
*/
@Service
public class QuestionServiceImpl extends ServiceImpl<QuestionMapper, Question>
    implements QuestionService{

}




