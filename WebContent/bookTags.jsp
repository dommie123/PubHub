
<!-- Default Header -->
<jsp:include page="header.jsp" />
	<header>
		<div class="container">
			<div class="container-sm" id="go-back">
				<a href="index.jsp">Go back</a>
			</div>
			
			<h1>Tags for Book ${book.isbn13}: </h1>
			
			<table class="table table-striped table-hover table-responsive pubhub-datatable">
				<thead>
					<tr>
						<th>ISBN_13</th>
						<th>Tag Name</th>
					</tr>	
				</thead>
				<tbody>
					<c:forEach var="tag" items="${tags}">
						<tr>
							<td><c:out value="${book.isbn13}" /></td>
							<td><c:out value="${book_tag.tag_name}" /></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</header>
	
	
<jsp:include page="footer.jsp" />