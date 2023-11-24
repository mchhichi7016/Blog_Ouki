$.ajax({
    type: 'POST',
    url: '/blog/comment/' + blogId,
    data: {
        commentContent: commentContent,
        accountId: accountId,
        blogId: blogId
    },
    success: function(response) {
        // 更新评论区域的内容
        $('.comments ul').append('<li><p>' + commentContent + '</p></li>');

        // 其他逻辑...
    },
    error: function() {
        alert('发生错误，请重试！');
    }
});
