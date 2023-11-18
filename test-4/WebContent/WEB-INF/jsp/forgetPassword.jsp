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

.rounded-end {
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

/* .form-signin #inputEmail,
.form-signin #inputPassword {
    direction: ltr;
    height: 44px;
    font-size: 16px;
} */
.form-signin input[type=email], .form-signin input[type=password],
	.form-signin input[type=text], .form-signin button {
	width: 100%;
	display: block;
	margin-bottom: 10px;
	z-index: 1;
	position: relative;
	-moz-box-sizing: border-box;
	-webkit-box-sizing: border-box;
	box-sizing: border-box;
}

.form-signin .form-control:focus {
	border-color: rgb(104, 145, 162);
	outline: 0;
	-webkit-box-shadow: inset 0 1px 1px rgba(0, 0, 0, .075), 0 0 8px
		rgb(104, 145, 162);
	box-shadow: inset 0 1px 1px rgba(0, 0, 0, .075), 0 0 8px
		rgb(104, 145, 162);
}

.btn.btn-submit {
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

#validate_msg {
	color: red;
}

.btn.btn-signin:hover, .btn.btn-signin:active, .btn.btn-signin:focus {
	background-color: rgb(12, 97, 33);
}
</style>

<title>register</title>

<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
</head>
<body>
	<div class="container">
		<div class="card card-container">
			<!-- <img class="profile-img-card" src="//lh3.googleusercontent.com/-6V8xOA6M7BA/AAAAAAAAAAI/AAAAAAAAAAA/rzlHcD0KYwo/photo.jpg?sz=120" alt="" /> -->
			<!-- <img id="profile-img" class="profile-img-card" src="//ssl.gstatic.com/accounts/ui/avatar_2x.png" /> -->
			<h1 class="rounded-end">メールアドレス入力</h1>

			<form action="/test-4/forget-password" method="post"
				class="form-signin" name="form">
				<p id="validate_msg"></p>
				<input type="email" id="inputEmail" class="form-control"
					placeholder="メールアドレス" name="email" required autofocus>
				<button class="btn btn-lg btn-primary btn-block btn-submit"
					type="submit" onclick="CheckEmail_1()">送信</button>
			</form>
			<!-- /form -->

		</div>
		<!-- /card-container -->
	</div>
	<!-- /container -->

	<script>
		function CheckEmail_1() {
			//IE対応の為変更
			//var mail = email_1.value; //メールフォームの値を取得
			//var mailConfirm = emailConfirm_1.value; //メール確認用フォームの値を取得
			var mail = document.getElementById("inputEmail").value; //メールフォームの値を取得
			var mdomain = mail.substr(-17, 17);
			var validate = "メールアドレスの形式が間違っています。";
			console.log(mail);
			// ドメインの一致確認
			if (mdomain === "@mitsuhashi.ac.jp") {
				document.form.submit();
				return true;

			} else {
// 				alert("メールアドレスの形式が間違っています。");
				// 一致していなかったら、エラーメッセージを表示する
				document.getElementById("validate_msg").innerHTML = validate;
				return false;
			}
		};
	</script>


</body>
</html>
