/**
 * add num1 and num2 isNum Validation
 * 
 */
var soap = require('soap');
var baseURL = "http://localhost:8085/Calculator-soap_service/services/CalcOperationsImpl?wsdl";
var option = {
		ignoredNamespaces : true	
	};

exports.compute = function(req,res){
	// These two variables come from the form on
	var operator = req.param("operator");
	var num1 = parseFloat(req.param("num1"));
	var num2 = parseFloat(req.param("num2"));
	console.log("num1:"+num1);
	console.log("num2:"+num2);
	var json_response;
	
	var params = {};
	
	if(isNaN(num1)=== true || isNaN(num2)=== true){
		json_responses = {"statusCode" : 401, "result":"Error"};
		console.log("Wrong Operands");
		res.send(json_responses);
	}
	
	switch(operator){
		case "+":
			/*var result = num1 + num2;
			json_responses = {"statusCode" : 200, "result":result};
			console.log("result:"+result);
			res.send(json_responses);
			break;*/
			params = {num1: num1,num2: num2};
			console.log("params: " + params);
			soap.createClient(baseURL,option, function(err, client) {
			      if(err){
			    	  console.log("Error in SOAP Request" + err);
			      }else{
			    	  client.add(params, function(err, result) {
			    		  console.log("In Add Method");
				    	  if(err){
				    		  console.log("Error in SOAP Add" + err);
				    	  }else{
				    		  console.log("Add Method Result: " + result.addReturn);
				    		  json_response = {'statusCode': '200', 'result': result.addReturn};
				    		  res.send(json_response);
				    	  }
				      }); 
			      }
			  });
			break;
			
		case "-":
			/*var result = num1 - num2;
			json_responses = {"statusCode" : 200, "result":result};
			console.log("result:"+result);
			res.send(json_responses);
			break;*/
			
			params = {num1: num1,num2: num2};
			console.log("params: " + params);
			soap.createClient(baseURL,option, function(err, client) {
			      if(err){
			    	  console.log("Error in SOAP Request" + err);
			      }else{
			    	  client.substract(params, function(err, result) {
			    		  console.log("In Subtract Method");
				    	  if(err){
				    		  console.log("Error in SOAP Subtract" + err);
				    	  }else{
				    		  console.log("Subtract Method Result: " + result.substractReturn);
				    		  json_response = {'statusCode': '200', 'result': result.substractReturn};
				    		  res.send(json_response);
				    	  }
				      }); 
			      }
			  });
			break;
			
		case "X":
			/*var result = num1 * num2;
			json_responses = {"statusCode" : 200, "result":result};
			console.log("result:"+result);
			res.send(json_responses);
			break;*/
			
			params = {num1: num1,num2: num2};
			console.log("params: " + params);
			soap.createClient(baseURL,option, function(err, client) {
			      if(err){
			    	  console.log("Error in SOAP Request" + err);
			      }else{
			    	  client.multiply(params, function(err, result) {
			    		  console.log("In Multiply Method");
				    	  if(err){
				    		  console.log("Error in SOAP Multiply" + err);
				    	  }else{
				    		  console.log("Multiply Method Result: " + result.multiplyReturn);
				    		  json_response = {'statusCode': '200', 'result': result.multiplyReturn};
				    		  res.send(json_response);
				    	  }
				      }); 
			      }
			  });
			break;
			
		case "/":
			var result;
			if(num2 == 0){
				result = "Cannot Divide by 0";
				json_response = {"statusCode" : 200, "result":result};
				console.log("result:"+result);
				res.send(json_response);
			}
			else{
				/*result = (num1 / num2);
				json_responses = {"statusCode" : 200, "result":result};*/
				params = {num1: num1,num2: num2};
				console.log("params: " + params);
				soap.createClient(baseURL,option, function(err, client) {
				      if(err){
				    	  console.log("Error in SOAP Request" + err);
				      }else{
				    	  client.divide(params, function(err, result) {
				    		  console.log("In Divide Method");
					    	  if(err){
					    		  console.log("Error in SOAP Divide" + err);
					    	  }else{
					    		  console.log("Divide Method Result: " + result.divideReturn);
					    		  json_response = {'statusCode': '200', 'result': result.divideReturn};
					    		  res.send(json_response);
					    	  }
					      }); 
				      }
				  });
			}
			
			
			break;
			
		default:
			json_responses = {"statusCode" : 401, "result":"Error"};
			console.log("result:"+result);
			res.send(json_responses);
			break;
	}
};
