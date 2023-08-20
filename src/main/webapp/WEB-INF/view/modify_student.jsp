<%@ page import="java.util.List"%>
<%@ page import="com.khadri.spring.mvc.form.StudentForm"%>

<html>
<script type="text/javascript">

function ajaxEditForm(rowCount){
	//alert('ajax Invoking '+rowCount);
	var studentId= document.getElementById('stdid'+rowCount).value;
	var studentName= document.getElementById('stdname'+rowCount).value;
	var studentAge= document.getElementById('stdage'+rowCount).value;
	var studentBranch= document.getElementById('stdbranch'+rowCount).value;
	var studentPhone= document.getElementById('stdphone'+rowCount).value;
	var studentParentPhone= document.getElementById('stdpphone'+rowCount).value;
	var studentAddress= document.getElementById('stdadd'+rowCount).value;
	
	var xhttp = new XMLHttpRequest();
	  xhttp.onreadystatechange = function() {
	    if (this.readyState == 4 && this.status == 200) {
	      alert("Update Successfully");
	    }
	  };
	  xhttp.open("POST", "modify/register?sId="+studentId+"&sName="+studentName+"&sAge="+studentAge+"&sBranch="+studentBranch+"&sPhone="+studentPhone+"&sAddress="+studentAddress+"&sParentPhone="+studentParentPhone, true);
	  xhttp.send();
	
}
</script>

<body bgcolor="#ffff99">
	<%
	List<StudentForm> listOfStudents = (List<StudentForm>) request
			.getAttribute("edit_result");
	%>

	<form action="">
	</table>
			<table bgcolor="#99ff99">
			<tr>
				<td colspan="2" align="center"><a href="student_admin.jsp">Go To</a> previous page</td>
			</tr>
		</table>
		<table border="4" id="mydata">
			<tr>
				<td colspan="7" align="center">MODIFY STUDENT FORM</td>
			</tr>

			<tr>
				<td align="center">STUDENT ID</td>
				<td align="center">STUDENT NAME</td>
				<td align="center">STUDENT AGE</td>
				<td align="center">STUDENT BRANCH</td>
				<td align="center">STUDENT PHONE NUMBER</td>
				<td align="center">STUDENT PARENT PHONE NUMBER</td>
				<td align="center">STUDENT ADDRESS</td>
				<td align="center">ACTION</td>
			</tr>
			<%
			int inc = 1;
			for (StudentForm student : listOfStudents) {
			%>

			<tr>
				<td><input type="text" id="stdid<%=inc%>"
					value="<%=student.getsId()%>" disabled="disabled"></td>
				<td><input type="text" id="stdname<%=inc%>"
					value="<%=student.getsName()%>"></td>
				<td><input type="text" id="stdage<%=inc%>"
					value="<%=student.getsAge()%>"></td>
				<td><input type="text" id="stdbranch<%=inc%>"
					value="<%=student.getsBranch()%>"></td>
				<td><input type="text" id="stdphone<%=inc%>"
					value="<%=student.getsPhone()%>"></td>
				<td><input type="text" id="stdpphone<%=inc%>"
					value="<%=student.getsParentPhone()%>"></td>
				<td><input type="text" id="stdadd<%=inc%>"
					value="<%=student.getsAddress()%>"></td>

				<td><input type="button" value="MODIFY RECORD"
					onclick="ajaxEditForm(<%=inc%>)"></td>
			</tr>

			<%
			inc++;
			}
			%>

			<input type="hidden" name="mode" value="EDIT">


		</table>
		
		</table>
			<table bgcolor="#99ff99">
			<tr>
				<td colspan="2" align="center"><a href="student_admin.jsp">Go To</a> previous page</td>
			</tr>
		</table>
	</form>

</body>
</html>
