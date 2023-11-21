function viewBlog(blogId) {
    // 使用 Ajax 发送浏览请求
    $.ajax({
      type: 'POST',
      url: '/blog/view/' + blogId,
      success: function(response) {
        // 请求成功后，可以在此处更新页面显示的浏览量
        // 获取当前博客的浏览量元素
        var viewElement = $('#blogView-' + blogId);
        
        // 如果找到了对应的元素
        if (viewElement.length > 0) {
          // 从响应中获取新的浏览量值
          var newViewCount = parseInt(response);
  
          // 更新页面显示的浏览量
          viewElement.text('这篇博客的浏览量是：' + newViewCount);
        } else {
          // 找不到对应的元素，可以在这里进行其他处理
          alert('博客元素未找到！');
        }
      },
      error: function() {
        alert('发生错误，请重试！');
      }
    });
  }
  