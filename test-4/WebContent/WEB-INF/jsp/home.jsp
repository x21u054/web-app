<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!doctype html>
<html lang="en">

<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>home</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM"
	crossorigin="anonymous">
<style>
.text-box {
	border: 2px solid #000;
	padding: 10px;
	margin: auto;
	width: 60%;
	/* 固定の幅を設定 */
}

.inbox-text {
	margin-left: 40px;
}

.text-box1 {
	border: 2px solid #000;
	padding: 30px;
	margin: auto;
	width: 20%;
	height: 360px;
	/* 固定の幅を設定 */
}

.inbox-text1 {
	margin-left: 40px;
}

.container {
	display: flex; /* フレックスボックスを使用 */
	flex-wrap: wrap;
}

.container-item {
	flex-basis: auto;
}

/* LINE007 */
.button_line007 a {
	position: relative;
	display: flex;
	justify-content: center;
	align-items: center;
	margin: 0 auto;
	max-width: 220px;
	padding: 10px 25px;
	color: #313131;
	transition: 0.3s ease-in-out;
	font-weight: 600;
	background: #eee;
	max-width: 100%;
	height: auto;
	float: right;
	top: -40px;
	font-size: 10px;
	text-decoration: none;
}

.button_line007 a:hover {
	background: #ebfcfe;
	color: #6bb6ff;
}

.button_line007 a:before, .button_line007 a:after {
	box-sizing: inherit;
	content: "";
	position: absolute;
	border: 2px solid transparent;
	width: 0;
	height: 0;
}

.button_line007 a:before {
	top: 0;
	left: 0;
}

.button_line007 a:after {
	bottom: 0;
	right: 0;
}

.button_line007 a:hover:before, .button_line007 a:hover:after {
	width: 100%;
	height: 100%;
}

.button_line007 a:hover:before {
	border-top-color: #6bb6ff;
	border-right-color: #6bb6ff;
	transition: width 0.15s ease-out, height 0.15s ease-out 0.15s;
}

.button_line007 a:hover:after {
	border-bottom-color: #6bb6ff;
	border-left-color: #6bb6ff;
	transition: border-color 0s ease-out 0.2s, width 0.15s ease-out 0.2s,
		height 0.15s ease-out 0.3s;
}

.button_line006 a {
	position: relative;
	display: flex;
	justify-content: center;
	align-items: center;
	margin: 0 auto;
	max-width: 220px;
	padding: 10px 25px;
	color: #313131;
	transition: 0.3s ease-in-out;
	font-weight: 600;
	background: #eee;
	max-width: 100%;
	height: auto;
	float: right;
	top: -40px;
	font-size: 9px;
	text-decoration: none;
}

.button_line006 a:hover {
	background: #ebfcfe;
	color: #6bb6ff;
}

.button_line006 a:before, .button_line006 a:after {
	box-sizing: inherit;
	content: "";
	position: absolute;
	border: 2px solid transparent;
	width: 0;
	height: 0;
}

.button_line006 a:before {
	top: 0;
	left: 0;
}

.button_line006 a:after {
	bottom: 0;
	right: 0;
}

.button_line006 a:hover:before, .button_line006 a:hover:after {
	width: 100%;
	height: 100%;
}

.button_line006 a:hover:before {
	border-top-color: #6bb6ff;
	border-right-color: #6bb6ff;
	transition: width 0.15s ease-out, height 0.15s ease-out 0.15s;
}

.button_line006 a:hover:after {
	border-bottom-color: #6bb6ff;
	border-left-color: #6bb6ff;
	transition: border-color 0s ease-out 0.2s, width 0.15s ease-out 0.2s,
		height 0.15s ease-out 0.3s;
}

/* 内側の枠のスタイル */
.inner-frame {
	border: 2px solid #000;
	padding: 10px;
	margin: 10px 0;
}

.event-container {
	position: fixed;
	bottom: 40px;
	right: 185px;
	background-color: #ffffff;
	border: 2px solid #000;
	padding: 40px;
	width: 1166px;
}
</style>

</head>

<body>
	<nav class="navbar navbar-expand-lg bg-body-tertiary">
		<div class="container-fluid">
			<a class="navbar-brand" href="#">CampusCraft</a>
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
				aria-controls="navbarSupportedContent" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarSupportedContent">
				<ul class="navbar-nav me-auto mb-2 mb-lg-0">
					<li class="nav-item"><a class="nav-link active"
						aria-current="page" href="home.html">ホーム </a></li>
					<li class="nav-item dropdown"><a
						class="nav-link dropdown-toggle" href="#" role="button"
						data-bs-toggle="dropdown" aria-expanded="false"> サービス </a>
						<ul class="dropdown-menu">
							<li><a class="dropdown-item" href="license.html">基本操作</a></li>
							<li><a class="dropdown-item" href="job.html">利用方法</a></li>
							<li><a class="dropdown-item" href="thread.html">掲示板</a></li>
							<li>
								<hr class="dropdown-divider">
							</li>
							<li><a class="dropdown-item" href="profile.html">プロフィール</a></li>
						</ul></li>
				</ul>
				<form class="d-flex" role="search">
					<input class="form-control me-2" type="search" placeholder="Search"
						aria-label="Search">
					<button class="btn btn-outline-success" type="submit">Search</button>
				</form>
			</div>
		</div>
	</nav>

	<h1 style="text-align: center;">ホーム</h1>
	<div class="container">
		<div class="text-box">
			<p style="margin-left: 40px;">サービス一覧<div class="button_line007"></div>
        </p>
			
        <hr />
        <div class="inner-frame">
          <a href="リンク先のパス">
            <font size="5">資格</font>
          </a><br>
          
        </div>
        <div class="inner-frame">
          <a href="リンク先のパス">
            <font size="5">掲示板</font>
          </a><br>
          
        </div>
        <div class="inner-frame">
          <a href="リンク先のパス">
            <font size="5">就活</font>
          </a><br>
          
        </div>
 
      </div>
 
      <!-- チェックボックス -->
      <div class="text-box1">
       
        <div class="button_line006">
       
        </div>
        </p>
        <hr />
        <ul>
 <p style=margin-left:40px;>チュートリアル
          
				<li class="list-group-item">
            <input class="form-check-input me-1" type="checkbox"
					value="" id="firstCheckbox">
            <label class="form-check-label" for="firstCheckbox">基本操作</label>
          </li>
          <li class="list-group-item">
            <input class="form-check-input me-1" type="checkbox"
					value="" id="secondCheckbox">
            <label class="form-check-label" for="secondCheckbox">利用方法</label>
          </li>
        </ul>
      </div>
    </div>
  <div class="event-container">
    <h2>今月のイベント</h2>
    <p>三社合同説明会</p>
  </div>
    <script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz"
		crossorigin="anonymous"></script>
  </body>
</html>