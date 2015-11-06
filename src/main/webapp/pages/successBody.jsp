<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sb" uri="/struts-bootstrap-tags"%>
<body>

	Successfully saved user with ID = ${savedId}

	<s:form action="customerListPage" method="post" class="form-horizontal"
		style="width:500px" validate="true">
		<button type="submit" class="btn btn-primary">View all
			customers</button>
	</s:form>



	<s:form action="createCustomerForm" method="post"
		class="form-horizontal" style="width:500px" validate="true">
		<button type="submit" class="btn btn-primary">Create another
			customer</button>
	</s:form>


</body>
