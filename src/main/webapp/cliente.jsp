<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Clientes</title>
</head>
<body>
	<div align="center">
		<jsp:include page="menu.jsp"></jsp:include>
	</div>
	<br />
	<br />
	<div align="center">
		<form action="cliente" method="post">
			<table border="1">
				<tr>
					<td colspan="3">
						<input type="number" min="0" step="1" id="idCliente" name="idCliente" placeholder="#ID"
						value='<c:out value="${cli.id }"></c:out>'>
					</td>
					<td><input type="submit" id="botao" name="botao" value="Consultar"></td>
				<tr>
					<td colspan="4">
						<input type="text" id="nomeCliente" name="nomeCliente" placeholder="Nome do Cliente"
						value='<c:out value="${cli.nome }"></c:out>'>
				</tr>
				<tr>
					<td colspan="4">
						<input type="text" id="emailCliente" name="emailCliente" placeholder="Email do Cliente"
						value='<c:out value="${cli.email }"></c:out>'>
					</td>
				</tr>
				<tr>
					<td colspan="4">
						<input type="text" id="telefoneCliente" name="telefoneCliente" placeholder="Telefone do Cliente"
						value='<c:out value="${cli.telefone }"></c:out>'>
					</td>
				</tr>
				<tr>
					<td><input type="submit" id="botao" name="botao" value="INSERIR"></td>
					<td><input type="submit" id="botao" name="botao" value="ATUALIZAR"></td>
					<td><input type="submit" id="botao" name="botao" value="EXCLUIR"></td>
					<td><input type="submit" id="botao" name="botao" value="LISTAR"></td>
				</tr>
			</table>
		</form>
	</div>
	<br />
	<div align="center">
		<c:if test="${not empty erro }">
			<H2><c:out value="${erro }" /></H2>
		</c:if>
		<c:if test="${not empty saida }">
			<H2><c:out value="${saida }" /></H2>
		</c:if>
	</div>
	<div align="center">
		<c:if test="${not empty clientes }">
			<table border="1">
				<thead>
					<tr>
						<th>#ID Cliente</th>
						<th>Nome Cliente</th>
						<th>Email Cliente</th>
						<th>Telefone Cliente</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${clientes }" var="c">
						<tr>
							<td><c:out value="${c.id }"></c:out></td>
							<td><c:out value="${c.nome }"></c:out></td>
							<td><c:out value="${c.email }"></c:out></td>
							<td><c:out value="${c.telefone }"></c:out></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</c:if>	
	</div>
</body>
</html>