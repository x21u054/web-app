<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style>
    body, html {
    height: 100%;
    background-repeat: no-repeat;
    /* background-image: linear-gradient(rgb(104, 145, 162), rgb(12, 97, 33)); */
}

.rounded-end{
    border: solid 1px;
    padding: 5px;
    text-align: center;
}

.card-container.card {
    max-width: 380px;
    padding: 40px 40px;
}

.btn {
    font-weight: 700;
    height: 36px;
    -moz-user-select: none;
    -webkit-user-select: none;
    user-select: none;
    cursor: default;
}

/*
 * Card component
 */
.card {
    background-color: #F7F7F7;
    /* just in case there no content*/
    padding: 20px 25px 30px;
    margin: 0 auto 25px;
    margin-top: 50px;
    /* shadows and rounded borders */
    -moz-border-radius: 2px;
    -webkit-border-radius: 2px;
    border-radius: 2px;
    -moz-box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);
    -webkit-box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);
    box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);
}

/*
 * Form styles
 */



.btn.btn-login {
    /*background-color: #4d90fe; */
    background-color: rgb(72, 199, 199);
    /* background-color: linear-gradient(rgb(104, 145, 162), rgb(12, 97, 33));*/
    padding: 0px;
    width: 100px;
    font-weight: 700;
    font-size: 14px;
    height: 36px;
    -moz-border-radius: 3px;
    -webkit-border-radius: 3px;
    border-radius: 3px;
    border: none;
    -o-transition: all 0.218s;
    -moz-transition: all 0.218s;
    -webkit-transition: all 0.218s;
    transition: all 0.218s;
    /* top:50; bottom:1px; left: 130px;; right:0; */
    margin: auto;
}


.btn.btn-signin:hover,
.btn.btn-signin:active,
.btn.btn-signin:focus {
    background-color: rgb(12, 97, 33);
}

.chara_container{
    margin: auto;
}

</style>

<title>register</title>
 
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
    <div class="container">
        <div class="card card-container">
            <!-- <img class="profile-img-card" src="//lh3.googleusercontent.com/-6V8xOA6M7BA/AAAAAAAAAAI/AAAAAAAAAAA/rzlHcD0KYwo/photo.jpg?sz=120" alt="" /> -->
            <!-- <img id="profile-img" class="profile-img-card" src="//ssl.gstatic.com/accounts/ui/avatar_2x.png" /> -->
            <h1 class="rounded-end">新規登録完了</h1>

            <div class="chara_container">
                <p> </p>
                <p>アカウントの新規登録が完了しました</p>
                <p>ログイン画面よりログインしてください</p>
            </div>
            <button class="btn btn-lg btn-primary btn-block btn-login" onclick="window.location.href='/test-4/login'">ログイン</button>
 
        </div><!-- /card-container -->
        
    </div><!-- /container -->
 
</body>
</html>
