<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Title</title>
</head>
<body>
<h1>Hello</h1>

<script src="//code.jquery.com/jquery-3.2.1.min.js"></script>
<script>
  $(function(){
    $.ajax("http://localhost:8081/hello")
    .done(function(msg){
      alert(msg);
    })
    .fail(function(){
      alert("fail");
    })
  })
</script>
</body>
</html>