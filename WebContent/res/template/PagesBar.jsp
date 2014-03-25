<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:choose>
	<c:when test="${pageOfProducts.totalNumPages < 1}"/>
	<c:otherwise>
		<div id="pages-bar">
			<table>
				<tr>
					<td>
						<c:if test="${pageOfProducts.pageNum != 1}">
							<form>
								<input type="hidden" name="action" value="${param['action']}"/>
								<input type="hidden" name="n" value="${pageOfProducts.pageNum - 1}"/>	
								<input id="prev-page" type="submit" value="< prev page"/>
							</form>
						</c:if>
					</td>
					<td>
						<p>
							<c:forEach var="i" begin="1" end="${pageOfProducts.totalNumPages}">
								<c:choose>
									<c:when test="${i == pageOfProducts.pageNum}">
										<span id="current-page">
											<c:out value="${i}"/>
										</span>
									</c:when>
									<c:otherwise>
										<c:out value="${i}"/>
									</c:otherwise>
								</c:choose>
							</c:forEach>
						</p>
					</td>
					<td>
						<c:if test="${pageOfProducts.pageNum != pageOfProducts.totalNumPages}">
							<form>
								<input type="hidden" name="action" value="${param['action']}"/>
								<input type="hidden" name="n" value="${pageOfProducts.pageNum + 1}"/>	
								<input id="next-page" type="submit" value="next page >"/>
							</form>
						</c:if>
					</td>
				</tr>
			</table>
		</div>
	</c:otherwise>
</c:choose>
