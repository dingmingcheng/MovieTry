<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html><head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>登录界面</title>
	<!-- BOOTSTRAP STYLES-->
    <link href="assets/css/bootstrap.css" rel="stylesheet" />
     <!-- FONTAWESOME STYLES-->
    <link href="assets/css/font-awesome.css" rel="stylesheet" />
    <script src="assets/js/jquery-3.2.1.js"></script>
    <script src="assets/js/jquery-3.2.1.min.js"></script>
        <!-- CUSTOM STYLES-->
    <link href="assets/css/custom.css" rel="stylesheet" />
     <!-- GOOGLE FONTS-->
   <link href='http://fonts.googleapis.com/css?family=Open+Sans' rel='stylesheet' type='text/css' />

<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css">
<style type="text/css">
body {
    padding: 0px;
    margin: 0px;
    background-color: rgb(33,33,33);background-image:url('');background-size:cover;backgrond-attachment:fixed;background-position:center;position:relative;
    color:#ccc;    font: 12px/1.5 Arial, 'Droid Sans', 'Hiragino Sans GB','Microsoft YaHei';
}



<style>
	#phoneLog{float: left; border-bottom: 1px solid #fff;font-size: 15px;padding: 10px 0 10px 0;width: 190px;color: #fff;}
	#webLog{float: right;border-bottom: 1px solid rgba(50,50,50,0);font-size: 15px;padding: 10px 0 10px 0;width: 189px;}
	.selectLog .v-line{float: left;width: 1px;height: 43px;background-color: #323232;}

	.other-wrap{overflow: hidden;margin-top: 20px;}
	.other-wrap .social-signup{float: left;}
	.other-wrap .social-signup span {
		vertical-align: middle;
	}
	.other-wrap .social-signup a {
		display: inline-block;
		color: #ccc;
		margin-left: 10px;
	}
	.other-wrap .social-signup i {
		vertical-align: middle;
		font-size: 16px;
		cursor: pointer;
		-webkit-transition: all 300ms ease-in-out;
		-moz-transition: all 300ms ease-in-out;
		transition: all 300ms ease-in-out;
	}
	.other-wrap .social-signup i:hover {
		color: #fff;
	}
	.other-wrap .forget-pwd{float: right;}
	.other-wrap .forget-pwd a {
		margin-left: 3px;
		margin-top: 20px;
		color: #ccc;
		font-size: 12px;
		-webkit-transition: all 300ms ease-in-out;
		-moz-transition: all 300ms ease-in-out;
		transition: all 300ms ease-in-out;
	}
	.other-wrap .forget-pwd a:hover {
		color: #fff;
	}
	.loading{
            width: 80px;
            height: 40px;
            margin: 0 auto;
            margin-top:100px;
        }
        .loading span{
            display: inline-block;
            width: 8px;
            height: 100%;
            border-radius: 4px;
            background: lightgreen;
            -webkit-animation: load 1s ease infinite;
        }
        @-webkit-keyframes load{
            0%,100%{
                height: 40px;
                background: lightgreen;
            }
            50%{
                height: 70px;
                margin: -15px 0;
                background: lightblue;
            }
        }
        .loading span:nth-child(2){
            -webkit-animation-delay:0.2s;
        }
        .loading span:nth-child(3){
            -webkit-animation-delay:0.4s;
        }
        .loading span:nth-child(4){
            -webkit-animation-delay:0.6s;
        }
        .loading span:nth-child(5){
            -webkit-animation-delay:0.8s;
        }

</style>
</head>


<body id="particles-js">

	<div class="loading" id="loading1" style="display:none;position:absolute;z-index:9999;height:30px;width:200px;top:30%;left:50%;
	margin-left:-150px;text-align:center;">
        <span></span>
        <span></span>
        <span></span>
        <span></span>
        <span></span>
	</div>
<div class="container">
        <div class="row text-center ">
            <div class="col-md-12">
                <br /><br />
                <h2> Rua! </h2>               
                <h5>( Login yourself to get access )</h5>
                 <br />
            </div>
        </div>
         <div class="row ">
               
                  <div class="col-md-4 col-md-offset-4 col-sm-6 col-sm-offset-3 col-xs-10 col-xs-offset-1">
                        <div class="panel panel-default">
                            <div class="panel-heading">
                        <strong>登录</strong>  
                            </div>
                            <div class="panel-body">
                                <form role="form">
                                       <br />
                                     <div class="form-group input-group">
                                            <span class="input-group-addon"><i class="fa fa-tag"  ></i></span>
                                            <input id="username" type="text" class="form-control" placeholder="请输入用户名" />
                                        </div>
                                                                              <div class="form-group input-group">
                                            <span class="input-group-addon"><i class="fa fa-lock"  ></i></span>
                                            <input id="password" type="password" class="form-control"  placeholder="请输入密码" />
                                        </div>
                                    <div class="form-group">
                                            <label class="checkbox-inline">
                                                <input type="checkbox" /> 记住我
                                            </label>
                                            <span class="pull-right">
                                                   <a href="#" >忘记密码？</a> 
                                            </span>
                                        </div>
                                     
                                     <a id="okay2" class="btn btn-primary ">登录</a>
                                    <hr />
                                    没有帐号? <a href="registeration.jsp" >点击这里</a> 
                                    </form>
                            </div>
                           
                        </div>
                    </div>                               
        </div>
    </div>

	<script type="text/javascript">
	$(function(){
		$("#okay2").click(function(){
			$("#loading1").show();
			$.ajax({
				url: 'loginer.do',  
		        type: 'POST',
		        data:{"username":$("#username").val(),"password":$("#password").val()},
		        success:function(data){	        	
		        	if("yes"==data){
	                    location.href="index.html";    
	                }else{  
	                    alert("用户名密码错误，请重新输入");
	                    $("#loading1").hide();
	                    return false;
	                }         
		        }
			})
		})
	})
	</script>
     <!-- SCRIPTS -AT THE BOTOM TO REDUCE THE LOAD TIME-->
    <!-- JQUERY SCRIPTS -->
    <script src="assets/js/jquery-1.10.2.js"></script>
      <!-- BOOTSTRAP SCRIPTS -->
    <script src="assets/js/bootstrap.min.js"></script>
    <!-- METISMENU SCRIPTS -->
    <script src="assets/js/jquery.metisMenu.js"></script>
      <!-- CUSTOM SCRIPTS -->
    <script src="assets/js/custom.js"></script>

</body>
</html>