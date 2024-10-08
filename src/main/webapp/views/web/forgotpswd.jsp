<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ include file="/commons/taglib.jsp" %>

<!-- BEGIN CONTENT -->
<div class="col-md-12 col-sm-12">
	<div class="content-form-page">
		<div class="row">
			<div class="col-md-7 col-sm-7">
				<form class="form-horizontal form-without-legend" role="form"
					action="${pageContext.request.contextPath}/forgotpswd" method="post">

					<c:if test="${alert !=null}">
						<h3 class="alert alert danger">${alert}</h3>
					</c:if>

					<div class="form-group">
						<label for="username" class="col-lg-4 control-label">Username
							<span class="require">*</span>
						</label>
						<div class="col-lg-8">
							<input type="text" class="form-control" id="username"
								name="username" placeholder="Enter Username" required>
						</div>
					</div>
					<div class="form-group">
						<label for="password" class="col-lg-4 control-label">New Password
							<span class="require">*</span>
						</label>
						<div class="col-lg-8">
							<input type="password" class="form-control" id="password"
								name="password" placeholder="Enter New Password" required>
						</div>
						<div class="col-lg-8" style="padding-top: 10px">
							<input type="password" class="form-control" id="retypepass"
								name="retypepass" placeholder="Retype New Password" required>
						</div>
					</div>
					<div class="row">
						<div
							class="col-lg-8 col-md-offset-4 padding-left-0">
							<button type="submit" class="btn btn-primary">CONTINUE</button>
						</div>
					</div>
				</form>
			</div>
			<div class="col-md-4 col-sm-4 pull-right">
				<div class="form-info">
					<h2>
						<em>Important</em> Information
					</h2>
					<p>Duis autem vel eum iriure at dolor vulputate velit esse vel
						molestie at dolore.</p>

					<button type="button" class="btn btn-default">More details</button>
				</div>
			</div>
		</div>
	</div>
</div>
<!-- END CONTENT -->