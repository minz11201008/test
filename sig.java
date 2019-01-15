    var appkey = '1nkhCLB7HU5eZ7dOL6c43A==';
   //获取当前时间
    function createTime() {
        return (new Date()).valueOf();
    }
    var time = createTime();
    var method = request.method;//提交方式
    delete request.data["sig"];//将sig排除排序
    console.log(request.data);
    var keys = Object.keys(request.data), i, len = keys.length;
      keys.sort();//根据key经行排序
     console.log(keys)
    // Build the request body string from the Postman request.data object
    var requestBody = "";
    var firstpass = true;
   // 构造数据为 key=param&key=param....字符串
    for(var index in keys){
          if(!firstpass){
            requestBody += "&";
        }
        if(keys[index]=="create_time"){
            request.data[keys[index]]=time;
            console.log(request.data[keys[index]]);
        }
        requestBody += keys[index] + "=" + request.data[keys[index]];
        firstpass = false;
    }
    
      console.log(requestBody);
    //将构造数据url编码
     var encodeURIdata = encodeURIComponent(requestBody);
     console.log(encodeURIdata);
    appkey=appkey+"&";
    //生成密钥
    var signHmacSHA1=CryptoJS.HmacSHA1(encodeURIdata, appkey);
    console.log(signHmacSHA1);
    var base64sha256 = CryptoJS.enc.Base64.stringify(signHmacSHA1);
       console.log(base64sha256);
    //    将变量放入postman 变量中
    //postman.setEnvironmentVariable('appid', appid);
    postman.setEnvironmentVariable('create_time', time);
    postman.setEnvironmentVariable('signature', base64sha256);
	
	
	
	
	
	
	
	
	
	
	
	
	
	==================================================
	
	
	    var appkey = '1nkhCLB7HU5eZ7dOL6c43A==';
    var url = 'http://localhost:8090/rest/';
    //生成密钥
    var signHmacSHA1=CryptoJS.HmacSHA1(url, appkey);
    var base64sha256 = CryptoJS.enc.Base64.stringify(signHmacSHA1);
    //将变量放入postman 变量中
    postman.setEnvironmentVariable('signature', base64sha256);
	
	
	
	
	