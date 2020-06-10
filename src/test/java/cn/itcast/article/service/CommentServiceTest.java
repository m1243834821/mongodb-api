package cn.itcast.article.service;


import cn.itcast.article.ArticleApplication;
import cn.itcast.article.entity.Comment;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ArticleApplication.class)
public class CommentServiceTest {
    @Autowired
    CommentService commentService;

    @Test
    public void testSaveComment() {
        Comment comment = new Comment();
        comment.setArticleid("1000001");
        comment.setContent("测试添加的数据1");
        comment.setCreatedatetime(LocalDateTime.now());
        comment.setUserid("1003");
        comment.setNickname("凯撒大帝");
        comment.setState("1");
        comment.setLikenum(0);
        comment.setReplynum(0);
        commentService.saveComment(comment);
    }

    @Test
    public void testFindAll() {
        List<Comment> list = commentService.findCommentList();
        System.out.println(list);
    }

    @Test
    public void testFindCommentById() {
        Comment comment = commentService.findCommentById("5ee09304d31c140478b56776");

        System.out.println(comment);
    }

    @Test
    public void testFindCommentListPageByParentid() {
        Page<Comment> pageResponse = commentService.findCommentListPageByParentid("3", 1, 2);
        System.out.println("	总记录数：" + pageResponse.getTotalElements());
        System.out.println("当前页数据：" + pageResponse.getContent());
    }

    @Test
    public void testUpdateCommentLikenum() {
        // 对 3 号 文 档 的 点 赞 数 +1
        commentService.updateCommentLikenum("33");
    }


}
