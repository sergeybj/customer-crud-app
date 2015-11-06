<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sb" uri="/struts-bootstrap-tags"%>
<body ng-app="myApp" ng-controller="myCustomerListCtrl">

	<table class="table table-striped table-hover ">
		<thead>
			<tr>
				<th>ID</th>
				<th>First Name</th>
				<th>Last Name</th>
				<th>Birth Date</th>
				<th>Username</th>
				<th>Edit</th>
				<th>Delete</th>
			</tr>
		</thead>
		<tbody>
			<tr class="info" ng-repeat="item in json">
				<td>{{item.customerId}}</td>
				<td>{{item.firstName}}</td>
				<td>{{item.lastName}}</td>
				<td>{{item.birthDate | date:'yyyy-MM-dd'}}</td>
				<td>{{item.username}}</td>
				<td><s:form action="createOrEditCustomerForm" method="post"
						class="form-horizontal" style="width:500px" validate="true">
						<s:hidden name="customerId" value="{{item.customerId}}" />
							<button type="submit" class="btn btn-primary">Edit
								Customer</button>

					</s:form></td>
				<td><s:form action="deleteCustomerAction" method="post"
						class="form-horizontal" style="width:500px" validate="true">
						<s:hidden name="customerId" value="{{item.customerId}}" />
							<button type="submit" class="btn btn-primary">Delete
								Customer</button>

					</s:form></td>
			</tr>

		</tbody>
	</table>


	<s:form action="createOrEditCustomerForm" method="post"
		class="form-horizontal" style="width:500px" validate="true">
		<fieldset>


			<div class="form-group">
				<div class="col-lg-10 col-lg-offset-2">
					<button type="submit" class="btn btn-primary">Create
						another customer</button>
				</div>
			</div>


		</fieldset>
	</s:form>


</body>
