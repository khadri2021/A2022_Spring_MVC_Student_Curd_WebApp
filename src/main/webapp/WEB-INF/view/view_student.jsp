<%@ page import="com.khadri.spring.mvc.form.StudentForm"%>
<%@ page import="java.util.Objects"%>

<html>
<script type="text/javascript">
</script>
<body bgcolor="#80ffff">
	<form action="view/register">
		 <table bgcolor="#99ff99">
			<tr>
				<td colspan="2" align="center"><a href="../adminpage">Go To</a> previous page</td>
			</tr>
		</table>
		<table border="4">
		
			<tr>
				<td colspan="2" align="center">VIEW STUDENT FORM</td>
			</tr>
			<tr>
				<td>STUDENT ID :</td>
				<td><input type="text"  name="stdid" placeholder="enter id for search"></td>
			</tr>
			 
			<tr>
				<td colspan="7" align="center"><input type="submit"  value="Search Record" ></td>
			</tr>
			<input type="hidden"  name="mode" value="SEARCH">
			<% StudentForm searchRecord = (StudentForm)request.getAttribute("search_result"); %>
			
			<%if(Objects.nonNull(searchRecord)){ %>
		
			<tr>
				<td align="center">STUDENT ID</td>
				<td align="center">STUDENT NAME</td>
				<td align="center">STUDENT AGE</td>
				<td align="center">STUDENT BRANCH</td>
				<td align="center">STUDENT PHONE NUMBER</td>
				<td align="center">STUDENT PARENT PHONE NUMBER</td>
				<td align="center">STUDENT ADDRESS</td>
			</tr>
			
			<tr>
				<td align="center"><%=searchRecord.getsId() %></td>
				<td align="center"><%=searchRecord.getsName() %></td>
				<td align="center"><%=searchRecord.getsAge() %></td>
				<td align="center"><%=searchRecord.getsBranch()%></td>
				<td align="center"><%=searchRecord.getsPhone()%></td>
				<td align="center"><%=searchRecord.getsParentPhone() %></td>
				<td align="center"><%=searchRecord.getsAddress() %></td>
			</tr>
			
			<%}else{ %>
			<tr>
				<td align="center">STUDENT ID</td>
				<td align="center">STUDENT NAME</td>
				<td align="center">STUDENT AGE</td>
				<td align="center">STUDENT BRANCH</td>
				<td align="center">STUDENT PHONE NUMBER</td>
				<td align="center">STUDENT PARENT PHONE NUMBER</td>
				<td align="center">STUDENT ADDRESS</td>
			</tr>
			
			<tr bgcolor="red">
			   <td colspan="7" align="center">No Record Found </td>
			</tr>
			
			<%} %>
				
		</table>
		 <table bgcolor="#99ff99">
			<tr>
				<td colspan="2" align="center"><a href="../adminpage">Go To</a> previous page</td>
			</tr>
		</table>

	</form>

</body>
</html>
