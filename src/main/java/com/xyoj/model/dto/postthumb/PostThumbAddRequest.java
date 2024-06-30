package com.xyoj.model.dto.postthumb;

import java.io.Serializable;
import lombok.Data;

/**
 * 帖子点赞请求
 *
 * @author xuyuan
 *  
 */
@Data
public class PostThumbAddRequest implements Serializable {

    /**
     * 帖子 id
     */
    private Long postId;

    private static final long serialVersionUID = 1L;
}