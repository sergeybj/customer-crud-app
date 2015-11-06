<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sb" uri="/struts-bootstrap-tags"%>

<html>
<head>

<script>
  $(function() {
    $( "#birthDate" ).datepicker({ dateFormat: 'yy-mm-dd', changeYear: true, yearRange: "-100:+0"});
  });
  </script>

</head>
<body>



	<s:form action="createOrEditCustomerAction" method="post"
		class="form-horizontal" style="width:500px" validate="true">
		<s:hidden name="customerId" value="%{customerToModify.customerId}" />
		<fieldset>
			<s:if test="%{customerToModify.customerId!=0}">
				<legend>
					Modifying customer ID =
					<s:property value="%{customerToModify.customerId}" />
				</legend>

			</s:if>
			<s:else>
				<legend>Create new customer</legend>
			</s:else>



			<div class="form-group">
				<label for="firstName" class="col-lg-2 control-label">First
					Name: </label>
				<div class="col-lg-10">
					<s:textfield class="form-control" id="firstName" name="firstName"
						placeholder="First Name" value="%{customerToModify.firstName}" />
				</div>
			</div>

			<div class="form-group">
				<label for="lastName" class="col-lg-2 control-label">Last
					Name: </label>
				<div class="col-lg-10">
					<s:textfield class="form-control" id="lastName" name="lastName"
						placeholder="Last Name" value="%{customerToModify.lastName}" />
				</div>
			</div>

			<div class="form-group">
				<label for="username" class="col-lg-2 control-label">Username:
				</label>
				<div class="col-lg-10">
					<s:textfield class="form-control" id="username" name="username"
						placeholder="Username" value="%{customerToModify.username}" />
				</div>
			</div>

			<div class="form-group">
				<label for="password" class="col-lg-2 control-label">Password:
				</label>
				<div class="col-lg-10">
					<s:password class="form-control" id="password" name="password"
						placeholder="Password"/>
				</div>
			</div>

			<div class="form-group">
				<label for="birthDate" class="col-lg-2 control-label">Birth
					Date: </label>
				<div class="col-lg-10">
					<s:textfield class="form-control" id="birthDate" name="birthDate"
						placeholder="Birth Date" readonly="true"
						value="%{getText('{0,date,yyyy-MM-dd}',{customerToModify.birthDate})}" />
				</div>
			</div>

			<div class="form-group">
				<div class="col-lg-10 col-lg-offset-2">
					<button type="reset" class="btn btn-default">Cancel</button>
					<button type="submit" class="btn btn-primary">Submit</button>
				</div>
			</div>


		</fieldset>
	</s:form>

	<s:form action="customerListPage" method="post" class="form-horizontal"
		style="width:500px" validate="true">
		<button type="submit" class="btn btn-primary">View all
			customers</button>
	</s:form>

</body>
</html>
