<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:choose>
	<c:when test="${productViewHelper.totalNumberOfPages < 2}"/>
	<c:otherwise>
		<div id="pages-bar">
			<table>
				<tr>
					<td>
						<c:if test="${productViewHelper.currentPage != 1}">
							<form>
								<input type="hidden" name="action" value="${param['action']}"/>
								<input type="hidden" name="n" value="${productViewHelper.currentPage - 1}"/>	
								<input id="prev-page" type="submit" value="< prev page"/>
							</form>
						</c:if>
					</td>
					<td>
						<p>
							<c:forEach var="i" begin="1" end="${productViewHelper.totalNumberOfPages}">
								<c:choose>
									<c:when test="${i == productViewHelper.currentPage}">
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
						<c:if test="${productViewHelper.currentPage != productViewHelper.totalNumberOfPages}">
							<form>
								<input type="hidden" name="action" value="${param['action']}"/>
								<input type="hidden" name="n" value="${productViewHelper.currentPage + 1}"/>	
								<input id="next-page" type="submit" value="next page >"/>
							</form>
						</c:if>
					</td>
				</tr>
			</table>
		</div>
	</c:otherwise>
</c:choose>
