<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="com.gamer.beans.ProductBeansWrapper" %>
<div id="pages-bar">
<% 
ProductBeansWrapper productBeans = 
	(ProductBeansWrapper)session.getAttribute("gamer.products");

int pageNum;
try {
	pageNum = Integer.parseInt(request.getParameter("n"));
} catch (NumberFormatException e) {
	pageNum = 1;
}

String thisPage = (String)request.getParameter("page");

int numPagesToDisplay = productBeans.getNumPagesToDisplayProducts();
%>
<table>
<tr>
<td>
<% 	if (pageNum != 1) { %>
<form>
<input type="hidden" name="page" value="<%= thisPage %>"/>
<input type="hidden" name="n" value="<%= pageNum-1 %>"/>	
<input id="prev-page" type="submit" value="< prev page"/>
</form>
<%	} %>
</td>
<td>
<p>
<%	for (int i=1; i<=numPagesToDisplay; i++) {
		if (i == pageNum) out.println("<span id=\"current-page\">");
		out.println(i);
		if (i == pageNum) out.println("</span>");
	}
%>
</p>
</td>
<td>
<% 	if (pageNum != numPagesToDisplay) { %>
<form>
<input type="hidden" name="page" value="<%= thisPage %>"/>
<input type="hidden" name="n" value="<%= pageNum + 1 %>"/>	
<input id="next-page" type="submit" value="next page >"/>
</form>
<% 	} %>
</td>
</tr>
</table>
</div>