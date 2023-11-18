<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="entity.Thread"%>
<%@ page import="java.util.List"%>
<%@ page import="entity.User"%>

<%
List<Thread> threads = (List<Thread>) request.getAttribute("threads");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>thread view</title>
<style>
/* ポップアップのスタイル */
.popup-container {
	display: none;
	position: fixed;
	top: 50%;
	left: 50%;
	transform: translate(-50%, -50%);
	width: 700px;
	background-color: #fff;
	border: 1px solid #ccc;
	box-shadow: 0 0 10px rgba(0, 0, 0, 0.5);
	padding: 20px;
	z-index: 999;
}

/* ポップアップを閉じるボタンのスタイル */
.close-button {
	position: absolute;
	top: 5px;
	right: 5px;
	cursor: pointer;
}

.container {
	display: flex; /* flexコンテナを作成 */
	flex-direction: row; /* 要素を横に並べる */
}

.box {
	flex: 1; /* 各要素が均等に広がるように指定 */
	padding: 10px; /* パディングを追加（任意） */
}
</style>
</head>
<body>
	<h1>スレッド一覧</h1>
	<ul>
		<%
		String baseUrl = "/test-4/thread/";
		for (Thread thread : threads) {
			String url = baseUrl + thread.getId();
		%>
		<li><a href=<%=url%>> <%=thread.getTitle()%>
		</a> <%
 }
 %>
	</ul>
<!-- 	<form action="/test-4/thread" method="post">
		<label for="title">タイトル:</label><input type="text" id="title"
			name="title" required>
		<button type="submit">作成</button>
	</form>
<<<<<<< HEAD
 -->	
 	<p>
		<a href="/test-4/">back</a>
	</p>
	
    <button id="showPopupButton">スレッドを作成</button>

    <!-- ポップアップのコンテナ -->
    <div id="popupContainer" class="popup-container">
        <span class="close-button" id="closePopupButton">&times;</span>
        <h2>スレッドを作成する</h2>
        <form action="/test-4/thread" method="post">
            <div class="container">
                <div class="box">
                    <label for="title">タイトル:</label>
                    <br>
                    <input type="text" id="title"
                        name="title" required>
                </div>
                <div class="box">
                    <label for="category">カテゴリ:</label>
                    <br>
                    <select id="dropdown">
                        <option value="option1">オプション1</option>
                        <option value="option2">オプション2</option>
                        <option value="option3">オプション3</option>
                        <option value="option4">オプション4</option>
                    </select>
                </div>            
            </div>

            <label for="message">メッセージ:</label>
            <br>
            <textarea id="message" name="message" rows="4" cols="50" required></textarea>
            <br>
            <button type="submit">作成</button>
        </form>
    </div>

    <script>
        // ポップアップを表示する関数
        function showPopup() {
            var popup = document.getElementById('popupContainer');
            popup.style.display = 'block';
        }

        // ポップアップを閉じる関数
        function closePopup() {
            var popup = document.getElementById('popupContainer');
            popup.style.display = 'none';
        }

        // ボタンにクリックイベントハンドラを追加
        var showPopupButton = document.getElementById('showPopupButton');
        var closePopupButton = document.getElementById('closePopupButton');

        showPopupButton.addEventListener('click', showPopup);
        closePopupButton.addEventListener('click', closePopup);
    </script>

	<p><a href="/test-4/home">戻る</a></p>
</body>
</html>