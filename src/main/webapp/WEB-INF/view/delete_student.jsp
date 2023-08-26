<%@ page import="java.util.List"%>
<%@ page import="com.khadri.spring.mvc.form.StudentForm"%>

<html>
<script type="text/javascript">

function ajaxDeleteForm(rowCount){
	//alert('ajax Invoking '+rowCount);
	var studentId= document.getElementById('stdid'+rowCount).value; 
	
	var xhttp = new XMLHttpRequest();
	  xhttp.onreadystatechange = function() {
	    if (this.readyState == 4 && this.status == 200) {
	      alert("Deleted Successfully");
	    }
	  };
	  xhttp.open("POST", "../../delete/register?sId="+studentId, true);
	  xhttp.send();
	
}
</script>

<body bgcolor="#ffff99">
	<%
	List<StudentForm> listOfStudents = (List<StudentForm>) request
			.getAttribute("delete_result");
	%>

	<form action="">
	</table>
			<table bgcolor="#99ff99">
			<tr>
				<td colspan="2" align="center"><a href="../../adminpage">Go To</a> previous page</td>
			</tr>
		</table>
		<table border="4" id="mydata">
			<tr>
				<td colspan="8" align="center">DELETE STUDENT FORM</td>
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
					value="<%=student.getsName()%>" disabled="disabled"></td>
				<td><input type="text" id="stdage<%=inc%>"
					value="<%=student.getsAge()%>" disabled="disabled"></td>
				<td><input type="text" id="stdbranch<%=inc%>"
					value="<%=student.getsBranch()%>" disabled="disabled"></td>
				<td><input type="text" id="stdphone<%=inc%>"
					value="<%=student.getsPhone()%>" disabled="disabled"></td>
				<td><input type="text" id="stdpphone<%=inc%>"
					value="<%=student.getsParentPhone()%>" disabled="disabled"></td>
				<td><input type="text" id="stdadd<%=inc%>"
					value="<%=student.getsAddress()%>" disabled="disabled"></td>

				<td><input type="button" value="DELETE RECORD"
					onclick="ajaxDeleteForm(<%=inc%>)"></td>
			</tr>

			<%
			inc++;
			}
			%>

		</table>
		
		</table>
			<table bgcolor="#99ff99">
			<tr>
				<td colspan="2" align="center"><a href="../../adminpage">Go To</a> previous page</td>
			</tr>
		</table>
	</form>

</body>
</html>
