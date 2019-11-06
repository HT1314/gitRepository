<%@page pageEncoding="utf-8"%>
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title></title>
		<link rel="stylesheet" type="text/css" href="css/style.css" />
		<script type="text/javascript" src="js/prototype-1.6.0.3.js">
        </script>
		<script type="text/javascript">
	function validateForm(){
                var form = document.forms['f1'];
                var b = validateUser(form['user']) & validatePwd(form['pwd']) &
                validatePwd1(form['pwd1'], form['pwd']) &
                validateEmail(form['email']);
                return b == 0 ? false : true;
            }
		
	
	function validateUser(f) {
		$('user_error').innerHTML = "";
		f.className = "";
		var value = f.value.strip();
		if (value.length == 0) {
			$('user_error').innerHTML = "用户必须填写";
			f.className = "error";
			return false;
		}
		return true;
	}
	            function validatePwd(f){
                $('pwd_error').innerHTML = "";
                f.className = "";
                var value = f.value.strip();
                if (value.length < 6) {
                    $('pwd_error').innerHTML = "密码必须大于6位";
                    f.className = "error";
                    return false;
                }
                return true;
            }
            function fresh(){
            document.getElementById('num').src='image?'+new Date().getTime();
            }
            
</script>
	</head>

	<body>
		<div id="wrap">
			<div id="top_content">
				<%@include file="header.jsp"%>
				<div id="content">
					<p id="whereami">
					</p>
					<h1>
						登录
					</h1>
					<form action="login.action" method="post" name="f1" >
						<table cellpadding="0" cellspacing="0" border="0"
							class="form_table">
							<tr>
								<td valign="middle" align="right">
									用户名:
								</td>
								<td valign="middle" align="left">
									<input type="text" class="inputgri" name="username"  onblur="validateUser(this);"/>
									<span id="user_error" ></span>
									
								</td>
							</tr>
							<tr>
								<td valign="middle" align="right">
									密码:
								</td>
								<td valign="middle" align="left">
									<input type="password" class="inputgri" name="password" />
									<span id="pwd_error" ></span>
									
								</td>

							</tr>
							<tr>
								<td valign="middle" align="right">
									验证码:
									<img id="num" src="image" alt="" />
									<a href="#" onClick="fresh()">换一张</a>
								</td>
								<td valign="middle" align="left">
									<input type="text" class="inputgri" name="number" />
								</td>

							</tr>
							<tr>
							<td colspan="2" align="center">
							<input type="submit" class="button" value="Submit &raquo;" />
							</td>
							</tr>
						</table>
															
						<center><span><font color="red">${errorMessage }</font></span></center>
					</form>
				</div>
			</div>
			<%@include file="foot.jsp"%>
		</div>
	</body>
</html>
