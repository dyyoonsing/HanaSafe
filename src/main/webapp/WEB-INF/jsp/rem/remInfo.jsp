<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="/WEB-INF/jsp/include/headcss.jsp"></jsp:include>

</head>
<body>
	<jsp:include page="/WEB-INF/jsp/include/headerSec.jsp"></jsp:include>
	<!-- page-header-start -->
	<div class="page-header">
        <div class="container">
            <div class="row">
                <div class="col-lg-5 col-md-5 col-sm-6 col-xs-12">
                    <div class="page-section">
                    </div>
                </div>
            </div>
        </div>
    </div>
	<!-- page-header-close -->


	<!-- remInfo page start -->
	
	<div class="container allAccount-con pb-3">
		<div class="row" style="color: #c6c6c6">
			<div class="col-md-12 d-flex justify-content-end whereThisPageIs">
				<span class="material-icons md-12 lineHeight mr-1">home</span>
				<div>Home</div>
				<div class="material-icons md-12 lineHeight">keyboard_arrow_right</div>
				<div>해외송금</div>
				<div class="material-icons md-12 lineHeight">keyboard_arrow_right</div>
				<div>송금정보 조회/등록</div>
			</div>	
		</div>
	
	
	
		<div class="row pt-2">
			<!-- side menu col-md-3   -->
			<jsp:include page="/WEB-INF/jsp/include/remSideMenu.jsp"></jsp:include>
			
			<div class="col-md-9">
				<div class="font-weight-bold text-body mb-2 topTitle" style="font-size: 25px;">
					<i class="material-icons align-middle">how_to_reg</i>
					<span class="align-middle">송금정보 조회/등록</span>
				</div>
			
			
				<div class="font-weight-bold"><i class="material-icons md-18 align-middle text-info" >person</i><span class="align-middle">내 정보</span></div>
				<table class="table ">
					<tr>
						<th colspan="2">영문이름</th>
						<td>${ loginVO.engName }</td>
					</tr>
					<tr>
						<th colspan="2">전화번호</th>
						<td>${ loginVO.phone }</td>
					</tr>
					<tr>
						<th colspan="2">이메일</th>
						<td>${ loginVO.email }</td>
					</tr>
					<tr>
						<th rowspan="2">영문주소</th>
						<th >주소</th>
						<td>${ loginVO.addr }</td>
					</tr>
					<tr>
						<th>세부주소</th>
						<td>${ loginVO.addrDetail }</td>
					</tr>
				</table>
				<div class="font-weight-bold"><i class="material-icons md-18 align-middle text-info" >person</i><span class="align-middle">수취인 정보</span></div>
				<c:choose>
					<c:when test="${ empty remInfoList }">
						<div class="mx-auto">등록된 송금정보가 없습니다</div>
					</c:when>
					<c:otherwise>
					<table class="table table-hover text-center " id="table-rem-info">
					
					<thead>
							<tr>
								<th>받는분</th>
								<th style="width:5%;">통화</th>
								<th>입금은행</th>
								<th>계좌번호</th>
								<th>승인현황</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${ remInfoList }" var="remInfo">
								<tr class="table-row-clickable" data-value="${ remInfo.infoNo }">
									<td>${ remInfo.name }</td>
									<td>${ remInfo.currency }</td>
									<td>${ remInfo.bankName }</td>
									<td>${ remInfo.accNo }</td>
									<td>
									<c:choose>
										<c:when test="${ remInfo.status eq '승인' }">
											<span class="text-success"> ${ remInfo.status } </span>
										</c:when>
										<c:when test="${ remInfo.status eq '비승인' }">
											<span class="text-danger"> ${ remInfo.status } </span>
										</c:when>
										<c:otherwise>
											<span> ${ remInfo.status } </span>
										</c:otherwise>
									</c:choose>
									</td>
								</tr>
							</c:forEach>
						</tbody>
						</table>
						<div></div>
						 
					</c:otherwise>
				</c:choose>
				<div class="text-center">
					<button class="btn btn-light">즐겨찾기 등록</button>
					<button class="btn btn-info" onclick="window.location.href='${ pageContext.request.contextPath }/remInfo/register'">새로 등록하기</button>
				</div>
				<!-- <div id="viewRemInfo"></div> -->
			</div>
		</div>
	</div>
	<!-- remInfo page close -->
	
	
<jsp:include page="/WEB-INF/jsp/include/footerSec.jsp"></jsp:include>
<jsp:include page="/WEB-INF/jsp/include/footerjs.jsp"></jsp:include>
<script>
$(document).ready(function(){
	$("#table-rem-info tbody tr").on('click', function() {
		var remNo = $(this).data("value");
		window.location.href = '${pageContext.request.contextPath}/remInfo/' + remNo;
        
      });
});
</script>
</body>
</html>