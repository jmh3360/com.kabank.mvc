<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
<%@ include file="../common/head.jsp"%>
<body>
<%@ include file="../common/header.jsp"%>
<%@ include file="../common/nav.jsp"%>

<%
%>
			<section>
			<article>
				<header>
					<hgroup>
						<h2><mark>버거킹</mark> 주문화면</h2>
						<h3>상품과 수량을 선택해 주세요</h3>
					</hgroup>
				</header>
			</article>
			<article>
			<div id = "wrapper">
					<form id="order_form" action="result.jsp">
					<table style="width: 800px; margin: 0 auto;">
						<tr >
							<td style="width: 400px; height: 200px;"><br />
						<figure>
						<img src="../../img/hamburger.jpg" 
						style="width: 150px; height: 150px" alt="" /> <br />
						<figcaption>
							<input type="checkbox" name = "menu" value="hamburger" /> 햄버거 <br /> ￦5,500 
							<input type="number" name="hamburger-count" min="1" max="9" style="width: 30px;"/> 개  
						</figcaption>
						</figure>
							
							</td>
							<td style="width: 400px; height: 200px;">
							<figure>
							<img src="../../img/chips.jpg" 
							style="width: 150px; height: 150px" alt="" /> <br />
							<figcaption>
							<input type="checkbox" name = "menu" value="chip" />감자칩 <br /> ￦1,000
							<input type="number" name="chip-count" min="1" max="9" style="width: 30px;"/>개
							</figcaption>
							</figure>
							</td >
							
							<td style="width: 400px; height: 200px;">
							<figure>
							<img src="../../img/salads.jpg" 
							style="width: 150px; height: 150px" alt="" /> <br />
							<figcaption>
							<input type="checkbox" name = "menu" value="salad" /> 샐러드 <br /> ￦3,000
							<input type="number" name="salad-count" min="1" max="9" style="width: 30px;"/>개
							</figcaption>
							</figure>
							</td>
						</tr>
						<tr >
							<td style="width: 200px; height: 200px;"><img src="../../img/coffee.jpg" 
							style="width: 150px; height: 150px" alt="" /><br />
							<input type="checkbox" name = "menu" value="coffee" /> 커피 <br /> ￦900
							<input type="number" name="coffee-count" min="1" max="9" style="width: 30px;"/>개
							</td>
							<td style="width: 200px; height: 200px;"><img src="../../img/coke.jpg" 
							style="width: 150px; height: 150px" alt="" /> <br /> 
							<input type="checkbox" name = "menu" value="coke" /> 콜라 <br /> ￦1,000
							<input type="number" name="coke-count" min="1" max="9" style="width: 30px;"/>개
							
							</td>
							<td style="width: 200px; height: 200px;"><img src="../../img/bagel.jpg" 
							style="width: 150px; height: 150px" alt="" /> <br />
							<input type="checkbox" name = "menu" value="bagel" />베이글 <br /> ￦4,000
							<input type="number" name="bagel-count" min="1" max="9" style="width: 30px;"/>개
							</td>
						</tr>
					<tr >
					<td colspan="3">
					매장식사 <input type="radio" name="place" value="매장식사" checked="checked"/>
					테이크 아웃 <input type="radio" name="place" value="take-out"/>
					</td>
					</tr>
					<tr>
					<td colspan ="3">
						<input type="hidden" name="hamburger" value="5500" /> 
						<input type="hidden" name="coke" value="1000" />
						<input type="hidden" name="chip" value="1000" />
						<input type="hidden" name="coffee" value="900" />
						<input type="hidden" name="bagel" value="4000" />
						<input type="hidden" name="salad" value="3000" />
						<input id="burgerking_order_btn" type="button" value="전송" style="margin-right: 50px;" />
					</td>
					</tr>
					</table>
					
					</form>
</div>
					</article>
					</section>
					<aside></aside>
		<!-- 				
	submit은 버튼 을 형성함
	text는 빈창을 생성하고 placeholder는 빈창에 미리보기기능
	  -->
<%@ include file="../common/footer.jsp"%>
</body>
<script src="../../js/burgerking/burgerKing.js"></script>
</html>