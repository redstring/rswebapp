<html>
<body>

	<a href="${pageContext.request.contextPath}/">iredstring_Home_page</a>
	<br />
	<br />

	<h2>Spring 4 and Hibernate 4!</h2>


	<p>
		Welcome to "Employee application".<br /> 
		<i>${message}</i><br /> 
		<a href="${pageContext.request.contextPath}/api/emp/list">List all new employees</a>
		<br /> <br />
		<br /> 
		List of ways to route requests <br /> <br /> 
		
				
		<a href="${pageContext.request.contextPath}/api/v1/rsuser/list">api-v1-rsuser-list</a><br /> 
        <a href="${pageContext.request.contextPath}/api/v1/rsuser/read?rsid=3">Leon</a><br /> 
		<a href="${pageContext.request.contextPath}/api/v1/rsuser/read?username=peter_sagan">person-peter</a><br /> 


        <hr/>
        <a href="${pageContext.request.contextPath}/api/hello">api/hello</a><br />
        <a href="${pageContext.request.contextPath}/api/hello2?name=test_name">api/hello2?name=test_name</a><br />
        <a href="${pageContext.request.contextPath}/api/hello3/atest">***Broken, not working***|||api/hello3/atest</a><br />    

        <a href="${pageContext.request.contextPath}/api/emp/list">api/emp/list</a><br /> 
        
    
	</p>

</body>
</html>
