// 提交评论的 Ajax 请求
$.ajax({
    type: 'POST',
    url: '/blog/comment/' + blogId,
    data: {
        // 提交的评论内容和其他参数
        commentId: commentId,
        commentContent: commentContent,
        commentTime: commentTime,
        accountId: accountId,
        blogId: blogId
    },
    success: function(response) {
        // 请求成功后，可以在此处更新页面显示的评论
        // 这里可以使用 JavaScript 操作 DOM，将新的评论内容添加到页面中
    },
    error: function() {
        alert('发生错误，请重试！');
    }
});
